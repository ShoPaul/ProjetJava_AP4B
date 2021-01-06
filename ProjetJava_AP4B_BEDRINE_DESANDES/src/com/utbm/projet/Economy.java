package com.utbm.projet;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;


public class Economy {

	public Label carboneLabel = new Label();
	public Label diazoteLabel = new Label();
	public Label hydrogeneLabel = new Label();
	public Label oxygeneLabel = new Label();
	public HBox economyLabels = new HBox(50);
	
	public int carboneNumber;
	public int diazoteNumber;
	public int hydrogeneNumber;
	public int oxygeneNumber;
	
	public int carboneProdSeconde;
	public int diazoteProdSeconde;
	public int hydrogeneProdSeconde;
	public int oxygeneProdSeconde;
	
	//Default constructor
	
	Economy(int ox, int da, int hy, int cb){
    	carboneNumber = cb;
    	diazoteNumber = da;
    	hydrogeneNumber = hy;
    	oxygeneNumber = ox;
    	carboneProdSeconde = 0;
    	diazoteProdSeconde = 0;
    	hydrogeneProdSeconde = 0;
    	oxygeneProdSeconde = 0;
    }
    
    public void setEconomy(int cb, int da, int hy, int ox) {
    	carboneLabel.setText("Carbone :	" + cb);
		carboneLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		carboneLabel.setTextFill(Color.WHITE);
		diazoteLabel.setText("Diazote :	" + da);
		diazoteLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		diazoteLabel.setTextFill(Color.WHITE);
		hydrogeneLabel.setText("Hydrogene :	" + hy);
		hydrogeneLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		hydrogeneLabel.setTextFill(Color.WHITE);
		oxygeneLabel.setText("Oxygene :	" + ox);
		oxygeneLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		oxygeneLabel.setTextFill(Color.WHITE);
    }
    
    public void refreshEconomy() {
    	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				carboneNumber += carboneProdSeconde;
				diazoteNumber += diazoteProdSeconde;
				hydrogeneNumber += hydrogeneProdSeconde;
				oxygeneNumber += oxygeneProdSeconde;
				setEconomy(carboneNumber, diazoteNumber, hydrogeneNumber, oxygeneNumber);
			}
    		
    	}));
    	
    	timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		economyLabels.getChildren().addAll(carboneLabel, diazoteLabel, hydrogeneLabel, oxygeneLabel);
		economyLabels.setAlignment(Pos.CENTER);
    }
}