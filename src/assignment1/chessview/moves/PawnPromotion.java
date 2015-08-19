package assignment1.chessview.moves;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;
import assignment1.chessview.pieces.*;

/**
 * This represents a "check move". Note that, a check move can only be made up
 * from an underlying simple move; that is, we can't check a check move.
 *
 * @author djp
 *
 */
public class PawnPromotion implements MultiPieceMove {
	@NonNull private Piece promotion;
	@NonNull private SinglePieceMove move;

	public PawnPromotion(@NonNull SinglePieceMove move, @NonNull Piece promotion) {
		this.promotion = promotion;
		this.move = move;
	}

	public boolean isWhite() {
		return move.isWhite();
	}

	public boolean isValid(@NonNull Board board) {
		int row = isWhite() ? 8 : 1;
		return move.isValid(board) && move.piece() instanceof Pawn
				&& move.newPosition.row() == row;
	}

	public void apply(@NonNull Board board) {
		move.apply(board);
		board.setPieceAt(move.newPosition(), promotion);
	}

	public @NonNull String toString() {
		return super.toString() + "=" + SinglePieceMove.pieceChar(promotion);
	}
}
