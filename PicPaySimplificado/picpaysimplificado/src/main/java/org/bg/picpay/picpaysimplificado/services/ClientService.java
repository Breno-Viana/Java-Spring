package org.bg.picpay.picpaysimplificado.services;

import jakarta.validation.Valid;
import org.bg.picpay.picpaysimplificado.dto.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.ClientNotFoundException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.NoValidBodyException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.NullAddressException;
import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.bg.picpay.picpaysimplificado.model.User.utils.Login;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;


@Service
public class ClientService {


    private static ClientRepository userRepository;

    public ClientService(ClientRepository repository){
        ClientService.userRepository=repository;
    }

    public List<Client> finAllClients(){
        var sort = Sort.by(Sort.Direction.ASC,"firstName");
        return userRepository.findAll(sort);
    }



    public static ResponseEntity<Client> addClient(ClientDTO clientDTO){
            var Address = SetAddress(clientDTO.cep(), clientDTO);
            var login = new Login(clientDTO);
            Client client = new Client(clientDTO, Address, login);
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


    public ResponseEntity<Client> getClient(UUID i){
        var client = userRepository.findById(i).orElseThrow(ClientNotFoundException::new);
       return new ResponseEntity<>(client,HttpStatus.FOUND);
    }

}
