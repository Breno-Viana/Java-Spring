package br.com.cubos.apirest.apirest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TesteController")
public class ControllerTest {

    @GetMapping
    public String Hello(){
        return "Rodando tudo certo, OK";
    }

    @GetMapping("soma")
    public double Som(@RequestParam double a , @RequestParam double b){
        return a + b;
    }
}
