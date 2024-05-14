package condominio;

import condominio.excecoes.tipoUsuarioInvalidoException;
import condominio.excecoes.usuarioNaoLogadoException;
import condominio.interfaces.Autenticavel;
import condominio.registros.ArmazenamentoDebitos;
import condominio.registros.Comunicado;

public class Administrador extends Usuario implements Autenticavel {

    public Administrador(String nome, String endereco, String senha, int telefoneContato) {
        super(nome, endereco, senha, telefoneContato);
    }

    //Métodos
    public Usuario criaUsuario(String tipoUsuario, String nome, String endereco, String senha, int telefoneContato){//Deve ser armazenado em uma variável
        if (this.autenticado) {
            switch (tipoUsuario) {// Strings possíveis: Admin, Morador, Funcionario
                case "Admin":
                    return new Administrador(nome, endereco, senha, telefoneContato);
                case "Morador":
                    return new Morador(nome, telefoneContato, 0, senha);//Setar o numero de Ap depois!
                case "Funcionario":
                    return new Funcionario(nome, endereco, senha, telefoneContato, null);//Setar o cargo depois!
                default:
                    throw new tipoUsuarioInvalidoException(tipoUsuario);
            }
        } else {
            throw new usuarioNaoLogadoException();
        }
    }

    public void registrarOcorrencia(String conteudo, Comunicado registroInserido){//* Criar Comunicado para inserir aqui!
        if (this.autenticado) {
            registroInserido.registrar(conteudo, this);
            //Registrará apenas no armazenamento específico de comunicados.
        } else { throw new usuarioNaoLogadoException(); }
    }

    public double consultarValorDebitoCliente(ArmazenamentoDebitos DebitosInseridos, Morador moradorInserido, String mesReferencia){
        if (this.autenticado) {
            double valorEncontrado = DebitosInseridos.getValorComTaxa(moradorInserido, mesReferencia);
            System.out.println("O valor encontrado foi de: " + valorEncontrado);
            return valorEncontrado;
        } else { throw new usuarioNaoLogadoException(); }
    }

    //Getters
}
