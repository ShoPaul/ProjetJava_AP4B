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
	public HBox buttonsHBox = new HBox(100);

	public Planet() {
		// Buttons's and text's effects
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

		// Buttons's background
		Image buttonsBackground = new Image(
				this.getClass().getResourceAsStream("/resources/images/backgrounds/blackStarsBackground.jpg"));

		// Set marsButton's effects, styles and infos
		marsButton.setText("Mars");
		marsButton.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		marsButton.setTextFill(Color.web("2E7BD8"));
		marsButton.setBackground(new Background(
				new BackgroundImage(buttonsBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		marsButton.setMinSize(100, 100);
		marsButton.setCursor(Cursor.HAND);
		marsButton.effectProperty()
				.bind(Bindings.when(marsButton.hoverProperty()).then(dropShadow3).otherwise(dropShadow2));

		// Set venusButton's effects, styles and infos
		venusButton.setText("Venus");
		venusButton.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		venusButton.setTextFill(Color.web("2E7BD8"));
		venusButton.setBackground(new Background(
				new BackgroundImage(buttonsBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		venusButton.setMinSize(100, 100);
		venusButton.setCursor(Cursor.HAND);
		venusButton.effectProperty()
				.bind(Bindings.when(venusButton.hoverProperty()).then(dropShadow3).otherwise(dropShadow2));

		// Set mercuryButton's effects, styles and infos
		mercuryButton.setText("Mercure");
		mercuryButton.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		mercuryButton.setTextFill(Color.web("2E7BD8"));
		mercuryButton.setBackground(new Background(
				new BackgroundImage(buttonsBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		mercuryButton.setMinSize(100, 100);
		mercuryButton.setCursor(Cursor.HAND);
		mercuryButton.effectProperty()
				.bind(Bindings.when(mercuryButton.hoverProperty()).then(dropShadow3).otherwise(dropShadow2));

		// Set planetChoiceLabel's effects, styles and infos
		planetChoiceLabel.setText("Choisir une planète".toUpperCase());
		planetChoiceLabel.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 50));
		planetChoiceLabel.setTextFill(Color.web("2E7BD8"));
		planetChoiceLabel.setEffect(dropShadow1);
	}

	// Method to add Mars's infos to planet
	public void itsMars(Planet planet, BorderPane root) {
		Mars mars = new Mars();
		planet.planetName = mars.name;
		planet.planetImage = mars.planetLinkImage;
		setLabels(planet, root);
	}

	// Method to add Venus's infos to planet
	public void itsVenus(Planet planet, BorderPane root) {
		Venus venus = new Venus();
		planet.planetName = venus.name;
		planet.planetImage = venus.planetLinkImage;
		setLabels(planet, root);
	}

	// Method to add Mercury's infos to planet
	public void itsMercury(Planet planet, BorderPane root) {
		Mercure mercure = new Mercure();
		planet.planetName = mercure.name;
		planet.planetImage = mercure.planetLinkImage;
		setLabels(planet, root);
	}

	// Method to set planet label and add the background to root (component of scene2)
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

		// Set background to root
		root.setBackground(
				new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
	}

	public void planetChoice(Planet planet) {
		// Add planet's buttons to the HBox planet.buttonsHBox
		planet.buttonsHBox.getChildren().addAll(planet.marsButton, planet.venusButton, planet.mercuryButton);
		planet.buttonsHBox.setAlignment(Pos.CENTER);

		// Add VBox planet.buttonsHBox and the label planet.planetChoiceLabel to the VBox planet.planetChoiceVBox
		planet.planetChoiceVBox.getChildren().addAll(planet.planetChoiceLabel, planet.buttonsHBox);
		planet.planetChoiceVBox.setAlignment(Pos.CENTER);

		// Add a background to scene1
		Image scene1Background = new Image(
				this.getClass().getResourceAsStream("/resources/images/backgrounds/scene1Background.jpg"));
		planet.planetChoiceVBox.setBackground(new Background(
				new BackgroundImage(scene1Background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));

		// Set VBox margin for planet.planetChoiceLabel
		VBox.setMargin(planet.planetChoiceLabel, new Insets(0, 0, 200, 0));
	}

	public void onMercuryButtonClick(ActionEvent e, Stage primaryStage, BorderPane root, Scene scene2) {
		// Call method to have mercury infos
		itsMercury(this, root);
		// Set scene2
		primaryStage.setScene(scene2);
	}

	public void onVenusButtonClick(ActionEvent e, Stage primaryStage, BorderPane root, Scene scene2) {
		// Call method to have venus infos
		itsVenus(this, root);
		// Set scene2
		primaryStage.setScene(scene2);
	}

	public void onMarsButtonClick(ActionEvent e, Stage primaryStage, BorderPane root, Scene scene2) {
		// Call method to have mars infos
		itsMars(this, root);
		// Set scene2
		primaryStage.setScene(scene2);
	}
}