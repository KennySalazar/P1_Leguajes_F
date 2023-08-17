/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Backend.AnalizadorLexico;
import Backend.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kenny
 */
public class Main {
    public static void main(String[] args) {
        
        /*Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        AnalizadorLexico analizadorlexico = new AnalizadorLexico(entrada);
        List<Token> tokens = analizadorlexico.analizarCodigoFuente();
        
        System.out.println(analizadorlexico.analizarCodigoFuente().size());
        for (int i = 0; i < analizadorlexico.analizarCodigoFuente().size(); i++) {
        System.out.println(analizadorlexico.analizarCodigoFuente().get(i).toString());
        
        }*/
        
        vista v = new vista();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        v.enableInputMethods(true);
        
        
    }
    
}
