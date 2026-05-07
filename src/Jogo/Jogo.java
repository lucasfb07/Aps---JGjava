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
                        "A Vertex quer derrubá-la para construir um shopping.\n\n" +
                        "Você faz parte da ONG que pode impedir isso.",
                "A Última Hora", JOptionPane.DEFAULT_OPTION,
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
                        "Você é membro de uma ONG dedicada à preservação da vida florestal.\n" +
                        "Seu grupo atua há anos protegendo uma das últimas áreas verdes\n" +
                        "preservadas da região.",
                "Introdução", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Essa área abriga árvores antigas, animais silvestres e nascentes naturais.\n" +
                        "Além disso, ela ajuda a manter o equilíbrio ambiental da cidade.\n\n" +
                        "Para muitas pessoas, esse lugar é mais do que uma floresta.\n" +
                        "É um símbolo de resistência contra a destruição ambiental.",
                "Área Preservada", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Mas tudo muda quando a empresa Vertex anuncia um novo projeto:\n" +
                        "a construção de um shopping exatamente sobre a área preservada.\n\n" +
                        "Segundo a empresa, todos os documentos ambientais foram aprovados.\n" +
                        "Porém, sua ONG desconfia que há algo errado nessa autorização.",
                "Vertex", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Depois de investigar, vocês descobrem a possível existência de um documento secreto:\n" +
                        "o verdadeiro Relatório de Impacto Ambiental.\n\n" +
                        "Esse relatório provaria que a Vertex sabe dos danos irreversíveis\n" +
                        "que a obra pode causar, mas decidiu esconder a verdade.",
                "A Suspeita", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "O problema é que sua ONG tem apoio de ativistas, contatos na mídia\n" +
                        "e ajuda jurídica, mas não possui acesso interno à Vertex.\n\n" +
                        "Sem provas, ninguém poderá impedir o início das obras.",
                "O Problema", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Com o prazo se esgotando, você decide agir.\n\n" +
                        "Existem dois caminhos possíveis:\n\n" +
                        "Invadir a sede da Vertex e tentar encontrar as provas reais.\n" +
                        "Ou criar documentos falsos para tentar incriminar a empresa.\n\n" +
                        "Cada escolha terá consequências.",
                "Sua Decisão", JOptionPane.WARNING_MESSAGE);

        String[] caminhos = {"Invasão Física", "Fraude Digital"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Como você vai tentar conseguir as provas contra a Vertex?",
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