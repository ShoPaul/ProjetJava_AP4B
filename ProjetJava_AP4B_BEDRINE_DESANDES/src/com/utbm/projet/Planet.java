package com.utbm.projet;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Planet {

	public String planetName;
	public String planetImage;
	public Label planetNameLabel = new Label();
	public Label planetChoiceLabel = new Label();
	public Button marsButton = new Button();
	public Button venusButton = new Button();
	public Button mercuryButton = new Button();
	public VBox planetChoiceVBox = new VBox();
	public HBox buttonsVBox = new HBox(100);

	public Planet() {
	}

	public void itsMars(Planet planet, BorderPane root) {
		Mars mars = new Mars();
		planet.planetName = mars.name;
		planet.planetImage = mars.planetLinkImage;
		setLabels(planet, root);
	}

	public void itsVenus(Planet planet, BorderPane root) {
		Venus venus = new Venus();
		planet.planetName = venus.name;
		planet.planetImage = venus.planetLinkImage;
		setLabels(planet, root);
	}

	public void itsMercury(Planet planet, BorderPane root) {
		Mercure mercure = new Mercure();
		planet.planetName = mercure.name;
		planet.planetImage = mercure.planetLinkImage;
		setLabels(planet, root);
	}

	private void setLabels(Planet planet, BorderPane root) {
		Image background = new Image(this.getClass().getResourceAsStream(planet.planetImage));

		// Text effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

		// Set information on the chosen planet
		planet.planetNameLabel.setText(planet.planetName);
		planet.planetNameLabel.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 30));
		planet.planetNameLabel.setTextFill(Color.WHITE);
		planet.planetNameLabel.setEffect(dropShadow);

		root.setBackground(
				new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
	}

	public void planetChoice(Planet planet) {
		DropShadow dropShadow1 = new DropShadow();
		dropShadow1.setRadius(5.0);
		dropShadow1.setOffsetX(3.0);
		dropShadow1.setOffsetY(5.0);
		dropShadow1.setColor(Color.BLACK);
		DropShadow dropShadow2 = new DropShadow();
		dropShadow2.setRadius(1.9);
		dropShadow2.setColor(Color.WHITE);
		DropShadow dropShadow3 = new DropShadow();
		dropShadow3.setRadius(8.0);
		dropShadow3.setHeight(20.0);
		dropShadow3.setWidth(20.0);
		dropShadow3.setColor(Color.WHITE);

		Image buttonsBackground = new Image(
				this.getClass().getResourceAsStream("/resources/images/backgrounds/blackStarsBackground.jpg"));

		planet.marsButton.setText("Mars");
		planet.marsButton.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		planet.marsButton.setTextFill(Color.web("2E7BD8"));
		planet.marsButton.setBackground(new Background(
				new BackgroundImage(buttonsBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		planet.marsButton.setMinSize(100, 100);
		planet.marsButton.setCursor(Cursor.HAND);
		planet.marsButton.effectProperty()
				.bind(Bindings.when(planet.venusButton.hoverProperty()).then(dropShadow3).otherwise(dropShadow2));

		planet.venusButton.setText("Venus");
		planet.venusButton.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		planet.venusButton.setTextFill(Color.web("2E7BD8"));
		planet.venusButton.setBackground(new Background(
				new BackgroundImage(buttonsBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		planet.venusButton.setMinSize(100, 100);
		planet.venusButton.setCursor(Cursor.HAND);
		planet.venusButton.effectProperty()
				.bind(Bindings.when(planet.venusButton.hoverProperty()).then(dropShadow3).otherwise(dropShadow2));

		planet.mercuryButton.setText("Mercure");
		planet.mercuryButton.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		planet.mercuryButton.setTextFill(Color.web("2E7BD8"));
		planet.mercuryButton.setBackground(new Background(
				new BackgroundImage(buttonsBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		planet.mercuryButton.setMinSize(100, 100);
		planet.mercuryButton.setCursor(Cursor.HAND);
		planet.mercuryButton.effectProperty()
				.bind(Bindings.when(planet.venusButton.hoverProperty()).then(dropShadow3).otherwise(dropShadow2));

		planet.planetChoiceLabel.setText("Quelle planète choisissez-vous ?");
		planet.planetChoiceLabel.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 50));
		planet.planetChoiceLabel.setTextFill(Color.web("2E7BD8"));
		planet.planetChoiceLabel.setEffect(dropShadow1);

		planet.buttonsVBox.getChildren().addAll(planet.marsButton, planet.venusButton, planet.mercuryButton);
		planet.buttonsVBox.setAlignment(Pos.CENTER);

		planet.planetChoiceVBox.getChildren().addAll(planet.planetChoiceLabel, planet.buttonsVBox);
		planet.planetChoiceVBox.setAlignment(Pos.CENTER);

		Image scene1Background = new Image(
				this.getClass().getResourceAsStream("/resources/images/backgrounds/scene1Background.jpg"));
		planet.planetChoiceVBox.setBackground(new Background(
				new BackgroundImage(scene1Background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));

		VBox.setMargin(planet.planetChoiceLabel, new Insets(0, 0, 200, 0));

	}

	public void onMercuryButtonClick(ActionEvent e, Stage primaryStage, BorderPane root, Scene scene2) {
		itsMercury(this, root);
		primaryStage.setScene(scene2);
	}

	public void onVenusButtonClick(ActionEvent e, Stage primaryStage, BorderPane root, Scene scene2) {
		itsVenus(this, root);
		primaryStage.setScene(scene2);
	}

	public void onMarsButtonClick(ActionEvent e, Stage primaryStage, BorderPane root, Scene scene2) {
		itsMars(this, root);
		primaryStage.setScene(scene2);
	}
}