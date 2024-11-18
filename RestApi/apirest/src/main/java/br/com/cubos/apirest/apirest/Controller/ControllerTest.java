package br.com.cubos.apirest.apirest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TesteController")
public class ControllerTest {

    @GetMapping
    public String Test(){
        return "Tudo ok, Hello word, codigo rodando";
    }
}
