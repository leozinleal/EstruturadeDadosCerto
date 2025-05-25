package exercicio1;

public class Pedido {
    public String id;
    public String descricao;

    Pedido(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' ;
    }
}
