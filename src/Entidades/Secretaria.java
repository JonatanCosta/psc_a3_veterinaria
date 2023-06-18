package Entidades;

public class Secretaria {
    private int id;

    private String CPF;

    private String nome;

    private String telefone;

    Secretaria (int id, String CPF, String nome, String telefone) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
    }

    Secretaria () {

    }

    public String getCPF() {
        return this.CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
