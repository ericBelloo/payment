package aceptapago.payment.commond.service;

public interface IUpdateService<T, O> {
    /*
     * Metodo para actualizar una instancia
     * */
    T update(O instance);
}
