/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test;

import fr.xebia.hiring.test.model.Terrain;
import fr.xebia.hiring.test.utils.TondeuseFileReaderInterface;
import fr.xebia.hiring.test.utils.TondeuseFileReaderSpaceSeparatedTextFormat;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author mbourkia
 */
public class XebiaHiringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Path path = Paths.get("D:\\data.txt");
        TondeuseFileReaderInterface fileReader = new TondeuseFileReaderSpaceSeparatedTextFormat();
        //Chargement des données à partir du fichier
        Terrain terrain = fileReader.loadData(path);
        //Parcours de toutes les tondeuses existantes sur le terrain
        terrain.getTondeuses().stream().forEach((tondeuse) -> {
            //Execution des commandes par la tondeuse
            tondeuse.executeCommand();
            //Affichage de la positiion de la tondeuse après exécution de la suite des commandes
            System.out.println(tondeuse);
        });
    }

}
