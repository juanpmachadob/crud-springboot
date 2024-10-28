package dev.jpmachado.crud_springboot.controller;

import dev.jpmachado.crud_springboot.exception.BadRequestException;
import dev.jpmachado.crud_springboot.exception.ResourceNotFoundException;
import dev.jpmachado.crud_springboot.model.dto.ClientDto;
import dev.jpmachado.crud_springboot.model.entity.Client;
import dev.jpmachado.crud_springboot.model.payload.MessageResponse;
import dev.jpmachado.crud_springboot.service.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("clients")
    public ResponseEntity<?> findAll() {
        ArrayList<Client> clients = clientService.findAll();

        if (clients == null || clients.isEmpty()) {
            throw new ResourceNotFoundException("Clients", "clients", null);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message(null)
                        .data(clients)
                        .build(),
                HttpStatus.OK);
    }

    @GetMapping("client/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Client clientToFind = clientService.findById(id);

        if (clientToFind == null) {
            throw new ResourceNotFoundException("Client", "id", id);
        }

        return new ResponseEntity<>(
                MessageResponse.builder().message(null)
                        .data(ClientDto.builder()
                                .id(clientToFind.getId())
                                .firstName(clientToFind.getFirstName())
                                .lastName(clientToFind.getLastName())
                                .email(clientToFind.getEmail())
                                .createdAt(clientToFind.getCreatedAt())
                                .build())
                        .build(),
                HttpStatus.OK);
    }

    @PostMapping("client")
    public ResponseEntity<?> create(@RequestBody @Valid ClientDto clientDto) {
        Client clientToCreate = null;

        try {
            clientToCreate = clientService.save(clientDto);
            return new ResponseEntity<>(
                    MessageResponse.builder().message("Client created successfully")
                            .data(ClientDto.builder()
                                    .id(clientToCreate.getId())
                                    .firstName(clientToCreate.getFirstName())
                                    .lastName(clientToCreate.getLastName())
                                    .email(clientToCreate.getEmail())
                                    .createdAt(clientToCreate.getCreatedAt())
                                    .build())
                            .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    @PutMapping("client/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid ClientDto clientDto) {
        Client clientToUpdate = null;

        try {
            if (clientService.findById(id) == null) {
                throw new ResourceNotFoundException("Client", "id", id);
            }

            clientDto.setId(id);
            clientToUpdate = clientService.save(clientDto);
            return new ResponseEntity<>(
                    MessageResponse.builder().message("Client updated successfully")
                            .data(ClientDto.builder()
                                    .id(clientToUpdate.getId())
                                    .firstName(clientToUpdate.getFirstName())
                                    .lastName(clientToUpdate.getLastName())
                                    .email(clientToUpdate.getEmail())
                                    .createdAt(clientToUpdate.getCreatedAt())
                                    .build())
                            .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Client clientToDelete = clientService.findById(id);
            clientService.delete(clientToDelete);
            return new ResponseEntity<>(clientToDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }
}
