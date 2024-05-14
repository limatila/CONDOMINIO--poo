package condominio.excecoes;

public class tipoUsuarioInvalidoException extends RuntimeException {
    public tipoUsuarioInvalidoException(String tipoInserido){
        super("O tipo de usuário " + tipoInserido + "é inválido! Selecione outro.");
    }
}
