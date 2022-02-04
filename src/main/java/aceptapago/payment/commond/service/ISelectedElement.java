package aceptapago.payment.commond.service;

public interface ISelectedElement<T, O> {

    /*
    * Debuelve la informacion de la instancia seleccionada
    * */
    T selectedElement(O instance);

}
