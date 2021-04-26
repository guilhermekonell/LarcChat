/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Nilton
 */
public class UserLogado extends User{
    
    private static UserLogado userLogado;
    
    public UserLogado(int id, String username){
        super(id, username);
    }
}
