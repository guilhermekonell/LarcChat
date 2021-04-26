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
    
    private final Integer userId;
    private final String username;
    private final Integer wins;

    public User(Integer userId, String username, Integer wins) {
        this.userId = userId;
        this.username = username;
        this.wins = wins;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getWins() {
        return wins;
    }
    
}
