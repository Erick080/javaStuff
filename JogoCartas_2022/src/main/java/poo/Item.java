package poo;

public abstract class Item extends Card{
    int potencia;
    int usos;

    public Item(int potencia,int usos,String anId,String animageId){
        super(anId,animageId);
        this.potencia = potencia;
        this.usos = usos;
    }
    
    public abstract void modificar(Heroi x);

    public int getUsos(){
        return usos;
    }
}
