package Servico;

import DAO.AgendamentoDAO;
import DAO.AnimalDAO;
import DAO.ResponsavelDAO;
import Entidades.Agendamento;

import java.util.Scanner;

public class AgendamentoServico extends Utils {

    public void cadastrarAgendamento() {
        Scanner ler = new Scanner(System.in);

        limpaTela();

        Agendamento agendamento = new Agendamento();

        System.out.print("Digite a data do agendamento (dd/MM/YYYY): ");
        agendamento.setDataAgendamento(ler.nextLine());

        limpaTela();
        System.out.print("Digite a hora do agendamento (00:00): ");
        agendamento.setHora(ler.nextLine());

        limpaTela();
        agendamento.setResponsavelId(this.buscarResponsavel());

        limpaTela();
        agendamento.setAnimalId(this.buscarAnimal(agendamento.getResponsavelId()));

        limpaTela();


        //Salva no final no banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.cadastrarAgendamento(agendamento);

    }

    public void listarAgendamentos() {

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

    private int buscarAnimal(int responsavelId) {
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
}
