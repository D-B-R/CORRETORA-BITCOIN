package bitcoin;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {

    public String nome;
    public Integer nbitcoins;
    public Double dinheiro;
    public Corretora corretora;
    public int quantidade;
      
    public Random gerador = new Random();
  

    public Cliente(String nome, Corretora corretora) {
        this.nome = nome;
        this.nbitcoins = 0;
        this.dinheiro = 1000000.00;
        this.corretora = corretora;
       
       
    }
    
    public void comprar(int quantidade) {
        nbitcoins = nbitcoins + quantidade ;
        dinheiro = dinheiro - corretora.venderBitcoin(quantidade);
    }

    public void vender(int quantidade) {
        nbitcoins = nbitcoins - quantidade;
        dinheiro = dinheiro + corretora.comprarBitcoin(quantidade);
    }
    
     public void negociacao() {
        quantidade = gerador.nextInt(4) + 1;
        
        if (nbitcoins == 0 && dinheiro >= corretora.valorBTC * quantidade && corretora.numBitcoins>=quantidade) {
            this.comprar(quantidade);
            
        } 
        
        else if (gerador.nextInt(3) == 1 && dinheiro >= (corretora.valorBTC * quantidade) && corretora.numBitcoins>=quantidade) {
            this.comprar(quantidade);
            
        } 
        
        else if (nbitcoins>=quantidade && corretora.dinheiro >= corretora.valorBTC * quantidade) {
            this.vender(quantidade);
        }

    }

    
    @Override
    public void run() {
        while (true) {
            negociacao();
            if(nbitcoins == 0){
                System.out.println("Cliente: " + nome + " - Quantidade de Bitcoins: " + nbitcoins + " - Dinheiro: " + dinheiro + " - [Cliente propício à compra]");
            }
            else if(nbitcoins > 0 && nbitcoins < 4){
                System.out.println("Cliente: " + nome + " - Quantidade de Bitcoins: " + nbitcoins + " - Dinheiro: " + dinheiro + " - [Cliente propício à compra ou venda]");
            }
            else{
            System.out.println("Cliente: " + nome + " - Quantidade de Bitcoins: " + nbitcoins + " - Dinheiro: " + dinheiro + " - [Cliente propício à venda]");
        }
            
            try {
                Thread.sleep(5000);
            } 
            
            catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }

    }

  


}