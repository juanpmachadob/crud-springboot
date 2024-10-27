package dev.jpmachado.crud_springboot.service;

import dev.jpmachado.crud_springboot.model.entity.Client;

import java.util.ArrayList;

public interface IClientService {
    ArrayList<Client> findAll();
    Client findById(Integer id);
    Client save(Client client);
    void delete(Client client);
}
