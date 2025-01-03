package caro5x5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FXMLController {

    @FXML
    Button btn00;
    @FXML
    private Label playerTurnLabel;
    @FXML
    private Label winnerLabel;
    @FXML
    private TextField playerXScore;
    @FXML
    private TextField playerOScore;

    private Button[][] buttons = new Button[10][10];
    
    private boolean playerXTurn = true; 
    private int[][] board = new int[10][10]; 

    @FXML
    public void initialize() {
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = (Button) ((GridPane) btn00.getParent()).getChildren().get(i * 10 + j);
            }
        }
    }

    @FXML
    private void handleCellClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int row = getRow(clickedButton);
        int col = getCol(clickedButton);
        if(playerXTurn){
          updatePlayerTurn("O");
        }
        else updatePlayerTurn("X");;

        if (board[row][col] == 0) { 
            board[row][col] = playerXTurn ? 1 : 2;
            clickedButton.setStyle("-fx-text-fill: black;");
            clickedButton.setText(playerXTurn ? "X" : "O");
            
            clickedButton.setDisable(true); 
            
            if (checkWin(row, col)) {
               
                System.out.println((playerXTurn ? "X" : "O") + " wins!");
                updateWinner((playerXTurn ? "X" : "O"));
            }
            
            playerXTurn = !playerXTurn; 
        }
    }
    public void updatePlayerTurn(String player){
        playerTurnLabel.setText( "Lượt của " + player);
    }

    public void updateWinner(String winner){
        winnerLabel.setText(winner + " Thắng!");
    }
    private int getRow(Button button) {
        
        String id = button.getId();
        return Integer.parseInt(id.substring(3, 4));
    }

    private int getCol(Button button) {
        
        String id = button.getId();
        return Integer.parseInt(id.substring(4, 5));
    }

    private boolean checkWin(int row, int col) {
        int celval = board[row][col];

        int counttop = 0, countbottom = 0, countleft = 0, countright = 0, countptop = 0,countpbottom = 0, countstop = 0,countsbottom = 0;
        
        for(int i = row; i>=0; i--){
            if(board[i][col] == celval){
                countbottom++;
            }
            else break;
        }
        
        for(int i = row;  i< board.length;i++){
            if(board[i][col] == celval){
                counttop++;
            }
        }
        for(int i = col;  i> 0;i--){
            if(board[row][i] == celval){
                countleft++;
            }
        }
        
        for(int i = col;  i< board.length;i++){
            if(board[row][i] == celval){
                countright++;
            }
        }
        for (int i = 0; i <= row; i++)
        {
            if (row - i < 0 || col - i < 0)
                break;

            if (board[col - i][row - i] ==celval)
            {
                countptop++;
            }
            else
                break;
        }
        for (int i = 0; i <= row; i++)
        {
            if (row - i < 0 || col - i < 0)
                break;

            if (board[col - i][row - i] ==celval)
            {
                countpbottom++;
            }
            else
                break;
        }

            for (int i = 0; i <= row; i++)
            {
                if (row + i > board[0].length || col - i < 0)
                    break;

                if (board[col - i][row + i] == celval)
                {
                    countstop++;
                }
                else
                    break;
            }

            
            for (int i = 1; i <= board[0].length - row; i++)
            {
                if (col + i >= board.length || row - i < 0)
                    break;

                if (board[col+ i][row - i] == celval)
                {
                    countsbottom++;
                }
                else
                    break;
            }

        return (counttop + countbottom == 5) ||  (countleft + countright == 5) ||  (countptop + countpbottom == 5) || (countstop + countsbottom == 5) ; // Placeholder
    }
}