public class Escolha {
    private String textoMostrado;
    private String textoDigitado;
    private Capitulo seguinte;

    public Escolha(String textoDigitado,String textoMostrado, Capitulo seguinte){
        this.textoDigitado = textoDigitado;
        this.textoMostrado = textoMostrado;
        this.seguinte = seguinte;
    }

    public String getTextoDigitado() {

        return this.textoDigitado;
    }

    public String getTextoMostrado() {

        return this.textoMostrado;
    }

    public Capitulo getSeguinte() {

        return this.seguinte;
    }
    
}
