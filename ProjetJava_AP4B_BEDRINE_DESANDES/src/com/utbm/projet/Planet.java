package com.utbm.projet;

import javafx.scene.control.Label;

public class Planet {

	public String planetName;
	public String planetImage;
	public Label planetNameLabel;
	
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
    
}