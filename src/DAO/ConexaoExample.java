package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoExample {
    public Connection criarConexao() {
        String usuario = "root";
        String senha = "root";
        String base = "sistema_pet";

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3310/" + base, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
