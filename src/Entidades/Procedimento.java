package Entidades;

public class Procedimento {
    private int id;

    private String nome_procedimento;

    private float preco_atendimento;

    public Procedimento(int id, String nome_procedimento, float preco_atendimento) {
        this.id = id;
        this.nome_procedimento = nome_procedimento;
        this.preco_atendimento = preco_atendimento;
    }

    public Procedimento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProcedimento() {
        return nome_procedimento;
    }

    public void setNomeProcedimento(String nome_procedimento) {
        this.nome_procedimento = nome_procedimento;
    }

    public float getPrecoAtendimento() {
        return preco_atendimento;
    }

    public void setPrecoAtendimento(float preco_atendimento) {
        this.preco_atendimento = preco_atendimento;
    }
}
