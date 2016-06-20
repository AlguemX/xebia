/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.xebia.hiring.test.model;

/**
 *
 * @author mbourkia
 */
public class Tondeuse {

    private int x, y;

    private Orientation orientation;

    private Terrain terrain;

    private String commandSuite;

    /**
     *
     * @return La coordonée X indiquant la position de la tondeuse sur l'axe
     * horizontal
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return La coordonée Y indiquant la position de la tondeuse sur l'axe
     * vertical
     */
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return l'orientation actuelle de la tondeuse
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Mets à jour l'orientation de la tondeuse
     *
     * @param orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     *
     * @return le terrain surlequel est la tondeuse
     */
    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public String getCommandSuite() {
        return commandSuite;
    }

    /**
     * Mets à jour la suite de commandes que doit executer la tondeuse
     *
     * @param commandSuite
     */
    public void setCommandSuite(String commandSuite) {
        this.commandSuite = commandSuite;
    }

    public Tondeuse(int x, int y, String orientation, Terrain terrain) {
        this.x = x;
        this.y = y;
        this.terrain = terrain;
        this.orientation = Orientation.valueOf(orientation);
    }

    /**
     * Execution de chaque commande unitairement
     *
     * @param command
     */
    private void executeCommand(Command command) {
        switch (command) {
            case A:
                this.moveForward();
                break;
            case D:
                this.right();
                break;
            case G:
                this.left();
                break;
        }
    }

    /**
     * Execution de la suite de commandes afin de se déplacer sur le terrain
     */
    public void executeCommand() {
        if (this.commandSuite != null) {
            String[] commands = this.commandSuite.split("");
            for (String cmd : commands) {
                this.executeCommand(Command.valueOf(cmd));
            }
        }
    }

    /**
     * Déplacement de la tondeuse d'un pas vers l'avant, selon son orientation
     * actuelle
     */
    private void moveForward() {
        switch (this.orientation) {
            case N:
                this.y = (this.isNextStepInsideTerrain(this.x, this.y + 1)) ? ++this.y : this.y;
                break;
            case E:
                this.x = (this.isNextStepInsideTerrain(this.x + 1, this.y)) ? ++this.x : this.x;
                break;
            case W:
                this.x = (this.isNextStepInsideTerrain(this.x - 1, this.y)) ? --this.x : this.x;
                break;
            case S:
                this.y = (this.isNextStepInsideTerrain(this.x, this.y - 1)) ? --this.y : this.y;
                break;
        }

    }

    /**
     * Changement d'orientation de 90° vers la droite
     */
    private void right() {
        this.orientation = this.orientation.right();
    }

    /**
     * Changement d'orientation de 90° vers la gauche
     */
    private void left() {
        this.orientation = this.orientation.left();
    }

    /**
     * Verifie si les coordonées fournies rentrent dans le terrain
     *
     * @param x
     * @param y
     * @return true si les coordonées fournies sont positifs et inférrieurs aux
     * limites suppérieurs du terrain
     */
    private boolean isNextStepInsideTerrain(int x, int y) {
        return (x >= 0 && x <= this.terrain.getX()) && (y >= 0 && y <= this.terrain.getY());
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.orientation;
    }

}
