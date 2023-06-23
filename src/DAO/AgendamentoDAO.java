package DAO;

import Entidades.Agendamento;
import Servico.Utils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgendamentoDAO extends Utils {
    Connection conexao;
    public AgendamentoDAO (){
        this.conexao = new Conexao().criarConexao();
    }
    public int cadastrarAgendamento(Agendamento agendamento) {
        int idInserido = 0;

        try {
            // Preparação da estrutura SQL para realização da execução no banco de dados
            String query = "INSERT INTO agendamento(data_agendamento, hora,responsavel_ID, animal_id," +
                          " clinica_ID, veterinario_ID, tipo_de_pagamento_ID,  procedimento_ID) " +
                          "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = formatoDate.parse(agendamento.getDataAgendamento());

            SimpleDateFormat formatoDateTime = new SimpleDateFormat("HH:mm");
            java.util.Date hora = formatoDateTime.parse(agendamento.getHora());

            stmt.setDate(1, new Date(data.getTime()));
            stmt.setTime(2, new Time(hora.getTime()));
            stmt.setInt(3, agendamento.getResponsavelId());
            stmt.setInt(4, agendamento.getAnimalId());
            stmt.setInt(5, agendamento.getClinicaId());
            stmt.setInt(6, agendamento.getVeterinarioId());
            stmt.setInt(7, agendamento.getTipodePagamentoId());
            stmt.setInt(8, agendamento.getProcedimentoId());

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
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return idInserido;
    }

    public void listarAgendamentos() {
        try {
            String query;
            PreparedStatement stmt = null;

            query = "select \n" +
                    "A.ID, \n" +
                    "date_format(data_agendamento, \"%d/%m/%Y\") as \"data_agendamento\",\n" +
                    "A.hora,\n" +
                    "R.nome as \"nome_responsavel\",\n" +
                    "AN.nome as \"nome_animal\",\n" +
                    "C.razao_social as \"nome_clinica\",\n" +
                    "V.nome as \"nome_veterinario\",\n" +
                    "TP.forma_pagamento as \"forma_pagamento\"\n" +
                    "from \n" +
                    "agendamento as A \n" +
                    "inner join responsavel as R\n" +
                    "on R.ID = A.responsavel_ID\n" +
                    "inner join animal as AN\n" +
                    "on AN.ID = A.animal_ID\n" +
                    "inner join clinica as C\n" +
                    "on C.ID = A.clinica_ID\n" +
                    "inner join veterinario as V\n" +
                    "on V.ID = A.veterinario_ID\n" +
                    "inner join tipo_de_pagamento as TP\n" +
                    "on TP.ID = A.tipo_de_pagamento_ID\n" +
                    "inner join procedimento as P\n" +
                    "on P.ID = A.procedimento_ID order by A.ID desc \n" +
                    ";\n";
            stmt = conexao.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();


             System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
             System.out.format("ID\tData Agendamento\tHora\t\tNome Responsavel\t\tNome Animal\t\t\tNome Clinica\t\tNome Veterinário\t\t\tForma de pagamento\n");
             System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
             while (rs.next()) {

                // Recupera cada um dos campos do registro, devemos recuperar com o tipo correto
                int id = rs.getInt("id");
                String data_agendamento = rs.getString("data_agendamento");
                String hora = rs.getString("hora");
                String nome_responsavel = rs.getString("nome_responsavel");
                String nome_animal = rs.getString("nome_animal");
                String nome_clinica = rs.getString("nome_clinica");
                String nome_veterinario = rs.getString("nome_veterinario");
                String forma_pagamento = rs.getString("forma_pagamento");


                // Imprime os dados do registro na tela de maneira formata para alinhamento
                // %d indica é inteiro | %s indica que é string | %f indica que é float/double
                // os valores numéricos correspondem a quantidade de caracteres que a coluna deve ocupar
                // por exemolo %-20s: o sinal de menos diz que o alinhamento deve ser alinhado a esquerda e que a coluna ocupa 20 caracteres com um valor de string
                // o \t corresponde a um tab para melhor organização em formato tabular
                System.out.format("%d\t%-15s\t\t%-8s\t%-16s\t\t%-15s\t\t%-15s\t\t%-20s\t\t%-15s\t\n", id,data_agendamento, hora, nome_responsavel, nome_animal, nome_clinica, nome_veterinario, forma_pagamento);
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

    public void excluirAgendamento(int idAgendamento) {
        try {
            String query = "DELETE FROM AGENDAMENTO WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setInt(1, idAgendamento);


            int res = stmt.executeUpdate();

            // Caso não ocorra erro na inserção, essa mensagem será exibida, senão vai direto para o catch
            if(res > 0)
                mensagemSucesso("AGENDAMENTO EXCLUIDO COM SUCESSO");
            else
                mensagemSucesso("AGENDAMENTO NÃO EXISTE");

            stmt.close();

        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        }
    }

    public void editarAgendamento(int IdAgendamento, Agendamento agendamento) {
        try {
            // Preparação da estrutura SQL para realização da execução no banco de dados
            String query = "UPDATE AGENDAMENTO SET data_agendamento = ?, hora = ? WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);

            SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = formatoDate.parse(agendamento.getDataAgendamento());

            SimpleDateFormat formatoDateTime = new SimpleDateFormat("HH:mm");
            java.util.Date hora = formatoDateTime.parse(agendamento.getHora());

            stmt.setDate(1, new Date(data.getTime()));
            stmt.setTime(2, new Time(hora.getTime()));
            stmt.setInt(3, IdAgendamento);

            // Execução da query no banco de dados e fechamento do statment
            stmt.execute();
            stmt.close();

            // Caso não ocorra erro na inserção, essa mensagem será exibida, senão vai direto para o catch
            mensagemSucesso("AGENDAMENTO EDITADO COM SUCESSO");

        } catch (SQLException e) {
            // Em caso de ocorrer erro na integração com banco de dados, as informações do erro serão exibidas
            System.out.println("Error Code = " + e.getErrorCode());
            System.out.println("SQL state = " + e.getSQLState());
            System.out.println("Message = " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
