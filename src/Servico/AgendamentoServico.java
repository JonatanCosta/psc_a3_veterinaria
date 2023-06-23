package Servico;

import DAO.*;
import Entidades.Agendamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AgendamentoServico extends Utils {

    public void cadastrarAgendamento() {
        Agendamento agendamento = new Agendamento();

        limpaTela();
        agendamento.setDataAgendamento(this.validarData());

        limpaTela();
        agendamento.setHora(this.validarHora());

        limpaTela();
        agendamento.setResponsavelId(this.buscarResponsavel());

        limpaTela();
        agendamento.setAnimalId(this.buscarAnimal(agendamento.getResponsavelId()));

        limpaTela();
        agendamento.setClinicaId(this.buscarClinica());

        limpaTela();
        agendamento.setVeterinarioId(this.buscarVeterinario());

        limpaTela();
        agendamento.setTipodePagamentoId(this.buscarTipoPagamento());

        limpaTela();
        agendamento.setProcedimentoId(this.buscarProcedimento());

        //Salva no final no banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.cadastrarAgendamento(agendamento);

        mensagemSucesso("AGENDAMENTO EFETUADO COM SUCESSO");

    }

    private String validarData() {
        String dataValida = "invalida";
        Scanner ler = new Scanner(System.in);

        do {
            System.out.print("Digite a data do agendamento (dd/MM/YYYY): ");

            try {
                String dataDigitada = ler.nextLine();

                SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");
                formatoDate.parse(dataDigitada);

                dataValida = dataDigitada;
            } catch (ParseException e) {
                System.out.println("*** ATENÇÃO DATA INVÁLIDA ***");
                dataValida = "invalida";
            }
        } while (dataValida == "invalida");;

        return dataValida;
    }

    private String validarHora() {
        String horaValida = "invalida";
        Scanner ler = new Scanner(System.in);

        do {
            System.out.print("Digite a hora do agendamento (00:00): ");

            try {
                String dataDigitada = ler.nextLine();

                SimpleDateFormat formatoDate = new SimpleDateFormat("HH:mm");
                formatoDate.parse(dataDigitada);

                horaValida = dataDigitada;
            } catch (ParseException e) {
                System.out.println("*** ATENÇÃO HORA INVÁLIDA ***");
                horaValida = "invalida";
            }
        } while (horaValida == "invalida");;

        return horaValida;
    }

    public void listarAgendamentos() {
        limpaTela();
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.listarAgendamentos();
        int continuar = 0;
        Scanner ler = new Scanner(System.in);
        do{
            System.out.print("Digite 1 para voltar");
            continuar = ler.nextInt();
        } while (continuar == 0);
    }

    public void excluirAgendamento() {

    }

    public void editarAgendamento() {

    }

    private int buscarResponsavel() {
        Scanner ler = new Scanner(System.in);
        int responsavelId = 0;

        do {
            //limpaTela();
            System.out.print("Digite o CPF do responsavel ou 0 parada cadastrar: ");
            String CPFDigitado = ler.nextLine().toLowerCase().replaceAll("[^0-9]", "");

            if (Long.parseLong(CPFDigitado) == 0) {
                ResponsavelServico responsavelServico = new ResponsavelServico();
                return responsavelServico.cadastrarResponsavel();
            }

            ResponsavelDAO responsavelDAO = new ResponsavelDAO();

            responsavelId = responsavelDAO.buscarIDResponsavelPorCPF(CPFDigitado);
        } while (responsavelId == 0);

        return responsavelId;
    }

    public int buscarAnimal(int responsavelId) {
        Scanner ler = new Scanner(System.in);


        int animalId = 0;

        do {
            AnimalServico animalServico = new AnimalServico();
            animalServico.listarAnimaisPorDono(responsavelId);

            System.out.print("Digite o código do animal: ");
            int codigoDigitado = ler.nextInt();

            AnimalDAO animalDAO = new AnimalDAO();

            int verificarId = animalDAO.buscarIDAnimalPorDono(codigoDigitado, responsavelId);

            if (verificarId != 0) {
                animalId = verificarId;
            }

        } while (animalId == 0);

        return animalId;

    }

    public int buscarClinica() {
        Scanner ler = new Scanner(System.in);


        int clinicaId = 0;

        do {
            ClinicaDAO clinicaDAO = new ClinicaDAO();
            clinicaDAO.listarClinicas();

            System.out.print("Digite o código da Clinica: ");
            int codigoDigitado = ler.nextInt();

            int verificarId = clinicaDAO.buscarClinicaPorId(codigoDigitado);

            if (verificarId != 0) {
                clinicaId = verificarId;
            }

        } while (clinicaId ==0);

        return clinicaId;
    }

    public int buscarVeterinario() {
        Scanner ler = new Scanner(System.in);

        int veterinarioId = 0;

        do {
            VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
            veterinarioDAO.listarVeterinarios();

            System.out.print("Digite o código do Veterinário: ");
            int codigoDigitado = ler.nextInt();

            int verificarId = veterinarioDAO.buscarVeterinarioPorId(codigoDigitado);

            if (verificarId != 0) {
                veterinarioId = verificarId;
            }

        } while (veterinarioId ==0);

        return veterinarioId;
    }

    public int buscarTipoPagamento() {
        Scanner ler = new Scanner(System.in);

        int tipoDePagamentoId = 0;

        do {
            TipoDePagamentoDAO tipoDePagamentoDAO = new TipoDePagamentoDAO();
            tipoDePagamentoDAO.listarTiposDePagamento();

            System.out.print("Digite o código da forma de Pagamento: ");
            int codigoDigitado = ler.nextInt();

            int verificarId = tipoDePagamentoDAO.buscarTipoPagamentoPorId(codigoDigitado);

            if (verificarId != 0) {
                tipoDePagamentoId = verificarId;
            }

        } while (tipoDePagamentoId ==0);

        return tipoDePagamentoId;
    }

    public int buscarProcedimento() {
        Scanner ler = new Scanner(System.in);

        int procedimentoId = 0;

        do {
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            procedimentoDAO.listarProcedimentos();

            System.out.print("Digite o código do procedimento: ");
            int codigoDigitado = ler.nextInt();

            int verificarId = procedimentoDAO.buscarProcedimentoPorId(codigoDigitado);

            if (verificarId != 0) {
                procedimentoId = verificarId;
            }

        } while (procedimentoId ==0);

        return procedimentoId;
    }
}
