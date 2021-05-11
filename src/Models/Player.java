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
public class Player {
    
    private final int userId;
    private final StatusPlayer status;

    public Player(int userId, StatusPlayer status) {
        this.userId = userId;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public StatusPlayer getStatus() {
        return status;
    }
    
}
