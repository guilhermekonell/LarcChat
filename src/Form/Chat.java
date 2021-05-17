/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Models.*;
import Communication.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nilton
 */
public class Chat extends javax.swing.JFrame {

    private final UserLogado usuarioLogado;
    private final Tcp tcp;
    private final Udp udp;
    private final String col[] = {"ID", "Nome"};
    private final DefaultListModel listModel;
    private List<User> listaUsuarios;
    Jogo21 jogo21;

    public Chat(UserLogado usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        tcp = new Tcp();
        udp = new Udp();
        listModel = new DefaultListModel();
    }

    public void start() {
        setVisible(true);
        setLocationRelativeTo(null);
        popularListaJogadores();
        popularMensagens();
    }

    public void popularListaJogadores() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    listaUsuarios = tcp.getUsers(usuarioLogado);
                    listModel.removeAllElements();
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        listModel.addElement(listaUsuarios.get(i).getUsername());
                    }
                    listJogadores.setModel(listModel);
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void popularMensagens() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String mensagem = tcp.getMessages(usuarioLogado);
                    if (!mensagem.equals("") && !mensagem.equals(":")) {
                        if (mensagem.contains("vencedor") && jogo21 != null) {
                            jogo21.setarMensagemTela(mensagem);
                        } else {
                            txtMensagens.append(getMensagemFormatada(mensagem) + "\n");
                        }
                    }

                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public String getMensagemFormatada(String response) {
        Integer id = 0;
        StringBuilder mensagem = new StringBuilder();
        String[] mensagemSeparada = response.split(":");
        for (int i = 0; i < mensagemSeparada.length; i = i + 2) {
            id = Integer.parseInt(mensagemSeparada[i]);
            for (User user : listaUsuarios) {
                if (user.getUserId() == id) {
                    mensagem.append(user.getUsername()).append(":");
                }
            }
            mensagem.append(mensagemSeparada[i + 1]);
        }

        if (mensagem.toString().equals("")) {
            return "";
        } else {
            return mensagem.toString();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        txtCampoEnviarMensagem = new javax.swing.JTextField();
        btEnviarMensagem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listJogadores = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensagens = new javax.swing.JTextArea();
        btn21 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jogadores", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btEnviarMensagem.setText("Enviar");
        btEnviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarMensagemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Jogadores Ativos");

        jScrollPane1.setViewportView(listJogadores);

        txtMensagens.setColumns(20);
        txtMensagens.setRows(5);
        txtMensagens.setFocusable(false);
        jScrollPane2.setViewportView(txtMensagens);

        btn21.setText("Jogar 21");
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCampoEnviarMensagem)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEnviarMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampoEnviarMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviarMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarMensagemActionPerformed
        // TODO add your handling code here:
        if (listJogadores.getSelectedIndex() == -1) {
            udp.sendMessages(usuarioLogado, 0, txtCampoEnviarMensagem.getText());
        } else {
            listaUsuarios.stream().filter((user) -> (user.getUsername().equals(listJogadores.getSelectedValue()))).forEachOrdered((user) -> {
                udp.sendMessages(usuarioLogado, user.getUserId(), txtCampoEnviarMensagem.getText());
            });
        }
        txtCampoEnviarMensagem.setText("");
    }//GEN-LAST:event_btEnviarMensagemActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        jogo21 = new Jogo21(usuarioLogado);
        jogo21.start();
    }//GEN-LAST:event_btn21ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviarMensagem;
    private javax.swing.JButton btn21;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listJogadores;
    private javax.swing.JTextField txtCampoEnviarMensagem;
    private javax.swing.JTextArea txtMensagens;
    // End of variables declaration//GEN-END:variables
}
