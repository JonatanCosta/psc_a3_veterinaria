package Entidades;

public class Endereco {
    private int id;

    private String CEP;

    private String rua;

    private int numero;

    private String bairro;

    public int getId() {
        return id;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public int getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
