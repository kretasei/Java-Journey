package mn.mi.assignment;

public class BoardFormatter {
    private BoardFormatter() {
    }

    static String asString(Board board) {
        Square[][] squares = board.getSquares();

        StringBuilder printBuilder = new StringBuilder();


        for (int i = 0; i < squares.length; i++) {
            String rowString = board.getRowName(squares.length - 1 - i);
            for (Square col : squares[i]) {
                Piece piece = col.getPiece();
                rowString += " [" + piece + "]";
            }
            printBuilder.append(rowString.trim());
            printBuilder.append(System.lineSeparator());
        }

        printBuilder.append(" ");
        for (int i = 0; i < board.getDimension(); i++) {
            printBuilder.append("  ").append(board.getColName(i)).append(" ");
        }

        return printBuilder.toString();
    }
}
