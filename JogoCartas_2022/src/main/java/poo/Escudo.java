package poo;

public class Escudo extends Item {

    public Escudo() {
        super(5, 1, "Escudo", "ES22");
        
    }

    @Override
    public void modificar(Heroi x) {
        x.maisDefesa(5);
        usos--;
        
    }
    
}
