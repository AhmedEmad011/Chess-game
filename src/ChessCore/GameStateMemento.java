/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

/**
 *
 * @author ahmed emad
 */
    public class GameStateMemento implements Cloneable{
    private Player currPlayer;
    private ChessBoard board;
    boolean isCanWhiteCastleKingSide;
    boolean isCanWhiteCastleQueenSide;
    boolean isCanBlackCastleKingSide;
    boolean isCanBlackCastleQueenSide;

    public GameStateMemento(Player currPlayer, ChessBoard board, boolean isCanWhiteCastleKingSide, boolean isCanWhiteCastleQueenSide, boolean isCanBlackCastleKingSide, boolean isCanBlackCastleQueenSide) {
        this.currPlayer = currPlayer;
        this.board = board.clone();
        this.isCanWhiteCastleKingSide = isCanWhiteCastleKingSide;
        this.isCanWhiteCastleQueenSide = isCanWhiteCastleQueenSide;
        this.isCanBlackCastleKingSide = isCanBlackCastleKingSide;
        this.isCanBlackCastleQueenSide = isCanBlackCastleQueenSide;
    }

   
    

    public Player getCurrPlayer() {
        return currPlayer;
    }

    public ChessBoard getBoard() {
        return board;
    }

   

    
}
    

