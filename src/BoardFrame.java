import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.TreeUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;

class BoardFrame extends JFrame implements ActionListener {

    public static Square[] squares = new Square[64];
    Boolean Marked = false;
    Square firstChoice;
    Square secondChoice;
    String colorChoice = "white";

        BoardFrame() {
            super();
            this.setTitle("white");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setLocationByPlatform(true);
            this.setSize(1000,1000);
            this.setVisible(true);
            this.add(this.createPanels());
        }

        private JPanel createPanels() {
            JPanel panel = new JPanel(new GridLayout(8,8));
            Boolean occupied;
            String type = null;
            String pictureFile = null;
            String color = null;
            for (int idx = 0; idx < 64; idx++) {
                if (idx < 16 || idx > 47) {
                    if (idx < 16) {
                        color = "black";
                    }
                    if (idx > 47) {
                        color = "white";
                        
                    }
                    occupied = true;
                    if ( idx > 7 && idx < 16 || idx > 47 && idx < 56) {
                        type = "pawn";
                        if (idx > 7 && idx < 16) {
                            pictureFile = "BlackPawn.png";
                        } else {
                            pictureFile = "WhitePawn.png";
                        }
                    } 
                    else if (( idx == 3||idx == 59)) {
                        type = "king";
                        if (idx == 3) {
                            pictureFile = "BlackKing.png";
                        } else {
                            pictureFile = "WhiteKing.png";
                        }
                    } else if (idx == 0 || idx == 7 || idx == 56|| idx == 63) {
                        type = "castle";
                        if (idx == 0 || idx == 7) {
                            pictureFile = "BlackCastle.png";
                        } else {
                            pictureFile = "WhiteCastle.png";
                        }
                    } else if (idx == 1 || idx == 6 || idx == 57|| idx == 62) {
                        type = "knight";
                        if (idx == 1 || idx == 6) {
                            pictureFile = "BlackKnight.png";
                        } else {
                            pictureFile = "WhiteKnight.png";
                        }
                    } else if (idx == 2 || idx == 5 || idx == 58|| idx == 61) {
                        type = "bishop";
                        if (idx == 2 || idx == 5) {
                            pictureFile = "BlackBishop.png";
                        } else {
                            pictureFile = "Whitebishop.png";
                        }
                    } else if (idx == 4 || idx == 60) {
                        type = "queen";
                        if (idx == 4) {
                            pictureFile = "blackQueen.png";
                        } else {
                            pictureFile = "WhiteQueen.png";
                        }
                    } 
                } else {
                    occupied = false;
                }
                Square square = new Square(idx,occupied);
                square.setText(type);
                square.addActionListener(this);
                squares[idx] = square;
                Image img;
                if (pictureFile != null) {
                    try {
                        img = ImageIO.read(getClass().getResource(pictureFile));
                        square.setIcon(new ImageIcon(img));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                pictureFile = null;
                square.colorPiece = color;
                panel.add(square);
                type = null;
                color = null;
            }
            return panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Marked == false) {
                for (Square i : squares) {
                    if (e.getSource().equals(i)) {
                        if (i.colorPiece != colorChoice) {
                            break;
                        }
                        System.out.println("Color is:" + i.colorPiece);
                        i.setBackground(Color.RED);
                        firstChoice = i;
                        Marked = true;
                        break;
                    }
                }
            } 
            else {
                for (Square i : squares) {
                    if (e.getSource().equals(firstChoice)){
                        Marked = false;
                        break;
                    }
                    if (e.getSource().equals(i)) {
                        
                        i.setBackground(Color.BLUE);
                        secondChoice = i;
                        System.out.println("first choice row" + firstChoice.row);
                        System.out.println("Second choice row" + secondChoice.row);
                        if (CheckMoves.LegalMoveChecker(firstChoice, secondChoice) == true){
                        
                            firstChoice.setBackground(Color.WHITE);
                            secondChoice.setBackground(Color.WHITE);
                            secondChoice.setText(firstChoice.getText());
                            firstChoice.setText(null);
                            secondChoice.setIcon(firstChoice.getIcon());
                            firstChoice.setIcon(null);
                            Color c1 = secondChoice.getForeground();
                            secondChoice.setForeground(firstChoice.getForeground());
                            firstChoice.setForeground(c1);
                            String col = firstChoice.colorPiece;
                            firstChoice.colorPiece = secondChoice.colorPiece;
                            secondChoice.colorPiece = col;
                            Square.board[firstChoice.row][firstChoice.column] = false;
                            Square.board[secondChoice.row][secondChoice.column] = true;
                            firstChoice = null;
                            secondChoice = null;
                            Marked = false;
                            if (colorChoice == "white") {
                                colorChoice = "black";
                                this.setTitle("black");
                            } else {
                                colorChoice = "white";
                                this.setTitle("white");
                            }
                        }
                        break;
                    }
                }
            }
            
        }
}