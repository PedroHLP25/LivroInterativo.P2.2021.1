import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

public class Capitulo {
    private String texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem personagem1;
    private Personagem personagem2;
    private int variacaoEnergia1;
    private int variacaoEnergia2;
    protected Scanner sr;

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
        this.sr = sr;
        this.escolhas = new ArrayList<Escolha>();

    }

    public Capitulo(Map<String, Personagem> personagens,
            Scanner srDeArquivos, Scanner srDoConsole,
            int i) {
        this.LerCapitulo(personagens, srDeArquivos, i);
        this.sr = srDoConsole;
        this.escolhas = new ArrayList<Escolha>();
    }

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

    public void executar() {
        // Mostrando o texto do capítulo e das escolhas
        mostrar();
        // Permitindo que o usuário realize sua escolha,caso existam escolhas possíveis
        if (escolhas.size() > 0) {
            int idCapituloEscolhido = escolher();
            escolhas.get(idCapituloEscolhido).getSeguinte().executar();
        }

    }

    protected void mostrar() {
        System.out.println(texto);
        personagem1.ajustarEnergia(variacaoEnergia1);
        personagem2.ajustarEnergia(variacaoEnergia2);

        for (int i = 0; i < escolhas.size(); i++) {
            System.out.println("-" + escolhas.get(i).getTextoMostrado() + "\n");
        }
    }

    private int escolher() {
        int resultado = 0;

        String escolha;

        boolean escolhaValida = false;

        if (escolhas.size() == 0) {
            System.out.println("A batalha acabou,reinicie a história para uma nova batalha!");
        }

        else {

            while (!escolhaValida) {
                escolha = sr.nextLine();

                for (int i = 0; i < escolhas.size(); i++) {

                    if (escolha.equals(escolhas.get(i).getTextoDigitado())) {
                        escolhaValida = true;
                        resultado = i;
                    }

                }

                if (!escolhaValida) {
                    System.out.println("A escolha digitada não é válida, digite novamente");
                    escolhaValida = false;
                }
            }

        }

        return resultado;
    }

}
