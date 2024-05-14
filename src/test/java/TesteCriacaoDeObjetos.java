import condominio.excecoes.adminNaoVerificadoException;
import condominio.excecoes.senhaErradaException;
import condominio.excecoes.tipoUsuarioInvalidoException;
import condominio.registros.ArmazenamentoDebitos;
import org.junit.Test;
import org.junit.Assert;

import condominio.*;

public class TesteCriacaoDeObjetos {

    Administrador adminPadrao = new Administrador("Fulano", "Rua Amadeus", "32238142", 12349531);

    @Test
    public void deveRetornarCondominioDeMorador(){ //* E outros dados comuns de Morador
        adminPadrao.Autenticar("32238142");
        int contatoAdicionado = 28809553;
        String placaAdicionada = "VUY3918";

        Morador morador = (Morador) adminPadrao.criaUsuario("Morador", "João", null, "35359301", contatoAdicionado);
        morador.setNumeroAp(5591, adminPadrao);
        morador.setPlacaCarro(placaAdicionada, adminPadrao);
        int contatoEncontrado = morador.getContato(adminPadrao);

        Assert.assertEquals(contatoAdicionado, contatoEncontrado);
        Assert.assertEquals("Condomínio Bela Vista", morador.getEndereco());
        Assert.assertEquals(placaAdicionada, morador.getPlacaCarro());
    }

    @Test
    public void deveRetornarCargoDeFuncionario(){
        adminPadrao.Autenticar("32238142");
        String cargoAdicionado = "Porteiro";

        Funcionario funcionario = (Funcionario) adminPadrao.criaUsuario("Funcionario", "Seu Marcos", "Rua Bela Vista", "17179212", 32328181);
        funcionario.setCargo(cargoAdicionado, adminPadrao);
        String cargoEncontrado = funcionario.getCargo();

        Assert.assertEquals(cargoAdicionado, cargoEncontrado);
    }

    @Test
    public void funcionarioDeveEncontrarContatoDeMorador(){
        adminPadrao.Autenticar("32238142");
        Funcionario funcionario = (Funcionario) adminPadrao.criaUsuario("Funcionario", "Vanessa", "Rua Marcos Fontenelle", "31922344", 97711212);
        funcionario.setCargo("Limpeza", adminPadrao);
        int contatoAdicionado = 12345678;

        Morador morador = (Morador) adminPadrao.criaUsuario("Morador", "José Fontes", null, "90098767", contatoAdicionado);
        int contatoEncontrado = morador.getContato(funcionario);

        Assert.assertEquals(contatoAdicionado, contatoEncontrado);
    }

    //Erros
    @Test (expected = senhaErradaException.class)
    public void deveErrarQuandoSeErraASenhaCriada(){
        adminPadrao.Autenticar("ablubluble"); //Não é a mesma que eu defini lá encima
    }

    @Test (expected = adminNaoVerificadoException.class)
    public void deveErrarAoNaoVerificarAdmin(){
        adminPadrao.Autenticar("32238142");

        ArmazenamentoDebitos armazem = new ArmazenamentoDebitos(180.59, 30);
        armazem.criarNovoRegistro( (Morador) adminPadrao.criaUsuario
                ("Morador", "João", null, "19991999", 11111111)); //Erra aqui pois não verificou no 'armazem' antes
    }

    @Test (expected = tipoUsuarioInvalidoException.class)
    public void deveErrarAoCriarUsuarioInvalidoNoSistema(){
        adminPadrao.Autenticar("32238142");
        adminPadrao.criaUsuario("Entregador", "João Fulan", "?", "12349090", 35933866);
    }

}
