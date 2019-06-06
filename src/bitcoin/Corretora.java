package bitcoin;

import java.util.Random;

public class Corretora {
    
    public Double valorBTC;
    public Double dinheiro;
    public Integer numBitcoins;
  
    public Random gerador = new Random();

    public Corretora() {
        this.valorBTC = 30305.00;
        this.dinheiro = 0.00;
        this.numBitcoins = 100;
     
    }

    public synchronized Double comprarBitcoin(int quantidade) {
        numBitcoins = numBitcoins + quantidade;
        dinheiro = dinheiro - (valorBTC * quantidade);
        Double aux = valorBTC * quantidade;
        
        int auxValor = gerador.nextInt(10001);
        
        if(valorBTC - auxValor >=0){
        valorBTC-= auxValor;
        
        }
        return aux;
    }

    public synchronized Double venderBitcoin(int quantidade) {

        while (numBitcoins == 0) {
            try{
                wait(3000);
               
            } 
            catch (InterruptedException ex) {
                
            }
        }
       
            numBitcoins = numBitcoins - quantidade;
            dinheiro = dinheiro + (valorBTC * quantidade);
            Double aux = valorBTC * quantidade;
            valorBTC = valorBTC + (gerador.nextInt(10001));
            notify();
            return aux;
}
    
}