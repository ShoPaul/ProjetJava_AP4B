package com.utbm.projet;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Economy {

	public Label carboneLabel;
	public Label diazoteLabel;
	public Label hydrogeneLabel;
	public Label oxygeneLabel;
	public HBox economyLabels = new HBox(50);
	
	public int carboneNumber;
	public int diazoteNumber;
	public int hydrogeneNumber;
	public int oxygeneNumber;
	
	//Default constructor
	
    Economy() {
    	carboneNumber = 0;
    	diazoteNumber = 0;
    	hydrogeneNumber = 0;
    	oxygeneNumber = 0;
    }

    Economy(int cb, int da, int hy, int ox){
    	carboneNumber = cb;
    	diazoteNumber = da;
    	hydrogeneNumber = hy;
    	oxygeneNumber = ox;
    	
    	carboneLabel = new Label();
    	diazoteLabel = new Label();
    	hydrogeneLabel = new Label();
    	oxygeneLabel = new Label();
    	
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