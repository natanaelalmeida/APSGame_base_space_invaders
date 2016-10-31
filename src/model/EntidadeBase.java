package model;

import java.awt.Rectangle;

public class EntidadeBase {
    private double x;
    private double y;
    private double vx; //velocidade em x
    private double vy; //velocidade em y
    private Rectangle rec1; //espaçamento da nave
    private Rectangle rec2; //espaçamento do alien
    private String src;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public Rectangle getRec1() {
        return rec1;
    }

    public void setRec1(Rectangle rec1) {
        this.rec1 = rec1;
    }

    public Rectangle getRec2() {
        return rec2;
    }

    public void setRec2(Rectangle rec2) {
        this.rec2 = rec2;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}