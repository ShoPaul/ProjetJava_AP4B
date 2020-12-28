package com.utbm.projet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

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
import javafx.scene.control.Label;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {
	
	private BorderPane root = new BorderPane();
	private VBox menu = new VBox(5);
	private VBox presentation = new VBox(20);
	private HBox firstButtonRange = new HBox(5);
	private HBox secondButtonRange = new HBox(5);
	private HBox economyLabels = new HBox(50);
	private HBox dateLabels = new HBox(20);
	private Button researchButton = new Button("Research");
	private Button popButton = new Button("Population");
	private Button cultureButton = new Button("Culture");
	private Button medecineButton= new Button("Medecine");
	private Button leaderButton = new Button("Leader");
	private Label monthLabel = new Label();
	private Label numberOfTheDayLabel = new Label();
	private Label actualTime = new Label();
	
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
		
		// Create Time labels
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LocalDate currentDate = LocalDate.now();
				int day = currentDate.getDayOfMonth();
				Month month = currentDate.getMonth();
				SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
				
				monthLabel.setText(month.toString());
				monthLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
				monthLabel.setTextFill(Color.WHITE);
				monthLabel.setEffect(dropShadow);
				numberOfTheDayLabel.setText(String.format("%d", day));
				numberOfTheDayLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
				numberOfTheDayLabel.setTextFill(Color.WHITE);
				numberOfTheDayLabel.setEffect(dropShadow);
				actualTime.setText(formatter.format(date));
				actualTime.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
				actualTime.setTextFill(Color.WHITE);
				actualTime.setEffect(dropShadow);
			}
			
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		// Call the planet method saying that Venus is the planet wanted by the player
		planet.itsVenus(planet);
		planet.setLabels(planet);
		
		// Time HBox
		dateLabels.getChildren().addAll(monthLabel, numberOfTheDayLabel, actualTime);
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
		Double buttonSize = 100.0;
		
		// Create a square for menu's buttons
		Rectangle r =new Rectangle();
		r.setX(50);
		r.setY(50);
		r.setWidth(200);
		r.setHeight(200);
		r.setArcHeight(20);
		r.setArcWidth(20);
	
		// Set the square shape and Minimum Size
		researchButton.setShape(r);
		researchButton.setMinSize(buttonSize, buttonSize);
		popButton.setShape(r);
		popButton.setMinSize(buttonSize, buttonSize);
		cultureButton.setShape(r);
		cultureButton.setMinSize(buttonSize, buttonSize);
		medecineButton.setShape(r);
		medecineButton.setMinSize(buttonSize, buttonSize);
		leaderButton.setShape(r);
		leaderButton.setMinSize(buttonSize, buttonSize);

		// Add buttons to two HBoxs
		firstButtonRange.getChildren().addAll(researchButton, popButton, cultureButton);
		secondButtonRange.getChildren().addAll(medecineButton, leaderButton);
		
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
