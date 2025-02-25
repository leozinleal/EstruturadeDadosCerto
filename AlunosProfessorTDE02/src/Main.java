//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Leonardo");
        Aluno aluno2 = new Aluno();
        aluno2.setNome("Leandro");

        Professor professor = new Professor();
        professor.setNome("Juliano");

        Turma turma1 = new Turma(22, "Estrutura de Dados Segunda", professor);

        turma1.inserirAluno(aluno1);
        turma1.inserirAluno(aluno2);
        turma1.listarAlunos();
    }

}