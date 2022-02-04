package aceptapago.payment.commond.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;


public class BaseResponse {

    /*
    * Plantilla de respuesta
    * @param folio :folio de la operacion
    * @param message: mensaje de la operacion
    * */

    @JsonProperty("folio")
    private String folio;
    @JsonProperty("mensaje")
    private String message;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
