package poo;

public class Wolverine extends Heroi {

    public Wolverine() {
        super(30, 3, 4, "Wolverine", "WO44");
        
    }

    @Override
    public void ataqueNormal(Heroi x) {
        x.dano(15);
        
    }

    
}
