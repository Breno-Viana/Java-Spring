package org.bg.picpay.picpaysimplificado.services;

import org.bg.picpay.picpaysimplificado.dto.utils.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.ClientNotFoundException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.DuplicateCredentialException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.NullAddressException;
import org.bg.picpay.picpaysimplificado.model.User.Client;

import org.bg.picpay.picpaysimplificado.model.User.utils.Credentials;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.bg.picpay.picpaysimplificado.repository.LoginRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Service
public class ClientService {


    private static ClientRepository userRepository;

    private static LoginRepository loginRepository;

    public ClientService(ClientRepository repository,LoginRepository loginRepository){
        ClientService.userRepository=repository;
        ClientService.loginRepository=loginRepository;
    }

    public List<Client> finAllClients(){
        var sort = Sort.by(Sort.Direction.ASC,"firstName");
        return userRepository.findAll(sort);
    }



    public static ResponseEntity<Client> addClient(ClientDTO clientDTO) throws Exception{

        loginRepository.findByDocument(clientDTO.document())
                .ifPresent(
                        ex ->{
                            throw new DuplicateCredentialException();
                        }
                );

            var Address = SetAddress(clientDTO.cep(), clientDTO);
            var login = new Credentials(clientDTO);
            login.setRole(2);
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
