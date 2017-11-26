package mn.mi.assignment;

public abstract class AbstractPiece implements Piece {


    @Override
    public String toString() {
        return getShortName();
    }
}
