/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test.utils;

import fr.xebia.hiring.test.model.Terrain;
import fr.xebia.hiring.test.model.Tondeuse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author mbourkia
 */
public class TondeuseFileReaderSpaceSeparatedTextFormat implements TondeuseFileReaderInterface{
 Terrain terrain = null;
 Path path = Paths.get("D:\\data.txt");
 public final String SEPARATION_CHAR = " ";
 int i;
 
    @Override
    public Terrain loadData(Path path) {
        try (BufferedReader reader = Files.newBufferedReader( path, StandardCharsets.UTF_8)) {
            String line;
            i = 0;
            if((line = reader.readLine()) != null){
                String[] coordonees = line.split(SEPARATION_CHAR);
                terrain = new Terrain(Integer.parseInt(coordonees[0]), Integer.parseInt(coordonees[1]));
                i++;
            }
            int m;
            Tondeuse tondeuseTemp = null;
            while ((line = reader.readLine()) != null) {
                m = i % 2; 
                switch(m){
                    case 0: tondeuseTemp.setCommandSuite(line); break;
                    case 1: String[] data = line.split(SEPARATION_CHAR); tondeuseTemp = new Tondeuse(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], terrain); terrain.getTondeuses().add(tondeuseTemp); break;
                }                
                i++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }catch(ArrayIndexOutOfBoundsException ex){
                    System.err.printf("Format des données du fichier en entrée incorrect, ligne : " + i+1);
        }
        return terrain;
    }
    
    
}
