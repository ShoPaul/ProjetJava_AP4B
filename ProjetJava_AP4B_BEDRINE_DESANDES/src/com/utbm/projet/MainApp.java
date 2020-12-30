package com.utbm.projet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	private BorderPane root = new BorderPane();
	private VBox menu = new VBox(5);
	private VBox presentation = new VBox(20);
	private HBox firstButtonRange = new HBox(5);
	private HBox secondButtonRange = new HBox(5);
	private Research res = new Research();
	private Culture clt = new Culture();
	private Leader lead = new Leader();
	private Medecine med = new Medecine();
	private Population pop = new Population();
	private Planet planet = new Planet();
	private Faction faction = new Faction();

	private Scene scene1 = new Scene(planet.planetChoiceVBox, 1600, 900);
	private Scene scene2 = new Scene(faction.factionBorder, 1600, 900);
	//private Scene scene3 = new Scene(root, 1600, 900);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Icon and background of the App
		Image icon16 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon16.png"));
		Image icon24 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon24.png"));
		Image icon32 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon32.png"));
		Image icon64 = new Image(this.getClass().getResourceAsStream("/resources/images/icon/icon64.png"));
		
		faction.factionChoice(faction);
		
		planet.planetChoice(planet);

		primaryStage.setScene(scene1);

		planet.marsButton.setOnAction((e) -> planet.onMarsButtonClick(e, primaryStage, root, scene2));
		planet.venusButton.setOnAction((e) -> planet.onVenusButtonClick(e, primaryStage, root, scene2));
		planet.mercuryButton.setOnAction((e) -> planet.onMercuryButtonClick(e, primaryStage, root, scene2));

		// Call method for placing bottom components in the BorderPane
		setBottomComponents();

		// Call method for placing top components in the BorderPane
		setTopComponents();

		// Stage configuration
		primaryStage.setTitle("Survival on a planet");
		primaryStage.getIcons().addAll(icon16, icon24, icon32, icon64);
		primaryStage.setFullScreen(false);
		primaryStage.setResizable(true);
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("F11"));

		// Show the window
		primaryStage.show();
	}

	private void setTopComponents() {
		Economy Eco = new Economy(50, 50, 50, 50);
		Time time = new Time();

		// Resources, Time and planet info in the VBox presentation
		presentation.getChildren().addAll(Eco.economyLabels, planet.planetNameLabel, time.dateLabels);
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
