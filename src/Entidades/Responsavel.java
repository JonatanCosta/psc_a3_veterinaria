package Entidades;

public class Responsavel {
    private int id;

    private String CPF;

    private String nome;

    private String telefone;

    private int secretaria_id;

    private int endereco_id;

    public Responsavel(int id, String CPF, String nome, String telefone, int secretaria_id, int endereco_id) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.secretaria_id = secretaria_id;
        this.endereco_id = endereco_id;
    }

    public Responsavel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF.replaceAll("[^0-9]", "");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getSecretaria_id() {
        return secretaria_id;
    }

    public void setSecretaria_id(int secretaria_id) {
        this.secretaria_id = secretaria_id;
    }

    public int getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }
}
