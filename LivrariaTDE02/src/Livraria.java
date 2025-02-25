public class Livraria {
    private int id;
    private Livro[] livros;
    private int contaLivros;
    private String nome;

    public Livraria(int id, String nome) {
        this.id = id;
        this.nome = nome;
        livros = new Livro[500];
        contaLivros = 0;
    }

    public void inserirLivros(Livro livro) {
        livros[contaLivros] = livro;
        contaLivros++;
    }

    public void listarLivros(){
        System.out.println("Todos livros da livraria:");
        for(int i = 0; i < contaLivros; i++){
            System.out.println("Livro: " + livros[i].getTitulo() + " - Autor:" + livros[i].getAutor() + " - Paginas:" + livros[i].getNumeroPaginas() + " - " + "Disponivel: " + livros[i].getDisponibilidade() );
        }
        System.out.println("Seja bem vindo a livraria " + this.nome);
    }

    public void listarDisponiveis(){
        System.out.println("Livros disponiveis para reserva:");
        for(int i = 0; i < contaLivros; i++){
            if(livros[i].getDisponibilidade()==true){
                System.out.println("Livro: " + livros[i].getTitulo() + " - Autor:" + livros[i].getAutor() + " - Paginas:" + livros[i].getNumeroPaginas() + " - " + "Disponivel: " + livros[i].getDisponibilidade() );
            }
        }
    }
}
