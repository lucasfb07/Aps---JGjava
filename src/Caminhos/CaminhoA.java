package Caminhos;

import javax.swing.JOptionPane;
import Jogo.AcaoItem;
import Jogo.Jogo;
import Jogo.Teste;
import Personagem.Membro;
import Jogo.Inventario;

public class CaminhoA {
    //Metodo estatico/Encapsulamento interno
    public static void executar(Membro jogador, Inventario inventario, int bonusVertex) {

        boolean possuiRadio = false;

        JOptionPane.showMessageDialog(null,
                """
                        CAMINHO A: INVASÃO FÍSICA
                        
                        Você escolheu invadir a sede da Vertex durante a madrugada.
                        
                        O plano é perigoso, mas pode revelar a verdade de forma definitiva:
                        encontrar o Relatório de Impacto Ambiental Real nos servidores da empresa.""",
                "Raiz Zero", JOptionPane.PLAIN_MESSAGE);

        String[] opcaoItem = {"Pegar o Rádio Comunicador", "Entrar sem equipamento"};
        int pegaItem = JOptionPane.showOptionDialog(null,
                """
                        Antes da missão, um colega da ONG te entrega um Rádio Comunicador.
                        
                        Com ele, você poderá receber instruções durante a invasão
                        e coordenar melhor seus movimentos.
                        
                        Você pega o rádio?""",
                "Item disponível",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcaoItem, opcaoItem[0]);

        if (pegaItem == 0) {
            possuiRadio = true;
            inventario.adicionarItem(Inventario.RADIO_COMUNICADOR, jogador);
        } else if (pegaItem == 1) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você decide entrar sem equipamento extra.
                            
                            Isso torna a missão mais arriscada, mas evita carregar algo
                            que poderia te comprometer caso fosse revistado.""",
                    "Sem equipamento", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Você hesitou demais.\n\nA missão foi cancelada antes mesmo de começar.",
                    "Missão abortada", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null,
                """
                        São 2h da manhã.
                        
                        A sede da Vertex está quase vazia.
                        Do lado de fora, há câmeras na entrada principal,
                        um guarda próximo ao estacionamento e uma porta lateral de manutenção.
                        
                        Você precisa entrar sem chamar atenção.""",
                "Chegada à Vertex", JOptionPane.PLAIN_MESSAGE);

        escolherEntrada(jogador, inventario, possuiRadio, bonusVertex);
    }
    //Metodo estatico/encapsulamento interno
    private static void escolherEntrada(Membro jogador, Inventario inventario, boolean possuiRadio, int bonusVertex) {

        Jogo.exibirStatusOpcional(jogador, inventario);
        AcaoItem.oferecerUsoKitMedico(jogador, inventario);

        String[] opcoes = {
                "Desativar câmeras primeiro",
                "Entrar pela porta lateral",
                "Usar o estacionamento subterrâneo"
        };

        int escolha = JOptionPane.showOptionDialog(null,
                "Qual será sua estratégia de entrada?",
                "Invasão - Entrada",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        boolean entrou;

        if (escolha == 0) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você se aproxima do painel externo das câmeras.
                            
                            Se conseguir desativá-las, terá uma entrada mais segura.
                            Mas qualquer erro pode acionar o alarme.""",
                    "Painel de Câmeras", JOptionPane.PLAIN_MESSAGE);

            entrou = Teste.realizarTesteComRisco(
                    jogador,
                    (possuiRadio ? 8 : 9) + bonusVertex,
                    "Desativar o sistema de câmeras",
                    20, Teste.INTELIGENCIA);

        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você decide entrar pela porta lateral de manutenção.
                            
