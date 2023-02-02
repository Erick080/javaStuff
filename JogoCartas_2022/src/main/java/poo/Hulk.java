package poo;

public class Hulk extends Heroi{
    
    public Hulk(){
        super(40,6,0,"Hulk","HID99");
    }
    
    @Override
    public void ataqueNormal( Heroi x) {
        
            x.dano(20);
       
        
    }

    
    
    
}
