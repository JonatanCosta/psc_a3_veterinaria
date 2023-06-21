package Entidades;

public class Clinica {

    private int id;

    private String CPNJ;

    private String razao_social;

    private String telefone;

    private int endereco_id;

    public Clinica(int id, String CPNJ, String razao_social, String telefone, int endereco_id) {
        this.id = id;
        this.CPNJ = CPNJ;
        this.razao_social = razao_social;
        this.telefone = telefone;
        this.endereco_id = endereco_id;
    }

    public Clinica() {

    }

    public String getTelefone() {
        return telefone;
    }

    public int getId() {
        return id;
    }

    public int getEndereco_id() {
        return endereco_id;
    }

    public String getCPNJ() {
        return CPNJ;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCPNJ(String CPNJ) {
        this.CPNJ = CPNJ;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }
}
