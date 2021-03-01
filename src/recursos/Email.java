/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import java.io.IOException;
import static org.jsoup.Jsoup.connect;

/**
 *
 * @author ThyagoPacher
 */
public class Email {
 
    Internet internet = new Internet();
    
    private String pegaTelefone(String url){
        try { 
            return connect(url).timeout(9000).get().getElementsContainingOwnText("+").text();
        } catch(IOException ex) {  
            System.out.println("Erro causado por:" + ex);  
        }  
        return null;
    }
}
