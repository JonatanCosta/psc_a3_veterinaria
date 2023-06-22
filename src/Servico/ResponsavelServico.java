package Servico;

import DAO.ResponsavelDAO;
import Entidades.Endereco;
import Entidades.Responsavel;

import java.util.Scanner;

public class ResponsavelServico extends Utils {

    public int cadastrarResponsavel() {
        Scanner ler = new Scanner(System.in);
        Responsavel responsavel = new Responsavel();

        limpaTela();
        System.out.print("Digite o CPF: ");
        responsavel.setCPF(ler.nextLine());

        limpaTela();
        System.out.print("Digite o Nome: ");
        responsavel.setNome(ler.nextLine());

        limpaTela();
        System.out.print("Digite o telefone (apenas números com DDD)");
        responsavel.setTelefone(ler.nextLine());

        limpaTela();
        EnderecoServico enderecoServico = new EnderecoServico();
        responsavel.setEndereco_id(enderecoServico.cadastrarEndereco());

        ResponsavelDAO responsavelDAO = new ResponsavelDAO();

        return responsavelDAO.inserirResponsavel(responsavel);
    }
}
