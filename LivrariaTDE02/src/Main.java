//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //criando livros
        Livro livro1 = new Livro();
        livro1.setTitulo("O maior da Argentina");
        livro1.setAutor("Maradona");
        livro1.setNumeroPaginas(10);

        //criando livros
        Livro livro2 = new Livro();
        livro2.setTitulo("O homem gol do Rio Grande do Sul");
        livro2.setAutor("Renato Gaucho");
        livro2.setNumeroPaginas(7);

        //criando uma livraria
        Livraria livraria1 = new Livraria(1, "SARAIVA RUA TINGUASSU");


        //Testando metodos
        livro1.exibirDetalhes();
        livro2.exibirDetalhes();
        livro1.reservar();
        livro1.exibirDetalhes();
        livro2.exibirDetalhes();


        livraria1.inserirLivros(livro1);
        livraria1.inserirLivros(livro2);
        livraria1.listarLivros();
        livraria1.listarDisponiveis();

        livro1.devolver();
        livraria1.listarDisponiveis();

    }
}