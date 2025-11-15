import java.sql.DriverManager;

import dao.AlunoDao;
import db.*;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mysql {
    public static void main(String[] args) throws SQLException {

        AlunoDao alunoDao = new AlunoDao();
//        Aluno aluno = alunoDao.buscaAlunoPorMatricula(103);
//        System.out.println("===========================");
//        System.out.println(aluno);

        List<Aluno> alunos;
        alunos = alunoDao.listarAlunos();

        for(Aluno aluno : alunos){
            System.out.println("========================");
            System.out.println(aluno);
        }

    }
}
