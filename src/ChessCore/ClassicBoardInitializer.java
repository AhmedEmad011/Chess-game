package ChessCore;

import ChessCore.Pieces.*;

public final class ClassicBoardInitializer implements BoardInitializer {

    private static final BoardInitializer instance = new ClassicBoardInitializer();
    private static PieceFactory pieceFactory = new PieceFactory();

    private ClassicBoardInitializer() {
    }

    public static BoardInitializer getInstance() {
        return instance;
    }

    @Override
    public Piece[][] initialize() {
        Piece[][] initialState = {
            {pieceFactory.createPiece("Rook", Player.WHITE), pieceFactory.createPiece("knight", Player.WHITE), pieceFactory.createPiece("Bishop", Player.WHITE),
            pieceFactory.createPiece("Queen", Player.WHITE), pieceFactory.createPiece("King", Player.WHITE), pieceFactory.createPiece("Bishop", Player.WHITE), pieceFactory.createPiece("king", Player.WHITE), pieceFactory.createPiece("Rook", Player.WHITE)},
            {pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE), pieceFactory.createPiece("pawn", Player.WHITE)},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK),pieceFactory.createPiece("pawn", Player.BLACK)},
            {pieceFactory.createPiece("Rook", Player.BLACK), pieceFactory.createPiece("Knight", Player.BLACK), pieceFactory.createPiece("Bishop", Player.BLACK), pieceFactory.createPiece("queen", Player.BLACK), pieceFactory.createPiece("king", Player.BLACK)
           , pieceFactory.createPiece("bishop", Player.BLACK), pieceFactory.createPiece("knight", Player.BLACK), pieceFactory.createPiece("Rook", Player.BLACK)}
        };
        return initialState;
    }
}
