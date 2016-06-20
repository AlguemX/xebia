/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test.model;

import java.util.ArrayList;

/**
 *
 * @author mbourkia
 */
public class Terrain {
    
    private ArrayList<Tondeuse> tondeuses;
    
    private int x,y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    public ArrayList<Tondeuse> getTondeuses() {
        return tondeuses;
    }

    public void setTondeuses(ArrayList<Tondeuse> tondeuses) {
        this.tondeuses = tondeuses;
    }

    public Terrain(int x, int y) {
        this.x = x;
        this.y = y;
        this.tondeuses = new ArrayList<>();
    }
    
    
    
}
