package tareaiv.datosii.com.backtrackingmaze;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class GameView extends View {
    private static GameView instance;
    private int cellSize;
    private boolean mazeON, fixON;
    private Cell[][] cells;
    private Paint paint;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (instance == null) {
            instance = this;
        }

        paint = new Paint();
        cells = new Cell[8][8];
    }

    public static GameView getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return null;
        }
    }

    /**
     * Dibuja el laberinto y la solución
     * @param canvas
     */
    @Override
    protected void onDraw(final Canvas canvas) {

        canvas.drawColor(Color.WHITE);

        if (mazeON) {
            int width = getWidth();

            cellSize = width / (8);

            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells.length; y++) {
                    if (cells[y][x].getTypeStatus() != 0) {
                        if (cells[y][x].getTypeStatus() == 1) { // Se ´pintan los obstáculos
                            paint.setColor(Color.BLUE);
                        } else if (cells[y][x].getTypeStatus() == 4) { // Se pintan los bloques de camino correcto
                            paint.setColor(Color.GREEN);
                        } else if (cells[y][x].getTypeStatus() == 5) { // Se pintan los caminos que tomó el algoritmo y no funcionaron
                            paint.setColor(Color.GRAY);
                        } else if (cells[y][x].getTypeStatus() == 2) { // Se pinta el destino
                            paint.setColor(Color.RED);
                        }
                        canvas.drawRect(x * cellSize, y * cellSize,
                                (x + 1) * cellSize, (y + 1) * cellSize, paint);

                    }
                }
            }
        }
        invalidate();
    }

    // Se resuelve el alberinto
    public void fixMaze() {
        BacktrackingAlgorithm backtrackingAlgorithm = new BacktrackingAlgorithm(cells);
        backtrackingAlgorithm.fixMaze();
        fixON = true;
    }

    // Se crea un nuevo laberinto seleccionando los predefinidos
    public void makeMaze() {
        int[][] maze = randomMaze();
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze.length; y++) {
                if (x == 7 && y == 7) {
                    cells[x][y] = new Cell(2, x, y);
                } else {
                    cells[x][y] = new Cell(maze[x][y], x, y);
                }
            }
        }
    }

    // Selecciona un laberinto posible
    public int[][] randomMaze() {
        int[][] maze1 = {{0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 2}};

        int[][] maze2 = {{0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0, 1, 2}};

        int[][] maze3 = {{0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 0, 2}};

        int[][] maze4 = {{0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 1, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 2}};

        int[][] maze5 = {{0, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 2}};

        Random random = new Random();
        int mazeNum = 1 + random.nextInt(5);

        System.out.println("La matriz es : " + mazeNum);

        switch (mazeNum) {
            case 1:
                return maze1;
            case 2:
                return maze2;
            case 3:
                return maze3;
            case 4:
                return maze4;
            case 5:
                return maze5;
            default:
                return maze1;
        }
    }

    public boolean isMazeON() {
        return mazeON;
    }

    public void setMazeON(boolean mazeON) {
        this.mazeON = mazeON;
    }

    public boolean isFixON() {
        return fixON;
    }

    public void setFixON(boolean fixON) {
        this.fixON = fixON;
    }
}
