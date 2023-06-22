package DAO;

import Entidades.Animal;

import java.sql.*;

public class AnimalDAO {

    Connection conexao;

    public AnimalDAO() {
        this.conexao = new Conexao().criarConexao();
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
