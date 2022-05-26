import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/** A classe CapituloImagem estende a classe Capitulo, com o objetivo
 * de auxiliar o controlador com a informação armazena:
 * <ul>
 * <li> protected String imagem;
 * </ul>
 */

public class CapituloImagem extends Capitulo {
    protected String imagem;

    public CapituloImagem(Map<String, Personagem> personagens,
    Scanner srDeArquivos, 
    int i)
    {
       super();
       this.LerCapitulo(personagens, srDeArquivos, i);
       this.escolhas = new ArrayList<Escolha>();
       
    }
 /** Método de leitura para identificar se é um capitulo ou capitulo com Imagem
     */

    protected void LerCapitulo(Map<String, Personagem> personagens,
    Scanner srDeArquivos,
    int i)
     {
      super.LerCapitulo(personagens, srDeArquivos, i);
      
      srDeArquivos.nextLine(); // IMAGEM
      String linha = srDeArquivos.nextLine();
      this.imagem = "";
      while (!linha.equals("IMAGEM_FIM")){
          this.imagem = imagem + "\n"+ linha;
          linha = srDeArquivos.nextLine();
      }
     }

  /** Método para mostrar a imagem
     */

    protected void mostrar() {
        System.out.println(this.imagem);
        System.out.println("- - -");
        
        }

    public void ajustarEnergia() {
    }
    
    }

