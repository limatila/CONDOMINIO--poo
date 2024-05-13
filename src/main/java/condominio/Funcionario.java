package condominio;

import condominio.registros.Comunicados;
import condominio.registros.Registro;

public class Funcionario extends Usuario{

    String cargo;

    public Funcionario(String nome, String endereco, String senha, int telefoneContato, String cargo) {
        super(nome, endereco, senha, telefoneContato);
        this.cargo = cargo;
    }

    //Métodos
    public void registraOcorrencia(Registro registroInserido){
        registroInserido.registrar(tal coisa, tal descricao);
    }

    public void registrarOcorrencia(Comunicados comunicadoInserido){

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
