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

/**Classe responsável por iniciar a história,capturar os eventos
 *  e executar/controlar tudo junto com a integração ao SceneBuilder e possui 
 * os atributos:
 *  * <ul> 
 * <li> private Capitulo raiz;
 * <li>  @FXML public Button botaoCarregar;   
 * <li>  public TextArea textoCapitulo;
 * <li>  public TextArea imagemAscii;
 * <li>  private VBox vboxEscolhas;
 * </u>
 */

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
 Map<String, Personagem> personagens = leitor.carregarPersonagem
 ("rsc/Personagem.txt");

 Map<String, Capitulo> capitulos = leitor.carregarCapitulos
 ("rsc/Capitulos.txt", personagens);

  System.out.println(" Carregamento Concluído com sucesso \n\n...\n");
  
  
  
   
    
  raiz = capitulos.get("raiz");
        
    botaoCarregar.setVisible(false);
    mostrarCapitulo(raiz);
    
        
         

    }
   /** O método mostrarCapitulo mostra o texto dos capitulos,ajusta a energia 
    * dos personagens e captura as escolhas.
 */
    private void mostrarCapitulo(Capitulo capitulo) 
    {
        
        capitulo.ajustarEnergia();
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
            
            
        }
    }

}

