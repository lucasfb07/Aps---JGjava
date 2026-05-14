package Personagem;

import javax.swing.JOptionPane;

// (Herança)
public class Membro extends Personagem {

    // (Encapsulamento)
    private boolean temProvasReais;
    private boolean temProvasFalsas;
    private boolean foiPreso;

    // Bônus de itens
    private int bonusFurtividade;
    private int bonusInteligencia;
    private int bonusArgumentacao;
    private int bonusEvidencia;

    // Atributos base do personagem
    private int furtividade;
    private int inteligencia;
    private int argumentacao;

    // Método Construtor
    public Membro(String nome) {
        super(nome, 100, 50);
        this.temProvasReais  = false;
        this.temProvasFalsas = false;
        this.foiPreso        = false;
        this.furtividade     = 0;
        this.inteligencia    = 0;
        this.argumentacao    = 0;
        this.bonusFurtividade  = 0;
        this.bonusInteligencia = 0;
        this.bonusArgumentacao = 0;
        this.bonusEvidencia    = 0;
    }

    // (Sobrescrita)
    @Override
    public void agir() {
        JOptionPane.showMessageDialog(null,
                getNome() + " está em ação!\n" + getStatus(),
                "Ação", JOptionPane.PLAIN_MESSAGE);
    }

    // Redutores de atributo base
    public void reduzirFurtividade(int valor) {
        this.furtividade = Math.max(0, this.furtividade - valor);
    }

    public void reduzirInteligencia(int valor) {
        this.inteligencia = Math.max(0, this.inteligencia - valor);
    }

    public void reduzirArgumentacao(int valor) {
        this.argumentacao = Math.max(0, this.argumentacao - valor);
    }

    // Status exibido nas caixinhas
    public String getStatus() {
        return " " + getNome() +
                "\n Vida: " + getVida() + "/100" +
                "\n Reputação: " + getReputacao() +
                "\n\n Atributos base:" +
                "\n  Furtividade:  " + furtividade +
                "\n  Inteligência: " + inteligencia +
                "\n  Argumentação: " + argumentacao +
                "\n\n Bônus de itens:" +
                "\n  Furtividade:  +" + bonusFurtividade +
                "\n  Inteligência: +" + bonusInteligencia +
                "\n  Argumentação: +" + bonusArgumentacao +
                "\n  Evidência:    +" + bonusEvidencia;
    }
    // Getters e Setters — atributos base
    public int getFurtividade()  { return furtividade; }
    public int getInteligencia() { return inteligencia; }
    public int getArgumentacao() { return argumentacao; }

    // Getters e Setters — bônus de itens
    public int getBonusFurtividade()  { return bonusFurtividade; }
    public int getBonusInteligencia() { return bonusInteligencia; }
    public int getBonusArgumentacao() { return bonusArgumentacao; }
    public int getBonusEvidencia()    { return bonusEvidencia; }

    public void addBonusFurtividade(int v)  { this.bonusFurtividade  += v; }
    public void addBonusInteligencia(int v) { this.bonusInteligencia += v; }
    public void addBonusArgumentacao(int v) { this.bonusArgumentacao += v; }
    public void addBonusEvidencia(int v)    { this.bonusEvidencia    += v; }

    public void setTemProvasReais(boolean v)  { this.temProvasReais  = v; }
    public void setTemProvasFalsas(boolean v) { this.temProvasFalsas = v; }
    public void setFoiPreso(boolean v)        { this.foiPreso        = v; }

    public boolean isTemProvasReais() {
        return temProvasReais;
    }

    public boolean isTemProvasFalsas() {
        return temProvasFalsas;
    }

    public boolean isFoiPreso() {
        return foiPreso;
    }
}