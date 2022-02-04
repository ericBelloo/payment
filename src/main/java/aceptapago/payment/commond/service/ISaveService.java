package aceptapago.payment.commond.service;

public interface ISaveService<T, O> {
    /*
     * Metodo para guardar una instancia
     * */
    T save(O instance);
}
