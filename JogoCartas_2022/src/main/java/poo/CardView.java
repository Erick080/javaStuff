package poo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.scene.control.Button;

public class CardView extends Button implements PropertyChangeListener{
	private Card card;
	private CardView thisCardView;
	private CardViewListener observer;

	public CardView(Card aCard) {
		
		super("", ImageFactory.getInstance().createImage("imgBck"));
		card = aCard;
		card.addPropertyChangeListener(this);
		thisCardView = this;
		//System.out.println("Nome - "+card.getId()+"ImageID - "+card.getImageId());

		//if(card.isFacedUp())
			this.setGraphic(ImageFactory.getInstance().createImage(card.getImageId()));

		

		this.setOnAction(e -> {
			if (observer != null) {
				observer.handle(new CardViewEvent(thisCardView));
			}
		});
	}

	public void setCardViewObserver(CardViewListener obs) {
		observer = obs;
	}

	public Card getCard() {
		return card;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (card.isFacedUp()) {
			this.setGraphic(ImageFactory.getInstance().createImage(card.getImageId()));
		} else {
			this.setGraphic(ImageFactory.getInstance().createImage("imgBck"));
		}		
	}
}