                            A fechadura parece antiga, mas há uma câmera virada para o corredor.
                            Você precisa ser rápido.""",
                    "Porta Lateral", JOptionPane.PLAIN_MESSAGE);

            entrou = Teste.realizarTesteComRisco(
                    jogador,
                    (possuiRadio ? 8 : 9) + bonusVertex,
                    "Arrombar a porta lateral sem ser visto",
                    25, Teste.FURTIVIDADE);

        } else if (escolha == 2) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você entra pelo estacionamento subterrâneo.
                            
                            O local está escuro, úmido e silencioso.
                            Há menos câmeras, mas existe maior chance de encontrar seguranças.""",
                    "Estacionamento Subterrâneo", JOptionPane.PLAIN_MESSAGE);

            entrou = Teste.realizarTesteComRisco(
                    jogador,
                    (possuiRadio ? 9 : 10) + bonusVertex,
                    "Passar pelo estacionamento sem ser notado",
                    30, Teste.FURTIVIDADE);

        } else {
            JOptionPane.showMessageDialog(null,
                    """
                            Você ficou tempo demais parado do lado de fora.
                            
                            Um carro da segurança passa perto e você decide recuar.
                            A missão foi abortada.""",
                    "Missão abortada", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
            return;
        }

        if (entrou) {
            //Encadeamento para proxima etapa
            corredorSeguranca(jogador, inventario, possuiRadio);
        } else {
            fracassoNaInvasao(jogador, inventario,
                    """
                            Você falhou na tentativa de entrada.
                            
                            O alarme foi acionado antes que você conseguisse entrar no prédio.""");
        }
    }
    //Metodo estatico/encapsulamento interno - logica do corredor interno
    private static void corredorSeguranca(Membro jogador, Inventario inventario, boolean possuiRadio) {

        JOptionPane.showMessageDialog(null,
                """
                        Você consegue entrar na sede da Vertex.
                        
                        O interior do prédio é frio e silencioso.
                        Nas paredes, telas mostram propagandas do futuro shopping.
                        
                        Enquanto avança pelo corredor, você ouve passos se aproximando.""",
                "Dentro da Vertex", JOptionPane.PLAIN_MESSAGE);

        Jogo.exibirStatusOpcional(jogador, inventario);
        AcaoItem.oferecerUsoKitMedico(jogador, inventario);

        String[] opcoes = possuiRadio
                ? new String[]{"Se esconder atrás dos armários", "Usar o rádio para pedir orientação", "Confrontar o segurança"}
                : new String[]{"Se esconder atrás dos armários", "Tentar passar andando normalmente", "Confrontar o segurança"};

        int escolha = JOptionPane.showOptionDialog(null,
                "Um segurança está vindo em sua direção.\n\nO que você faz?",
                "Segurança",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        boolean passou;

        if (escolha == 0) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você se esconde atrás de alguns armários metálicos.
                            
                            O segurança passa devagar pelo corredor.
                            Você prende a respiração e espera o momento certo para sair.""",
                    "Furtividade", JOptionPane.PLAIN_MESSAGE);

            passou = Teste.realizarTesteComRisco(
                    jogador, 8, "Se esconder do segurança", 20, Teste.FURTIVIDADE);

        } else if (escolha == 1 && possuiRadio) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você usa o Rádio Comunicador em volume baixo.
                            
                            Seu colega da ONG observa as câmeras externas e te orienta:
                            Espera... agora! Vai pela porta à esquerda!
                            
                            A ajuda aumenta suas chances de passar sem ser visto.""",
                    "Apoio da ONG", JOptionPane.PLAIN_MESSAGE);

            passou = Teste.realizarTesteComRisco(
                    jogador, 7, "Seguir a orientação pelo rádio", 15, Teste.FURTIVIDADE);

        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você tenta passar andando normalmente,
                            como se fosse um funcionário atrasado.
                            
                            O segurança olha desconfiado.""",
                    "Blefe", JOptionPane.PLAIN_MESSAGE);

            passou = Teste.realizarTesteComRisco(
                    jogador, 9, "Enganar o segurança", 30, Teste.ARGUMENTACAO);

        } else if (escolha == 2) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você decide confrontar o segurança.
                            
                            Essa é a opção mais arriscada.
                            Mesmo vencendo, o barulho pode chamar atenção.""",
                    "Confronto", JOptionPane.WARNING_MESSAGE);

            passou = Teste.realizarTesteComRisco(
                    jogador, 10, "Confrontar o segurança", 40, Teste.FURTIVIDADE);

        } else {
            fracassoNaInvasao(jogador, inventario,
                    """
                            Você hesitou por alguns segundos.
                            
                            O segurança percebeu sua presença e acionou o alarme.""");
            return;
        }

        if (passou) {
            salaServidores(jogador, inventario, possuiRadio);
        } else {
            fracassoNaInvasao(jogador, inventario,
                    """
                            O segurança percebeu sua presença.
                            
                            Antes que você pudesse fugir, a Vertex acionou o protocolo de emergência.""");
        }
    }
    //Metodo estatico/encapsulamento - etapa da invasão final
    private static void salaServidores(Membro jogador, Inventario inventario, boolean possuiRadio) {

        JOptionPane.showMessageDialog(null,
                """
                        Depois de passar pela segurança, você finalmente chega à sala de servidores.
                        
                        Centenas de cabos e máquinas piscam no escuro.
                        Em algum lugar dali está o Relatório de Impacto Ambiental Real.
                        
                        Mas o sistema está protegido.""",
                "Sala de Servidores", JOptionPane.PLAIN_MESSAGE);

        Jogo.exibirStatusOpcional(jogador, inventario);
        AcaoItem.oferecerUsoKitMedico(jogador, inventario);

        String[] opcoes = {
                "Procurar o relatório manualmente",
                "Copiar tudo para análise da ONG",
                "Apagar rastros antes de sair"
        };

        int escolha = JOptionPane.showOptionDialog(null,
                "Como você pretende obter a prova?",
                "Servidor da Vertex",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        boolean conseguiuProva;

        if (escolha == 0) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você decide procurar somente o relatório ambiental.
                            
                            É mais rápido e chama menos atenção,
                            mas exige encontrar o arquivo certo em pouco tempo.""",
                    "Busca direta", JOptionPane.PLAIN_MESSAGE);

            conseguiuProva = Teste.realizarTesteComRisco(
                    jogador,
                    possuiRadio ? 8 : 9,
                    "Encontrar o Relatório Ambiental Real",
                    25, Teste.INTELIGENCIA);

        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você decide copiar o máximo de arquivos possível.
                            
                            Isso pode revelar muito mais do que apenas o relatório,
                            mas o processo demora e aumenta o risco de rastreamento.""",
                    "Cópia de Arquivos", JOptionPane.PLAIN_MESSAGE);

            conseguiuProva = Teste.realizarTesteComRisco(
                    jogador, 10, "Copiar os arquivos da Vertex", 35, Teste.INTELIGENCIA);

        } else if (escolha == 2) {
            JOptionPane.showMessageDialog(null,
                    """
                            Você decide apagar seus rastros antes de procurar o relatório.
                            
                            Isso reduz as chances de a Vertex descobrir a invasão imediatamente,
                            mas consome um tempo precioso.""",
                    "Apagar Rastros", JOptionPane.PLAIN_MESSAGE);

            conseguiuProva = Teste.realizarTesteComRisco(
                    jogador, 9, "Apagar rastros e localizar o relatório", 30, Teste.INTELIGENCIA);

        } else {
            fracassoNaInvasao(jogador, inventario,
                    """
                            Você perdeu tempo demais diante dos servidores.
                            
                            O sistema detectou uma presença não autorizada.""");
            return;
        }

        if (conseguiuProva) {
            sucessoNaInvasao(jogador, inventario);
        } else {
            fracassoNaInvasao(jogador, inventario,
                    """
                            Você não conseguiu obter o relatório a tempo.
                            
                            O sistema bloqueou os arquivos e acionou a segurança.""");
        }
    }
    //Metodo estatico/encapsulamento - desfecho positivo encapsulado
    private static void sucessoNaInvasao(Membro jogador, Inventario inventario) {

        JOptionPane.showMessageDialog(null,
                """
                        Você encontra o arquivo escondido em uma pasta interna da Vertex:
                        
                        Relatório de Impacto Ambiental Real
                        
                        O documento prova que a empresa sabia dos danos ambientais
                        que a construção do shopping causaria à área preservada.
                        
                        Agora você possui uma prova verdadeira contra a Vertex.""",
                "Prova Encontrada", JOptionPane.PLAIN_MESSAGE);

        inventario.adicionarItem(Inventario.RELATORIO_REAL);
        jogador.setTemProvasReais(true);

        JOptionPane.showMessageDialog(null,
                """
                        Com o relatório em mãos, você escapa da sede da Vertex antes do amanhecer.
                        
                        A missão foi um sucesso.
                        
                        Agora vem a decisão mais importante:
                        o que fazer com a prova?""",
                "Fuga Bem-Sucedida", JOptionPane.PLAIN_MESSAGE);

        Finais.Finais.caminhoA1(jogador, inventario);
    }
    //Metodo estatico/encapsulamento interno - desfecho negativo
    private static void fracassoNaInvasao(Membro jogador, Inventario inventario, String motivo) {

        JOptionPane.showMessageDialog(null,
                motivo + "\n\n" +
                        "Luzes vermelhas tomam os corredores.\n" +
                        "Seguranças cercam a saída.\n\n" +
                        "Você é detido dentro da sede da Vertex.",
                "Invasão Fracassada", JOptionPane.WARNING_MESSAGE);

        jogador.setFoiPreso(true);
        Finais.Finais.caminhoA2(jogador, inventario);
    }
}