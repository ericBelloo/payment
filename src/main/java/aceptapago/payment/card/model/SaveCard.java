package aceptapago.payment.card.model;

import aceptapago.payment.commond.utils.MessageResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import lombok.Setter;
import lombok.Getter;


public class SaveCard {
    /*
    * Modelo para guardar tarjeta
    * */

    @JsonProperty("numeroTarjeta")
    @NotNull(message = MessageResponse.NOT_NULL)
    @NotBlank(message = MessageResponse.NOT_BLANK)
    @Size(min = 16, max = 16, message = MessageResponse.BAD_LENGTH)
    @Pattern(regexp = "^([1-9]{4})([0-9]{4})([0-9]{4})([0-9]{4})$", message = MessageResponse.BAD_FORMAT)
    @Getter @Setter private String pan;

    @JsonProperty("clave")
    @NotNull(message = MessageResponse.NOT_NULL)
    @NotBlank(message = MessageResponse.NOT_BLANK)
    @Size(min = 3, max = 3, message = MessageResponse.BAD_LENGTH)
    @Pattern(regexp = "^([0-9]{3})$", message = MessageResponse.BAD_FORMAT)
    @Getter @Setter private String ccv;

    @JsonProperty("fechaExpiracion")
    @NotNull(message = MessageResponse.NOT_NULL)
    @NotBlank(message = MessageResponse.NOT_BLANK)
    @Size(min = 6, max = 7, message = MessageResponse.BAD_LENGTH)
    @Pattern(regexp = "^(0?[1-9]|1[012])([2-9][0-9]{3})$", message = MessageResponse.BAD_FORMAT)
    @Getter @Setter private String expirationDate;

}
