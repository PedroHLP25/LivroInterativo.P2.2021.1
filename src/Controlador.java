import java.util.ArrayList;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Controlador {

    private Capitulo raiz;

   

    @FXML
    public Button botaoCarregar;

    @FXML
    public TextArea textoCapitulo;

    @FXML
    public TextArea imagemAscii;

    @FXML
    private VBox vboxEscolhas;
 
    

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
        vboxEscolhas.setPadding(new Insets(10));
        vboxEscolhas.getChildren().clear();

        for (int i = 0; i < escolhas.size(); i++) 
        
        {

            BotaoEscolha botao = new BotaoEscolha(escolhas.get(i));
            botao.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    mostrarCapitulo(botao.getEscolha().getSeguinte()); 
                }
                
            });
            
            vboxEscolhas.getChildren().add(botao);
            
            //System.out.println("-" + escolhas.get(i).getTextoMostrado() + "\n");
        }
    }

}

