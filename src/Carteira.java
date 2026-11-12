import java.util.ArrayList;

public class Carteira {
    private double saldo;
    private int id;
    private ArrayList<Lancamento> lancamentos = new ArrayList<>();

    public Carteira() {
        this.saldo = 0.0;
        this.id ++;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    public void adicionarLancamento(Lancamento lancamento) {
        lancamentos.add(lancamento);
        saldo += lancamento.getValor();
        System.out.println("Lancamento adicionado: " + lancamento.getValor() + " em " + lancamento.getData() + " às " + lancamento.getHora());
        System.out.println("Novo saldo: " + saldo);
    }
}
