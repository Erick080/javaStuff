package poo;

public class Cura extends Item {
    int potencia = 15;
    
    public Cura(){
        super(15,1,"CURAID","C88");
    }
    
    @Override
    public void modificar(Heroi x){
        x.cura(potencia);
        usos--;

    }
    
}
