import model.*;

public class Program {
    public static void main(String[] args) {
        Turma turma = new Turma(1001, "1A");
        Aluno aluno1 = new Aluno(1010, "Guilherme Silva", turma);

        System.out.println(aluno1);

    }
}
