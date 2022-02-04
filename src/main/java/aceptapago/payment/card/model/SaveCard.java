package aceptapago.payment.card.model;

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
    @NotNull
    @NotBlank
    @Size(min = 16, max = 16)
    @Pattern(regexp = "^([1-9]{4})([0-9]{4})([0-9]{4})([0-9]{4})$")
    @Getter @Setter private String pan;

    @JsonProperty("clave")
    @NotNull
    @NotBlank
    @Size(min = 4, max = 4)
    @Pattern(regexp = "^([0-9]{3})$")
    @Getter @Setter private String ccv;

    @JsonProperty("fechaExpiracion")
    @NotNull(message = "El parametro no puede estar en blanco")
    @NotBlank(message = "El parametro no puede ser nulo")
    @Size(min = 6, max = 7)
    @Pattern(regexp = "/^(0?[1-9]|1[012])\\/([2-9][0-9]{3})$/")
    @Getter @Setter private String expiration_date;

}
