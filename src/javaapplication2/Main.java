/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String dni = "";
        String tipo = "";
        String letra = "";
        boolean coincide;
        System.out.println("Dígame NIF o NIE (000000000Z o Z000000000) :");
        dni = scanner.next();
        tipo = tipoDni(dni);
        letra = calcularLetra(dni, tipo);
  //      System.out.println("el tipo es "+tipo);
        coincide=dniCheck(dni, letra, tipo);
        System.out.println(coincide+"");

    }

    public static String tipoDni(String dni) {
        Pattern nif = Pattern.compile("[0-9]{8}[A-Z]");
        Matcher mNif = nif.matcher(dni);
        boolean bNif = mNif.matches();
        if (bNif) {
            return "nif";
        }

        Pattern nie = Pattern.compile("[A-Z][0-9]{8}");
        Matcher mNie = nie.matcher(dni);
        boolean bNie = mNie.matches();
        if (bNie) {
            return "nie";
        }
        return "";
    }

    public static String calcularLetra(String dni, String tipo) {
        String dniIntermedio = "0";
        String letra = "";
        int modulo;
        int dniInt = 0;
        if (tipo.equals("nif")) {
            dniIntermedio = dni.substring(0, 8);
        } else if (tipo.equals("nie")) {
            dniIntermedio = dni.substring(1, 9);;
        }
        dniInt = Integer.parseInt(dniIntermedio);
        modulo = dniInt % 23;
        switch (modulo) {
            case 0:
                letra = "T";
                break;
            case 1:
                letra = "R";
                break;
            case 2:
                letra = "W";
                break;
            case 3:
                letra = "A";
                break;
            case 4:
                letra = "G";
                break;
            case 5:
                letra = "M";
                break;
            case 6:
                letra = "Y";
                break;
            case 7:
                letra = "F";
                break;
            case 8:
                letra = "P";
                break;
            case 9:
                letra = "D";
                break;
            case 10:
                letra = "X";
                break;
            case 11:
                letra = "B";
                break;
            case 12:
                letra = "N";
                break;
            case 13:
                letra = "J";
                break;
            case 14:
                letra = "Z";
                break;
            case 15:
                letra = "S";
                break;
            case 16:
                letra = "Q";
                break;
            case 17:
                letra = "V";
                break;
            case 18:
                letra = "H";
                break;
            case 19:
                letra = "L";
                break;
            case 20:
                letra = "C";
                break;
            case 21:
                letra = "K";
                break;
            case 22:
                letra = "E";
                break;
        }
        
        return letra;
    }

    public static Boolean dniCheck(String dni, String letra, String tipo) {

        String letraAutentica = "0";
        if (tipo.equals("nif")) {
            letraAutentica = dni.substring(8,9);
        } else if (tipo.equals("nie")) {
            letraAutentica = dni.substring(0,1);
        }
        if(letraAutentica.equals(letra)){
            return true;
        }
        return false;
    }

}
