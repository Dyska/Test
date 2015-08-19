package assignment1.chessview.pieces;

import java.util.Arrays;

import org.eclipse.jdt.annotation.Nullable;

import assignment1.chessview.*;

public abstract class PieceImpl {
	protected boolean isWhite;

	public PieceImpl(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isWhite ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(@Nullable Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PieceImpl other = (PieceImpl) obj;
		if (isWhite != other.isWhite)
			return false;
		return true;
	}
}
