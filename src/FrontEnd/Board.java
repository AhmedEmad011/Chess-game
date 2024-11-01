/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import ChessCore.*;
import ChessCore.Pieces.King;
import ChessCore.Pieces.Piece;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Mohamed M. Hussein
 */
public class Board extends javax.swing.JPanel implements MouseListener {

    /**
     * Creates new form NewJPanel
     */
    public int tileSize = 85;
    int cols = 8;
    int rows = 8;
    int flagForMouse;
    boolean flagForDraw = false;
    //private Piece[][] boardState; 
    
    public Piece selectedPiece;
    Square fromSquare;
    ClassicChessGame chessGame = ClassicChessGame.getInstance();

    public Board() {
        initComponents();

        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        addMouseListener(this);
    }

    private void setComponent(Graphics2D graphics2D) throws IOException {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Square Square = new Square(BoardFile.fromInt(col), BoardRank.fromInt(row));
                Piece piece = chessGame.getPieceAtSquare(Square);
                if (piece != null) {
                    BufferedImage pieceImage = ImageIO.read(new File(piece.toString()));
                    Image x = pieceImage.getScaledInstance(tileSize - 5, tileSize - 5, 0);
                    graphics2D.drawImage(x, col * tileSize, row * tileSize, null);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                graphics2D.setColor((row + col) % 2 == 0 ? Color.GRAY : Color.white);
                graphics2D.fillRect(row * tileSize, col * tileSize, tileSize, tileSize);
            }
        }
        try {
            setComponent(graphics2D);
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        undoButton = new javax.swing.JButton();

        setToolTipText("");

        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(undoButton)
                .addGap(0, 488, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 768, Short.MAX_VALUE)
                .addComponent(undoButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        chessGame.undoMove();
        repaint();
    }//GEN-LAST:event_undoButtonActionPerformed

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    private void highlightSquares(ArrayList<Square> squares, Color color, Graphics2D graphics2D) {
        for (int i = 0; i < squares.size(); i++) {
            int col = squares.get(i).getFile().ordinal();
            int row = squares.get(i).getRank().ordinal();
            graphics2D.setStroke(new BasicStroke(5));
            graphics2D.setColor(color);
            graphics2D.drawRect(col * tileSize, row * tileSize, tileSize, tileSize);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println(flagForMouse);
        if (flagForMouse == 0) {
            int fromColm = e.getX() / tileSize;
            int fromRow = e.getY() / tileSize;
            fromSquare = new Square(BoardFile.fromInt(fromColm), BoardRank.fromInt(fromRow));
            //System.out.println(fromSquare);
            selectedPiece = chessGame.getPieceAtSquare(fromSquare);
            if (selectedPiece != null) {
                ArrayList<Square> validMoves = (ArrayList<Square>) chessGame.getAllValidMovesFromSquare(fromSquare);
                highlightSquares(validMoves, Color.green, (Graphics2D) getGraphics());
            }

            flagForMouse = 1;
        }

//        System.out.println(fromColm);
//        System.out.println(fromRow);
//        System.out.println(flagForMouse);
        if (selectedPiece != null && flagForMouse == 2) {

            int destinationColumn = e.getX() / tileSize;
            int destinationRow = e.getY() / tileSize;

            Square toSquare = new Square(BoardFile.fromInt(destinationColumn), BoardRank.fromInt(destinationRow));

            Move move = new Move(fromSquare, toSquare);

            try {
                chessGame.makeMove(move);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }

            repaint();
//            if (chessGame.makeMove(move)) {
//
//                Graphics2D graphics2D = (Graphics2D) getGraphics();
//
//                graphics2D.setColor((fromSquare.getFile().ordinal() + fromSquare.getRank().ordinal()) % 2 == 0 ? Color.GRAY : Color.white);
//                graphics2D.fillRect(fromSquare.getFile().ordinal() * tileSize, fromSquare.getRank().ordinal() * tileSize, tileSize, tileSize);
//
//                graphics2D.setColor((toSquare.getFile().ordinal() + toSquare.getRank().ordinal()) % 2 == 0 ? Color.GRAY : Color.white);
//                graphics2D.fillRect(toSquare.getFile().ordinal() * tileSize, toSquare.getRank().ordinal() * tileSize, tileSize, tileSize);
//                try {
//
//                    BufferedImage pieceImage = ImageIO.read(new File(selectedPiece.toString()));
//                    Image y = pieceImage.getScaledInstance(tileSize - 5, tileSize - 5, 0);
//                    graphics2D.drawImage(y, destinationColumn * tileSize, destinationRow * tileSize, null);
//
//                } catch (IOException ex) {
//                    System.out.println("Piece image file exception");
//                }
//                repaint();
//            }

        }

        if (flagForMouse == 2) {
            flagForMouse = 0;
        } else {
            flagForMouse = 2;
        }

        System.out.println(chessGame.getGameStatus());
        if (chessGame.getGameStatus() == GameStatus.BLACK_WON) {
            JOptionPane.showMessageDialog(this, "Black Win");
        }

        if (chessGame.getGameStatus() == GameStatus.WHITE_WON) {
            JOptionPane.showMessageDialog(this, "White Win");
        }

        if (chessGame.getGameStatus() == GameStatus.BLACK_UNDER_CHECK) {
            Graphics2D graphics2D = (Graphics2D) getGraphics();
            King k;
            Square kingSquare;
            if (chessGame.getWhoseTurn() == Player.BLACK) {
                k = new King(Player.BLACK);
                kingSquare = k.getKingSquare(Player.BLACK, chessGame);

                graphics2D.setStroke(new BasicStroke(5));
                graphics2D.setColor(Color.RED);
                graphics2D.drawRect(kingSquare.getFile().ordinal() * tileSize, kingSquare.getRank().ordinal() * tileSize, tileSize, tileSize);

            }
        }

        if (chessGame.getGameStatus() == GameStatus.WHITE_UNDER_CHECK) {
            Graphics2D graphics2D = (Graphics2D) getGraphics();

            King k = new King(Player.WHITE);
            Square kingSquare = k.getKingSquare(Player.WHITE, chessGame);

            graphics2D.setStroke(new BasicStroke(5));

            graphics2D.setColor(Color.RED);
            graphics2D.drawRect(kingSquare.getFile().ordinal() * tileSize, kingSquare.getRank().ordinal() * tileSize, tileSize, tileSize);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
