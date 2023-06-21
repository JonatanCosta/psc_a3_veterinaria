package Entidades;

public class Veterinario {
    private int id;

    private String nome;

    private String CRMV;

    private String telefone;

    Veterinario () {

    }

    Veterinario (int id, String nome, String CRMV, String telefone) {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCRMV(String CRMV) {
        this.CRMV = CRMV;
    }

    public void setTelefone(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCRMV() {
        return CRMV;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
