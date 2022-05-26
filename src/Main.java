import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**Classe principal a Main aqui executamos o programa deixamos essa com o menor
 * número de informações possivel, ou seja, só o necessário.Logo,nesse contexto,
 * não tem construtor só o padrão(Vazio) e também, não possui atributos.
 */

public class Main extends Application {
public static void main(String[] args) throws Exception 
  {
     launch(args);
  };

   @Override
     public void start(Stage primaryStage) throws Exception {
     FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource
     ("layout.fxml"));
      Parent root = fxmlLoader.load();
      Scene tela = new Scene(root);

      primaryStage.setTitle("Livro Interativo");
      primaryStage.setScene(tela);
      primaryStage.show();
    };

}








 


    

