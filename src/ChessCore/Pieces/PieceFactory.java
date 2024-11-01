/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ChessCore.Pieces;

import ChessCore.Player;

/**
 *
 * @author Mohamed M. Hussein
 */
public interface PieceFactory {
    Piece createPiece(Player owner);
}
