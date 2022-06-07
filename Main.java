import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(root);

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);

        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }
    public void exit(Stage stage){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Are you sure want to exit?");
        alert.setContentText("Don't you want to play again?");
        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}