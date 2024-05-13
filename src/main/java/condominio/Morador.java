package condominio;

import condominio.excecoes.metodoInvalidoException;
import condominio.excecoes.usuarioInvalidoException;
import condominio.registros.ReclameAqui;

public class Morador extends Usuario {

    protected String placaCarro;
    protected int numeroAp;

    //Construtores
    public Morador(String nome, int telefoneContato, int numeroAp, String senha, String placaCarro){
        super(nome, "Condomínio Bela Vista", senha, telefoneContato);
        this.numeroAp = numeroAp;
        this.placaCarro = placaCarro;
    }

    public Morador(String nome, int telefoneContato, String senha, int numeroAp){
        super(nome, "Condomínio Bela Vista", senha,  telefoneContato);
        this.numeroAp = numeroAp;
    }

    //Métodos
    public void registrarReclamacao(ReclameAqui registroInserido){

    }
    public void consultarValorPagamento(){

    }
    public void verComunicados(){

    }


    //Getters
    public String getPlacaCarro() {
        return this.placaCarro;
    }

    public int getNumeroAp() {
        return this.numeroAp;
    }

    @Override
    public int getContato(){
        throw new metodoInvalidoException();
    }

    public int getContato(Usuario usuarioRequisitante) { //!Versão sem usuário não pode ser usada.
        //Rodará apenas se um usuário válido for o requisitante
        if (usuarioRequisitante instanceof Funcionario || usuarioRequisitante instanceof Administrador){
            return this.telefoneContato;
        } else {
            throw new usuarioInvalidoException( usuarioRequisitante.getNome() );
        }
    }
}
