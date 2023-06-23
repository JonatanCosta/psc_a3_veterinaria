package DAO;

import Servico.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class ProcedimentoDAO extends Utils  {
    Connection conexao;

    public ProcedimentoDAO() {
        this.conexao = new Conexao().criarConexao();
    }

    public void listarProcedimentos() {
        try {
            String query;
            PreparedStatement stmt = null;

            query = "SELECT * FROM PROCEDIMENTO order by id desc;";

            stmt = conexao.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();


            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
             System.out.format("CÓDIGO\tNOME\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPREÇO\t\t\n");
             System.out.println("---------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome_procedimento");

                Locale ptBr = new Locale("pt", "BR");
                String preco = NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco_atendimento"));

                System.out.format("\t%d\t%-60s\t\t%-6s\t\n", id, nome, preco);
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

    public int buscarProcedimentoPorId(int idBusca) {
        int idProcedimento = 0;
        try {
            String query;
            PreparedStatement stmt = null;

            query  = "SELECT * FROM PROCEDIMENTO where ID = ? order by id desc limit 1";
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idBusca);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idProcedimento =  rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }

        return idProcedimento;
    }


}
