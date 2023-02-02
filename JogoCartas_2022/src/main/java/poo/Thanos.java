package poo;

public class Thanos extends Heroi {

    public Thanos() {
        super(40, 4,2, "Thanos", "TH11");
        
    }

    @Override
    public void ataqueNormal(Heroi x) {
        x.dano(20);
        
    }

    


    
    
}
