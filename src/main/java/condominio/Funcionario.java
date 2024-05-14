package condominio;

import condominio.excecoes.usuarioInvalidoException;
import condominio.excecoes.usuarioNaoLogadoException;
import condominio.registros.Comunicado;

public class Funcionario extends Usuario{

    String cargo;

    Funcionario(String nome, String endereco, String senha, int telefoneContato, String cargo) {
        super(nome, endereco, senha, telefoneContato);
        this.cargo = cargo;
    }

    //Métodos
    public void registrarOcorrencia(String conteudo, Comunicado registroInserido){//* Criar Comunicado para inserir aqui!
        if (this.autenticado){
            registroInserido.registrar(conteudo, this);
        } else { throw new usuarioNaoLogadoException(); }
    }

    public int obterContatoMorador(Morador moradorInserido){
        if (this.autenticado) {
            int result = moradorInserido.getContato(this);

            System.out.println("Contato do morador: " + result + '.'); //ou fazer algo com isso.. por exemplo na hora de algum registro
            return result;
        } else { throw new usuarioNaoLogadoException(); }
    }


    //Getters
    public String getCargo() {
        return cargo;
    }

    //Setters
    public void setCargo(String cargo, Usuario usuarioRequisitante) {
        if(usuarioRequisitante instanceof Administrador) {
            this.cargo = cargo;
        } else { throw new usuarioInvalidoException(usuarioRequisitante.getNome()); }
    }
}
