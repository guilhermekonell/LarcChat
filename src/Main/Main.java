/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Communication.Tcp;
import Models.User;
import java.util.List;

/**
 *
 * @author guiri
 */
public class Main {
    public static void main(String args[]) {
        Tcp tcp = new Tcp();
        List<User> users = tcp.getUsers(7636, "qmftc");
        
        System.out.println(users);
    }
}
