package DAO;

import Entidades.Endereco;
import Entidades.Responsavel;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ResponsavelDAO {

    Connection conexao;

    public ResponsavelDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public int buscarIDResponsavelPorCPF(String CPF) {
        int idResponsavel = 0;
        try {
            String query;
            PreparedStatement stmt = null;

            query  = "SELECT * FROM RESPONSAVEL where CPF = ? order by id desc limit 1";
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, CPF);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idResponsavel =  rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return idResponsavel;
    }

    public int inserirResponsavel(Responsavel responsavel) {
        int idInserido = 0;

        try {
            // Preparação da estrutura SQL para realização da execução no banco de dados
            String query = "INSERT INTO responsavel(CPF, nome, telefone, endereco_ID) VALUES (?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Passagem de parâmetros para a query, onde cada "?" corresponde a um dos parâmetros definidos a seguir
            stmt.setString(1, responsavel.getCPF());
            stmt.setString(2, responsavel.getNome());
            stmt.setString(3, responsavel.getTelefone());
            stmt.setInt(4, responsavel.getEndereco_id());

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
