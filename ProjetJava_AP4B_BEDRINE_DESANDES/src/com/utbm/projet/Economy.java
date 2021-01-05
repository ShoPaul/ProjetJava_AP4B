package com.utbm.projet;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


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
	
	//Default constructor
	
	Economy(int ox, int da, int hy, int cb){
    	carboneNumber = cb;
    	diazoteNumber = da;
    	hydrogeneNumber = hy;
    	oxygeneNumber = ox;
    	setEconomy(cb, da, hy, ox);
    }
    
    public void setEconomy(int cb, int da, int hy, int ox) {
    	carboneLabel.setText("Carbone :	" + carboneNumber);
		carboneLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		carboneLabel.setTextFill(Color.WHITE);
		diazoteLabel.setText("Diazote :	" + diazoteNumber);
		diazoteLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		diazoteLabel.setTextFill(Color.WHITE);
		hydrogeneLabel.setText("Hydrogene :	" + hydrogeneNumber);
		hydrogeneLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		hydrogeneLabel.setTextFill(Color.WHITE);
		oxygeneLabel.setText("Oxygene :	" + oxygeneNumber);
		oxygeneLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
		oxygeneLabel.setTextFill(Color.WHITE);
    	
		economyLabels.getChildren().addAll(carboneLabel, diazoteLabel, hydrogeneLabel, oxygeneLabel);
		economyLabels.setAlignment(Pos.CENTER);
    }
}