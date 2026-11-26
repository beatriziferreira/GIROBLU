public class BicicletaEletrica extends Veiculo implements Recarregavel {
    private int bateria;

    public BicicletaEletrica(int bateria) {
        super();
        this.bateria = bateria;
    }

    @Override
    public int bateriaAtual() {
        return bateria;
    }

    @Override
    public void descontarBateria(int minutos) {
        bateria -= minutos;
        if (bateria <= 0) {
            bateria = 0;
            throw new IllegalStateException("O veículo está descarregado.");
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

    @Override
    public boolean liberar() {
        if (bateria < 20) {
            System.out.println("O veículo só pode ser liberado com bateria de 20% ou mais.");
            return false;
        }
        return super.liberar();
    }

    @Override
    public String toString() {
        return "Bicicleta elétrica [Código: " + getCodigo() + "] - Bateria: " + bateria + "%";
    }
}
