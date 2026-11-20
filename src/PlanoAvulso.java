public class PlanoAvulso extends Plano{
    
    public double calcularValor(Veiculo veiculo, int minutos){
        return veiculo.taxaDesbloqueio() + veiculo.valorPorMin() * minutos;
    };
}
