/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GeneracionGrafics;


import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.attribute.Rank;
import static guru.nidi.graphviz.attribute.Records.label;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.text.*;

public class GenerateGrafic {

   
    
    public void generarGrafico(String cadena, JLabel label){
        

        String inputString = cadena; // Tu string aquí 

        MutableGraph g = guru.nidi.graphviz.model.Factory.mutGraph("stringToNode").setDirected(true)
                .graphAttrs().add(Rank.dir(Rank.RankDir.LEFT_TO_RIGHT)); // Configuración del atributo del grafo 

        MutableNode prevNode = null;
        MutableNode lastNode = null; // Para mantener referencia al último nodo del string 
        for (char c : inputString.toCharArray()) {
            MutableNode node = guru.nidi.graphviz.model.Factory.mutNode(Character.toString(c));
            g.add(node);
            if (prevNode != null) {
                prevNode.addLink(node); // Cambiado como mencionaste 
            }
            prevNode = node;
            lastNode = node; // Actualizar el último nodo en cada iteración 
        }

        // Cambiar el shape del último nodo ("y") a círculo doble 
        if (lastNode != null) {
            lastNode.add(Shape.DOUBLE_CIRCLE);
        }

        // Generar la imagen y cargarla en el JLabel 
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Graphviz.fromGraph(g).render(Format.PNG).toOutputStream(outputStream);
            byte[] imageBytes = outputStream.toByteArray();
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

