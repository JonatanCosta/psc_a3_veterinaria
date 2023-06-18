package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public Connection criarConexao() {
        String usuario = "TESTE";
        String senha = "p4ssw0rdpsc";
        String base = "alinedecampos01";

        try {
            return DriverManager.getConnection("jdbc:mysql://mysql.alinedecampos.pro.br:3306/" + base, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
