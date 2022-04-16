package ChessGame.model;

public class Board {
    int boardSize;
    Cell[][] cells;
    public Board(int boardSize, Cell[][] cells){
        this.boardSize = boardSize;
        this.cells = cells;
    }
    //to get Adjecent Cell from current location.
    public Cell getLeftCell(Cell cell){return getCellAtLocation(cell.getX(),cell.getY()-1);}
    public Cell getRightCell(Cell cell){return getCellAtLocation(cell.getX(),cell.getY()+1);}
    public Cell getUpCell(Cell cell){return getCellAtLocation(cell.getX()+1,cell.getY());}
    public Cell getDownCell(Cell cell){return getCellAtLocation(cell.getX()-1,cell.getY());}

    //get the current Cell with x and y coordinates
    public Cell getCellAtLocation(int x, int y){
        if(x < 0 || x >= boardSize ||  y < 0 || y >= boardSize){
            return null;
        }
        return cells[x][y];
    }

    //check if the player is on checkmate positon. Means player king is in trouble.
    public boolean isPlayerOnCheck(Player player){
       // return checkIfPlayerCanBeKilled(Player.getPiece(PieceType.KING), kingCheckEvaluationBlocker(), player);
        return false;
    }

    /*
    * Method to check if the piece can be killed currently by the opponent as per the current board configuration.
    *
    * @param targetPiece              Piece which is to be checked.
    * @param cellOccupyBlocker        Blockers which make cell non-occupiable.
    * @param                          player whose piece has to be checked.
    * @return                         Boolean indicating weather the piece is in danger or not.
    * */
   // public boolean checkIfPlayerCanBeKilled(Piece targetPiece, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player){
   //     return false;
    //}
}
