package jediGalaxy;

public class Galaxy {
    private Filed filed;

    public Galaxy(Filed filed) {
        this.filed = filed;
    }

    public void moveEvil(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (this.filed.isValid(row, col)) {
                this.filed.setValue(row, col, 0);
            }
            row--;
            col--;
        }
    }

    public long moveJedi(int row, int col) {
        long startsCollected = 0;
        while (row >= 0 && col < this.filed.getColLength(1)) {
            if (this.filed.isValid(row, col)) {
                startsCollected += this.filed.getValue(row, col);
            }
            row--;
            col++;
        }
        return startsCollected;
    }
}
