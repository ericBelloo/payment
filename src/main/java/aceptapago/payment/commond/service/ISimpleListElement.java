package aceptapago.payment.commond.service;

import java.util.List;

public interface ISimpleListElement<T, O> {

    /*
    * Obtiene un lista de elementos con una instancia en comun
    * */
    List<T> listElements(O instance);
    
}
