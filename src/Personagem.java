/**Classe Personagem que armazena todas as informações 
 * relativas aos personagens da história
 * as informações armazenadas são:
 * <ul> 
 * <li> private String nome;
 * <li> private int energia;
 * </u>
 */

public class Personagem {

     private String nome;
     private int energia;
     

    public Personagem(String nome,int energia)
    {    
        this.nome = nome;
        this.energia = energia;
    }

    public Personagem(String nome)
    {    
        this.nome = nome;
        this.energia = 100;
       
    }

    public void apresentacao()
    {
       System.out.format(" %s  \n",nome); 
    }

    public void ajustarEnergia (int variacao) {

      if(variacao != 0)
        {      setEnergia(this.energia + variacao);
             
         System.out.println("Por conta dos acontecimentos atuais a energia de "
                 + this.nome+
                  " foi a"+this.energia)
                ;}
            
            }
      
       
    
    
       /** O Método setEnergia serve para evitar que a energia do personagem
        * seja menor que 0.
     */
  
    private void setEnergia(int energia)
  {
      this.energia = energia ;
      if(this.energia<0) 
      {
         this.energia = 0;
      }
  }
   int getEnergia(int energia)
   {
       return this.energia;
   }

   String getNome()
   {
       return this.nome;
   }
}
  
