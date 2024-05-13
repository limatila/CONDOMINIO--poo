package condominio.registros;

import condominio.Administrador;
import condominio.Funcionario;
import condominio.Usuario;
import condominio.excecoes.metodoInvalidoException;
import condominio.excecoes.usuarioInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Comunicado extends Registro {

    //Ocorrencia para funcionarios, Comunicado para admins
    //Apenas conteúdos dos problemas
    private List<String> armazenamentoOcorrencia = new ArrayList<>();
    private List<String> armazenamentoComunicado = new ArrayList<>();

    //Métodos
    public void registrar(String conteudo, Usuario usuarioRequisitante){
        //Verifica se admin/funcionario
        if ( usuarioRequisitante instanceof Funcionario ) {
            armazenamentoOcorrencia.add(conteudo);
        } else if (usuarioRequisitante instanceof Administrador) {
            armazenamentoComunicado.add(conteudo);
        } else {
            throw new usuarioInvalidoException( usuarioRequisitante.getNome() );
        }
    }

    public void removerOcorrencia(int posicao){
        armazenamentoOcorrencia.remove(posicao);
    }
    public void removerComunicado(int posicao){
        armazenamentoComunicado.remove(posicao);
    }

    //Getters
    public String getOcorrencia(int posicao) {
        return armazenamentoOcorrencia.get(posicao);
    }
    public String getComunicado(int posicao) {
        return armazenamentoComunicado.get(posicao);
    }

    //Métodos substituidos
    @Override
    public void registrar(String conteudo) {
        throw new metodoInvalidoException();
    }
    @Override
    public String getRegistro() {
        throw new metodoInvalidoException();
    }
    @Override
    public void remover(int posicao) {
        throw new metodoInvalidoException();
    }
}
