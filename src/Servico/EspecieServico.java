package Servico;

import DAO.EspecieDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EspecieServico {

    public void listarEspecie () {
        EspecieDAO especieDAO = new EspecieDAO();

        especieDAO.listarEspecies();
    }

    public int buscarEspeciePorID(int id) {
        EspecieDAO especieDAO = new EspecieDAO();

        return especieDAO.buscarEspeciePorID(id);
    }
}
