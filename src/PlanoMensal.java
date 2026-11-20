public class PlanoMensal extends Plano {

    @Override
    public double calcularValor(Veiculo veiculo, int minutos) {
        if (minutos <= 15){
            return veiculo.taxaDesbloqueio();
        } 
        return minutos * veiculo.taxaDesbloqueio();
    }
    
    
}
