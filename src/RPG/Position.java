package RPG;

/**
 * Keeps track of position using x, y, and z
 * Created by johnathonwalker on 9/28/16.
 */
public class Position {
    private int x;
    private int y;
    private int z;

    /**
     * default constructor initializes all variables to zero
     */
    public Position() {
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * non-default constructor allows user to set manual position values
     * @param x position
     * @param y position
     * @param z position
     */
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    /**
     * increases x position by 1
     */
    public void incrementX() {
        x++;
    }

    /**
     * increases y position by 1
     */
    public void incrementY() {
        y++;
    }

    /**
     * increases z position by 1
     */
    public void incrementZ() {
        z++;
    }

    /**
     * decreases x position by 1
     */
    public void decrementX() {
        x--;
    }

    /**
     * decreases y position by 1
     */
    public void decrementY() {
        y--;
    }

    /**
     * decreases z position by 1
     */
    public void decrementZ() {
        z--;
    }
}
