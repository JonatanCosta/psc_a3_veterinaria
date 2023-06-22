package Servico;

import DAO.AnimalDAO;
import DAO.ResponsavelDAO;
import Entidades.Animal;
import java.util.Scanner;


public class AnimalServico extends Utils {
    public void listarAnimais() {

    }

    public void cadastrarAnimal() {
        Scanner ler = new Scanner(System.in);

        limpaTela();

        Animal animal = new Animal();

        System.out.print("Digite o nome do Animal: ");
        animal.setNome(ler.nextLine());

        limpaTela();
        System.out.print("Digite o porte do Animal: ");
        animal.setPorte(ler.nextLine());

        limpaTela();
        System.out.print("Digite a idade do animal: ");
        animal.setIdade(ler.nextInt());

        limpaTela();
        animal.setResponsavel_id(this.selecionarResponsavel(ler));

        limpaTela();
        int especieId = this.selecionarEspecie();

        animal.setRaca_id(this.selecionarRaca(especieId));

        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.inserirAnimal(animal);

        limpaTela();
        mensagemSucesso("ANIMAL CADASTRADO COM SUCESSO");
    }

    private int selecionarResponsavel(Scanner ler) {
        String resposta;
        ResponsavelServico responsavelServico = new ResponsavelServico();

        System.out.print("O responsável já está cadastrado? (sim/não): ");

        do {
            resposta = ler.nextLine().toLowerCase();
        } while (!resposta.equals("sim") && !resposta.equals("não"));

        if (resposta.equals("sim")) {
            return this.buscarResponsavel();
        }

        return responsavelServico.cadastrarResponsavel();
    }

    public int buscarResponsavel() {
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

    public int selecionarEspecie() {
        Scanner ler = new Scanner(System.in);

        int especieId = 0;

        System.out.println("Especies: ");

         do {
            EspecieServico especieServico = new EspecieServico();
            especieServico.listarEspecie();
            System.out.print("Digite o código da especie do animal: ");

            int especieDigitada = ler.nextInt();

            int verificaEspecie = especieServico.buscarEspeciePorID(especieDigitada);

            if (verificaEspecie != 0) {
                especieId = especieDigitada;
            }
        } while (especieId == 0);

        return especieId;
    }

    public int selecionarRaca(int especieId) {
        Scanner ler = new Scanner(System.in);

        int racaId = 0;

        System.out.println("Raças: ");

        do {
            RacaServico racaServico = new RacaServico();
            racaServico.listarRacasPorEspecie(especieId);
            System.out.print("Digite o código da raça do animal: ");

            int racaDigitada = ler.nextInt();

            int verificaRaca = racaServico.buscarRacaPorIDeEspecie(racaDigitada, especieId);

            if (verificaRaca != 0) {
                racaId = racaDigitada;
            }
        } while (racaId == 0);

        return racaId;
    }
}
