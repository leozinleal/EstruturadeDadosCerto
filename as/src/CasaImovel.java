public class CasaImovel extends Casa {
    private Imovel imovel;

    public CasaImovel(Imovel imovel) {
        super(imovel.getNome());
        this.imovel = imovel;
    }

    @Override
    public void acao(Jogador jogador) {
        imovel.interagir(jogador);
    }

    public Imovel getImovel() {
        return imovel;
    }
}