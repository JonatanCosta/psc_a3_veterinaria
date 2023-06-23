package DAO;

import Servico.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeterinarioDAO extends Utils  {
    Connection conexao;

    public VeterinarioDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public void listarVeterinarios() {
        try {
            String query;
            PreparedStatement stmt = null;

            query = "SELECT * FROM VETERINARIO order by id desc;";

            stmt = conexao.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();


            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
             System.out.format("CÓDIGO\tNOME\t\t\t\t\tCRMV\t\tTELEFONE\t\t\t\t\n");
             System.out.println("---------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String CRMV = rs.getString("CRMV");
                String telefone = rs.getString("telefone");

                System.out.format("\t%d\t%-18s\t\t%-6s\t\t%-10s\t\n", id, nome, CRMV, telefone);
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

    public int buscarVeterinarioPorId(int idBusca) {
        int idVeterinario = 0;
        try {
            String query;
            PreparedStatement stmt = null;

            query  = "SELECT * FROM VETERINARIO where ID = ? order by id desc limit 1";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idBusca);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idVeterinario =  rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return idVeterinario;
    }


}
