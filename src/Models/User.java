/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author guiri
 */
public class User {
    
    private final int userId;
    private final String username;
    private final int wins;

    public User(int userId, String username, int wins) {
        this.userId = userId;
        this.username = username;
        this.wins = wins;
    }
    
    public User(int userId, String username){
        this(userId, username, 0);
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getWins() {
        return wins;
    }
    
}
