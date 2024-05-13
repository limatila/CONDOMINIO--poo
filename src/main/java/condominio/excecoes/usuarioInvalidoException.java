package condominio.excecoes;

public class usuarioInvalidoException extends RuntimeException {
    public usuarioInvalidoException(String usuarioJogado){
        super("Usuário inválido inserido:" + usuarioJogado);
    }
}
