package condominio.registros;

import condominio.Usuario;
import condominio.excecoes.metodoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ReclameAqui extends Registro {

    protected List< String[] > armazenamento = new ArrayList<>(); //NOME e CONTEUDO por entrada!

    //Métodos
    public void registrar(String conteudo, Usuario pessoaResponsavel) {
        this.armazenamento.add( new String[]{ conteudo, pessoaResponsavel.getNome() } );
    }

    public void remover(int posicao){
        this.armazenamento.remove(posicao);
    };

    //Getters
    public String[] getRegistro(int posicaoInserida) {
        return this.armazenamento.get(posicaoInserida);
    }

    //Métodos substituídos
    @Override
    public void registrar(String conteudo) {
        throw new metodoInvalidoException();
    }
    @Override
    public String getRegistro() {
        throw new metodoInvalidoException();
    }
}
