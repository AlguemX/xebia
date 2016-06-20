/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test.model;

/**
 * Enum Command , représente les commandes possible pouvant être effectués par une Tondeuse
 * @author mbourkia
 */
public enum Command {
    
    A('A'), D('D'), G('G');
    
    private char command;
    
    private Command(char command){
        this.command = command;
    }
    
    
}
