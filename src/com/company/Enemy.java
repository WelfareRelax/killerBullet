package com.company;

/**
 * Created by Administrator on 2016-08-16.
 */
public abstract class Enemy implements Entity {
    public float x;
    public float y;
    public float speed;
    public char displayChar;
    public boolean gameRun = true;



    public Enemy() {

    }

    public void move() {
        y = y + speed;
    }
    public char getChar(){
        return displayChar;

    }
    public int getX(){
        return ((int)Math.round(x));

    }
    public int getY(){
        return ((int)Math.round(y));
    }
}

class SlowEnemy extends  Enemy {
    public SlowEnemy(int x, int y) {
        this.x = x;
        this.y = y;
        displayChar='S';
        speed=0.05f;
    }
    public void move () {
        y = y+speed;
        if (y > 30) {
            y = 30;
        }
    }

}
class FastEnemy extends  Enemy {
    public FastEnemy(int x, int y) {
        this.x = x;
        this.y = y;
        displayChar='F';
        speed=0.1f;}

    public void move () {
        y = y+speed;
        if (y > 30) {
            gameRun = false;
        }

    }

}


