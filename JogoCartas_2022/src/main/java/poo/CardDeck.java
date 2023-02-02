package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class CardDeck {
	public static final int NCARDSH = 3; //numero de cartas herois no baralho
	public static final int NCARDSI = 1; //numero de cartas item no baralho
	private List<Card> cartas;
	private Card selected;
	private List<GameListener> observers;

	//CRIA UM DECK COM CARTAS ALEATORIAS
	public CardDeck() {
		cartas = new ArrayList<>(NCARDSH+NCARDSI);
		selected = null;
		Random r = new Random();
		
		//RANDOMIZA AS CARTAS HEROIS
		for (int i = 0; i < NCARDSH; i++) {
			int n = r.nextInt(5) + 1;
			switch(n){
				case 1:
					Card c = new Hulk();
					cartas.add(c);
					
					break;
				case 2:
					c = new Spider();
					cartas.add(c);
					
					break;
				case 3:
					c = new Iron();
					cartas.add(c);
					
					break;
				case 4:
					c = new Thanos();
					cartas.add(c);
					break;
				case 5:
					c = new Wolverine();
					cartas.add(c);
					break;
			}
			
			
			
		}
		//RANDOMIZA AS CARTAS ITEMS
		for(int j = 0; j < NCARDSI;j++){
			int p = r.nextInt(3)+1;
			switch(p){
				case 1:
					Card c = new Cura();
					
					cartas.add(c);
					
					break;
				case 2:
					c = new Escudo();
					cartas.add(c);
					break;
				case 3:
					c = new Espada();
					cartas.add(c);
					break;
				}
			
		}
		observers = new LinkedList<>();
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cartas);
	}

	public int getNumberOfCards() {
		return cartas.size();
	}

	public void removeSel() {
		if (selected == null) {
			return;
		}
		cartas.remove(selected);
		selected = null;
		GameEvent gameEvent = new GameEvent(this, GameEvent.Target.DECK, GameEvent.Action.REMOVESEL, "");
		for (var observer : observers) {
			observer.notify(gameEvent);
		}
	}

	public void setSelectedCard(Card card) {
		selected = card;
	}

	public Card getSelectedCard() {
		return selected;
	}

	//VERIFICA SE O JOGADOR PODE CURAR UMA CARTA
	public boolean PodeCurar(){
		for(Card x:cartas){
			if(x instanceof Cura){
				if(((Cura) x).getUsos() > 0){
					return true;
				} else{System.out.println("[ALERTA!]Voce ja gastou todas suas curas!");

				
			}
		
		}}return false;}

		//RETORNA A CARTA CURA DO BARALHO
		public Cura getCura(){
			for(Card x:cartas){
				if(x instanceof Cura){
					return (Cura)x;
				}
			}
			return null;
		}

	//PEGA UMA CARTA HEROI ALEATORIA 

	public Card CartaAleatoria(){
		for(Card x:cartas){
			if(x instanceof Heroi){
				return x;
			}
		}
		return null;
	}

	//VERIFICA SE O JOGADOR PODE AUMENTAR A DEFESA DE UMA CARTA
	public boolean PodeAumentarDef(){
		for(Card x:cartas){
			if(x instanceof Escudo){
				if(((Escudo) x).getUsos() > 0){
					return true;
				} else{System.out.println("[ALERTA!]Voce ja gastou todos seus escudos!");

				
			}
		
		}}return false;}

	
	//RETORNA A CARTA ESCUDO DO BARALHO
	public Escudo getEscudo(){
		for(Card x:cartas){
			if(x instanceof Escudo){
				return (Escudo)x;
			}
		}
		return null;
	}

	//VERIFICA SE O JOGADOR PODE AUMENTAR O ATAQUE DE UMA CARTA
	public boolean PodeAumentarAtaque(){
		for(Card x:cartas){
			if(x instanceof Espada){
				if(((Espada) x).getUsos() > 0){
					return true;
				} else{System.out.println("[ALERTA!]Voce ja gastou todas suas espadas!");

				
			}
		
		}}return false;}


		//RETORNA A CARTA ESPADA DO BARALHO
	public Espada getEspada(){
		for(Card x:cartas){
			if(x instanceof Espada){
				return (Espada)x;
			}
		}
		return null;
	}



	public void addGameListener(GameListener listener) {
		observers.add(listener);
	}

}
