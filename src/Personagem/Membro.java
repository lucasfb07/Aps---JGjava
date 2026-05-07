package Personagem;

import javax.swing.JOptionPane;

// Herança
public class Membro extends Personagem {

    // Atributo específico do Membro
    private boolean temProvasReais;
    private boolean temProvasFalsas;
    private boolean foiPreso;

    //novo - ainda testando (nao mexer)
    private int vida;
    private int bonusItem;

    // METODO CONSTRUTOR
    public Membro(String nome) {
        super(nome, 100, 50);
        this.temProvasReais = false;
        this.temProvasFalsas = false;
        this.foiPreso = false;
        this.vida = 100; //inicio do jogo
        this.bonusItem = 0; //bonus inicial começa sem
    }

    //aplicando dano '
    public boolean receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            return true;
        }
        return false;
    }

    //Cura de vida
    public void curar(int quantidade) {
        this.vida = Math.min(100,this.vida + quantidade);
    }
    public int getVida() { return vida; }
    public int getBonusItem() { return bonusItem; }
    public void setBonusItem(int bonus) { this.bonusItem = bonus; }

    // Mostra status
    public String getStatus() {
        return " Vida: " + vida + "/100  |  Bônus: +" + bonusItem;
    }

    @Override
    public void agir() {
        JOptionPane.showMessageDialog(null,
                getNome() + " está em ação!\n" + getStatus(),
                "Ação", JOptionPane.PLAIN_MESSAGE);
    }

    // Get e Set
    public boolean isTemProvasReais() { return temProvasReais; }
    public boolean isTemProvasFalsas() { return temProvasFalsas; }
    public boolean isFoiPreso() { return foiPreso; }
    public void setTemProvasReais(boolean v) { this.temProvasReais = v; }
    public void setTemProvasFalsas(boolean v) { this.temProvasFalsas = v; }
    public void setFoiPreso(boolean v) { this.foiPreso = v; }


}