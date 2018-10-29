package tareaiv.datosii.com.backtrackingmaze;

public class BacktrackingAlgorithm {
    private Cell[][] maze;

    public BacktrackingAlgorithm(Cell[][] maze) {
        this.maze = maze;
    }

    public void print() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j].getTypeStatus() + " ");
            }
            System.out.println();
        }
    }

    // Resuelve el algoritmo
    public boolean fixMaze() {
        if (fixMazeAux(0, 0)) {
            return true;
        }
        return false;
    }

    // Resuelve el algoritmo
    private boolean fixMazeAux(int coordX, int coordY) {
        if (coordX == maze[0].length - 1 && coordY == maze.length - 1) {
            return true;
        }

        if (canMove(coordX, coordY)) {
            maze[coordY][coordX].setTypeStatus(4);
            if (fixMazeAux(coordX + 1, coordY)) {
                return true;
            }
            if (fixMazeAux(coordX, coordY + 1)) {
                return true;
            }
            if (fixMazeAux(coordX - 1, coordY)) {
                return true;
            }
            if (fixMazeAux(coordX, coordY - 1)) {
                return true;
            }
            maze[coordY][coordX].setTypeStatus(5);
            return false;
        }

        return false;
    }

    // Verifica que se pueda mover en la dirección de la coordenada seleccionada
    private boolean canMove(int coordX, int coordY) {
        if (0 <= coordX && coordX < maze[0].length && coordY >= 0 && coordY < maze.length
                && maze[coordY][coordX].getTypeStatus() == 0) {
            return true;
        }
        return false;
    }
}