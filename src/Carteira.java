import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Carteira {
    private double saldo;
    private int id;
    private static int contadorId;
    private ArrayList<Recarga> recargas = new ArrayList<>();

    public Carteira() {
        this.saldo = 0.0;
        contadorId ++;
        this.id = contadorId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void pagarViagem(double valorCobrado){
        if (valorCobrado > saldo){
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valorCobrado;
        System.out.println("Pagamento realizado com sucesso. Novo saldo: " + saldo);
    }

    public int getId() {
        return id;
    }

    public void adicionarRecarga(LocalDate data, LocalTime hora, double valor) {
        Recarga recarga = new Recarga(LocalDate.now(), LocalTime.now(), valor);
        recargas.add(recarga);
        saldo += recarga.getValor();
        System.out.println("Recarga adicionada: " + String.format("%.2f", recarga.getValor()) + " em " + recarga.getData() + " às " + recarga.getHora().getHour() + ":" + recarga.getHora().getMinute());
        System.out.println("Novo saldo: " + String.format("%.2f", saldo));
    }
}
