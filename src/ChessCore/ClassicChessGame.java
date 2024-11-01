package ChessCore;

public final class ClassicChessGame extends ChessGame {
    private static ClassicChessGame chessGame = null;

    private ClassicChessGame() {
        super(ClassicBoardInitializer.getInstance());
    }
    public static ClassicChessGame getInstance (){
        if(chessGame == null){
            return new ClassicChessGame();
        }
        return chessGame;
    }

    @Override
    protected boolean isValidMoveCore(Move move) {
        return !Utilities.willOwnKingBeAttacked(this.getWhoseTurn(), move, this.getBoard());
    }
}
