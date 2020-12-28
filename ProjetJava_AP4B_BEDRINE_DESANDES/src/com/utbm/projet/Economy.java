package com.utbm.projet;

import java.util.*;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Economy {

	public Label carboneLabel;
	public Label diazoteLabel;
	public Label hydrogeneLabel;
	public Label oxygeneLabel;
	
	private int carboneNumber;
	private int diazoteNumber;
	private int hydrogeneNumber;
	private int oxygeneNumber;
	
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
    	    	
    }
}