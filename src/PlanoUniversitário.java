public class PlanoUniversitário extends Plano {
    
    @Override
    public double calcularValor(Veiculo veiculo, int minutos) {
        return (veiculo.taxaDesbloqueio() + veiculo.valorPorMin() * minutos) * 0.5;
    };
    

    
    
}
