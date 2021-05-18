/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Communication.Tcp;
import Communication.Udp;
import Main.Util;
import Models.Card;
import Models.MsgGame;
import Models.Player;
import Models.UserLogado;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author guiri
 */
public class Jogo21 extends javax.swing.JFrame {

    private final UserLogado usuarioLogado;
    private final Udp udp;
    private final Tcp tcp;
    private List<Player> players;
    private HashMap<String, ImageIcon> listaCardsImagens;
    private List<Card> cartas;

    /**
     * Creates new form Jogo21
     */
    public Jogo21(UserLogado usuarioLogado) {
        initComponents();
        Util util = new Util();
        listaCardsImagens = util.setarCardsLista();
        this.usuarioLogado = usuarioLogado;
        udp = new Udp();
        tcp = new Tcp();
        setVisibleButtons(true);
        cartas = new ArrayList<>();
        btnObterCard.setEnabled(false);
        jButton2.setEnabled(false);
    }

    public void start() {
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setVisibleButtons(boolean value) {
        jButton1.setEnabled(value);//participar
        //btnObterCard.setVisible(!value);//obter card
        //jButton2.setVisible(!value);//sair
    }

    public void setarMensagemTela(String mensagem) {
        txt21.append("\n" + mensagem);
        udp.sendGame(usuarioLogado, MsgGame.QUIT);
        players = tcp.getPlayers(usuarioLogado);
        setVisibleButtons(true);
    }

    public void setarCardTela(Card card) {
        ImageIcon image = listaCardsImagens.get(card.getNumero() + card.getNaipe().name().substring(0, 1));
        ImageIcon imageIcon = new ImageIcon(image.getImage().getScaledInstance(120, 180, Image.SCALE_DEFAULT));
        if (cartas.size() == 1) {
            carta1.setIcon(imageIcon);
        } else if (cartas.size() == 2) {
            carta2.setIcon(imageIcon);
        } else if (cartas.size() == 3) {
            carta3.setIcon(imageIcon);
            
            btnObterCard.setEnabled(false);
            jButton2.doClick();
            jButton2.setEnabled(false);
        }
        
        setTotal();
    }
    
    public void setTotal() {
        int totalCartas = 0;
        for (Card carta : cartas) {
            totalCartas += carta.getNumero();
        }
        
        total.setText(String.valueOf(totalCartas));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnObterCard = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt21 = new javax.swing.JTextArea();
        carta1 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Participar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticiparActionPerformed(evt);
            }
        });

        jButton2.setText("Parar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnObterCard.setText("Obter carta");
        btnObterCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObterCardActionPerformed(evt);
            }
        });

        txt21.setColumns(20);
        txt21.setRows(5);
        jScrollPane1.setViewportView(txt21);

        carta1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        carta2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        carta3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total:");

        total.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnObterCard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObterCard)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(carta2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnParticiparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticiparActionPerformed
        btnObterCard.setEnabled(true);
        jButton2.setEnabled(true);
        txt21.setText("");
        total.setText("");
        
        udp.sendGame(usuarioLogado, MsgGame.ENTER);
        players = tcp.getPlayers(usuarioLogado);
        setVisibleButtons(false);
        carta1.setIcon(null);
        carta2.setIcon(null);
        carta3.setIcon(null);
        cartas.clear();
    }//GEN-LAST:event_btnParticiparActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        udp.sendGame(usuarioLogado, MsgGame.STOP);
        players = tcp.getPlayers(usuarioLogado);
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        udp.sendGame(usuarioLogado, MsgGame.QUIT);
        players = tcp.getPlayers(usuarioLogado);
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnObterCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObterCardActionPerformed
        try {
            Card card;
            while (true) {
                card = tcp.getCard(usuarioLogado);
                if (card != null) {
                    break;
                } else {
                    Thread.sleep(500);
                }
            }
            players = tcp.getPlayers(usuarioLogado);
            
            if (card != null) {

                if (players.size() > 0) {
                    if (cartas.size() == 3) {
                        cartas.clear();
                    }
                    cartas.add(card);
                    txt21.append("Obteve a carta " + card.getNumero() + " de " + card.getNaipe() + "\n");
                    setarCardTela(card);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }//GEN-LAST:event_btnObterCardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObterCard;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel total;
    private javax.swing.JTextArea txt21;
    // End of variables declaration//GEN-END:variables
}
