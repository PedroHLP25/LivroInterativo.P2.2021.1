import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** A Classe LeitorDeArquivos ajuda a carregar personagens e capítulos.
 * Além disso,lê e armazena as escolhas em questão.
 * Não possui um construtor só o padrão e não possui atributos.
 */
public class LeitorDeArquivos {
    public HashMap<String, Personagem> carregarPersonagem(String caminho) {
 HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();

        File arquivo = new File(caminho);
        try {
            Scanner sr = new Scanner(arquivo, "UTF-8");
            System.out.println("Carregando personagens .....");
            int i = 0;
            while (sr.hasNextLine()) {
                i++;
                String id = sr.nextLine().toLowerCase(); // ID
                String nome = sr.nextLine(); // Nome

                int energia = Integer.parseInt(sr.nextLine());

                sr.nextLine(); // \n

                System.out.println("Personagem" + i);
                personagens.put(id, new Personagem(nome, energia));
            }
            sr.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return personagens;
    }

    public HashMap<String, Capitulo> carregarCapitulos(String caminho,
            Map<String, Personagem> personagens) {

        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();

        File arquivo = new File(caminho);
        try {
            Scanner srDeArquivos = new Scanner(arquivo, "UTF-8");
            System.out.println("Carregando capitulos .....");
            String linha = srDeArquivos.nextLine();
            int i = 0;
    while (srDeArquivos.hasNextLine()) {

        if (linha.equals("CAPITULO") || 
           linha.equals("CAPITULO_COM_IMAGEM")) {

            srDeArquivos.nextLine(); // ID
            String id = srDeArquivos.nextLine().toLowerCase();

            if(linha.equals("CAPITULO"))
             {
                capitulos.put(id, new Capitulo(personagens, srDeArquivos, i));
             }
                    
            else if(linha.equals("CAPITULO_COM_IMAGEM"))
             {
              capitulos.put(id, new CapituloImagem(personagens,
              srDeArquivos, i));
             }

                    System.out.println("Capitulo" + id);
                    srDeArquivos.nextLine(); // \n

                 
                } else if (linha.equals("ESCOLHA")) {

                    LerEscolha(capitulos, srDeArquivos);
                }
                linha = srDeArquivos.nextLine();

            }
            srDeArquivos.close();

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return capitulos;
    }
   /** O método LerEscolha, lê as escolhas de acordo com algumas informações 
    * no bloco de texto em questão são elas De, PARA ,TEXTO DIGITADO e TEXTO
    MOSTRADO.E a partir disso dá pra ir entendendo as ordens das escolhas que 
    leva de um capitulo para outro e mostra o TEXTO DIGITADO ou MOSTRADO.
 */
    private void LerEscolha(HashMap<String, Capitulo> capitulos, 
    Scanner srDeArquivos) {

        srDeArquivos.nextLine(); // DE
        String idCapituloDe = srDeArquivos.nextLine().toLowerCase();
        srDeArquivos.nextLine(); // PARA
        String idCapituloPara = srDeArquivos.nextLine().toLowerCase();
        srDeArquivos.nextLine(); // TEXTO DIGITADO
        String textoDigitado = srDeArquivos.nextLine();
        srDeArquivos.nextLine(); // TEXTO MOSTRADO
        String textoMostrado = srDeArquivos.nextLine();


        Capitulo capituloDe=capitulos.get(idCapituloDe);
        Capitulo capituloPara=capitulos.get(idCapituloPara);
        capituloDe.adicionarEscolha(new Escolha(
                textoDigitado,
                textoMostrado,
                capituloPara));
    }
}

    
