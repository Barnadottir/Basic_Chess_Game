import javax.swing.JButton;

import java.awt.Color;


public class Square extends JButton {

    public static Boolean[][] board = new Boolean[8][8];
    private int idx;
    public int column;
    public int row;
    private Boolean occupied;
    public String colorPiece;
    Square(int idx,Boolean occupied) {
        super();
        this.idx = idx; 
        //this.setOpaque(true);
        if (idx == 0) {
            this.row = 0;
        } else {
            this.row = idx/8;
        }
        this.column = idx%8;
        board[row][column] = occupied;
        if (this.idx < 16) {
            this.setForeground(Color.BLUE);
        } else if (this.idx > 47) {
            this.setForeground(Color.RED);
        }
        if (this.idx%2 == 0) {

            this.setBackground(Color.BLACK);
            
            
        } else {
            this.setBackground(Color.WHITE);
            
        }
    }
    
}
