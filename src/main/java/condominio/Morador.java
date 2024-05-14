package condominio;

import condominio.excecoes.metodoInvalidoException;
import condominio.excecoes.usuarioInvalidoException;
import condominio.excecoes.usuarioNaoLogadoException;
import condominio.registros.ArmazenamentoDebitos;
import condominio.registros.Comunicado;
import condominio.registros.ReclameAqui;

public class Morador extends Usuario {

    protected String placaCarro;
    protected int numeroAp;

    //Construtores
    Morador(String nome, int telefoneContato, int numeroAp, String senha, String placaCarro){
        super(nome, "Condomínio Bela Vista", senha, telefoneContato);
        this.numeroAp = numeroAp;
        this.placaCarro = placaCarro;
    }

    Morador(String nome, int telefoneContato, int numeroAp, String senha){
        super(nome, "Condomínio Bela Vista", senha,  telefoneContato);
        this.numeroAp = numeroAp;
    }

    //Métodos
    public void registrarReclamacao(String conteudo, ReclameAqui registroInserido){
        if (this.autenticado) {
            registroInserido.registrar(this, conteudo);
        } else { throw new usuarioNaoLogadoException(); }
    }
    public double consultarValorDebito(ArmazenamentoDebitos DebitosInseridos, String mesReferencia){
        if (this.autenticado) {
            double valorEncontrado = DebitosInseridos.getValorComTaxa(this, mesReferencia);
            System.out.println("O valor encontrado foi de: " + valorEncontrado);
            return valorEncontrado;
        } else { throw new usuarioNaoLogadoException(); }
    }
    public void verComunicado(Comunicado registroInserido, int posicaoSelecionada, boolean verOcorrencia){
        if(this.autenticado) {
            if(!verOcorrencia){
                registroInserido.getComunicado(posicaoSelecionada);
            } else { //true para selecionar ocorrencias de funcionarios
                registroInserido.getOcorrencia(posicaoSelecionada);
            }
        } else { throw new usuarioNaoLogadoException(); }
    }


    //Getters
    public String getPlacaCarro() { //* Pode ser implementado para aplicar uma taxa sobre isso, por exemplo
        return this.placaCarro;
    }

    public int getNumeroAp() {
        return this.numeroAp;
    }

    public int getContato(Usuario usuarioRequisitante) { //!Versão sem parametro de usuário não deve ser usada.
        //Rodará apenas se um usuário válido for o requisitante
        if (usuarioRequisitante instanceof Funcionario || usuarioRequisitante instanceof Administrador){
            return this.telefoneContato;
        } else {
            throw new usuarioInvalidoException( usuarioRequisitante.getNome() );
        }
    }

    //Setters
    public void setPlacaCarro(String placaCarro, Usuario usuarioRequisitante) {
        if(usuarioRequisitante instanceof Administrador) {
            this.placaCarro = placaCarro;
        } else { throw new usuarioInvalidoException(usuarioRequisitante.getNome()); }
    }

    public void setNumeroAp(int numeroAp, Usuario usuarioRequisitante) {
        if(usuarioRequisitante instanceof Administrador) {
            this.numeroAp = numeroAp;
        } else { throw new usuarioInvalidoException(usuarioRequisitante.getNome()); }
    }

    //Métodos substituidos
    @Override
    public int getContato(){
        throw new metodoInvalidoException();
    }
}
