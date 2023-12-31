package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RacaDAO {
    Connection conexao;

    public RacaDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public void listarRacasPorEspecies(int especieId) {
        try {
            String query;
            PreparedStatement stmt = null;

            query = "SELECT * FROM RACA WHERE especie_ID = ?";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, especieId);


            ResultSet rs = stmt.executeQuery();


            /**System.out.println("---------------------------------------------------------------------------------------------------------------------------");
             System.out.format("ID\tNOME\t\t\t\t\t\t\n");
             System.out.println("---------------------------------------------------------------------------------------------------------------------------");*/

            // Como não sabemos quantas linhas podem ser retornadas na consulta no banco de dados
            // deve-se usar um laço de repetição que vai fazer a leitura enquanto existirem linhas de registros
            while (rs.next()) {

                // Recupera cada um dos campos do registro, devemos recuperar com o tipo correto
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                // Imprime os dados do registro na tela de maneira formata para alinhamento
                // %d indica é inteiro | %s indica que é string | %f indica que é float/double
                // os valores numéricos correspondem a quantidade de caracteres que a coluna deve ocupar
                // por exemolo %-20s: o sinal de menos diz que o alinhamento deve ser alinhado a esquerda e que a coluna ocupa 20 caracteres com um valor de string
                // o \t corresponde a um tab para melhor organização em formato tabular
                System.out.format("%d\t%-20s\t\n", id, nome);
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

    public int buscarRacaPorIDeEspecie (int id, int especieId) {
        int idEspecie = 0;
        try {
            String query;
            PreparedStatement stmt = null;

            query  = "SELECT * FROM RACA where ID = ? AND especie_ID = ? order by id desc limit 1";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setInt(2, especieId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idEspecie =  rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return idEspecie;
    }
}
