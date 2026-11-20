public class Bicicleta extends Veiculo{

    public Bicicleta(String descricao) {
        super(descricao);
    }

    @Override
    public double taxaDesbloqueio() {
        return 0;
    }

    @Override
    public double valorPorMin() {
        return 0;
    }
    
}
