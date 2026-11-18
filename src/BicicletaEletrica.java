public class BicicletaEletrica extends Veiculo implements Recarregavel{
    private int bateria;

    public BicicletaEletrica(String descricao) {
        super(descricao);
    }

    @Override
    public int bateriaAtual() {
        return bateria;
    }

    @Override
    public void descontarBateria(int minutos) {
        for (int i = 0; i <= minutos; i++){
            bateria -= 1;
        }
    }

    @Override
    public void recarregar() {
        bateria = 100;
    }

    @Override
    public double taxaDesbloqueio() {
        return 2;
    }

    @Override
    public double valorPorMin() {
        return 0.3;
    }
}
