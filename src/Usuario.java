public class Usuario {
    private String nome;
    private String email;
    private Plano plano;
    private Carteira carteira;
   
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.plano = new PlanoAvulso();
        this.carteira = new Carteira();
    }

    public String getNome() {
        return nome;
    }

    public Plano getPlano() {
        return plano;
    }

    public String getEmail() {
        return email;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void mudarPlano(int opcao){
        if (opcao == 1){
            plano = new PlanoUniversitário();
        } else if (opcao == 2){
            plano = new PlanoMensal();
        }
    }


}
