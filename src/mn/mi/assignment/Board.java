package mn.mi.assignment;

import java.util.Set;

public interface Board {
    Square[][] getSquares();

    Square getSquare(Index index);

    Square getSquare(Piece piece);

    Index indexOf(Square square);

    int getDimension();

    String getRowName(int index);

    String getColName(int index);

    /**
     * @param piece reference to moving piece
     * @param index reference to new square index
     * @return old square
     */
    Square move(Piece piece, Index index);

    Set<Square> getBound(Piece piece);

    default boolean isValidPosition(int row, int col) {
        if (row < 0 || row >= getDimension()) {
            return false;
        }
        if (col < 0 || col >= getDimension()) {
            return false;
        }
        return true;
    }

    class Index {
        final int row, col;

        public Index(int row, int col) {
            this.row = row;
            this.col = col;
        }

        static Index of(int row, int col) {
            return new Index(row, col);
        }

        @Override
        public String toString() {
            return "[" + row + "]" + "[" + col + "]";
        }
    }
}
