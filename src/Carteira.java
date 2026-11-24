import java.util.ArrayList;

public class Carteira {
    private double saldo;
    private int id;
    private ArrayList<Recarga> recargas = new ArrayList<>();

    public Carteira() {
        this.saldo = 0.0;
        this.id ++;
    }

    public double getSaldo() {
        return saldo;
    }

    public void pagarViagem(double valorCobrado){
        if (valorCobrado > saldo){
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valorCobrado;
    }

    public int getId() {
        return id;
    }

    public void adicionarRecarga(double valor) {
        Recarga recarga = new Recarga(null, null, valor);
        recargas.add(recarga);
        saldo += recarga.getValor();
        System.out.println("Recarga adicionada: " + recarga.getValor() + " em " + recarga.getData() + " às " + recarga.getHora());
        System.out.println("Novo saldo: " + saldo);
    }
}
