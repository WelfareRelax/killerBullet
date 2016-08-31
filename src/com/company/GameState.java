package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016-08-30.
 */
public class GameState {

    private List<Enemy> enemyList = new ArrayList<>();
    private List<Bullet> bulletList = new ArrayList<>();

    private Terminal terminal;
    private Player player;

    public GameState(Terminal terminal, Player player) {
        this.terminal = terminal;
        this.player = player;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean gameLogic()  {
        if(!bulletList.isEmpty()) {

            if (bulletList.get(0).y == 0) {
                bulletList.remove(bulletList.get(0));
            }
        }

        return (enemyList.get(enemyList.size()-1).gameRun);

    }
    public void checkCollide() throws InterruptedException {
        for(int i = 0; i < enemyList.size(); i++) {

            for (int j = 0; j < bulletList.size(); j++) {
                if ((enemyList.get(i).getX() == bulletList.get(j).x) && (enemyList.get(i).getY() == bulletList.get(j).y)) {
                    enemyList.remove(enemyList.get(i));
                    if (enemyList.isEmpty()) {
                        Main.printToTerminal("WINNER", terminal);
                        Thread.sleep(2000);
                        System.exit(0);
                    }
                    break;
                }
            }
        }

    }
    public void updateState() throws InterruptedException {


        checkCollide();
        for(int i = 0; i < enemyList.size(); i++ ) {
            this.enemyList.get(i).move();

        }



        checkCollide();




        for(int i = 0; i < bulletList.size(); i++ ) {
            this.bulletList.get(i).move();

        }





    }
    public void updateScreen() {
        terminal.clearScreen();
        terminal.moveCursor(player.x,player.y);
        terminal.putCharacter('O');

        int xnum;
        int ynum;
        List<Entity> entityList = new ArrayList<Entity>(enemyList);
        entityList.addAll(bulletList);


        for(int i = 0; i < entityList.size(); i++ ) {
            xnum = entityList.get(i).getX();
            ynum = entityList.get(i).getY();
            terminal.moveCursor(xnum, ynum);
            terminal.putCharacter(entityList.get(i).getChar());
        }

        terminal.moveCursor(0,0);
    }
}
