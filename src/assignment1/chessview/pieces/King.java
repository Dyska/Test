package assignment1.chessview.pieces;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;

public class King extends PieceImpl implements Piece {
	public King(boolean isWhite) {
		super(isWhite);
	}

	public boolean isValidMove(@NonNull Position oldPosition, @NonNull Position newPosition,
			@Nullable Piece isTaken, @NonNull Board board) {
		int diffCol = Math.max(oldPosition.column(), newPosition.column())
				- Math.min(oldPosition.column(), newPosition.column());
		int diffRow = Math.max(oldPosition.row(), newPosition.row())
				- Math.min(oldPosition.row(), newPosition.row());
		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
		return this.equals(p)
				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
				&& (diffCol == 1 || diffRow == 1) && diffCol <= 1
				&& diffRow <= 1;
	}

	public @NonNull String toString() {
		if(isWhite) {
			return "K";
		} else {
			return "k";
		}
	}
}
