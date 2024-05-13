package condominio.interfaces;

public interface Autenticavel {

    public void Autenticar(String senhaInserida);

    public void Deslogar();

    public boolean isAutenticado(); //Retorna true/false para quaisquer operações de que necessitam o usuário estar logado.
}
