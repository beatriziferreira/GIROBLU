public class PlanoUniversitário extends Plano {
    
    @Override
    public double calcularValor(Veiculo veiculo, int minutos) {
        if (minutos <= 0){
            throw new IllegalArgumentException("A duração da viagem deve ser maior que zero.");
        }
        if (veiculo == null){
            throw new IllegalArgumentException("O veículo não pode ser nulo.");
        }
        double totalCheio = veiculo.taxaDesbloqueio() + (veiculo.valorPorMin() * minutos);
        if (veiculo instanceof PatineteEletrico){
            totalCheio = veiculo.taxaDesbloqueio() + (veiculo.valorPorMin() * minutos);
            return totalCheio;
        }
        double valorDesconto = totalCheio * 0.5;
        return totalCheio - valorDesconto;
    };
    

    
    
}
