import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

/**Classe que armazena todas as informações relativas à um capítulo da história
 * as informações armazenadas são:
 * <ul> 
 * <li> private String texto;
 * <li> protected ArrayList<Escolha> escolhas;
 * <li> private Personagem personagem1;
 * <li> private Personagem personagem2;
 * <li> private int variacaoEnergia1;
 * <li> private int variacaoEnergia2;
 * </u>
 */
public class Capitulo {
    private String texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem personagem1;
    private Personagem personagem2;
    private int variacaoEnergia1;
    private int variacaoEnergia2;
    
    /** Método para acessar o ArrayList de escolhas em questão.
     */
  
    protected Capitulo()
    { 
        this.texto = "";
        this.escolhas = new ArrayList<Escolha>(); 
    }

    public Capitulo(String texto,
            Personagem personagem1, Personagem personagem2,
            int variacaoEnergia1, int variacaoEnergia2, Scanner sr)

    {
        this.texto = texto;
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
        this.variacaoEnergia1 = variacaoEnergia1;
        this.variacaoEnergia2 = variacaoEnergia2;
        this.escolhas = new ArrayList<Escolha>();

    }

    public Capitulo(Map<String, Personagem> personagens,
            Scanner srDeArquivos, 
            int i) {
        this.LerCapitulo(personagens, srDeArquivos, i);
        this.escolhas = new ArrayList<Escolha>();
        
    }

    public String getTexto() {
         return this.texto;
    }

     /** Metodo para ler o capitulo e armazenar esse dados sobre os personagens
     * @return e o texto. 
     * 
     */
  
    protected void LerCapitulo(Map<String, Personagem> personagens,
            Scanner srDeArquivos,
            int i) {
        i++;

        srDeArquivos.nextLine(); // PERSONAGEM
        String idPersonagem1 = srDeArquivos.nextLine().toLowerCase();
        String idPersonagem2 = srDeArquivos.nextLine().toLowerCase();
        this.personagem1 = personagens.get(idPersonagem1);
        this.personagem2 = personagens.get(idPersonagem2);

        srDeArquivos.nextLine(); // TEXTO
        String linha = srDeArquivos.nextLine();
        this.texto = "";
        while (!linha.equals("VARIACOES")) {

            if (linha.toLowerCase().equals(idPersonagem1)) {
                texto = texto + personagem1.getNome();
            } else if (linha.toLowerCase().equals(idPersonagem2)) {
                texto = texto + personagem2.getNome();
            } else {
                texto = texto + linha;
            }
            linha = srDeArquivos.nextLine();

        }

        this.variacaoEnergia1 = Integer.parseInt(srDeArquivos.nextLine());
        this.variacaoEnergia2 = Integer.parseInt(srDeArquivos.nextLine());

        srDeArquivos.nextLine(); // \n
        
    }

    public void adicionarEscolha(Escolha escolha) {
        escolhas.add(escolha);
    }


    public ArrayList<Escolha> getEscolhas() {
        return escolhas;
    }

    public void ajustarEnergia() {

        personagem1.ajustarEnergia(variacaoEnergia1);
        personagem2.ajustarEnergia(variacaoEnergia2);

    }


    

    

}
