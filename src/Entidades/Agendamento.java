package Entidades;

public class Agendamento {

    private int id;

    private String data_agendamento;

    private String hora;

    private int responsavel_id;

    private int animal_id;

    private int clinica_id;

    private int veterinario_id;

    private int tipo_de_pagamento_id;

    private int procedimento_id;

    public Agendamento(int id, String data_agendamento, String hora, int responsavel_id, int animal_id, int clinica_id, int veterinario_id, int tipo_de_pagamento_id, int procedimento_id) {
        this.id = id;
        this.data_agendamento = data_agendamento;
        this.hora = hora;
        this.responsavel_id = responsavel_id;
        this.animal_id = animal_id;
        this.clinica_id = clinica_id;
        this.veterinario_id = veterinario_id;
        this.tipo_de_pagamento_id = tipo_de_pagamento_id;
        this.procedimento_id = procedimento_id;
    }

    public int getId() {
        return id;
    }

    public String getDataAgendamento() {
        return data_agendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.data_agendamento = dataAgendamento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getResponsavelId() {
        return responsavel_id;
    }

    public void setResponsavelId(int responsavel_id) {
        this.responsavel_id = responsavel_id;
    }

    public int getAnimalId() {
        return animal_id;
    }

    public void setAnimalId(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getClinicaId() {
        return clinica_id;
    }

    public void setClinicaId(int clinica_id) {
        this.clinica_id = clinica_id;
    }

    public int getVeterinarioId() {
        return veterinario_id;
    }

    public void setVeterinarioId(int veterinario_id) {
        this.veterinario_id = veterinario_id;
    }

    public int getTipodePagamentoId() {
        return tipo_de_pagamento_id;
    }

    public void setTipodePagamentoId(int tipo_de_pagamento_id) {
        this.tipo_de_pagamento_id = tipo_de_pagamento_id;
    }

    public int getProcedimentoId() {
        return procedimento_id;
    }

    public void setProcedimentoId(int procedimento_id) {
        this.procedimento_id = procedimento_id;
    }
}
