package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016-08-16.
 */
public class Player {
    public int x;
    public int y;
    public static char keyPress;


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
        public static void movePlayer(Player player, Terminal terminal, List<Enemy> enemyList, List<Bullet> bulletList, GameState gameState, Key key ) throws InterruptedException {

            if(key == null){

        } else {
        //terminal.clearScreen();
        switch (key.getCharacter()) {
            case 'a':
                Bullet bullet = new Bullet(player.x, player.y);
                bulletList.add(bullet);


                break;

            case 'L':
                keyPress = 'L';

                if (player.x <= 0) {
                    //player.x = 1;
                } else
                    player.x = player.x - 1;
                break;
            case 'R':
                keyPress = 'R';

                if (player.x >= 30) {
                    //player.x = 19;
                } else
                    player.x = player.x + 1;
                break;
        }
        }




    }

}
