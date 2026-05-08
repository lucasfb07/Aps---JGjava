package Jogo;

import Personagem.Membro;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<String> itens;

    // (Método Construtor)
    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item, Personagem.Membro jogador) {
        itens.add(item);

        // Cada item tem um bônus associado
        switch (item) {
            case "Credencial Falsa":
                jogador.setBonusItem(jogador.getBonusItem() + 3);
                break;
            case "Rádio Comunicador":
                jogador.setBonusItem(jogador.getBonusItem() + 2);
                break;
            case "Pendrive Hacker":
                jogador.setBonusItem(jogador.getBonusItem() + 3);
                break;
            case "Gravador":
                jogador.setBonusItem(jogador.getBonusItem() + 2);
                break;
            case "Kit Médico":
                jogador.curar(30); // cura em vez de dar bônus
                break;
        }


    }

    public boolean temItem(String item) {
        return itens.contains(item);
    }

    public String listarItens() {
        if (itens.isEmpty()) return "Inventário vazio.";
        return String.join(", ", itens);
    }

    // versão pra compatibilidade
    public void adicionarItem(String item) {
        itens.add(item);
    }
}