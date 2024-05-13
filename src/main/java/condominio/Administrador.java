package condominio;

public class Administrador extends Usuario {

    public Morador criaMorador(String nome /*! etc, criar 1 método pra cada subclasse*/ ){
        return null;
    }

    /* Como admin, ele pode modificar todo o sistema.
    *  logo cada classe deve verificar se quem chama é Administrador, e executar se sim.
    *  pode ser usado Objeto.class ou instance of pra isso (pesquisar como) */
    public void apagaUsuario();

    //Getters
}
