package org.bg.picpay.picpaysimplificado;

import org.bg.picpay.picpaysimplificado.obj.PicObj;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestRestTemplate {
    static RestTemplate rt = new RestTemplate();
    static String Test(){
        ResponseEntity<PicObj> rp = rt.getForEntity("https://util.devi.tools/api/v2/authorize", PicObj.class);
       return rp.toString();
    }

    public static void main(String[] args) {
        System.out.println(Test());
    }
}
