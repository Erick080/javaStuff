package poo;

public class Espada extends Item {

    public Espada() {
        super(3, 1, "Espada", "ESP23");
        
    }

    @Override
    public void modificar(Heroi x) {
        x.maisAtaque(3);
        
    }
    
}
