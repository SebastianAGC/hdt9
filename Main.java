/**
 * UVG
 * Hoja 9
 * Clase principal que traduce una oracion en ingles contenida en texto.txt
 * Utiliza una implementacion de Red Black Tree y una de Treemap (java collection framework)
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Rodrigo Arriaza y Sebastian Galindo
 */
public class Main {
    static Scanner userInput = new Scanner(System.in);
     static Map<String,String> elmapa= null;
     static String oracion;
     static Factory lafabrica = new Factory();
     
     //metodo que pide la estructura de datos deseada para crear en tiempo de corrida la implementacion
     public static void pedir(){
         boolean flag = false;
        while (!flag){
        System.out.print("¿Que estructura de datos desea probar? (Red Black Tree/Treemap)");
        if (userInput.hasNextLine()){
            String tipomapa = userInput.nextLine();
            if (tipomapa.equals("Red Black Tree") || tipomapa.equals("Treemap")){
                elmapa=lafabrica.iniciarDiccionario(tipomapa);
                flag = true;
            }
            else {
                System.out.println("No ha escogido una opcion valida");
            }
        }
     }
     }
    
     // este metodo lee el archivo de texto almacena cada palabra en el mapa, con su traduccion
     public static void crearDiccionario(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Spanish.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                linea = linea.replaceAll(",", ""); //esto sirve para eliminar las comas unidas a las palabras
                String[] palabras = linea.split("\\s{1,}");
                if (palabras.length>2){
                    if (palabras[1].equals("la") || palabras[1].equals("el")){
                        elmapa.put(palabras[0], palabras[2]); //esto sirve para que solo se tome el sustantivo
                    }
                    else {
                        elmapa.put(palabras[0],palabras[1]);
                    }
                }
                else if (palabras.length>1){
                    elmapa.put(palabras[0], palabras[1]);
                }
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
     //metodo que lee la oracion en ingles en el archivo de texto "texto.txt" y lo traduce si se tiene la palabra en el diccionario
     public static void traducir(){
          int i=0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\texto.txt"));
            oracion = "";
            String tmp = br.readLine();
            tmp = tmp.toLowerCase();
            String[] palabras = tmp.split(" ");
            while(i<palabras.length){
                if (!elmapa.containsKey(palabras[i])){
                    oracion=oracion+"*"+palabras[i]+"*"+" ";
                }
                else {
                    oracion = oracion + elmapa.get(palabras[i])+" ";
                }
                i++;               
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
     }
     
     public static void main (String[] args){
         
         pedir();
         crearDiccionario();
         traducir();
         System.out.println(oracion);
                 
     }
}
