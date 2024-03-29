package assignment1.chessview.moves;

import java.util.*;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;
import assignment1.chessview.pieces.Piece;


/**
 * A MultiPieceMove represents a simple move operation involving one or more
 * pieces.
 *
 * @author djp
 *
 */
public interface MultiPieceMove extends Move {
	public @NonNull String toString();
}
