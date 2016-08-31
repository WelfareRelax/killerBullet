package com.company;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;

import java.util.Random;

import static com.company.Player.movePlayer;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Terminal terminal = TerminalFacade.createTerminal(System.in,System.out, Charset.forName("UTF8"));
        Player player = new Player(10,terminal.getTerminalSize().getRows());
        GameState gameState = new GameState(terminal, player);

        gameState.getTerminal().enterPrivateMode();

        Random random = new Random();
        int randomX1 = random.nextInt(10);
        gameState.getEnemyList().add(new SlowEnemy(randomX1+1, 0));
        int randomX2 = random.nextInt(10);
        gameState.getEnemyList().add(new SlowEnemy(randomX1+randomX2+1, 0));

        randomX1 = random.nextInt(10);
        gameState.getEnemyList().add(new FastEnemy(randomX1+1, 1));
        randomX2 = random.nextInt(10);
        gameState.getEnemyList().add(new FastEnemy(randomX1+randomX2+1, 1));

        while(gameState.gameLogic()){
            //Wait for a key to be pressed
            Key key;
            do{
                gameState.updateState();
                gameState.updateScreen();

                key = gameState.getTerminal().readInput();

                if(!gameState.gameLogic()){

                    break;
                }
                Thread.sleep(20);

            if(!gameState.getBulletList().isEmpty()) {


                if (gameState.getBulletList().get(0).y == 0) {
                    gameState.getBulletList().remove(gameState.getBulletList().get(0));
                }
            }

        }while(key == null);

            movePlayer(gameState.getPlayer(), gameState.getTerminal(), gameState.getEnemyList(), gameState.getBulletList(), gameState, key);
            gameState.updateState();
            gameState.updateScreen();
        }

        printToTerminal("Game over", gameState.getTerminal());
        Thread.sleep(1000);
        System.exit(0);

    }
    public static void printToTerminal(String s, Terminal terminal) {
        terminal.clearScreen();
        for (int i = 0; i < s.length(); i++) {
            terminal.moveCursor(i, 10);
            terminal.putCharacter(s.charAt(i));

        }
    }

}


