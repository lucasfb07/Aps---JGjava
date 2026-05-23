package Finais;

import javax.swing.JOptionPane;

import Jogo.AcaoItem;
import Personagem.Membro;
import Jogo.Inventario;

public class Finais {
    //Encapsulamento - atributo privado
    private static Membro jogador;

    // CAMINHO A1 — tem provas reais
    public static void caminhoA1(Membro jogador, Inventario inventario) {

        AcaoItem.oferecerUsoKitMedico(jogador, inventario);

        String[] opcoes = {"Entregar ao Ministério Público", "Vazar nas redes sociais"};
        int escolha = JOptionPane.showOptionDialog(null,
                """
                        Você tem o Relatório Real da Vertex.
                        
                        O que você vai fazer com ele?""",
                "O que fazer?", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            finalBom(jogador);
        } else {
            finalNeutro();
        }
    }

    // CAMINHO A2 — foi preso
    public static void caminhoA2(Membro jogador, Inventario inventario) {

        if (inventario != null) {
            AcaoItem.oferecerUsoKitMedico(jogador, inventario);
        }

        String[] opcoes = {"Fazer acordo de delação", "Ficar em silêncio"};
        int escolha = JOptionPane.showOptionDialog(null,
                """
                        Você está detido na sede da Vertex.
                        
                        Um advogado da empresa entra na sala.
                        O que você faz?""",
                "Preso", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            FinalAcordo();
        } else {
            FinalSilencioso();
        }
    }

    // CAMINHO B2 — documentos falsos não descobertos
    public static void caminhoB2(Membro jogador, Inventario inventario) {

        AcaoItem.oferecerUsoKitMedico(jogador, inventario);

        String[] opcoes = {"Chantagear a Vertex", "Vazar os documentos"};
        int escolha = JOptionPane.showOptionDialog(null,
                """
                        Você tem documentos falsos que podem incriminar a Vertex.
                        
                        O que você vai fazer?""",
                "Decisão", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            finalMau();
        } else {
            gameOverFraude();
        }
    }
    //Metodo publico, acesso e armazena quem quiser
    public static void finalBom(Membro jogador) {
        //Atributo estatico
        Finais.jogador = jogador;
        JOptionPane.showMessageDialog(null,
                """

                        O Ministério Público abriu investigação.
                        A obra foi embargada.
                        A área preservada continua de pé.
                        
                        Você não ficou rico. Mas fez a coisa certa.""",
                "FIM", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);

    }

    public static void finalNeutro() {
        JOptionPane.showMessageDialog(null,
                """
                        O vídeo viralizou em 2 horas.
                        A Vertex parou as obras por pressão popular.
                        Mas sem processo jurídico, podem recomeçar em qualquer momento.
                        
                        A luta continua.""",
                "FIM", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);

    }

    public static void finalMau() {
        JOptionPane.showMessageDialog(null,
                """
                        
                        A Vertex pagou para você se calar.
                        O shopping foi construído.
                        A área preservada não existe mais.
                        
                        Você tem dinheiro. E uma consciência pesada.""",
                "FIM", JOptionPane.WARNING_MESSAGE);
        System.exit(0);

    }

    public static void FinalAcordo() {
        JOptionPane.showMessageDialog(null,
                """
                        Você aceitou o acordo.
                        
                        Em troca da sua liberdade, revelou informações sobre
                        as estratégias internas da ONG.
                        
                        A Vertex usou isso para desacreditar o grupo publicamente.
                        Você saiu livre, mas a organização ficou enfraquecida.
                        
                        A obra foi aprovada. A área preservada foi destruída.
                        
                        Você está livre. Mas sozinho.""",
                "FIM", JOptionPane.WARNING_MESSAGE);
        System.exit(0);

    }

    public static void FinalSilencioso() {
        JOptionPane.showMessageDialog(null,
                """
                        Você não disse uma palavra.
                        
                        Enquanto estava detido, sua ONG acionou contatos jurídicos
                        e vazou o caso para a imprensa.
                        
                        A repercussão foi grande o suficiente para forçar sua soltura.
                        Você saiu sem provas, mas sem trair ninguém.
                        
                        A batalha pela área preservada ainda não acabou.
                        
                        Às vezes resistir já é uma vitória.""",
                "FIM", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);

    }

    public static void gameOverFraude() {
        JOptionPane.showMessageDialog(null,
                """
                        GAME OVER
                        
                        A fraude foi descoberta.
                        Você responde por falsidade ideológica.
                        A Vertex saiu ilesa.
                        A área foi destruída.""",
                "Fim", JOptionPane.ERROR_MESSAGE);
        System.exit(0);

    }

    public static void gameOverVidaZero() {
        JOptionPane.showMessageDialog(null,
                """           
                        Seus ferimentos foram graves demais.
                        Você não conseguiu continuar a missão.
                        
                        A área preservada foi destruída.""",
                "Fim", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    public static void setJogador(Membro jogador) {
        Finais.jogador = jogador;
    }
}