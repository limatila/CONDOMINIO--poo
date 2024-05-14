import condominio.registros.ArmazenamentoDebitos;
import condominio.registros.Comunicado;
import condominio.registros.ReclameAqui;
import org.junit.Assert;
import org.junit.Test;

import condominio.*;

//! Ao usar, precisa ter o JUnit instalado. No Intellij Idea ele pode ser instalado automaticamente
public class TesteCarlos {

    //Objetos padrão
    Comunicado comunicados = new Comunicado();
    ReclameAqui reclamacoes = new ReclameAqui();


    @Test //* Se algum destes comandos for errado, dará erro pelo teste.
    public void adminCarlosUsaOSistemaCompletamente(){
        Administrador carlos = new Administrador("Carlos", "Rua coco verde", "123456", 89637793);
        carlos.Autenticar("123456"); //Necessário para utilizar os métodos do mesmo

        //Passo 1
        Morador morador1 = (Morador) carlos.criaUsuario("Morador", "José", null, "32238142", 32238142); //Cria e guarda um morador
        morador1.setNumeroAp(302, carlos);

        //Passo 2
        ArmazenamentoDebitos armazem = new ArmazenamentoDebitos(0); //Cria um armazenamento de débitos
        armazem.setTaxasLiquidas(305.30, carlos); //Seta taxa a somar a todas as faturas
        armazem.setTaxaCondominial(9 /* porcentagem */, carlos); //Seta taxa de porcentagem encima do calculo final

        //Passo 3
        double taxaLiquida = armazem.getTaxaLiquidaAtual();
        double taxaCondominial = armazem.getTaxaCondominial();

        //Passo 4
        Funcionario funcionario1 = (Funcionario) carlos.criaUsuario("Funcionario", "Seu Marcos", "Rua Pojasiras", "159951", 32231515);
        funcionario1.Autenticar("159951");

        funcionario1.registrarOcorrencia("A entrada do prédio está molhada, tenham cuidado.", comunicados);
        morador1.Autenticar("32238142"); //Ainda não foi autenticado
        morador1.registrarReclamacao("A piscina está SUJA! necessária limpeza urgente!", reclamacoes);
        carlos.registrarOcorrencia("Favor apresentar informações de visitantes na portaria.", comunicados);

        //Passo 5
        int numeroDeMoradorEncontrado =  morador1.getContato(funcionario1);

        //Passo 6
        armazem.verificaAdmin(carlos); //Deve verificar antes de usar
        armazem.criarNovoRegistro(morador1);
        armazem.registrarNovoValor(morador1, "Fevereiro", 1580.0);
        double valorPagamento = armazem.getValorComTaxa(morador1, "Fevereiro");

        //Asserts finais de confirmação
        Assert.assertEquals( 2054.9F , (float) valorPagamento, 0.1);
        Assert.assertEquals( 305.30F, (float) taxaLiquida, 0.1 );
        Assert.assertEquals( 0.09F, (float) taxaCondominial, 0.1);
        Assert.assertEquals( 32238142, numeroDeMoradorEncontrado );
        Assert.assertEquals( "A entrada do prédio está molhada, tenham cuidado.", comunicados.getOcorrencia(0) );
        Assert.assertEquals( "Favor apresentar informações de visitantes na portaria.", comunicados.getComunicado(0) );
    }
}
