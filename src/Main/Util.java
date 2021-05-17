/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Nilton
 */
public class Util {

    public HashMap setarCardsLista() {
        List<String> naipeList = Arrays.asList("C", "D", "H", "S");
        HashMap<String, ImageIcon> hashImagens = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            for (String naipe : naipeList) {
                ImageIcon img = new ImageIcon(getClass().getResource("/Images/" + i + naipe + ".png"));
                hashImagens.put(i+naipe, img);
            }

        }
        return hashImagens;
    }
}
