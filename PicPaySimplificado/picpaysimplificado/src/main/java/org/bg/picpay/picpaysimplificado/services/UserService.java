package org.bg.picpay.picpaysimplificado.services;

import org.bg.picpay.picpaysimplificado.dto.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.exceptions.error.ClientNotFoundException;
import org.bg.picpay.picpaysimplificado.exceptions.error.NullAddressException;
import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.UUID;


@Service
public class UserService {


    private static ClientRepository userRepository;

    public UserService(ClientRepository repository){
        UserService.userRepository=repository;
    }

    public List<Client> finAllUsers(){
        return userRepository.findAll();
    }


    public static ResponseEntity<Client> addUser(ClientDTO clientDTO){
        var Address = SetAddress(clientDTO.cep(),clientDTO);
        Client client = new Client(clientDTO,Address);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(client));
    }


    private static Address SetAddress(String cep, ClientDTO cl){
        RestTemplate rt = new RestTemplate();
        var NoFormatAddress = rt.getForEntity(String.format("http://viacep.com.br/ws/%s/json/",cep), AddressApiConsumerDTO.class);
        if (NoFormatAddress.getBody() == null){
            throw new NullAddressException();
        }
        return new Address(NoFormatAddress.getBody(),cl);
    }


    public ResponseEntity<Client> getUser(UUID i){
        var user = userRepository.findById(i);
       if (user.isEmpty()){
           throw new ClientNotFoundException();
       }
       return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
    }
}
