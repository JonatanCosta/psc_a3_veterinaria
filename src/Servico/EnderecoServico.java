package Servico;

import DAO.EnderecoDAO;
import Entidades.Endereco;

import java.util.Scanner;

public class EnderecoServico extends Utils{
    public int cadastrarEndereco () {
        Scanner ler = new Scanner(System.in);
        limpaTela();

        Endereco endereco = new Endereco();

        System.out.print("Digite o CEP do endereço: ");
        endereco.setCEP(ler.nextLine());

        limpaTela();
        System.out.print("Digite o nome do bairro: ");
        endereco.setBairro(ler.nextLine());

        limpaTela();
        System.out.print("Digite a Rua do endereço: ");
        endereco.setRua(ler.nextLine());

        limpaTela();
        System.out.print("Digite o numero do endereço: ");
        endereco.setNumero(ler.nextInt());

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        return enderecoDAO.inserirEndereco(endereco);
    }
}
