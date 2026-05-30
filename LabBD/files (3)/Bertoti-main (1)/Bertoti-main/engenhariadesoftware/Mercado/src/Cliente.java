public class Cliente {
    private String nome;
    private String cpf;
    private boolean cartao;

    public Cliente(String nome, String cpf, boolean cartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartao = cartao;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public boolean isCartao() {
        return cartao;
    }


    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }
}

