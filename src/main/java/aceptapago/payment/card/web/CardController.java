package aceptapago.payment.card.web;

import aceptapago.payment.card.model.SaveCard;
import aceptapago.payment.card.services.CardService;
import aceptapago.payment.commond.model.response.BaseResponse;
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
import java.util.List;

@RestController
@Validated
public class CardController {

    private final CardService cardService;

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
    public String handleException(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!((List<?>) errors).isEmpty()) {
                FieldError fieldError = (FieldError) errors.get(0);
                return new String(fieldError.toString());
            }
        }
        return new String("Error");
    }

}
