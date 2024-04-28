package condominio;

import condominio.registros.Registro;

public class Funcionario extends Usuario{

    @Override
    public void Autenticar() {

    }

    @Override
    public void Deslogar() {

    }

    public void registraOcorrencia(Registro registroInserido){
        registroInserido.registrar(tal coisa, tal descricao);
    }

    public void obterContatoMorador(Morador moradorInserido){
        int result = moradorInserido.getContato();
        System.out.println("Contato é: " + result + '.'); //ou fazer algo com isso.. por exemplo na hora de algum registro
    }

    //Getters
    @Override
    public boolean isAutenticado() {
        return this.autenticado;
    }

}
