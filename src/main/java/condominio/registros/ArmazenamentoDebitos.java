package condominio.registros;

import condominio.Administrador;
import condominio.Morador;
import condominio.Usuario;
import condominio.excecoes.adminNaoVerificadoException;

import java.util.HashMap;
import java.util.Map;

/* Principal meio para acessar os registros.
Criar primeiro o objeto 'Debito',
depois adicionar criando um objeto desta classe,
e usando 'adicionar()' */
public class ArmazenamentoDebitos {

    private Map<Integer, Debito> armazenamento = new HashMap<>();
    private double taxasLiquidasSomadas;
    private int taxaCondominialPorcentagem = 0; //Porcentagem,  0 a 100
    private boolean adminVerificado;

    public ArmazenamentoDebitos(double taxasLiquidasSomadas){
        this.taxasLiquidasSomadas = taxasLiquidasSomadas;
    }
    public ArmazenamentoDebitos(double taxasLiquidasSomadas, int taxaCondominialPorcentagem){ //Em caso de uma porcentagem ser aplicada
        this.taxasLiquidasSomadas = taxasLiquidasSomadas;
        this.taxaCondominialPorcentagem = taxaCondominialPorcentagem;
    }

    //Métodos administrativos
    public void verificaAdmin(Usuario adminInserido){
        this.adminVerificado = adminInserido instanceof Administrador;
    }
    public void deslogaAdmin(){ //Sempre executar após fim de uso.
        if (adminVerificado){
            this.adminVerificado = false;
        }
    }

    public void criarNovoRegistro(Morador moradorInserido){ //Criar novo debito e adiciona ao armazenamento
        if (!this.adminVerificado){ //Verifica foi logado por admin
            throw new adminNaoVerificadoException();
        }
        Debito debitoCriado = new Debito(moradorInserido);
        this.armazenamento.put(debitoCriado.getResponsavel().getNumeroAp(), debitoCriado);
    }

    public void registrarNovoValor(Morador moradorInserido, String mesReferencia, double valorInserido){
        if (!this.adminVerificado){
            throw new adminNaoVerificadoException();
        }
        Debito debitoSelecionado = this.armazenamento.get( moradorInserido.getNumeroAp() );
        debitoSelecionado.registrar(mesReferencia, valorInserido);
    }

    //Ao pagar
    public void excluirValor(Morador moradorInserido, String mesReferencia){
        if (!this.adminVerificado){
            throw new adminNaoVerificadoException();
        }
        Debito debitoSelecionado = this.armazenamento.get( moradorInserido.getNumeroAp() );
        debitoSelecionado.remover(mesReferencia);
    }

    //Getters de valores para pagamento
    private double getValorDebito(Morador moradorInserido, String mesReferencia){
        Debito debitoAchado = this.armazenamento.get( moradorInserido.getNumeroAp() );
        return debitoAchado.getRegistro(mesReferencia);
    }
    public double getValorComTaxa(Morador moradorInserido, String mesReferencia){
        double valorComTaxa = getValorDebito(moradorInserido, mesReferencia) + this.taxasLiquidasSomadas;
        if (this.taxaCondominialPorcentagem > 0){
            valorComTaxa += valorComTaxa * getTaxaCondominial();
        }
        return valorComTaxa;
    }

    //Getters
    public double getTaxaLiquidaAtual() {
        return taxasLiquidasSomadas;
    }
    public double getTaxaCondominial() {
        return (double) taxaCondominialPorcentagem / 100;
    }

    //Setters
    public void setTaxasLiquidas(double taxaInserida) {
        this.taxasLiquidasSomadas = taxaInserida;
    }
    public void setTaxaCondominial(int taxaInserida) {
        this.taxaCondominialPorcentagem = taxaInserida;
    }
}
