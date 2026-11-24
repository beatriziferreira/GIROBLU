public class Bicicleta extends Veiculo{

    public Bicicleta() {
        super();
    }

    @Override
    public double taxaDesbloqueio() {
        return 1;
    }

    @Override
    public double valorPorMin() {
        return 0.15;
    }

    @Override
    public String toString() {
        return "Bicicleta [Código: " + getCodigo() + "]";
    }
    
}
