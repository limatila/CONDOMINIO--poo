package condominio.excecoes;

public class senhaErradaException extends RuntimeException {
    public senhaErradaException(){
        super("Senha inserida incorretamente para o usuário! Abortando programa.");
    }
}
