public class PlanoMensal extends Plano {

    @Override
    public double calcularValor(Veiculo veiculo, int minutos) {
        if (minutos <= 15){
            return 0;
        } 
        return (minutos - 15) * veiculo.valorPorMin();
    }
    
    
}
