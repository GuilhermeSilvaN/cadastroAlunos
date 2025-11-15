package model;

public class Turma {
    private int codigo_turma;
    private String name;

    public Turma(){};

    public Turma(int codigo_turma, String name){
        this.codigo_turma = codigo_turma;
        this.name = name;
    }

    public int getCodigo_turma() { return codigo_turma; }
    public String getName() {return name;}

    public void setCodigo_turma(int codigo_turma) {this.codigo_turma = codigo_turma;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo_turma: " + getCodigo_turma() + " ");
        sb.append("Nome_turma: " + getName());

        return sb.toString();
    }
}
