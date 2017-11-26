package mn.mi.assignment;

public abstract class NamedSquare implements Square {
    private Piece piece;

    public NamedSquare() {
        this.piece = new NullPiece();
    }

    public NamedSquare(Piece piece) {
        this.piece = piece;
    }

    @Override
    public Piece getPiece() {
        return this.piece;
    }

    @Override
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public void clear() {
        setPiece(new NullPiece());
    }

    public abstract SquareId getId();

    static class SquareId {
        private final String row;
        private final String col;

        public SquareId(String rowName, String colName) {
            this.row = rowName;
            this.col = colName;
        }

        @Override
        public String toString() {
            return row + col;
        }
    }
}
