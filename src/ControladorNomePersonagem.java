import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorNomePersonagem {

    @FXML
    private TextField textFieldNomePersonagem;

    @FXML
    private Label lableNomePersonagem;

    @FXML
    private Button botaoIniciar;

    @FXML
    void salvarNomePersonagem(ActionEvent event) {
        String nome = textFieldNomePersonagem.getText();
        lableNomePersonagem.setText(nome);
        textFieldNomePersonagem.setVisible(false);
    }

}
