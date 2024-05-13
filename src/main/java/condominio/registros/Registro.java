package condominio.registros;

import java.util.ArrayList;
import java.util.List;

public abstract class Registro {

    protected List< String > armazenamento; //Definir em cada classe a necessidade.

    public abstract void registrar(String conteudo);

    //Getters
    public abstract String getRegistro();

    public abstract void remover(int posicao);
}
