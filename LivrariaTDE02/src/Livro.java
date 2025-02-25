public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean disponibilidade = true;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void exibirDetalhes(){
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Numero de Paginas: " + numeroPaginas);
        System.out.println("Disponibilidade: " + disponibilidade);
        System.out.println("/////////////////////");
    }

    public void reservar(){
        if (disponibilidade==true){
            setDisponibilidade(false);
            System.out.println("Reservado com sucesso!");
            System.out.println("/////////////////////");
        }
        else{
            System.out.println("Este livro ja esta reservado!");
            System.out.println("/////////////////////");
        }
    }

    public void devolver(){
        setDisponibilidade(true);
        System.out.println("Devolvido com sucesso!");
        System.out.println("/////////////////////");
    }

}
