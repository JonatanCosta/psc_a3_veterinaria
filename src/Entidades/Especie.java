package Entidades;

public class Especie {
    private int id;
    private String nome;

    Especie (int id, String name) {
        this.id = id;
        this.nome = name;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }
}
