package Entidades;

public class TipoDePagamento {
    private int id;

    private String nomePagamento;

    TipoDePagamento(int id, String nomePagamento) {
        this.id = id;
        this.nomePagamento = nomePagamento;
    }

    public void setNomePagamento(String nomePagamento) {
        this.nomePagamento = nomePagamento;
    }

    public String getNomePagamento () {
        return this.nomePagamento;
    }
}
