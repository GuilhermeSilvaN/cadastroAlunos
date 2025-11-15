package model;

import model.Turma;

public class Aluno {
    private int matricula;
    private String name;
    private Turma turma;

    public Aluno(){};

    public Aluno (int matricula, String name, Turma turma) {
        this.matricula = matricula;
        this.name = name;
        this.turma = turma;
    }

    public int getMatricula(){return matricula;}
    public String getName(){return name;}
    public Turma getTurma(){return turma;}

    public void setMatricula(int matricula){this.matricula = matricula;}
    public void setName(String name){this.name = name;}
    public void setTurma(Turma turma){this.turma = turma;}


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Matricula: " + getMatricula() + "\n");
        sb.append("Nome: " + getName() + "\n");
        sb.append("Classe[" + getTurma() + "]\n");

        return sb.toString();
    }

}
