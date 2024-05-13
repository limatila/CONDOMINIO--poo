package condominio.excecoes;

public class adminNaoVerificadoException extends RuntimeException {
    public adminNaoVerificadoException(){
        super("Admin não foi verificado! Abortando processo.");
    }
}
