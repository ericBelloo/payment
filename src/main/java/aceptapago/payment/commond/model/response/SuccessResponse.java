package aceptapago.payment.commond.model.response;

public class SuccessResponse<T> {

    /*
     * Plantilla de respuesta
     * @param result: tipo de resultado
     * */

    public T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public SuccessResponse(T result) {
        this.result = result;
    }
}
