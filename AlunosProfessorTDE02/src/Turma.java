public class Turma {
    private int id;
    private String nome;
    private Professor professor;
    private Aluno[] alunos;
    private int contaAlunos;


    public Turma(int id, String nome, Professor professor){
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        alunos = new Aluno[10];
        contaAlunos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void inserirAluno(Aluno aluno){
        if(contaAlunos < 10){
            alunos[contaAlunos] = aluno;
            contaAlunos++;
        }
        else{
            System.out.println("Lista cheia de alunos");
        }
    }

    public void listarAlunos(){
        System.out.println("Turma: " + id);
        System.out.println("Materia: " + nome);
        System.out.println("Professor: " + professor.getNome());
        for (int i = 0; i < contaAlunos; i++) {
            System.out.println(alunos[i].getNome());
        }
    }

}
