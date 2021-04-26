/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import Models.User;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public List<User> getUsers(Integer userId, String password) {
        try {
            System.setProperty("java.net.preferIPv6Addresses", "true");
            Socket sock = new Socket("larc.inf.furb.br", 1012);
            
            DataOutputStream d = new DataOutputStream(sock.getOutputStream());
            String request = "GET USERS " + userId + ":" + password + "\n";
            d.writeBytes(request);

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
                String username = usersResponse[i+1];
                Integer wins = Integer.parseInt(usersResponse[i+2]);
                
                User newUser = new User(id, username, wins);
                
                users.add(newUser);
            }
            
            sock.close();
            
            return users;
        } catch(UnknownHostException e) {
            
        } catch(IOException e) {
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return new ArrayList();
    }
}
