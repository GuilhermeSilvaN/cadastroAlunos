package dao;

import db.DB;
import db.DBException;
import model.Aluno;
import model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    public void inserirAluno(Aluno aluno){
        String sql = "INSERT INTO aluno (matricula, nome, fk_turma) VALUES (?, ?, ?)";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, aluno.getMatricula());
            ps.setString(2, aluno.getName());
            ps.setInt(3, aluno.getTurma().getCodigo_turma());

            System.out.println("aluno inserido");

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, fk_turma = ? WHERE matricula = ?";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, aluno.getName());
            ps.setInt(2, aluno.getTurma().getCodigo_turma());
            ps.setInt(3, aluno.getMatricula());

            System.out.println("Aluno atualizado!");

            ps.execute();

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletarAluno(Aluno aluno){
        String sql = "DELETE FROM aluno WHERE matricula = ?";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, aluno.getMatricula());

            System.out.println("Aluno deletado!");

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Aluno buscaAlunoPorMatricula(int matricula){
        String SQL = "SELECT aluno.matricula, aluno.nome AS aluno_nome, " +
                "turma.codigo_turma, turma.nome AS nome_turma " +
                "FROM aluno JOIN turma ON aluno.fk_turma = turma.codigo_turma " +
                "WHERE aluno.matricula = ?";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                //cria turma;
                Turma turma = new Turma();
                turma.setCodigo_turma(rs.getInt("codigo_turma"));
                turma.setName(rs.getString("nome_turma"));

                //cria aluno;
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setName(rs.getString("aluno_nome"));
                aluno.setTurma(turma);

                return aluno;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Aluno> listarAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        //select aluno.matricula AS matricula_aluno, aluno.nome AS nome_aluno, turma.nome AS nome_turma from aluno join turma on aluno.fk_turma = turma.codigo_turma;
        String sql = "SELECT aluno.matricula AS matricula_aluno, " +
                "aluno.nome AS nome_aluno, turma.nome AS nome_turma, turma.codigo_turma " +
                "FROM aluno JOIN turma ON aluno.fk_turma = turma.codigo_turma";

        try(Connection conn = DB.getConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
        ){
            while(rs.next()){
                //cria turma;
                Turma turma = new Turma();
                turma.setCodigo_turma(rs.getInt("codigo_turma"));
                turma.setName(rs.getString("nome_turma"));

                //cria aluno;
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula_aluno"));
                aluno.setName(rs.getString("nome_aluno"));
                aluno.setTurma(turma);

                alunos.add(aluno);
            }

            return alunos;

        } catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
