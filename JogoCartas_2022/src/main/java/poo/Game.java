package poo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class Game {
	private static Game game = new Game();
	public CardDeck deckJ1, deckJ2;
	private int player;
	private List<GameListener> observers;
	
	public static Game getInstance() {
		return game;
	}

	private Game() {
		deckJ1 = new CardDeck();
		deckJ2 = new CardDeck();
		player = 1;
		observers = new LinkedList<>();
	}

	private void nextPlayer() {
		player++;
		
	}
	
	public CardDeck getDeckJ1() {
		return deckJ1;
	}

	public CardDeck getDeckJ2() {
		return deckJ2;
	}
	
	//metodo para gerar aleatoriamente o ataque (hit) da carta
	public static void GeraAtaque(Heroi x,Heroi y){
		Random r = new Random();
		int n = r.nextInt(10) + x.hagilidade;
		//se o hit for maior que a defesa da outra carta, ele acerta
		if(n > y.defesa){
			x.ataqueNormal(y);
			System.out.println("--Ataque acertado!\n");
		}
		else if (n <= y.defesa){
			System.out.println("--Ataque desviado!\n");
		}


	}

	public void play(CardDeck deckAcionado) {
		GameEvent gameEvent = null;
		
		
		if (deckAcionado == deckJ1) {
			if (player  == 2) {
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			} else {
				//IMPRIME NO TERMINAL A VIDA DO HEROI
				if(deckJ1.getSelectedCard() instanceof Heroi){
				System.out.println("CARTA J1 - "+deckJ1.getSelectedCard().getId());
				System.out.println("VIDA - "+((Heroi) deckJ1.getSelectedCard()).getVida());}

				if(deckJ1.getSelectedCard() instanceof Item){
					System.out.println("CARTA J1 - "+deckJ1.getSelectedCard().getId());
					System.out.println("USOS - "+((Item) deckJ1.getSelectedCard()).getUsos());
				}

				

				if(!(deckJ1.getSelectedCard().isFacedUp()))
					deckJ1.getSelectedCard().flip();
				// Proximo jogador
				nextPlayer();
			}
		} else if (deckAcionado == deckJ2) {
			if (player == 1) {
				gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
				for (var observer : observers) {
					observer.notify(gameEvent);
				}
			} else {
				
				if(deckJ2.getSelectedCard() instanceof Heroi){
					System.out.println("CARTA J2 - "+deckJ2.getSelectedCard().getId());
					System.out.println("VIDA - "+((Heroi) deckJ2.getSelectedCard()).getVida());}

				if(deckJ2.getSelectedCard() instanceof Item){
					System.out.println("CARTA J2 - "+deckJ2.getSelectedCard().getId());
					System.out.println("USOS - "+((Item) deckJ2.getSelectedCard()).getUsos());
					}

					
					
				
				Card x = deckJ1.getSelectedCard();
				Card y = deckJ2.getSelectedCard();
				
				
				//CARTA DO DECK 1 ATACA CARTA DO DECK 2
				if(x instanceof Heroi && y instanceof Heroi){
					GeraAtaque((Heroi)x,(Heroi)y);
					if(((Heroi) y).getVida() >= 0){ 	//SE A CARTA DO DECK 2 N MORREU, ELA ATACA DE VOLTA
						GeraAtaque((Heroi)y,(Heroi)x);
					}else{removeSelected();}
				}
				
				// SE ALGUMA CARTA DO DECK1 MORREU, VAI SER ELIMINADA PELO METODO
				removeSelected();

				//AO ACABAR A RODADA, OS CARDS TERAO Q SER SELECIONADOS DE NOVO 
				
				deckJ1.setSelectedCard(null);
				deckJ2.setSelectedCard(null);
				player = 0;
				
				//CASO TODAS CARTAS DE UM BARALHO FOREM ELIMINADAS, O JOGO ACABA
				if (deckJ1.getNumberOfCards() == 0 || deckJ2.getNumberOfCards() == 0) {
					gameEvent = new GameEvent(this, GameEvent.Target.GWIN, GameEvent.Action.ENDGAME, "");
					for (var observer : observers) {
						observer.notify(gameEvent);
					}
				} 

				for (var observer : observers) {
					observer.notify(gameEvent);
				}
				// Próximo jogador
				nextPlayer();
			}
		}
	}


	//REMOVE AS CARTAS QUE MORRERAM
	public void removeSelected() {
		GameEvent gameEvent = null;
		
		
		
		
		
		Card a = deckJ1.getSelectedCard();
		Card b = deckJ2.getSelectedCard();
		
		
		if(a instanceof Heroi) {
			if( ((Heroi) a).getVida() <= 0){
				System.out.println(""+a.getId()+" "+"Morreu,carta eliminada");
				deckJ1.removeSel();
			}}
		
		
			if(b instanceof Heroi){ 
				if(((Heroi)b).getVida() <= 0){
					System.out.println(""+a.getId()+" "+"Morreu,carta eliminada");
					deckJ2.removeSel();
		}}
		
		
		//Caso a ultima carta sobrando de um deck for um item, ela será eliminada
		
		if(a instanceof Item && deckJ1.getNumberOfCards() == 1){
			deckJ1.removeSel();
		}

		if(b instanceof Item && deckJ2.getNumberOfCards() == 1){
			deckJ2.removeSel();
		}
		
		nextPlayer();
	}

	//ATIVADO PELO BOTAO ITEM CURA, SE HOUVER CARTA CURA COM USOS SOBRANDO, CURA UMA CARTA ALEATORIA DO BARALHO
	public void CuraCarta(){
		if(deckJ1.PodeCurar()){
			Card a = deckJ1.CartaAleatoria();
			deckJ1.getCura().modificar((Heroi)a);
			System.out.println(""+a.getId()+"\tFoi curado");
			
		}
	}

	//ATIVADO PELO BOTAO ITEM ESCUDO, SE HOUVER CARTA ESCUDO COM USOS SOBREANDO, AUMENTA A DEFESA DE UMA CARTA DO BARALHO
	public void AumentaDefCarta(){
		if(deckJ1.PodeAumentarDef()){
			Card a = deckJ1.CartaAleatoria();
			deckJ1.getEscudo().modificar((Heroi)a);
			System.out.println(""+a.getId()+"\tTeve a defesa aumentada + 5");
			
		}
	}

	//ATIVADO PELO BOTAO ITEM ESPADA, SE HOUVER CARTA ESPADA COM USOS SOBRANDO, AUMENTA O ATAQUE DE UMA CARTA DO BARALHO
	public void AumentaAtaqueCarta(){
		if(deckJ1.PodeAumentarAtaque()){
			Card a = deckJ1.CartaAleatoria();
			deckJ1.getEspada().modificar((Heroi)a);
			System.out.println(""+a.getId()+"\tTeve o ataque aumentado + 3");
			
		}
	}
	
	public void addGameListener(GameListener listener) {
		observers.add(listener);
	}
}
