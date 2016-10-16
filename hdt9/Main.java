
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Main {
    static Scanner userInput = new Scanner(System.in);
     static Map<String,String> elmapa= null;
     //static ArrayList<Association<String, String>> prueba = new ArrayList();
     static String oracion;
     
     
     public static void pedir(){
        System.out.print("¿Que estructura de datos desea probar? (RBTree/TreeMap)");
        if (userInput.hasNextLine()){
            String tipoFabrica = userInput.nextLine();
            if (tipoFabrica.equals("RBTree")){
                 elmapa = new RedBlackBST(); //Uso de la implementacion de un Red Black Tree
            }
            else if (tipoFabrica.equals("TreeMap")){
                elmapa = new TreeMap<>(); //Uso del JCF para la segunda implementacion
            }
        }
     }
    
     public static void crearDiccionario(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                linea = linea.replaceAll(",", ""); //esto sirve para eliminar las comas unidas a las palabras
                String[] palabras = linea.split("\\s{1,}");
                if (palabras.length>2){
                    if (palabras[1].equals("la") || palabras[1].equals("el")){
                        elmapa.put(palabras[0], palabras[2]);
                    }
                    else {
                        elmapa.put(palabras[0],palabras[1]);
                    }
                }
                else if (palabras.length>1){
                    elmapa.put(palabras[0], palabras[1]);
                }
                /*
                if (palabras.length>1)
                {
                Association<String, String> traduccion = new Association(palabras[0], palabras[1]);       
                prueba.add(traduccion);
                
                }*/
                
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
     public static void traducir(){
          int i=0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\texto.txt"));
            oracion = "";
            String tmp = br.readLine();
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
                 
         //String probando = "about	acerca, sobre, a punto de";
         //String[] laprueba = probando.split("\\s{1,}");
         //System.out.println(laprueba[1].equals("la"));
     }
}
