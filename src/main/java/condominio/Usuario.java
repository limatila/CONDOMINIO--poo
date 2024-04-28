package condominio;

import condominio.interfaces.Autenticavel;

public abstract class Usuario implements Autenticavel {

    private String nome, endereco;
    private int telefoneContato;
    //! implementar com mais informações importantes!

    //! Lembrar de criar construtor pra cada subclasse.

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public int getContato() {
        return this.telefoneContato;
    }

}
