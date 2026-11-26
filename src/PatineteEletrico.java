public class PatineteEletrico extends Veiculo implements Recarregavel {
    private int bateria;

    public PatineteEletrico(int bateria) {
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
        bateria -= minutos * 2;
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
        return 3;
    }

    @Override
    public double valorPorMin() {
        return 0.4;
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
        return "Patinete elétrico [Código: " + getCodigo() + "] Bateria: " + bateria + "%";
    }
    
}
