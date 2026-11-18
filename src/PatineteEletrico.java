public class PatineteEletrico extends Veiculo implements Recarregavel {
    private int bateria;

    public PatineteEletrico(String descricao) {
        super(descricao);
    }

    @Override
    public int bateriaAtual() {
        return bateria;
    }

    @Override
    public void descontarBateria(int minutos) {
        for (int i = 0; i <= minutos; i++){
            bateria -= 2;
            if (bateria == 0){
                throw new IllegalStateException("O veículo está descarregado. Por favor, encerre a viagem e leve o veículo à estação mais próxima");
            }
        }
    }

    @Override
    public void recarregar() {
        bateria = 100;
    }

    @Override
    public double taxaDesbloqueio() {
        return 3;
    }

    @Override
    public double valorPorMin() {
        return 0.4;
    }
    

}
