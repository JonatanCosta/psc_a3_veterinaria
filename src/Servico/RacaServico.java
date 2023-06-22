package Servico;

import DAO.EspecieDAO;
import DAO.RacaDAO;

public class RacaServico {

    public void listarRacasPorEspecie (int especieId) {
        RacaDAO racaDAO = new RacaDAO();

        racaDAO.listarRacasPorEspecies(especieId);
    }

    public int buscarRacaPorIDeEspecie(int id, int especieID) {
        RacaDAO racaDAO = new RacaDAO();

        return racaDAO.buscarRacaPorIDeEspecie(id, especieID);
    }
}
