import java.util.Map;
import java.util.Scanner;

//import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner srDoConsole = new Scanner(System.in, "CP850");

        LeitorDeArquivos leitor = new LeitorDeArquivos();
        Map<String, Personagem> personagens = leitor.carregarPersonagem("rsc/Personagem.txt");

        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("rsc/Capitulos.txt", personagens, srDoConsole);

        System.out.println(" Carregamento Concluído \n\n...\n");

        Capitulo raiz = capitulos.get("raiz");
         raiz.executar();
        srDoConsole.close();

    };

}
