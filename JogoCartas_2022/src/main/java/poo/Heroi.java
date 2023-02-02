package poo;

public abstract class Heroi extends Card {
    int vida;
    int defesa;
    int hagilidade;

    public Heroi (int vida,int defesa,int hagilidade,String anId,String anImageId){
        super(anId,anImageId);
        this.vida = vida;
        this.defesa = defesa;
        this.hagilidade = hagilidade;
    }
    
    public abstract void ataqueNormal(Heroi x);  
    
    public int getVida(){
        return vida;
    }

    public  void dano (int dano){
        vida = vida - dano;
    }; //quando a carta leva dano

    public void menosDefesa(int mod){
        defesa = defesa - mod;
    }

    public void maisDefesa(int mod){
        defesa = defesa + mod;
    }

    public void maisAtaque(int mod){
        hagilidade = hagilidade + mod;
    }

    public void cura(int mod){
        vida = vida + mod;
    }
    
}
