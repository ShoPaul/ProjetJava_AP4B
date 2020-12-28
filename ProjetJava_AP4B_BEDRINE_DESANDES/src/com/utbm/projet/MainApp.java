package com.utbm.projet;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private BorderPane root = new BorderPane();
	private VBox menu = new VBox(5);
	private VBox presentation = new VBox(20);
	private HBox firstButtonRange = new HBox(5);
	private HBox secondButtonRange = new HBox(5);
	private HBox economyLabels = new HBox(50);
	private HBox dateLabels = new HBox(20);
	private Research res = new Research ();
	private Culture clt = new Culture ();
	private Leader lead = new Leader ();
	private Medecine med = new Medecine ();
	private Population pop = new Population ();
	
	private Planet planet = new Planet();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Icon and background of the App
		Image icon16 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon16.png"));
		Image icon24 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon24.png"));
		Image icon32 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon32.png"));
		Image icon64 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon64.png"));
		Image background = new Image(this.getClass().getResourceAsStream("/resources/images/planets/marsBackground.jpg"));
		
		// Call method for placing bottom components in the BorderPane
		setBottomComponents();
		
		// Call method for placing top components in the BorderPane
		setTopComponents();

		// Set BorderPane background
		root.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
		
		// Create the scene
		Scene scene = new Scene(root);
		
		// Stage configuration
		primaryStage.setScene(scene);
		primaryStage.setTitle("Survival on a planet");
		primaryStage.getIcons().addAll(icon16, icon24, icon32, icon64);
		primaryStage.setFullScreen(false);
		primaryStage.setResizable(true);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("F11"));

		// Show the window
		primaryStage.show();
	}

	private void setTopComponents() {
		
		// Text effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
		
		Economy Eco = new Economy (50,50,50,50);
		Time time = new Time();
		
		// Call the planet method saying that Venus is the planet wanted by the player
		planet.itsVenus(planet);
		planet.setLabels(planet);
		
		// Time HBox
		dateLabels.getChildren().addAll(time.month, time.day, time.clock);
		dateLabels.setAlignment(Pos.CENTER);
		
		// Resources HBox
		economyLabels.getChildren().addAll(Eco.carboneLabel, Eco.diazoteLabel, Eco.hydrogeneLabel, Eco.oxygeneLabel);
		economyLabels.setAlignment(Pos.CENTER);
		
		// Resources, Time and planet info in the VBox presentation
		presentation.getChildren().addAll(economyLabels, planet.planetNameLabel, dateLabels);
		presentation.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(presentation, new Insets(30));
		
		// Set presentation at the top of the BorderPane
		root.setTop(presentation);
	}

	private void setBottomComponents() {

		// Add buttons to two HBoxs
		firstButtonRange.getChildren().addAll(res.button, pop.button, clt.button);
		secondButtonRange.getChildren().addAll(med.button, lead.button);
		
		// Set HBoxs's components alignment to the center
		firstButtonRange.setAlignment(Pos.CENTER);
		secondButtonRange.setAlignment(Pos.CENTER);
		
		// Add the two HBoxs to the VBox menu
		menu.getChildren().addAll(firstButtonRange, secondButtonRange);
		menu.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(menu, new Insets(30));
		
		// Set menu at the bottom of the BorderPane
		root.setBottom(menu);
	}

	public static void main(String[] args) {
		// Start app
		launch(args);
	}
}
