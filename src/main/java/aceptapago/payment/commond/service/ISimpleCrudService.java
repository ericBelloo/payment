package aceptapago.payment.commond.service;

import java.util.List;

public interface ISimpleCrudService<T, E> {

    /*
    * Metodo para guardar una instancia
    * */
    T save(E instance)                                                                                      ;
    /*
    * Metodo para actualizar una instancia
    * */
    T update(E instance);
    /*
    * Metodo para eliminar una instancia (Borrado logico)
    * */
    T delete(E instance);
    /*
    * Metodo para obtener una lista de
    * */
    List<T> SelectedParam(E instance);
}
