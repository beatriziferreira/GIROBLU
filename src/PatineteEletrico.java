public class PatineteEletrico extends Veiculo implements Recarregavel {
    private int bateria;

    public PatineteEletrico(String descricao) {
        super(descricao);
        this.bateria = 100; // Inicializa a bateria com 100%
    }

    @Override
    public int bateriaAtual() {
        return bateria;
    }

    @Override
    public void descontarBateria() {
        bateria -= 2;
        if (bateria == 0) {
            throw new IllegalStateException(
                    "O veículo está descarregado. Por favor, encerre a viagem e leve o veículo à estação mais próxima");
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

    @Override
    public boolean liberar() {
        if (bateria < 20) {
            System.out.println("O veículo só pode ser liberado com bateria de 20% ou mais.");
            return false;
        }
        return super.liberar();
    }

}
