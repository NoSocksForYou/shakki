package chess.move;

import chess.board.ChessBoard;
import chess.piece.Color;
import misc.Position;

public class Move {
    private Position targetPosition;
    private Position basePosition;
    private ChessBoard board;
    private Color turn;

    public Move (Position basePosition, Position targetPosition, ChessBoard board, Color turn) {
        this.targetPosition = targetPosition;
        this.basePosition = basePosition;
        this.board = board;
        this.turn = turn;
    }

    @Override
    public String toString () {
        return basePosition.toString() + targetPosition.toString();
    }

    public Position getTargetPosition () {
        return targetPosition;
    }

    public Position getBasePosition () {
        return basePosition;
    }

    public ChessBoard getBoard () {
        return board;
    }

    public Color getTurn () {
        return turn;
    }

    public static Move valueOf (String string, ChessBoard board) {
        var oldPos = Position.fromChessPosition(string.substring(0, 2));
        System.out.println(oldPos + ", " + Position.fromChessPosition(string.substring(2)) + ", " + board.getSquare(oldPos));
        return new Move(oldPos, Position.fromChessPosition(string.substring(2)), board, board.getSquare(oldPos).getPieceColor());
    }
}