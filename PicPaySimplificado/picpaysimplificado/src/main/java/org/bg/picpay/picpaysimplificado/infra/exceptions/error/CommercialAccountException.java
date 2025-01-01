package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

public class CommercialAccountException extends RuntimeException {
    public CommercialAccountException(String message) {
        super(message);
    }
    public CommercialAccountException(){super("conta do tipo comercial");}
}
