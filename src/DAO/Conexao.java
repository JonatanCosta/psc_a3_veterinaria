package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public Connection criarConexao() {
        String usuario = "root";
        String senha = "lari2305";
        String base = "clinica_vet";

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + base, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
