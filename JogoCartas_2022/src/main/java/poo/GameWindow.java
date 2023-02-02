package poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameWindow extends Application implements GameListener {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Game.getInstance().addGameListener(this);

		primaryStage.setTitle("Batalha de Herois");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		DeckView deckJ1 = new DeckView(1);
		ScrollPane sd1 = new ScrollPane();
		sd1.setPrefSize(1024, 256);
		sd1.setContent(deckJ1);
		grid.add(sd1, 0, 0);

		
		
		
		Button ItemCura = new Button("Item-Cura");
		grid.add(ItemCura,2,1);
		ItemCura.setOnAction(e -> Game.getInstance().CuraCarta());

		Button ItemEscudo = new Button("Item-Escudo");
		grid.add(ItemEscudo,1,1);
		ItemEscudo.setOnAction(e->Game.getInstance().AumentaDefCarta());

		Button ItemEspada = new Button("Item-Espada");
		grid.add(ItemEspada,1,0);
		ItemEspada.setOnAction(e->Game.getInstance().AumentaAtaqueCarta());

		DeckView deckJ2 = new DeckView(2);
		ScrollPane sd2 = new ScrollPane();
		sd2.setPrefSize(1024, 256);
		sd2.setContent(deckJ2);
		grid.add(sd2, 0, 2);

		Scene scene = new Scene(grid);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void notify(GameEvent eg) {
		Alert alert;
		if (eg == null) return;
		if (eg.getTarget() == GameEvent.Target.GWIN) {
			switch (eg.getAction()) {
			case INVPLAY:
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Atenção !!");
				alert.setHeaderText("Jogada inválida!!");
				alert.setContentText("Era a vez do jogador " + eg.getArg());
				alert.showAndWait();
				break;
			case MUSTCLEAN:
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Um heroi foi derrotado/Item usado");
				alert.setHeaderText(null);
				alert.setContentText("Utilize o botao \"Clean\"");
				alert.showAndWait();
				break;
			case ENDGAME:
				String text = "Fim de Jogo !!\n";
				if (Game.getInstance().getDeckJ1().getNumberOfCards() == 0) {
					text += "O jogador 2 venceu";
				} else if(Game.getInstance().getDeckJ2().getNumberOfCards() == 0) {
					text += "O jogador 1 venceu";
				}
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Parabens !!");
				alert.setHeaderText(null);
				alert.setContentText(text);
				alert.showAndWait();
				break;
			case REMOVESEL:
				// Esse evento não vem para cá
			}
		}
	}

}
