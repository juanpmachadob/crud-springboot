package dev.jpmachado.crud_springboot.service;

import dev.jpmachado.crud_springboot.model.dto.ClientDto;
import dev.jpmachado.crud_springboot.model.entity.Client;

import java.util.ArrayList;

public interface IClientService {
    ArrayList<Client> findAll();
    Client findById(Integer id);
    Client save(ClientDto clientDto);
    void delete(Client client);
    boolean existsById(Integer id);
}
