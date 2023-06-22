package DAO;

import Servico.Utils;

import java.sql.Connection;

public class ClinicaDAO extends Utils  {
    Connection conexao;

    public ClinicaDAO() {
        this.conexao = new Conexao().criarConexao();
    }


}
