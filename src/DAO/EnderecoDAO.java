package DAO;

import Entidades.Endereco;

import java.sql.*;

public class EnderecoDAO {

    Connection conexao;

    public EnderecoDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public int inserirEndereco(Endereco endereco) {
        int idInserido = 0;
        
        try {
            // Preparação da estrutura SQL para realização da execução no banco de dados
            String query = "INSERT INTO endereco (CEP, rua, numero, bairro) VALUES (?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Passagem de parâmetros para a query, onde cada "?" corresponde a um dos parâmetros definidos a seguir
            stmt.setString(1, endereco.getCEP());
            stmt.setString(2, endereco.getRua());
            stmt.setInt(3, endereco.getNumero());
            stmt.setString(4, endereco.getBairro());

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
