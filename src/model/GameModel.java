package model;

import abstracts.Entidade;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class GameModel {
    private BufferStrategy bfStrategy;
    private boolean gameExec;
    private Entidade nave;
    private double movSpeed;
    private long ultTiro;
    private long intervaloDisparo;
    private int qtdAlien;
    
    private String message;
    private boolean espraKeyPress ;
    private boolean leftPressed;
    private boolean rightPressed;   
    private boolean tiroPressionado;    
    private boolean loop;

    public BufferStrategy getBfStrategy() {
        return bfStrategy;
    }

    public void setBfStrategy(BufferStrategy bfStrategy) {
        this.bfStrategy = bfStrategy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

    public boolean isEspraKeyPress() {
        return espraKeyPress;
    }

    public void setEspraKeyPress(boolean espraKeyPress) {
        this.espraKeyPress = espraKeyPress;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public boolean isTiroPressionado() {
        return tiroPressionado;
    }

    public void setTiroPressionado(boolean tiroPressionado) {
        this.tiroPressionado = tiroPressionado;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }        
    
    public BufferStrategy getbfStrategy() {
        return bfStrategy;
    }

    public void setbfStrategy(BufferStrategy bs) {
        this.bfStrategy = bs;
    }

    public boolean isGameExec() {
        return gameExec;
    }

    public void setGameExec(boolean gameExec) {
        this.gameExec = gameExec;
    }

    public Entidade getNave() {
        return nave;
    }

    public void setNave(Entidade nave) {
        this.nave = nave;
    }

    public double getMovSpeed() {
        return movSpeed;
    }

    public void setMovSpeed(double movSpeed) {
        this.movSpeed = movSpeed;
    }

    public long getUltTiro() {
        return ultTiro;
    }

    public void setUltTiro(long ultTiro) {
        this.ultTiro = ultTiro;
    }

    public long getIntervaloDisparo() {
        return intervaloDisparo;
    }

    public void setIntervaloDisparo(long intervaloDisparo) {
        this.intervaloDisparo = intervaloDisparo;
    }

    public int getQtdAlien() {
        return qtdAlien;
    }

    public void setQtdAlien(int qtdAlien) {
        this.qtdAlien = qtdAlien;
    }
    
    
}
