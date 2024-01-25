package chess.piececalculator;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.HashSet;

public class PawnCalculator implements PieceMovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        ChessGame.TeamColor color = board.getPiece(position).getTeamColor();

        HashSet<ChessMove> validMoves = new HashSet<>();

        if(color == ChessGame.TeamColor.BLACK){
            int limit;
            if(position.getRow() == 7){
                limit = 2;
            } else {
                limit = 1;
            }
            CalculatorUtils.NorthMoves(board, position, color, validMoves, limit);
        }
        if(color == ChessGame.TeamColor.WHITE){
            int limit;
            if(position.getRow() == 2){
                limit = 2;
            } else {
                limit = 1;
            }
            CalculatorUtils.SouthMoves(board, position, color, validMoves, limit);
        }
        return validMoves;
    }
}
