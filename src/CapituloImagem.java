import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CapituloImagem extends Capitulo {
    private String imagem;

    public CapituloImagem(Map<String, Personagem> personagens,
    Scanner srDeArquivos, Scanner srDoConsole,
    int i)
    {
       super();
       this.LerCapitulo(personagens, srDeArquivos, i);
       this.sr = srDoConsole;
       this.escolhas = new ArrayList<Escolha>();
    }
  
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


    protected void mostrar() {
        System.out.println(this.imagem);
        System.out.println("- - -");
        super.mostrar();
        }
    }

