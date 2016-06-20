/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test.utils;

import fr.xebia.hiring.test.model.Terrain;
import java.nio.file.Path;

/**
 *
 * @author mbourkia
 */
public interface TondeuseFileReaderInterface {
    
    public Terrain loadData(Path path);
     
    
}
