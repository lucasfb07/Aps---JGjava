package Jogo;

import javax.swing.*;
import Antagonista.Vertex;
import Personagem.Membro;
import Caminhos.CaminhoA;
import Caminhos.CaminhoB;

public class Jogo {

    private final Inventario inventario;

    // Método Construtor
    public Jogo() {
        this.inventario = new Inventario();
    }
    //metodo estatico - pode ser chamado sem instanciar o jogo
    public static void exibirStatusOpcional(Membro jogador, Inventario inventario) {

        String[] opcoes = {"Continuar", "Ver meu status"};
        while(true) {
            int escolha = JOptionPane.showOptionDialog(
                    null,"Deseja continuar ou verificar seu status antes de prosseguir?",
                    "Pausa",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );
            if (escolha != 1) {
                return;
            }
            JOptionPane.showMessageDialog(
                    null,"status atual\n\n" +
                            jogador.getStatus() +
                            "\n\nInventario:\n" + inventario.listarItens(),
                            "Status personagem",
                            JOptionPane.PLAIN_MESSAGE
            );
        }
    }
    //metodo instacia - coordena logica narrativa
    public void iniciar() {

        String[] botaoStart = {"START"};
        JOptionPane.showOptionDialog(null,
                """
                        BEM-VINDO AO JOGO
                        
                        Uma área preservada está em risco.
                        A Vertex quer derrubá-la para construir um shopping.
                        
                        Você faz parte da ONG que pode impedir isso.""",
                "A Última Hora", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, botaoStart, botaoStart[0]);

        String nome = JOptionPane.showInputDialog(null,
                "Qual é o seu nome, ativista?",
                "Criar Personagem", JOptionPane.PLAIN_MESSAGE);

        if (nome == null) {
            System.exit(0);
        }
        if (nome.trim().isEmpty()) nome = "Ativista";
        //Polimorfismo de classe - subtipo de personagem
        Membro jogador = new Membro(nome);

        JOptionPane.showMessageDialog(null,
                "Olá, " + jogador.getNome() + ".\n\n" +
                        "Você é membro de uma ONG dedicada à preservação da vida florestal.\n" +
                        "Seu grupo atua há anos protegendo uma das últimas áreas verdes\n" +
                        "preservadas da região.",
                "Introdução", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                """
                        Essa área abriga árvores antigas, animais silvestres e nascentes naturais.
                        Além disso, ela ajuda a manter o equilíbrio ambiental da cidade.
                        
                        Para muitas pessoas, esse lugar é mais do que uma floresta.
                        É um símbolo de resistência contra a destruição ambiental.""",
                "Área Preservada", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                """
                        Mas tudo muda quando a empresa Vertex anuncia um novo projeto:
                        a construção de um shopping exatamente sobre a área preservada.
                        
                        Segundo a empresa, todos os documentos ambientais foram aprovados.
                        Porém, sua ONG desconfia que há algo errado nessa autorização.""",
                "Vertex", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                """
                        Depois de investigar, vocês descobrem a possível existência de um documento secreto:
                        o verdadeiro Relatório de Impacto Ambiental.
                        
                        Esse relatório provaria que a Vertex sabe dos danos irreversíveis
                        que a obra pode causar, mas decidiu esconder a verdade.""",
                "A Suspeita", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                """
                        O problema é que sua ONG tem apoio de ativistas, contatos na mídia
                        e ajuda jurídica, mas não possui acesso interno à Vertex.
                        
                        Sem provas, ninguém poderá impedir o início das obras.""",
                "O Problema", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                """
                        Com o prazo se esgotando, você decide agir.
                        
                        Existem dois caminhos possíveis:
                        
                        Invadir a sede da Vertex e tentar encontrar as provas reais.
                        Ou criar documentos falsos para tentar incriminar a empresa.
                        
                        Cada escolha terá consequências.""",
                "Sua Decisão", JOptionPane.WARNING_MESSAGE);
        //instancia da classe final vertex
        Vertex vertex = new Vertex();

        String[] caminhos = {"Invasão Física", "Fraude Digital"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Como você vai tentar conseguir as provas contra a Vertex?",
                "Escolha seu caminho",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, caminhos, caminhos[0]);

        if (escolha == 0) {
            CaminhoA.executar(jogador, inventario, vertex.getBonusDificuldade());
        } else if (escolha == 1) {
            CaminhoB.executar(jogador, inventario);
        } else {
            JOptionPane.showMessageDialog(null,
                    """
                            Você hesitou tempo demais.
                            
                            Sem uma decisão, a Vertex avançou com as obras.
                            A área preservada foi destruída.""",
                    "Missão Abandonada", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
}