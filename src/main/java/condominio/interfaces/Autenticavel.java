package condominio.interfaces;

public interface Autenticavel {

    public void Autenticar();

    public void Deslogar();

    public boolean isAutenticado(); //Retorna true/false para quaisquer operações de que necessitam o usuário estar logado.
}
