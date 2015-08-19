package assignment1.chessview.moves;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;
import assignment1.chessview.pieces.Piece;

public class SinglePieceTake extends SinglePieceMove {
	@NonNull private Piece isTaken;

	public SinglePieceTake(@NonNull Piece piece, @NonNull Piece isTaken, @NonNull Position oldPosition, @NonNull Position newPosition) {
		super(piece,oldPosition,newPosition);
		this.isTaken = isTaken;
	}

	public boolean isValid(@NonNull Board board) {
		return piece.isValidMove(oldPosition, newPosition, isTaken, board);
	}

	public @NonNull String toString() {
		return pieceChar(piece) + oldPosition + "x" + pieceChar(isTaken) + newPosition;
	}
}
