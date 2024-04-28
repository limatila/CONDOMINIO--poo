package condominio;

public class Morador extends Usuario {

    String placaCarro;
    int numeroAp;

    @Override
    public void Autenticar() { // deve receber senha(?) e modificar o status

    }

    @Override
    public void Deslogar() { // deve checar se já está logado, e modificar o valor

    }

    //Getters
    @Override
    public boolean isAutenticado() {
        return this.autenticado;
    }

    public String getPlacaCarro() {
        return this.placaCarro;
    }

    public int getNumeroAp() {
        return this.numeroAp;
    }

}
