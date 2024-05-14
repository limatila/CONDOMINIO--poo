package condominio;

import condominio.excecoes.senhaErradaException;
import condominio.interfaces.Autenticavel;

import java.util.Objects;

public abstract class Usuario implements Autenticavel {

    protected String nome;
    protected String endereco;
    protected int telefoneContato; //8 números!
    protected String senha;
    protected boolean autenticado;

    public Usuario(String nome, String endereco, String senha, int telefoneContato){
        this.nome = nome;
        this.endereco = (String) endereco;
        this.telefoneContato = telefoneContato;
    }

    public void Autenticar(String senhaInserida) { // deve receber senha(?) e modificar o status
        if(Objects.equals(senhaInserida, this.senha)){
            this.autenticado = true;
            System.out.println(this.nome + "Foi Logado");
        } else {
            throw new senhaErradaException();
        }
    }

    public void Deslogar() { // deve checar se já está logado, e modificar o valor
        if(this.autenticado){
            this.autenticado = false;
            System.out.println(this.nome + "Foi Deslogado");
        } else {
            System.out.println("Usuário não foi logado antes.");
        }
    }


    //Getters
    public boolean isAutenticado() {
        return this.autenticado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public int getContato(){
        return this.telefoneContato;
    };

}
