package mn.mi.assignment;

import java.util.Set;

public class DefaultBoard implements Board {
    private static final char[] ROWS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private static final int[] COLS = {1, 2, 3, 4, 5, 6, 7, 8};

    private int dimension = 8;

    private Square[][] squares = new Square[dimension][dimension];

    DefaultBoard() {
        this.squares = new Square[dimension][dimension];
        initialize();
    }

    @Override
    public Square[][] getSquares() {
        return squares;
    }

    @Override
    public Square getSquare(Index index) {
        final int row = index.row;
        final int col = index.col;

        if (isValidPosition(row, col)) {
            return getSquares()[row][col];
        }

        throw new IllegalArgumentException("Could not get square: [" + row + "]" + "[" + col + "] is out of bounds.");
    }

    @Override
    public Square getSquare(Piece piece) {
        for (Square[] row : getSquares()) {
            for (Square square : row) {
                if (piece == square.getPiece()) {
                    return square;
                }
            }
        }
        return null;
    }

    @Override
    public Index indexOf(Square square) {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (square == squares[row][col]) {
                    return Index.of(row, col);
                }
            }
        }

        return null;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public String getRowName(int index) {
        return String.valueOf(ROWS[index]);
    }

    @Override
    public String getColName(int index) {
        return String.valueOf(COLS[index]);
    }

    @Override
    public Square move(Piece piece, Index destIndex) {
        int row = destIndex.row;
        int col = destIndex.col;

        if (!isValidPosition(row, col)) {
            throw new IllegalArgumentException("Can not move [" + piece + "]: [" + row + "]" + "[" + col + "] is out of bounds.");
        }

        Square oldSquare = getSquare(piece);
        if (oldSquare != null) {
//            TODO
            getBound(piece).forEach(square -> System.out.print(((NamedSquare) square).getId() + " "));
            System.out.println();

            oldSquare.clear();
        }

        getSquare(destIndex).setPiece(piece);

        return oldSquare;
    }

    @Override
    public Set<Square> getBound(Piece piece) {
        return Bound.of(piece, this);
    }

    private void initialize() {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {
                NamedSquare.SquareId squareId = getSquareId(Index.of(row, col));
                squares[row][col] = new DefaultSquare(squareId);
            }
        }
    }

    private NamedSquare.SquareId getSquareId(Index index) {
        String rowName = getRowName(index.row);
        String colName = getColName(index.col);

        return new NamedSquare.SquareId(rowName, colName);
    }
}