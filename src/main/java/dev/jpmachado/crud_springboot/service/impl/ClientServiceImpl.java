package dev.jpmachado.crud_springboot.service.impl;

import dev.jpmachado.crud_springboot.model.dao.ClientDao;
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

    @Transactional
    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
