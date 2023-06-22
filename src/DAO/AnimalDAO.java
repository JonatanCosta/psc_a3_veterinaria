package DAO;

import Entidades.Animal;

import java.sql.*;

public class AnimalDAO {

    Connection conexao;

    public AnimalDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public int buscarIDAnimalPorDono(int codigoAnimal, int responsavelId) {
        int animalId = 0;
        try {
            String query;
            PreparedStatement stmt = null;

            query  = "SELECT * FROM ANIMAL where ID = ? AND responsavel_ID = ? order by id desc limit 1";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, codigoAnimal);
            stmt.setInt(2, responsavelId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                animalId =  rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return animalId;
    }

    public void listarAnimaisPorDono(int responsavelId) {
        try {
            String query;
            PreparedStatement stmt = null;

            query = "SELECT * FROM ANIMAL WHERE responsavel_ID = ?";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, responsavelId);


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

    public int inserirAnimal(Animal animal) {
        int idInserido = 0;

        try {
            // Preparação da estrutura SQL para realização da execução no banco de dados
            String query = "INSERT INTO animal(nome,porte,idade,responsavel_ID,raca_ID) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Passagem de parâmetros para a query, onde cada "?" corresponde a um dos parâmetros definidos a seguir
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getPorte());
            stmt.setInt(3, animal.getIdade());
            stmt.setInt(4, animal.getResponsavel_id());
            stmt.setInt(5, animal.getRaca_id());

            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();

            if (! resultSet.next()) {
                throw new SQLException();
            }

            idInserido = resultSet.getInt(1);

            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return idInserido;
    }
}
