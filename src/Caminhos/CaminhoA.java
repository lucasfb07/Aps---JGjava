package Caminhos;

import javax.swing.JOptionPane;

import Jogo.Teste;
import Personagem.Membro;
import Jogo.Inventario;

public class CaminhoA {

    public static void executar(Membro jogador, Inventario inventario) {

        //oferecer item
        String[] opcaoItem = {"Pegar o Rádio Comunicador", "Entrar sem equipamento"};
        int pegaItem = JOptionPane.showOptionDialog(null,
                "Seu colega da ONG te oferece um Rádio Comunicador.\n" +
                        "Ele pode te ajudar a coordenar a entrada.\n\n" +
                        "Você pega?",
                "Item disponível", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcaoItem, opcaoItem[0]);

        if (pegaItem == 0) {
            inventario.adicionarItem("Rádio Comunicador", jogador);
            JOptionPane.showMessageDialog(null,
                    "Rádio Comunicador adicionado!\n" + jogador.getStatus(),
                    "Item obtido", JOptionPane.PLAIN_MESSAGE);
        }

        // Teste de furtividade para entrar
        boolean entrou = Teste.realizarTesteComRisco(
                jogador,
                6,// dificuldade 6/10
                "Entrar furtivamente no prédio",
                25// perde 25 de vida se falhar
        );

        if (entrou) {
            sucessoNaInvasao(jogador, inventario);
        } else {
            fracassoNaInvasao(jogador);
        }

        JOptionPane.showMessageDialog(null,
                "INVASÃO FÍSICA\n\n" +
                        "São 2h da manhã.\n" +
                        "Você está do lado de fora da sede da Vertex.\n" +
                        "Há câmeras na entrada principal e um guarda na lateral.",
                "Raiz Zero", JOptionPane.PLAIN_MESSAGE);

        // Escolha do jogador
        String[] opcoes = {"Desativar câmeras primeiro", "Entrar direto pela lateral"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Como vamos entrar?",
                "Invasão", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            // Jogador foi cuidadoso — maior chance de sucesso
            entradaCuidadosa(jogador, inventario);
        } else {
            // Jogador foi direto — maior chance de ser pego
            entradaDireta(jogador, inventario);
        }
    }

    private static void entradaCuidadosa(Membro jogador, Inventario inventario) {

        JOptionPane.showMessageDialog(null,
                "Você hackeia o painel de câmeras.\n" +
                        "Janela de 3 minutos aberta. Você corre.",
                "Raiz Zero", JOptionPane.PLAIN_MESSAGE);

        // Dado — simula sorte
        try {
            int sorte = (int)(Math.random() * 10);

            if (sorte >= 3) { // 70% de chance de sucesso
                sucessoNaInvasao(jogador, inventario);
            } else {
                fracassoNaInvasao(jogador);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro inesperado: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void entradaDireta(Membro jogador, Inventario inventario) {

        JOptionPane.showMessageDialog(null,
                "Você tenta entrar sem se preparar.\n" +
                        "O guarda da lateral te avista.",
                "Raiz Zero", JOptionPane.PLAIN_MESSAGE);

        int sorte = (int)(Math.random() * 10);

        if (sorte >= 6) { // 40% de chance de sucesso
            sucessoNaInvasao(jogador, inventario);
        } else {
            fracassoNaInvasao(jogador);
        }
    }

    private static void sucessoNaInvasao(Membro jogador, Inventario inventario) {

        JOptionPane.showMessageDialog(null,
                "Você chegou ao servidor da Vertex.\n\n" +
                        "Nos arquivos você encontra:\n" +
                        "'Relatório de Impacto Ambiental Real'\n\n" +
                        "A Vertex sabia de tudo desde o início.",
                "Sucesso", JOptionPane.PLAIN_MESSAGE);

        inventario.adicionarItem("Relatório Real da Vertex");
        jogador.setTemProvasReais(true);
        Finais.Finais.caminhoA1(jogador, inventario);
    }

    private static void fracassoNaInvasao(Membro jogador) {

        JOptionPane.showMessageDialog(null,
                "Uma sirene dispara.\n\n" +
                        "Seguranças chegam de todos os lados.\n" +
                        "Você é detido no local.",
                "Preso", JOptionPane.WARNING_MESSAGE);

        jogador.setFoiPreso(true);
        Finais.Finais.caminhoA2(jogador);
    }
}