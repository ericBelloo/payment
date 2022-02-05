package aceptapago.payment.commond.model.response;

import aceptapago.payment.commond.utils.FieldResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

public class ErrorResponse extends BaseResponse{

    public ErrorResponse(List<String> details) {
        this.details = details;
    }

    /**
     * Plantilla de respuestas de error
     */
    @JsonProperty("detalles")
    @Getter @Setter private List<String> details;




}
