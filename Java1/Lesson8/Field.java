/**
 * Java 1. Lesson 8. Game Tic Tac Toe
 *
 * @author Vvedenskiy Aleksandr
 * @version dated Jul 25, 2017
 */

import java.awt.*;
import java.awt.geom.*; // for Graphics2D
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.*;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Field {
    private final int FIELD_SIZE;
    private final int CELL_SIZE;
    private final char HUMAN_DOT = 'x';
    private final char AI_DOT = 'o';
    private final char EMPTY_DOT = '.';
    private final String MSG_DRAW = "Draw, sorry...";
    private final String MSG_HUMAN_WON = "YOU WON!"; 
    private final String MSG_AI_WON = "AI WON!";
    private char[][] field;
    private String gameOverMsg;
    private Image cross;
    private Image circle;

    Field(int field_size, int cell_size) {
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;
        field = new char[FIELD_SIZE][FIELD_SIZE];
        init();
    }

    void init() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                field[i][j] = EMPTY_DOT;
        gameOverMsg = null;
    }

    int getSize() { return FIELD_SIZE; }

    char getHumanDot() { return HUMAN_DOT; }

    char getAIDot() { return AI_DOT; }

    boolean isGameOver() { return gameOverMsg != null; }

    String getGameOverMsg() { return gameOverMsg; }
                                             
    void setDot(int x, int y, char dot) { // set dot and check fill and win
        field[x][y] = dot;
        if (isFull() && !isWin(HUMAN_DOT)) {
            gameOverMsg = MSG_DRAW;
            Sound.playSound("Draw.wav").join();
        }
        if (isWin(HUMAN_DOT)) {
            gameOverMsg = MSG_HUMAN_WON;
            Sound.playSound("Win.wav").join();
        }
        if (isWin(AI_DOT)) {
            gameOverMsg = MSG_AI_WON;
            Sound.playSound("Loser.wav").join();
        }
    }

    boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) return false;
        if (field[x][y] == EMPTY_DOT) return true;
        return false;
    }

    boolean isFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (field[i][j] == EMPTY_DOT) return false;
        return true;
    }

    boolean isWin(char ch) {
        // checking horizontals / verticals
        for (int i = 0; i < FIELD_SIZE; i++)
            if ((field[i][0] == ch && field[i][1] == ch && field[i][2] == ch) ||
                (field[0][i] == ch && field[1][i] == ch && field[2][i] == ch))
                return true;
        // checking diagonals
        if ((field[0][0] == ch && field[1][1] == ch && field[2][2] == ch) ||
            (field[2][0] == ch && field[1][1] == ch && field[0][2] == ch))
            return true;
        return false;
    }
	
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE, i*CELL_SIZE);
            g.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE);
        }
        Graphics2D g2 = (Graphics2D) g; // use Graphics2D
        g2.setStroke(new BasicStroke(5));
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (field[x][y] == HUMAN_DOT) {
                    //g.setColor(Color.blue);
                    //g2.draw(new Line2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4));
                    //g2.draw(new Line2D.Float(x*CELL_SIZE+CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4));
                    try {
                    cross = ImageIO.read(new File("cross.png"));
                    } catch(IOException e) { e.printStackTrace(); }
                    g.drawImage(cross, x*CELL_SIZE+CELL_SIZE/12, y*CELL_SIZE+CELL_SIZE/12, null);
                }
                if (field[x][y] == AI_DOT) {
                    //g.setColor(Color.red);
                    //g2.draw(new Ellipse2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, CELL_SIZE/2, CELL_SIZE/2));
                    try {
                    circle = ImageIO.read(new File("circle.png"));
                    } catch(IOException e) { e.printStackTrace(); }
                    g.drawImage(circle, x*CELL_SIZE+CELL_SIZE/12, y*CELL_SIZE+CELL_SIZE/12, null);
                }
            }
        }
    }
}