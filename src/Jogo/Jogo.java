package Jogo;

import javax.swing.JOptionPane;
import Personagem.Membro;
import Caminhos.CaminhoA;
import Caminhos.CaminhoB;

public class Jogo {

    private Membro jogador;
    private Inventario inventario;

    //  METODO CONSTRUTOR
    public Jogo() {
        this.inventario = new Inventario();
    }

    public void iniciar() {

        // Tela de início
        String[] botaoStart = {"START"};
        JOptionPane.showOptionDialog(null,
                "BEM-VINDO AO JOGO\n\n" +
                        "Uma área preservada está em risco.\n" +
                        "Você é a última esperança.",
                "O Jogo", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, botaoStart, botaoStart[0]);

        // Nome do jogador
        String nome = JOptionPane.showInputDialog(null,
                "Qual é o seu nome, ativista?",
                "Criar Personagem", JOptionPane.PLAIN_MESSAGE);

        if (nome == null || nome.trim().isEmpty()) nome = "Ativista";
        jogador = new Membro(nome);

        // Introdução
        JOptionPane.showMessageDialog(null,
                "Olá, " + jogador.getNome() + ".\n\n" +
                        "A Vertex Corp obteve licença para destruir\n" +
                        "uma área de preservação permanente.\n\n" +
                        "Você sabe que os documentos são fraudados.\n" +
                        "Mas precisa de provas.",
                "Introdução", JOptionPane.PLAIN_MESSAGE);

        // Escolha do caminho
        String[] caminhos = {" Invasão Física", "Fraude Digital"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Como você vai tentar conseguir as provas? Ah poucas opções, mas é oque temos:",
                "Escolha seu caminho",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, caminhos, caminhos[0]);

        if (escolha == 0) {
            CaminhoA.executar(jogador, inventario);
        } else {
            CaminhoB.executar(jogador, inventario);
        }
    }
}