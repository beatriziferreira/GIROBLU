public class App {
    public static void main(String[] args) {
        Estacao estacao = new Estacao("Vila Germânica", 20);
        Estacao estacao2 = new Estacao("FURB campus 1", 20);

        Veiculo v1 = new PatineteEletrico();
        Veiculo v2 = new Bicicleta();
        Veiculo v3 = new BicicletaEletrica();

        estacao.adicionarVeiculo(v1);
        estacao2.adicionarVeiculo(v2);
        estacao.adicionarVeiculo(v3);

        System.out.println(v1.getStatus());
        System.out.println(v2.getStatus());
        System.out.println(v3.getStatus());

        Usuario u1 = new Usuario("Zeca", "Zeca@");
        u1.mudarPlano(1);
        
        u1.getCarteira().adicionarRecarga(200);

        System.out.println(u1.getCarteira().getSaldo());

    }
}
