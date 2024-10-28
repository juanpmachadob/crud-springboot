package dev.jpmachado.crud_springboot.service.impl;

import dev.jpmachado.crud_springboot.model.dao.ClientDao;
import dev.jpmachado.crud_springboot.model.dto.ClientDto;
import dev.jpmachado.crud_springboot.model.entity.Client;
import dev.jpmachado.crud_springboot.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientDao clientDao;

    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public ArrayList<Client> findAll() {
        return (ArrayList<Client>) clientDao.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return clientDao.existsById(id);
    }

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder()
                .id(clientDto.getId())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .email(clientDto.getEmail())
                .createdAt(clientDto.getCreatedAt())
                .build();
        return clientDao.save(client);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
