import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
    
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;
    
    @FXML
    private Button button5;

    @FXML
    private Button button6;
    
    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winner;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int playerTurn = 0;
    private boolean won = false;
    ArrayList<Button> buttons;  

    public void gameOver(){
        for(int i = 0; i < 8; i++){
            String win = switch(i){
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };
            if(win.equals("XXX")){
                winner.setText("Player 1 win");
                won = true;
                
            }
            else if(win.equals("OOO")){
                winner.setText("Player 2 win");
                won = true;
            }
        }
    }
    
    public void setSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        }
        else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void setupButton(Button button){
        button.setOnMouseClicked(MouseEvent ->{
            setSymbol(button);
            button.setDisable(true);
            gameOver();
        });
    }

    public void array(){
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        buttons.forEach(button ->{
            if(won == true){
                buttons.remove(button);
            }
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    public void scene1(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void scene2(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
