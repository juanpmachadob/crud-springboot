package dev.jpmachado.crud_springboot.model.dao;

import dev.jpmachado.crud_springboot.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Integer> {

}
