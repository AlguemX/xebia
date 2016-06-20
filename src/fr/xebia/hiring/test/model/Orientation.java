/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Enum Orientation , représentant l'orientation géographique selon la notation cardinale anglaise (N,E,S,W)  
 * @author mbourkia
 */
public enum Orientation {
    
    N('N'),E('E'),S('S'),W('W');
    /**
     * Liste des orientations N, E, S, W. Qui sont insérés dans le sens des aiguilles de la montre
     */
    private static final List<Orientation> orientationMapping;
    
    static{
        //Initialisation de la liste avec les orientations ordonées dans le sens des aiguilles de la montre
        ArrayList<Orientation> myAL = new ArrayList<Orientation>();
        myAL.add(N);
        myAL.add(E);
        myAL.add(S);
        myAL.add(W);
        orientationMapping = Collections.unmodifiableList(myAL);
    }
    /**
     * Le caractère représentant l'orientation courante 
     */
    private char orientation;

    /**
     * Constructeur de l'orientation selon le caractère de type <code>char</code> fourni en paramètre : N, E, S, W.
     * @param orientation 
     * 
     */
     Orientation(char orientation) {
        this.orientation = orientation;
    }
    /**
     * Déplacement de l'orientation de 90° vers la gauche (dans le sens inverse des aiguilles de la montre)
     * @return la nouvelle orientation à 90° à gauche de la précédente
     */
     public Orientation left(){
         //Récupération de l'index de l'iroentation courante
         int currentIndex = orientationMapping.indexOf(this);
         // Retour de l'orientation se trouvant à gauche dans le sens des aiguilles de la montre. 
         //Si l'orientation courante est la première entrée de la liste, alors on retourne la dernière entrée de la liste d'orientation
         char finalOrientation = (currentIndex == 0)? orientationMapping.get(orientationMapping.size()- 1).getValue() : orientationMapping.get(currentIndex - 1).getValue();
         
         return Orientation.valueOf(String.valueOf(finalOrientation));
     }
    
     /**
      * Déplacement de l'orientation de 90° vers la droite (dans le sens des aiguilles de la montre)
      * @return la nouvelle orientation à 90° à droite de la précédente
      */
     public Orientation right(){
         //Récupération de l'index de l'iroentation courante
         int currentIndex = orientationMapping.indexOf(this);
         // Retour de l'orientation se trouvant à droite dans le sens des aiguilles de la montre. 
         //Si l'orientation courante est la dernière entrée de la liste, alors on retourne la première entrée de la liste d'orientation
         char finalOrientation = (currentIndex == orientationMapping.size() - 1)? orientationMapping.get(0).getValue() : orientationMapping.get(currentIndex + 1).getValue();
          return Orientation.valueOf(String.valueOf(finalOrientation));
     }
    
     /**
      * 
      * @return la valeur de type <code>char</code> de l'orientation actuelle
      */
     public char getValue(){
         return this.orientation;
     }
     
    
    
}
