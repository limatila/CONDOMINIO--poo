package condominio.registros;

import condominio.Morador;
import condominio.excecoes.metodoInvalidoException;

import java.util.HashMap;
import java.util.Map;

//!USAR 'ArmazenamentoDebitos.java' MAJORITARIAMENTE!!!
public class Debito extends Registro {
    //Todas as operações devem ser feitas pelo 'ArmazenamentoDebitos'!!!
    protected Map<String, Double> armazenamento = new HashMap<>(); //MÊS de referência (extenso) e VALOR

    private Morador moradorResponsavel; //Um objeto de débitos para cada morador

    //Construtor
    public Debito(Morador moradorResponsavel){
        this.moradorResponsavel = moradorResponsavel;
    }

    //Métodos
    public void registrar(String mesReferencia, double valorAPagar){
        this.armazenamento.put(mesReferencia, valorAPagar);
    }
    public void remover(String mesReferencia){
        this.armazenamento.remove(mesReferencia);
    }

    //Getters
    public double getRegistro(String mesReferencia){
        return this.armazenamento.get(mesReferencia);
    }
    public Morador getResponsavel() {
        return this.moradorResponsavel;
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
