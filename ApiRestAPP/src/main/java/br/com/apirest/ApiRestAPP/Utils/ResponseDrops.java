package br.com.apirest.ApiRestAPP.Utils;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseDrops {
    public static ResponseEntity<Object> GenerateMensages(String message,HttpStatus statusCode){
        Map<String,Object> messages = new HashMap<String,Object>();
        messages.put("Mensagem: ", message);
        return new ResponseEntity<Object>(message,statusCode);

    }
}
