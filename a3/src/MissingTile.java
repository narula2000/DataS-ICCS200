public class MissingTile {
    public static void tileGrid(Grid board) {
        dividerFunc(board, board.getPaintedCellX(), board.getPaintedCellY(), board.size(), 0, 0);
    }

    static void dividerFunc(Grid board, int pCellX, int pCellY, int boardSize, int newX, int newY) {
        if (boardSize == 2) {
            if (pCellX == newX + 1 && pCellY == newY + 1) {
                board.setTile(newX + 1, newY + 1, 1);
            } else if (pCellX == newX && pCellY == newY) {
                board.setTile(newX, newY, 3);
            } else if (pCellX == newX + 1 && pCellY == newY) {
                board.setTile(newX + 1, newY, 0);
            } else {
                board.setTile(newX, newY + 1, 2);
            }
        } else {
            boardSize = boardSize / 2;
            if (pCellX > boardSize + newX && pCellY > boardSize + newY) {
                board.setTile(newX + boardSize, newY + boardSize, 1);
                dividerFunc(board, newX + boardSize, newY + boardSize - 1, boardSize, newX + boardSize, newY);
                dividerFunc(board, newX + boardSize - 1, newY + boardSize, boardSize, newX, newY + boardSize);
                dividerFunc(board, pCellX, pCellY, boardSize, newX + boardSize, newY + boardSize);
                dividerFunc(board, newX + boardSize - 1, newY + boardSize - 1, boardSize, newX, newY);
            } else if (pCellX < boardSize + newX && pCellY > boardSize + newY) {

                board.setTile(newX + boardSize - 1, newY + boardSize, 2);
                dividerFunc(board, newX + boardSize - 1, newY + boardSize - 1, boardSize, newX, newY);
                dividerFunc(board, pCellX, pCellY, boardSize, newX, newY + boardSize);
                dividerFunc(board, newX + boardSize, newY + boardSize, boardSize, newX + boardSize, newY + boardSize);
                dividerFunc(board, newX + boardSize, newY + boardSize - 1, boardSize, newX + boardSize, newY);
            } else if (pCellX < boardSize + newX && pCellY < boardSize + newY) {

                board.setTile(newX + boardSize - 1, newY + boardSize - 1, 3);
                dividerFunc(board, pCellX, pCellY, boardSize, newX, newY);
                dividerFunc(board, newX + boardSize, newY + boardSize - 1, boardSize, newX + boardSize, newY);
                dividerFunc(board, newX + boardSize - 1, newY + boardSize, boardSize, newX, newY + boardSize);
                dividerFunc(board, newX + boardSize, newY + boardSize, boardSize, newX + boardSize, newY + boardSize);

            } else {
                board.setTile(newX + boardSize, newY + boardSize - 1, 0);
                dividerFunc(board, newX + boardSize - 1, newY + boardSize - 1, boardSize, newX, newY);
                dividerFunc(board, newX + boardSize - 1, newY + boardSize, boardSize, newX, newY + boardSize);
                dividerFunc(board, newX + boardSize, newY + boardSize, boardSize, newX + boardSize, newY + boardSize);
                dividerFunc(board, pCellX, pCellY, boardSize, newX + boardSize, newY);
            }
        }
    }
}
