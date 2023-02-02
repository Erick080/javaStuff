package poo;

public class Iron extends Heroi {

    public Iron(){
        super(40,4,2,"IronMan","IMID44");
    }

    @Override
    public void ataqueNormal( Heroi x) {
        
            x.dano(15);
        }
    
    
        
    }

    



