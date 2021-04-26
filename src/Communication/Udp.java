/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import Models.UserLogado;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author guiri
 */
public class Udp {

    public void sendMessages(UserLogado userLogado, int idReceptor, String mensagem) {
        try {
            StringBuilder messageBuilder = new StringBuilder("SEND MESSAGE ");
            messageBuilder.append(userLogado.getUserId());
            messageBuilder.append(":");
            messageBuilder.append(userLogado.getUsername());
            messageBuilder.append(":");
            messageBuilder.append(idReceptor);
            messageBuilder.append(":");
            messageBuilder.append(mensagem);
            byte[] s = new byte[messageBuilder.toString().length()];
            s = messageBuilder.toString().getBytes();
            InetAddress ip = InetAddress.getByName("larc.inf.furb.br");
            DatagramPacket pack = new DatagramPacket(s, s.length, ip, 1011);

            // Cria um socket UDP e envia o pacote para 'localhost:8000'
            DatagramSocket socket = new DatagramSocket();
            socket.send(pack);

            // Encerra o socket
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
