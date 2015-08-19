package assignment1.chessview.pieces;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;

public class Rook extends PieceImpl implements Piece {
	public Rook(boolean isWhite) {
		super(isWhite);
	}

	public boolean isValidMove(@NonNull Position oldPosition, @NonNull Position newPosition,
			@Nullable Piece isTaken, @NonNull Board board) {
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);

		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (board.clearColumnExcept(oldPosition, newPosition, p, t) || board
						.clearRowExcept(oldPosition, newPosition, p, t));
	}

	public @NonNull String toString() {
		if(isWhite) {
			return "R";
		} else {
			return "r";
		}
	}
}
