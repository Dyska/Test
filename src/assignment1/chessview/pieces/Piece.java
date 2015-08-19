package assignment1.chessview.pieces;

import java.util.Arrays;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;


public interface Piece {
	/**
	 * Determine whether this piece is white or black.
	 * @return
	 */
	public boolean isWhite();

	/**
	 * Check whether or not a given move on a given board is valid. For takes,
	 * the piece being taken must be supplied.
	 *
	 * @param oldPosition
	 *            --- position of this piece before move.
	 * @param newPosition
	 *            --- position of this piece after move.
	 * @param isTaken
	 *            --- piece being taken, or null if no piece taken.
	 * @param board
	 *            --- board on which the validity of this move is being checked.
	 * @return
	 */
	public boolean isValidMove(@NonNull Position oldPosition,
			@NonNull Position newPosition, @Nullable Piece isTaken, @NonNull Board board);
}
