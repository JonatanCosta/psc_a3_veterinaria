package Entidades;

public class Raca {
    private int id;

    private int id_especie;

    private String nome;

    Raca (int id, int id_especie, String nome) {
        this.id = id;
        this.id_especie = id_especie;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }
}
