/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import ChessCore.Pieces.Bishop;
import ChessCore.Pieces.King;
import ChessCore.Pieces.Knight;
import ChessCore.Pieces.Pawn;
import ChessCore.Pieces.Piece;
import ChessCore.Pieces.Queen;
import ChessCore.Pieces.Rook;

/**
 *
 * @author Mohamed M. Hussein
 */
public class PieceFactory {
    public Piece createPiece(String pieceType, Player owner) {
        if(pieceType.equalsIgnoreCase("Pawn")){
            return new Pawn(owner);
        }
        if(pieceType.equalsIgnoreCase("Rook")){
            return new Rook(owner);
        }
        if(pieceType.equalsIgnoreCase("Bishop")){
            return new Bishop(owner);
        }
        if(pieceType.equalsIgnoreCase("Knight")){
            return new Knight(owner);
        }
        if(pieceType.equalsIgnoreCase("Queen")){
            return new Queen(owner);
        }
        if(pieceType.equalsIgnoreCase("King")){
            return new King(owner);
        }
        return null;
    }
}
