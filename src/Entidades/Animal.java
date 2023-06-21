package Entidades;

public class Animal {
    private int id;

    private String nome;

    private String porte;

    private int idade;

    private int responsavel_id;

    private int secretaria_id;

    private int raca_id;

    private Responsavel responsavel;

    private Secretaria secretaria;

    private Raca raca;

    public Animal(int id, String nome, String porte, int idade, int responsavel_id, int secretaria_id, int raca_id) {
        this.id = id;
        this.nome = nome;
        this.porte = porte;
        this.idade = idade;
        this.responsavel_id = responsavel_id;
        this.secretaria_id = secretaria_id;
        this.raca_id = raca_id;
    }

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getResponsavel_id() {
        return responsavel_id;
    }

    public void setResponsavel_id(int responsavel_id) {
        this.responsavel_id = responsavel_id;
    }

    public int getSecretaria_id() {
        return secretaria_id;
    }

    public void setSecretaria_id(int secretaria_id) {
        this.secretaria_id = secretaria_id;
    }

    public int getRaca_id() {
        return raca_id;
    }

    public void setRaca_id(int raca_id) {
        this.raca_id = raca_id;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
}
