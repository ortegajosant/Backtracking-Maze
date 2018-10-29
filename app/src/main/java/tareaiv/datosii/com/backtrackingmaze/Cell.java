package tareaiv.datosii.com.backtrackingmaze;

/**
 * Created by jorte on 27/10/2018.
 */

public class Cell {
    private int typeStatus;
    private int xCoord, yCoord;

    public Cell(int typeStatus, int xCoord, int yCoord) {
        this.typeStatus = typeStatus;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(int typeStatus) {
        this.typeStatus = typeStatus;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
