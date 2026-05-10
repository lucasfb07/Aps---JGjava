package Personagem;

import javax.swing.JOptionPane;

// Herança
public class Membro extends Personagem {

    // Encapsulamento
    private boolean temProvasReais;
    private boolean temProvasFalsas;
    private boolean foiPreso;

    private int vida;
    private int bonusItem;

    // Atributos de RPG
    private int furtividade;
    private int inteligencia;
    private int argumentacao;

    // Método Construtor
    public Membro(String nome) {
        super(nome, 100, 50);
        this.temProvasReais = false;
        this.temProvasFalsas = false;
        this.foiPreso = false;
        this.vida = 100;
        this.bonusItem = 0;
        this.furtividade = 0;
        this.inteligencia = 0;
        this.argumentacao = 0;
    }

    // Sobrescrita
    @Override
    public void agir() {
        JOptionPane.showMessageDialog(null,
                getNome() + " está em ação!\n" + getStatus(),
                "Ação", JOptionPane.PLAIN_MESSAGE);
    }

    public boolean receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            return true;
        }
        return false;
    }

    public void curar(int quantidade) {
        this.vida = Math.min(100, this.vida + quantidade);
    }

    public void aumentarBonusItem(int valor) {
        this.bonusItem += valor;
    }

    public void reduzirFurtividade(int valor) {
        this.furtividade = Math.max(0, this.furtividade - valor);
    }

    public void reduzirInteligencia(int valor) {
        this.inteligencia = Math.max(0, this.inteligencia - valor);
    }

    public void reduzirArgumentacao(int valor) {
        this.argumentacao = Math.max(0, this.argumentacao - valor);
    }

    public String getStatus() {
        return "Nome: " + getNome() +
                "\nVida: " + vida + "/100" +
                "\nBônus de item: +" + bonusItem +
                "\nReputação: " + getReputacao() +
                "\n\nAtributos:" +
                "\nFurtividade: " + furtividade +
                "\nInteligência: " + inteligencia +
                "\nArgumentação: " + argumentacao;
    }

    public String getAtributos() {
        return "Furtividade: " + furtividade +
                "\nInteligência: " + inteligencia +
                "\nArgumentação: " + argumentacao;
    }

    public int getVida() { return vida; }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else if (vida > 100) {
            this.vida = 100;
        } else {
            this.vida = vida;
        }
    }

    public int getBonusItem() { return bonusItem; }
    public void setBonusItem(int bonus) { this.bonusItem = bonus; }

    public boolean isTemProvasReais() { return temProvasReais; }
    public boolean isTemProvasFalsas() { return temProvasFalsas; }
    public boolean isFoiPreso() { return foiPreso; }

    public void setTemProvasReais(boolean v) { this.temProvasReais = v; }
    public void setTemProvasFalsas(boolean v) { this.temProvasFalsas = v; }
    public void setFoiPreso(boolean v) { this.foiPreso = v; }

    public int getFurtividade() { return furtividade; }
    public void setFurtividade(int furtividade) { this.furtividade = furtividade; }

    public int getInteligencia() { return inteligencia; }
    public void setInteligencia(int inteligencia) { this.inteligencia = inteligencia; }

    public int getArgumentacao() { return argumentacao; }
    public void setArgumentacao(int argumentacao) { this.argumentacao = argumentacao; }
}