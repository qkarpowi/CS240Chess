package chess.piececalculator;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;

public class KnightCalculator implements PieceMovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        ChessGame.TeamColor color = board.getPiece(position).getTeamColor();

        HashSet<ChessMove> validMoves = new HashSet<>();


        int row = position.getRow();
        int col = position.getColumn();


        for (int i = row - 1; i > 0; i--) {
            ChessPosition checkPosition = new ChessPosition(i, col);
            if (board.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if(board.getPiece(checkPosition).getTeamColor() != color){
                validMoves.add(new ChessMove(position, checkPosition, null));
                break; // Stop when encountering a piece
            }else{
                break;
            }
        }
        return new HashSet<ChessMove>();
    }
}
