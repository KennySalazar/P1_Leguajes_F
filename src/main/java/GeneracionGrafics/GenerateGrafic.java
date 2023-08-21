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
        

        String inputString = cadena; 

        MutableGraph grafica = guru.nidi.graphviz.model.Factory.mutGraph("String").setDirected(true)
                .graphAttrs().add(Rank.dir(Rank.RankDir.LEFT_TO_RIGHT)); 

        MutableNode prevNode = null;
        MutableNode lastNode = null; 
        for (char c : inputString.toCharArray()) {
            MutableNode node = guru.nidi.graphviz.model.Factory.mutNode(Character.toString(c));
            grafica.add(node);
            if (prevNode != null) {
                prevNode.addLink(node);
            }
            prevNode = node;
            lastNode = node; 
        }

        
        if (lastNode != null) {
            lastNode.add(Shape.DOUBLE_CIRCLE);
        }

        
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Graphviz.fromGraph(grafica).render(Format.PNG).toOutputStream(outputStream);
            byte[] imageBytes = outputStream.toByteArray();
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

