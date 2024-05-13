package condominio.excecoes;

public class metodoInvalidoException extends RuntimeException{
    public metodoInvalidoException(){
        super("O método usado é inválido! Favor optar por outro método.");
    }
}
