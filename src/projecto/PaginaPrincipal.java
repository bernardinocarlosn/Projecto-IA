/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class PaginaPrincipal extends JFrame {

    private JComboBox origem, destino, criterio, piso;
    private JButton btnEntrar;
    private Panel panel;
    private int indice1, indice2, indice3;
    private JLabel caminho;
    private ImageIcon fundo = new ImageIcon(getClass().getResource("/imagens/Mapa.png"));
    private ImageIcon ImageButton = new ImageIcon(getClass().getResource("/imagens/botao.png"));
    
    // Construtor
    public PaginaPrincipal() {
        
        desenharPagina();
        
        ButtonHandler bh = new ButtonHandler();
        btnEntrar.addActionListener(bh);
        
        ComboBoxHandler cbh = new ComboBoxHandler();
        origem.addItemListener(cbh);
        destino.addItemListener(cbh);
        piso.addItemListener(cbh);

        definicoePadrao();

    }

    // definicoes padrao da JFrame 
    private void definicoePadrao() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        
    }
    
    // metodo que faz o desenho da pagina principal
    private void desenharPagina() {
        
        Box vBox = Box.createVerticalBox();
        Box hBox = Box.createHorizontalBox();
        Box hBoxResu = Box.createHorizontalBox();
        vBox.add(Box.createVerticalStrut(580));
        
        panel = new Panel();
        
        String[] origens = {"Maputo             ",
                          "Catembe", 
                           "Matola", 
                           "Liberdade", 
                          "Marracuene",  
                          "Namaacha", 
                          "Ressano Garcia", 
                          "Malhampsene"};
        
        
        
        String[] destinos = {"Maputo", "Catembe", "Matola", "Liberdade", 
            "Marracuene", "Namaacha", "Ressano Garcia", "Malhampsene"};
        
        String[] criterios = {"Criterio1 : Distancia", "Criterio2 : duracao", "Criterio3 : custo"};
        
        String[] estadoPisos = {"1 -> Pior      ", "2 -> Normal      ", "3 -> Moderado      ", "4 -> Bom      ", 
            "5 -> Optimo"};
   
        origem = criarComboBox(origens, 5);
        
        destino = criarComboBox(destinos, 5);
        
        criterio = criarComboBox(criterios, 3);
        
        piso = criarComboBox(estadoPisos, 5);
        
        caminho = new JLabel();
        caminho.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 26));
        caminho.setText("");
        btnEntrar = new JButton(ImageButton);
        btnEntrar.setPreferredSize(new Dimension(110, 30));
        hBox.add(Box.createHorizontalStrut(14));
        hBox.add(origem);
        hBox.add(Box.createHorizontalStrut(26));
        hBox.add(destino);
        hBox.add(Box.createHorizontalStrut(52));
        hBox.add(criterio);
        hBox.add(Box.createHorizontalStrut(14));
        hBox.add(piso);
        hBox.add(Box.createHorizontalStrut(7));
        hBox.add(btnEntrar);
        hBox.add(Box.createHorizontalStrut(168));
        
        vBox.add(hBox);
        vBox.add(Box.createVerticalStrut(20));
        hBoxResu.add(Box.createHorizontalStrut(20));
        hBoxResu.add(caminho);
        hBoxResu.add(Box.createHorizontalStrut(300));
        vBox.add(hBoxResu);
        panel.add(vBox);
        
        add(panel);
    }
    
    // metodo que cria combox
    private JComboBox criarComboBox(String[] nomes, int i) {
        JComboBox jcb = new JComboBox(nomes);
        jcb.setFont(new Font("Calibri", Font.PLAIN, 25));
        jcb.setMaximumRowCount(i);
        return jcb;
    }

    // sobrescrita do metodo paintComponent para setar 
    // um background
    private class Panel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image img = fundo.getImage();
            g.drawImage(img, 0, 0, this);
        }
    }
    
    
    private class ComboBoxHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ie) {
        
            //piso = criarComboBox(estadoPisos, 5);
            
            if(ie.getStateChange() == ItemEvent.SELECTED) {
                
                switch(origem.getSelectedIndex()) {
                    case 0: indice1 = 0; break;
                    case 1: indice1 = 1; break;
                    case 2: indice1 = 2; break;
                    case 3: indice1 = 3; break;
                    case 4: indice1 = 4; break;
                    case 5: indice1 = 5; break;
                    case 6: indice1 = 6; break;
                    case 7: indice1 = 7; break;
                    default: javax.swing.JOptionPane.showMessageDialog(null, "Selecione o Estado Inicial!");
                }
                
                switch(destino.getSelectedIndex()) {
                    case 0: indice2 = 0; break;
                    case 1: indice2 = 1; break;
                    case 2: indice2 = 2; break;
                    case 3: indice2 = 3; break;
                    case 4: indice2 = 4; break;
                    case 5: indice2 = 5; break;
                    case 6: indice2 = 6; break;
                    case 7: indice2 = 7; break;
                    default: javax.swing.JOptionPane.showMessageDialog(null, "Selecione o Estado Inicial!");
                }
                
                switch(piso.getSelectedIndex()) {
                    case 0: indice3 = 1; break;
                    case 1: indice3 = 2; break;
                    case 2: indice3 = 3; break;
                    case 3: indice3 = 4; break;
                    case 4: indice3 = 5; break;
                    default: javax.swing.JOptionPane.showMessageDialog(null, "Selecione o Estado Inicial!");
                }
                
            }
            
        }
    
    }
    
    // classe que trata o evento
    private class ButtonHandler implements ActionListener {

        BuscaDeCustoUniforme  busca = new BuscaDeCustoUniforme();
        
        Grafo grafo = new Grafo();
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(indice1 == 0 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 0 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 0 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 0 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 0 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 0 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 0 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 0 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL1(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
            
            //////////////////////////////////////////////////
            
            if(indice1 == 1 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 1 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 1 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 1 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 1 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 1 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 1 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 1 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL2(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
           
           //////////////////////////////////////////////////
            
            if(indice1 == 2 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 2 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 2 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 2 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 2 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 2 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 2 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 2 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL3(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
            
            //////////////////////////////////////////////////
            
            if(indice1 == 3 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 3 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 3 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 3 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 3 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 3 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 3 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 3 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL4(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
            
            
            //////////////////////////////////////////////////
            
            if(indice1 == 4 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 4 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 4 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 4 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 4 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 4 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 4 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 4 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL5(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
            
            //////////////////////////////////////////////////
            
            if(indice1 == 5 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 5 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 5 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 5 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 5 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 5 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 5 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 5 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL6(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
            
            
            //////////////////////////////////////////////////
            
            if(indice1 == 6 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 6 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 6 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 6 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 6 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 6 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 6 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 6 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL7(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
            
            
            
            //////////////////////////////////////////////////
            
            if(indice1 == 7 && indice2 == 0) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL1(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL1()));
            } 
            if(indice1 == 7 && indice2 == 1) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL2(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL2()));
            }
            if(indice1 == 7 && indice2 == 2) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL3(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL3()));
            }
            
            if(indice1 == 7 && indice2 == 3) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL4(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL4()));
            }
            if(indice1 == 7 && indice2 == 4) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL5(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL5()));
            }
            if(indice1 == 7 && indice2 == 5) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL6(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL6()));
            }
            if(indice1 == 7 && indice2 == 6) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL7(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL7()));
            }
            if(indice1 == 7 && indice2 == 7) {
                    busca.buscaCustoUniforme(grafo.getL8(), grafo.getL8(), indice3);
                    caminho.setText("" + busca.printPath(grafo.getL8()));
            }
           
                    
        }
            
    }
    
   
}
