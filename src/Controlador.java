import java.util.ArrayList;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controlador {

    private Capitulo raiz;

   

    @FXML
    private Button botaoCarregar;

    @FXML
    private TextArea textoCapitulo;

    @FXML
    private TextArea imagemAscii;

    @FXML
    private ButtonBar botoesEscolha;

    @FXML
    void iniciarHistoria(ActionEvent event) {

        LeitorDeArquivos leitor = new LeitorDeArquivos();
        Map<String, Personagem> personagens = leitor.carregarPersonagem("rsc/Personagem.txt");

        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("rsc/Capitulos.txt", personagens);

        System.out.println(" Carregamento Concluído com sucesso \n\n...\n");

        raiz = capitulos.get("raiz");
        
        botaoCarregar.setVisible(false);
        mostrarCapitulo(raiz);
         //raiz.executar();

    }

    private void mostrarCapitulo(Capitulo capitulo) 
    {
        mostrarTextoCapitulo(capitulo.getTexto());
        mostrarEscolhas(capitulo.getEscolhas());
    }

    public void mostrarTextoCapitulo(String texto)
    {
     textoCapitulo.setText(texto);
    }

    public void mostrarImagemAscii(String imagem)
    {
     imagemAscii.setText(imagem);
    }

    public void mostrarEscolhas(ArrayList<Escolha> escolhas) 
    {
        botoesEscolha.setPadding(new Insets(10));

        for (int i = 0; i < escolhas.size(); i++) {
            
            botoesEscolha.getButtons().add(new Button(escolhas.get(i).getTextoMostrado()));
            
            //System.out.println("-" + escolhas.get(i).getTextoMostrado() + "\n");
        }
    }

}

