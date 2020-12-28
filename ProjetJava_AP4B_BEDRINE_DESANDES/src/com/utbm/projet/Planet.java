package com.utbm.projet;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Planet {

	public String planetName;
	public String planetImage;
	public Label planetNameLabel = new Label();
	
    public Planet() {
    }
    
    public void itsMars(Planet planet) {
    	Mars mars = new Mars();
    	planet.planetName = mars.name;
    	planet.planetImage = mars.planetLinkImage;
    	//setLabels(planet);
    }
    
    public void itsVenus(Planet planet) {
    	Venus venus = new Venus();
    	planet.planetName = venus.name;
    	planet.planetImage = venus.planetLinkImage;
    	//setLabels(planet);
    }
    
    public void itsMercure(Planet planet) {
    	Mercure mercure = new Mercure();
    	planet.planetName = mercure.name;
    	planet.planetImage = mercure.planetLinkImage;
    	//setLabels(planet);
    }
    
    public void setLabels(Planet planet) {
    	// Text effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
		
		// Set information on the chosen planet
		planet.planetNameLabel.setText(planet.planetName);
		planet.planetNameLabel.setFont(Font.font(getClass().getResource("/resources/fonts/times-new-roman.ttf").toString(), FontWeight.BOLD, 30));
		planet.planetNameLabel.setTextFill(Color.WHITE);
		planet.planetNameLabel.setEffect(dropShadow);
    }
    
    
    
}