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
public class Card {
    
    private final int numero;
    private final Naipe naipe;

    public Card(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }
    
}
