package assignment1.chessview.moves;

import java.util.*;

import org.eclipse.jdt.annotation.*;

import assignment1.chessview.*;
import assignment1.chessview.pieces.*;


public class SinglePieceMove implements MultiPieceMove {
	@NonNull protected Piece piece;
	@NonNull protected Position oldPosition;
	@NonNull protected Position newPosition;

	public SinglePieceMove(@NonNull Piece piece, @NonNull Position oldPosition, @NonNull Position newPosition) {
		this.piece = piece;
		this.oldPosition = oldPosition;
		this.newPosition = newPosition;
	}

	public @NonNull Piece piece() {
		return piece;
	}

	public boolean isWhite() {
		return piece.isWhite();
	}

	public @NonNull Position oldPosition() {
		return oldPosition;
	}

	public @NonNull Position newPosition() {
		return newPosition;
	}

	public boolean isValid(@NonNull Board board) {
		return oldPosition.isValid() && newPosition.isValid()
				&& piece.isValidMove(oldPosition, newPosition, null, board);
	}

	public void apply(@NonNull Board b) {
		b.move(oldPosition,newPosition);
		if(piece instanceof King) {
			b.setKingMoved(piece.isWhite());
		} else if(piece instanceof Rook) {
			if(piece.isWhite()) {
				if(oldPosition.equals(new Position(1,1))) {
					b.setRookMoved(true,false);
				} else if(oldPosition.equals(new Position(1,8))) {
					b.setRookMoved(true,true);
				}
			} else {
				if(oldPosition.equals(new Position(8,1))) {
					b.setRookMoved(false,false);
				} else if(oldPosition.equals(new Position(8,8))) {
					b.setRookMoved(false,true);
				}
			}
		} else if (piece instanceof Pawn) {
			// Store the double-step information required to implement En
			// Passant.
			int deltaRow = Math.abs(newPosition.row() - oldPosition.row());
			Pawn p = (Pawn) b.pieceAt(newPosition);
			assert p != null;
			p.setDoubleStep(deltaRow == 2);
		}
	}

	public @NonNull String toString() {
		return pieceChar(piece) + oldPosition + "-" + newPosition;
	}

	protected static @NonNull String pieceChar(Piece p) {
		if(p instanceof Pawn) {
			return "";
		} else if(p instanceof Knight) {
			return "N";
		} else if(p instanceof Bishop) {
			return "B";
		} else if(p instanceof Rook) {
			return "R";
		} else if(p instanceof Queen) {
			return "Q";
		} else {
			return "K";
		}
	}
}
