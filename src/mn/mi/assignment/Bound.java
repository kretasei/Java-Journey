package mn.mi.assignment;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Bound {
    static Set<Square> of(Piece piece, Board board) {
        if (piece instanceof Knight) {
            return of((Knight) piece, board);
        }

        return Collections.emptySet();
    }

    static Set<Square> of(Knight knight, Board board) {
        Set<Square> bound = new HashSet<>();

        final Square currentSquare = board.getSquare(knight);
        final Board.Index currentIndex = board.indexOf(currentSquare);
        int currentRow = currentIndex.row;
        int currentCol = currentIndex.col;

//        FIXME
        boolean forward = true;
        for (int i = 0; i < 2; i++) {
            int byRow = forward ? 2 : -2;
            for (int j = 0; j < 2; j++) {
                int byCol = forward ? 1 : -1;

                int destRow = currentRow + byRow;
                int destCol = currentCol + byCol;
                if (board.isValidPosition(destRow, destCol)) {
                    Board.Index index = Board.Index.of(destRow, destCol);
                    Square validSquare = board.getSquare(index);
                    bound.add(validSquare);
                }
                forward = !forward;
            }
            forward = !forward;
        }

        return bound;
    }
}
