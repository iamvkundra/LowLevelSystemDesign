package ChessGame.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
public class Piece {
    private boolean isKilled = false;
    private final Color color;
   // private final List<PossibleMoveProvider> movesProvider;
    private Integer numMoves = 0;
    PieceType pieceType;

    @Setter
    private Cell currentCell;

    public Piece(Color color) {
        this.color = color;
    }
}
