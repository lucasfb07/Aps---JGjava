package Personagem;

public abstract class Personagem {

    // (Encapsulamento)
    private final String nome;
    private int pontosDeVida;
    private int reputacao; // afeta qual final vai ter

    // METODO CONSTRUTO
    public Personagem(String nome, int pontosDeVida, int reputacao) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.reputacao = reputacao;
    }

    // Método Abstrato Cada Personagem agr é diferente
    public abstract void agir();

    // Get/Set
    public int getVida() {return pontosDeVida;}
    public String getNome() { return nome; }
    public int getPontosDeVida() { return pontosDeVida; }
    public int getReputacao() { return reputacao; }

    public void setPontosDeVida(int pv) { this.pontosDeVida = pv; }
    public void setReputacao(int rep) { this.reputacao = rep; }

    public boolean receberDano(int dano) {
        if (dano <= 0) return false;
        pontosDeVida = Math.max(0, pontosDeVida - dano);
        return pontosDeVida == 0;
    }

    public void curar(int quantidade) {
        if (quantidade <= 0) return;
        pontosDeVida = Math.min(100, pontosDeVida + quantidade);
    }

}