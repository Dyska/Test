package assignment1.chessview;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.moves.Move;

/**
 * A round consists of a move by white, and will normally also have a move by
 * black. The latter may not happen in the case that White wins the game.
 *
 * @author djp
 *
 */
public class Round {
	@NonNull private Move white;
	@Nullable private Move black;

	/**
	 * Create a round from a white move, and an optional black move.
	 *
	 * @param white - whites move; cannot be null;
	 * @param black - blacks move; may be null.
	 */
	public Round(@NonNull Move white, @Nullable Move black) {
		if(white == null) {
			throw new IllegalArgumentException("A round must always consist of a move by white");
		}
		this.white = white;
		this.black = black;
	}

	public @NonNull Move white() {
		return white;
	}

	public @Nullable Move black() {
		return black;
	}

	public @Nullable String toString() {
		String r = white.toString();
		if (black != null) {
			final Move black2 = black;
			if (black2 != null) {
				r += " " + black2.toString();
			} else {return null;}
		}
		return r;
	}
}
