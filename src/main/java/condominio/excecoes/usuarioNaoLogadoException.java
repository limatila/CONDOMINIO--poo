package condominio.excecoes;

public class usuarioNaoLogadoException extends RuntimeException{
    public usuarioNaoLogadoException(){
        super("Usuário não está logado para executar essa ação.\nLogue com a senha certa primeiro para usá-lo");
    }
}
