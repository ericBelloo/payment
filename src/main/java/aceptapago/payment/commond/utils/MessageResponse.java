package aceptapago.payment.commond.utils;

import lombok.Getter;
import lombok.Setter;

public class MessageResponse {
    /**
     * Mensajes de respuesta
     */

    public static final String BAD_FORMAT = "Formato incorrecto";
    public static final String NOT_BLANK = "El parametro no puede estar en blanco";
    public static final String NOT_NULL = "El parametro no puede ser nulo";
    public static final String BAD_LENGTH = "Longitud invalida";

    public static String badLength(int min, int max){
       return String.format("%s, [minimo aceptado: %s, maximo aceptado: %s]", BAD_LENGTH, min, max);
    }

}
