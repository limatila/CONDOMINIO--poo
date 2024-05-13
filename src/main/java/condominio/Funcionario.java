package condominio;

import condominio.registros.Comunicado;

public class Funcionario extends Usuario{

    String cargo;

    public Funcionario(String nome, String endereco, String senha, int telefoneContato, String cargo) {
        super(nome, endereco, senha, telefoneContato);
        this.cargo = cargo;
    }

    //Métodos
    public void registraOcorrencia(String conteudo, Comunicado registroInserido){
        registroInserido.registrar(conteudo, this);
    }

    public int obterContatoMorador(Morador moradorInserido){
        int result = moradorInserido.getContato(this);

        System.out.println("Contato do morador: " + result + '.'); //ou fazer algo com isso.. por exemplo na hora de algum registro
        return result;
    }

    //Getters

    public String getCargo() {
        return cargo;
    }

}
