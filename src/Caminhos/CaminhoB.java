package Caminhos;

import javax.swing.JOptionPane;
import Personagem.Membro;
import Jogo.Inventario;
import Jogo.Teste;

public class CaminhoB {

    public static void executar(Membro jogador, Inventario inventario) {

        JOptionPane.showMessageDialog(null,
                """
                        FRAUDE DIGITAL
                        
                        Você decide forjar documentos contra a Vertex.
                        
                        A ideia é criar um relatório falso que prove
                        que a empresa violou as normas ambientais.
                        
                        É arriscado. Se descobrirem, você é o criminoso.""",
                "Caminho B", JOptionPane.PLAIN_MESSAGE);

        // Oferecer Pendrive antes de forjar
        String[] opcaoPendrive = {"Usar o Pendrive Hacker", "Forjar sem auxílio"};
        int pegaPendrive = JOptionPane.showOptionDialog(null,
                """
                        Um contato anônimo da ONG te envia um Pendrive Hacker.
                        
                        Com ele, você pode usar ferramentas digitais avançadas
                        para tornar os documentos mais convincentes e difíceis
                        de serem detectados numa perícia.
                        
                        Você usa o pendrive?""",
                "Item Disponível",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcaoPendrive, opcaoPendrive[0]);

        if (pegaPendrive == 0) {
            inventario.adicionarItem(Inventario.PENDRIVE_HACKER, jogador);
        } else if (pegaPendrive != 1) {

            JOptionPane.showMessageDialog(null,
                    "Você não tomou nenhuma decisão e perdeu a janela de oportunidade.",
                    "Missão Abortada", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        // Cena de forjar os documentos
        JOptionPane.showMessageDialog(null,
                """
                        Você passa horas trabalhando nos documentos.
                        
                        Cada detalhe precisa ser convincente:
                        assinaturas, datas, carimbos e dados técnicos.
                        
                        Qualquer erro pode ser detectado pela perícia da Vertex.""",
                "Forjando Documentos", JOptionPane.PLAIN_MESSAGE);

        // Teste de inteligência — pendrive ajuda aqui
        boolean documentosConvincentes = Teste.realizarTesteComRisco(
                jogador,
                7,
                "Forjar documentos convincentes",
                20,
                Teste.INTELIGENCIA
        );

        inventario.adicionarItem("Documentos Falsificados");
        jogador.setTemProvasFalsas(true);


        // Chance de descoberta baseada no resultado do teste
        int chanceFraude = documentosConvincentes ? 2 : 5; // 20% ou 50%
        int sorte = (int)(Math.random() * 10);

        JOptionPane.showMessageDialog(null,
                """
                        Os documentos foram entregues às autoridades.
                        
                        Agora é aguardar.
                        A perícia técnica da Vertex vai analisá-los.""",
                "Aguardando Perícia", JOptionPane.PLAIN_MESSAGE);

        if (sorte < chanceFraude) {
            // Fraude descoberta
            JOptionPane.showMessageDialog(null,
                    """
                            A perícia detectou inconsistências nos documentos.
                            
                            Os advogados da Vertex identificaram metadados
                            que provam que os arquivos foram adulterados.
                            
                            Você está sendo processado por falsidade ideológica.""",
                    "Fraude Descoberta", JOptionPane.ERROR_MESSAGE);

            Finais.Finais.gameOverFraude();

        } else {
            // Fraude não descoberta
            JOptionPane.showMessageDialog(null,
                    """
                            Os documentos passaram pela análise inicial.
                            
                            Por enquanto, ninguém suspeitou da autenticidade.
                            
                            Agora você precisa decidir o que fazer com eles.""",
                    "Sucesso Temporário", JOptionPane.PLAIN_MESSAGE);

            Finais.Finais.caminhoB2(jogador, inventario);
        }

    }
}