package mn.mi.assignment;

public class DefaultSquare extends NamedSquare {
    private final SquareId id;

    public DefaultSquare(SquareId id) {
        this.id = id;
    }

    @Override
    public NamedSquare.SquareId getId() {
        return this.id;
    }
}
