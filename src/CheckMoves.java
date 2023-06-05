public class CheckMoves {

    public static Boolean LegalMoveChecker(Square first,Square second) {
        if (first.getText() == "pawn") {
            return CheckPawnMove(first,second);
        }
        else if (first.getText() == "king" || first.getText() == "castle" || first.getText() == "knight" || first.getText() == "bishop" || first.getText() == "queen") {
            return CheckKingMove(first,second);
        }
        return false;
    }
    private static Boolean CheckKingMove(Square first, Square second) {
        if (first.colorPiece == "white") {
            return CheckKingMoveWhite(first,second);
        }
        if (first.colorPiece == "black") {
            return CheckKingMoveBlack(first,second);
        }
        return false;
    }
    private static Boolean CheckKingMoveBlack(Square first, Square second) {
        if (second.row == first.row + 1 && first.column == second.column && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        } if (second.row == first.row - 1 && first.column == second.column && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        } if (second.column == first.column - 1 && first.row == second.row && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        }if (second.column == first.column + 1 && first.row == second.row && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        }if (second.row == first.row + 1 && second.column == first.column + 1 && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        }if (second.row == first.row + 1 && second.column == first.column - 1 && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        } if (second.row == first.row - 1 && second.column == first.column - 1 && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        } if (second.row == first.row - 1 && second.column == first.column + 1 && (second.getText() == null || second.colorPiece == "white")) {
            return true;
        } 
        else {
            return false;
        }
    }
    private static Boolean CheckKingMoveWhite(Square first, Square second) {
        if (second.row == first.row + 1 && first.column == second.column && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        } if (second.row == first.row - 1 && first.column == second.column && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        } if (second.column == first.column - 1 && first.row == second.row && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        }if (second.column == first.column + 1 && first.row == second.row && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        }if (second.row == first.row + 1 && second.column == first.column + 1 && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        }if (second.row == first.row + 1 && second.column == first.column - 1 && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        } if (second.row == first.row - 1 && second.column == first.column - 1 && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        } if (second.row == first.row - 1 && second.column == first.column + 1 && (second.getText() == null || second.colorPiece == "black")) {
            return true;
        } 
        else {
            return false;
        }
    }
    public static Boolean CheckPawnMove(Square first,Square second) {
        if (first.colorPiece == "white") {
            return CheckPawnMoveWhite(first,second);
        }
        if (first.colorPiece == "black") {
            return CheckPawnMoveBlack(first,second);
        }
        return true;
    }
    private static Boolean CheckPawnMoveBlack(Square first, Square second) {
        if (second.row == first.row + 1 && first.column == second.column  && second.getText() == null) {
            return true;
        } else if (first.row == 1 && second.row == 3 && first.column == second.column && second.getText() == null && Square.board[first.row + 1][first.column] == false) {
            return true;
        }  else if (second.row == (first.row+1) && second.column == (first.column -1) && second.getText() != null) {
            return true;
        } else if (second.row == first.row+1 && second.column == first.column +1 && second.getText() != null) {
            return true;
        }
        else {
            return false;
        }
    }
    private static Boolean CheckPawnMoveWhite(Square first, Square second) {
        if (second.row == first.row - 1 && first.column == second.column && second.getText() == null) {
            return true;
        }  else if (first.row == 6 && second.row == 4 && first.column == second.column && second.getText() == null && Square.board[first.row - 1][first.column] == false) {
            return true;
        }  else if (second.row == first.row-1 && second.column == first.column -1 && second.colorPiece == "black") {
            return true;
        } else if (second.row == first.row-1 && second.column == first.column +1 && second.colorPiece == "black"){
            return true;
        }
        else {
            return false;
        }
    }
    
}
