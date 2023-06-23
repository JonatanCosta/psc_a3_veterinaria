package DAO;

import Servico.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicaDAO extends Utils  {
    Connection conexao;

    public ClinicaDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public void listarClinicas() {
        try {
            String query;
            PreparedStatement stmt = null;

            query = "SELECT C.ID, C.CNPJ, C.razao_social, c.telefone, CONCAT(E.CEP, ' ', E.rua, ' ', E.numero, ' ', E.bairro) as 'endereco_completo' FROM CLINICA C inner join ENDERECO E on E.ID = C.endereco_ID order by id desc;";

            stmt = conexao.prepareStatement(query);


            ResultSet rs = stmt.executeQuery();


            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
             System.out.format("CÓDIGO\tDADOS DA CLINICA\t\t\t\t\t\t\n");
             System.out.println("---------------------------------------------------------------------------------------------------------------------------");

            // Como não sabemos quantas linhas podem ser retornadas na consulta no banco de dados
            // deve-se usar um laço de repetição que vai fazer a leitura enquanto existirem linhas de registros
            while (rs.next()) {

                // Recupera cada um dos campos do registro, devemos recuperar com o tipo correto
                int id = rs.getInt("id");
                String nome = rs.getString("CNPJ");
                String razao_social = rs.getString("razao_social");
                String telefone = rs.getString("telefone");
                String endereco_completo = rs.getString("endereco_completo");

                // Imprime os dados do registro na tela de maneira formata para alinhamento
                // %d indica é inteiro | %s indica que é string | %f indica que é float/double
                // os valores numéricos correspondem a quantidade de caracteres que a coluna deve ocupar
                // por exemolo %-20s: o sinal de menos diz que o alinhamento deve ser alinhado a esquerda e que a coluna ocupa 20 caracteres com um valor de string
                // o \t corresponde a um tab para melhor organização em formato tabular
                System.out.format("\t%d\t%-10s\t\t%-10s\t\t%-10s\t\t%-10s\t\n", id, nome, razao_social, telefone, endereco_completo);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }
    }

    public int buscarClinicaPorId(int idBusca) {
        int idClinica = 0;
        try {
            String query;
            PreparedStatement stmt = null;

            query  = "SELECT * FROM CLINICA where ID = ? order by id desc limit 1";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idBusca);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idClinica =  rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return idClinica;
    }


}
