package mn.mi.assignment;

public class CloningBoard extends DefaultBoard {

    @Override
    public Square move(Piece piece, Index destIndex) {
        Square oldSquare = super.move(piece, destIndex);
        if (oldSquare != null) {
            oldSquare.setPiece(piece);
        }

        return oldSquare;
    }
}
