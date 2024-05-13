package condominio.excecoes;

public class senhaErradaException extends RuntimeException {
    public senhaErradaException(){
        super("Senha Inserida Incorretamente! Abortando programa.");
    }
}
