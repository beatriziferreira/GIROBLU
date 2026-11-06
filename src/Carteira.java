public class Carteira {
    private Usuario usuario;
    private double saldo;

    public Carteira(Usuario usuario, double saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public void recarregarSaldo(String data, String hora, double valor){
        saldo += valor;
        System.out.println("Recarga de R$" + valor + "realizada no dia " + data + ", às/ao " + hora);
        System.out.println(saldo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    
}
