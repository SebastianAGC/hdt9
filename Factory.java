
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo Arriaza y Sebastian Galindo
 */
public class Factory {
    public Map iniciarDiccionario(String tipoMapa){
        Map elmapa = null;
        if (tipoMapa.equals("Red Black Tree")){
            elmapa=new RedBlackBST();
        } else if (tipoMapa.equals("Treemap")){
            elmapa=new Arbolmapa();
        }
        return elmapa;
    }
}
