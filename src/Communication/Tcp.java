/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import Models.Card;
import Models.Naipe;
import Models.Player;
import Models.StatusPlayer;
import Models.User;
import Models.UserLogado;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guiri
 */
public class Tcp {

    public List<User> getUsers(UserLogado userLogado) {
        try {
            //System.setProperty("java.net.preferIPv6Addresses", "true");
            Socket sock = new Socket("larc.inf.furb.br", 1012);

            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            String request = "GET USERS " + userLogado.getUserId() + ":" + userLogado.getUsername() + "\r\n";
            out.println(request);
            InputStreamReader s = new InputStreamReader(sock.getInputStream());
            BufferedReader rec = new BufferedReader(s);

            String response = rec.readLine();

            if (response.equals("Mensagem inválida!")) {
                throw new Exception("Não foi possível buscar os usuários conectados!");
            }

            String[] usersResponse = response.split(":");

            List<User> users = new ArrayList();

            for (int i = 0; i < usersResponse.length; i = i + 3) {
                Integer id = Integer.parseInt(usersResponse[i]);
                String username = usersResponse[i + 1];
                Integer wins = Integer.parseInt(usersResponse[i + 2]);

                User newUser = new User(id, username, wins);

                users.add(newUser);
            }

            sock.close();

            return users;
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList();
    }

    public String getMessages(UserLogado userLogado) {
        try {
            //System.setProperty("java.net.preferIPv6Addresses", "true");
            Socket sock = new Socket("larc.inf.furb.br", 1012);

            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            String request = "GET MESSAGE " + userLogado.getUserId() + ":" + userLogado.getUsername() + "\r\n";
            out.println(request);
            InputStreamReader s = new InputStreamReader(sock.getInputStream());
            BufferedReader rec = new BufferedReader(s);

            String response = rec.readLine();

            if (response.equals("Mensagem inválida!")) {
                throw new Exception("Não foi possível buscar as mensagens!");
            }
            sock.close();
            return response;
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    
    public List<Player> getPlayers(UserLogado userLogado) {
        try {
            //System.setProperty("java.net.preferIPv6Addresses", "true");
            Socket sock = new Socket("larc.inf.furb.br", 1012);

            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            String request = "GET PLAYERS " + userLogado.getUserId() + ":" + userLogado.getUsername() + "\r\n";
            out.println(request);
            InputStreamReader s = new InputStreamReader(sock.getInputStream());
            BufferedReader rec = new BufferedReader(s);

            String response = rec.readLine();

            String[] playersResponse = response.split(":");

            List<Player> players = new ArrayList();

            for (int i = 0; i < playersResponse.length; i = i + 2) {
                Integer id = Integer.parseInt(playersResponse[i]);
                StatusPlayer status = StatusPlayer.valueOf(playersResponse[i + 1]);

                Player newPlayer = new Player(id, status);

                players.add(newPlayer);
            }

            sock.close();
            
            return players;
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList();
    }
    
    public Card getCard(UserLogado userLogado) {
        try {
            //System.setProperty("java.net.preferIPv6Addresses", "true");
            Socket sock = new Socket("larc.inf.furb.br", 1012);

            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            String request = "GET CARD " + userLogado.getUserId() + ":" + userLogado.getUsername() + "\r\n";
            out.println(request);
            InputStreamReader s = new InputStreamReader(sock.getInputStream());
            BufferedReader rec = new BufferedReader(s);

            String response = rec.readLine();

            String[] cardResponse = response.split(":");

            int numero = 0;
            switch(cardResponse[0]) {
                case "A":
                    numero = 1;
                    break;
                case "J":
                case "Q":
                case "K":
                    numero = 10;
                    break;
                default:
                    numero = Integer.parseInt(cardResponse[0]);
                    break;
            }
            
            Naipe naipe = Naipe.valueOf(cardResponse[1]);
            Card card = new Card(numero, naipe);

            sock.close();
            
            return card;
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
