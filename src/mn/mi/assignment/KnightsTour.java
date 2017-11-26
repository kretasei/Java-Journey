package mn.mi.assignment;

import java.util.Random;

public class KnightsTour {
    public static void main(String... args) {
        Board board = newBoardInstance();

        solve(board);

        print(board);
    }

    private static void solve(Board board) {
        Square initialSquare = initialize(board);

        print(board);

        Piece knight = initialSquare.getPiece();
        Board.Index next = getNext(board.getDimension());

        board.move(knight, next);
    }

    private static Square initialize(Board board) {
        int startRow = getRandom(board.getDimension());
        int startCol = getRandom(board.getDimension());

        Board.Index startIndex = Board.Index.of(startRow, startCol);
        board.move(newKnight(), startIndex);

        return board.getSquare(startIndex);
    }

    private static void print(Board board) {
        String boardString = BoardFormatter.asString(board);
        System.out.println(boardString);
    }

    private static Piece newKnight() {
        return new DefaultKnight();
    }

    private static Board.Index getNext(int bound) {
        return Board.Index.of(getRandom(bound), getRandom(bound));
    }

    private static int getRandom(int bound) {
        return new Random().nextInt(bound);
    }

    private static Board newBoardInstance() {
        return new CloningBoard();
    }
}
