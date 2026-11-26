public class BicicletaEletrica extends Veiculo implements Recarregavel {
    private int bateria;

    public BicicletaEletrica(int bateria) {
        if(bateria < 0 || bateria > 100){
            throw new IllegalArgumentException("A bateria deve estar entre 0 e 100.");
        }
        super();
        this.bateria = bateria;
    }

    @Override
    public int bateriaAtual() {
        return bateria;
    }

    @Override
    public void descontarBateria(int minutos) {
        if (minutos < 0) {
            throw new IllegalArgumentException("O tempo de uso não pode ser negativo.");
        }
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
    public boolean liberar() throws BateriaInsuficienteException {
        if (bateria < 20) {
            throw new BateriaInsuficienteException();
        }
        return super.liberar();
    }

    @Override
    public String toString() {
        return "Bicicleta elétrica [Código: " + getCodigo() + "] - Bateria: " + bateria + "%";
    }
}
