package com.company;

/**
 * Created by Administrator on 2016-08-30.
 */
public class Bullet implements Entity {
    public int x;
    public int y;
    public char displayChar = 'O';

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move () {
        y = y-1;
        if(y <= 1)
            y = 0;

    }
    public char getChar(){
        return displayChar;


    }
    public int getX(){
        return x;

    }
    public int getY(){
        return y;

    }


}

