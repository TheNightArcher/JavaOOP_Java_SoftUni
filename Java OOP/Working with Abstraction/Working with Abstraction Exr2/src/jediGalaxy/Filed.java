package jediGalaxy;

public class Filed {

    private int[][] matrix;

    public Filed(int rows, int cols, int beginValue) {
        this.matrix = new int[rows][cols];
        this.fillMatrix(beginValue);
    }

    public Filed(int rows, int cols) {
        this(rows, cols, 0);
    }

    private void fillMatrix(int beginValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.matrix[i][j] = beginValue++;
            }
        }
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < this.matrix.length && col < this.matrix[row].length;
    }

    public void setValue(int row, int col, int newValue) {
        this.matrix[row][col] = newValue;
    }

    public int getValue(int row, int col) {
        return matrix[row][col];
    }

    public int getColLength(int row) {
        return this.matrix[row].length;
    }
}
