package aceptapago.payment.card.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.relational.core.sql.In;

public class SelectedCard {

    /*
    * Modelo para mostrar la informacion de una tarjeta seleccionada
    * */

    @JsonProperty("numeroTarjeta")
    private String aid;
    @JsonProperty("clave")
    private String cvv;
    @JsonProperty("fechaCreacion")
    private String createAt;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
