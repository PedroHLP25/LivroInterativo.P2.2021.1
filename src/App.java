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

//import java.util.Scanner;

public class App extends Application {
    public static void main(String[] args) throws Exception {

        Scanner srDoConsole = new Scanner(System.in, "CP850");

        LeitorDeArquivos leitor = new LeitorDeArquivos();
        Map<String, Personagem> personagens = leitor.carregarPersonagem("rsc/Personagem.txt");

        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("rsc/Capitulos.txt", personagens, srDoConsole);

        System.out.println(" Carregamento Concluído com sucesso \n\n...\n");

        Capitulo raiz = capitulos.get("raiz");
         //raiz.executar();
        srDoConsole.close();

        launch(args);

    };

    @Override
    public void start(Stage primaryStage) throws Exception {
      FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("layout.fxml"));
      Parent root = fxmlLoader.load();
      Scene tela = new Scene(root);

      primaryStage.setTitle("Livro Interativo");
      primaryStage.setScene(tela);
      primaryStage.show();
    };

}








 


    

