package com.utbm.projet;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Planet {

	public String planetName;
	public String planetImage;
	public Label planetNameLabel = new Label();
	public Label planetChoiceLabel = new Label();
	public Button marsButton = new Button();
	public Button venusButton = new Button();
	public Button mercuryButton = new Button();
	public VBox planetChoiceVBox = new VBox();
	public HBox buttonsVBox = new HBox();
	
    public Planet() {
    }
    
    private void itsMars(ActionEvent e, Planet planet, Image background) {
    	Mars mars = new Mars();
    	planet.planetName = mars.name;
    	planet.planetImage = mars.planetLinkImage;
    	background = new Image(this.getClass().getResourceAsStream(planet.planetImage));
    	setLabels(planet);
    }
    
    private void itsVenus(ActionEvent e, Planet planet, Image background) {
    	Venus venus = new Venus();
    	planet.planetName = venus.name;
    	planet.planetImage = venus.planetLinkImage;
    	//background = planet.planetImage;
    	setLabels(planet);
    }
    
    private void itsMercure(ActionEvent e, Planet planet, Image background) {
    	Mercure mercure = new Mercure();
    	planet.planetName = mercure.name;
    	planet.planetImage = mercure.planetLinkImage;
    	//background = planet.planetImage;
    	setLabels(planet);
    }
    
    private void setLabels(Planet planet) {
    	// Text effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
		
		// Set information on the chosen planet
		planet.planetNameLabel.setText(planet.planetName);
		planet.planetNameLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 30));
		planet.planetNameLabel.setTextFill(Color.WHITE);
		planet.planetNameLabel.setEffect(dropShadow);
    }
    
    public void planetChoice(Planet planet, Image background) {
    	planet.marsButton.setText("Mars");
    	planet.marsButton.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
    	planet.marsButton.setTextFill(Color.web("2E7BD8"));
    	planet.marsButton.setBackground(new Background(new BackgroundImage(new Image(this.getClass().getResourceAsStream("/resources/images/planets/blackStarsBackground.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(0, 0, false, false, false, true))));
    	planet.marsButton.setMinSize(100, 100);
    	
    	planet.planetChoiceLabel.setText("Quelle planète choisissez-vous ?");
    	planet.planetChoiceLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 50));
    	
    	planet.buttonsVBox.getChildren().addAll(planet.marsButton);
    	planet.buttonsVBox.setAlignment(Pos.CENTER);
    	
    	planet.planetChoiceVBox.getChildren().addAll(planet.planetChoiceLabel, planet.buttonsVBox);
    	planet.planetChoiceVBox.setAlignment(Pos.CENTER);
    	VBox.setMargin(planet.planetChoiceLabel, new Insets(0, 0, 200, 0));
    	
    	planet.marsButton.setOnAction((e) -> planet.itsMars(e, planet, background));
    	planet.venusButton.setOnAction((e) -> planet.itsVenus(e, planet, background));
    	planet.mercuryButton.setOnAction((e) -> planet.itsMercure(e, planet, background));
    }
}