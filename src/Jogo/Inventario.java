package Jogo;

import Personagem.Membro;

import javax.swing.*;
import java.util.ArrayList;

public class Inventario {

    // Atributo Estático
    public static final String RADIO_COMUNICADOR = "Rádio Comunicador";
    public static final String CREDENCIAL_FALSA  = "Credencial Falsa";
    public static final String PENDRIVE_HACKER   = "Pendrive Hacker";
    public static final String GRAVADOR          = "Gravador";
    public static final String KIT_MEDICO        = "Kit Médico";

    private ArrayList<String> itens;

    // Método Construtor
    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item, Personagem.Membro jogador) {
        itens.add(item);

        String descricao = "";
        String efeito    = "";

        switch (item) {

            case RADIO_COMUNICADOR:
                jogador.setBonusItem(jogador.getBonusItem() + 2);
                descricao = "Aparelho de comunicação com sua equipe da ONG.";
                efeito    = "+2 nos testes de furtividade";
                break;

            case CREDENCIAL_FALSA:
                jogador.setBonusItem(jogador.getBonusItem() + 3);
                descricao = "Crachá com identidade forjada de funcionário da Vertex.";
                efeito    = "+3 nos testes de entrada e diálogo";
                break;

            case PENDRIVE_HACKER:
                jogador.setBonusItem(jogador.getBonusItem() + 3);
                descricao = "Dispositivo com ferramentas de invasão digital da ONG.";
                efeito    = "+3 nos testes digitais";
                break;

            case GRAVADOR:
                jogador.setBonusItem(jogador.getBonusItem() + 2);
                descricao = "Gravador de áudio disfarçado de caneta.";
                efeito    = "+2 nos testes de evidência";
                break;

            case KIT_MEDICO:
                jogador.curar(30);
                descricao = "Kit de primeiros socorros preparado pela ONG.";
                efeito    = "❤ +30 de vida restaurados";
                break;

            default:
                descricao = "Item desconhecido.";
                efeito    = "Nenhum efeito.";
                break;
        }

        // Feedback visual ao pegar o item
        JOptionPane.showMessageDialog(null,
                "ITEM OBTIDO\n\n" +
                        "📦 " + item + "\n\n" +
                        descricao + "\n\n" +
                        "Efeito: " + efeito + "\n\n" +
                        jogador.getStatus(),
                "Novo Item", JOptionPane.PLAIN_MESSAGE);
    }

    public boolean temItem(String item) {
        return itens.contains(item);
    }

    public String listarItens() {
        if (itens.isEmpty()) return "Inventário vazio.";
        return String.join(", ", itens);
    }

    // (Sobrecarga) — versão sem jogador pra compatibilidade
    public void adicionarItem(String item) {
        itens.add(item);
    }
}
