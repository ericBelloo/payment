package aceptapago.payment.card.web;

import aceptapago.payment.card.model.SaveCard;
import aceptapago.payment.card.services.CardService;
import aceptapago.payment.commond.model.response.BaseResponse;
import aceptapago.payment.commond.model.response.ErrorResponse;
import aceptapago.payment.commond.model.response.SuccessResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class CardController {

    private final CardService cardService;
    private ObjectError error;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/tarjeta")
    public @JsonFormat BaseResponse test(){
        /*
         * Valida que el servicio este funcionando
         * */
        return new BaseResponse();
    }

    /**
     * Guarda las datos de una tarjeta
     * @param userId identificador del usuario
     * @param userSession sesion activa del usuario
     * @param accessId identificador de acceso
     * @param card request de la tarjeta
     * @return SuccessResponse respuesta de exitp
     */
    @PostMapping("tajeta/guardar-pago")
    public @JsonFormat SuccessResponse<?> SaveCardPayment(
            @RequestHeader("x-id-usuario") Integer userId,
            @RequestHeader("x-id-session") String userSession,
            @RequestHeader("x-id-acceso") String accessId,
            @Valid @RequestBody SaveCard card
    ) {
        return new SuccessResponse<>(cardService.save(card));
    }

    @GetMapping("tarjeta/obtener-tarjeta/{cardId}")
    public @JsonFormat SuccessResponse<?> SelectedCard(
            @RequestHeader("x-id-usuario") Integer userId,
            @RequestHeader("x-id-session") String userSession,
            @RequestHeader("x-id-acceso") String accessId,
            @PathVariable("cardId") Integer cardId
    ){
        return new SuccessResponse<>(cardService.selectedElement(cardId));
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class})
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        /**
         * Manejador de exceptiones para validaciones
         */
        BindingResult exceptions = e.getBindingResult();
        List<FieldError> errors = exceptions.getFieldErrors();
        /**
         * Lista de mensajes de error
         */
        ArrayList<String> details = new ArrayList<>();
        errors.forEach(error -> details.add( error.getField() + " : " + error.getDefaultMessage()));

        return new ErrorResponse(details);
    }

}
