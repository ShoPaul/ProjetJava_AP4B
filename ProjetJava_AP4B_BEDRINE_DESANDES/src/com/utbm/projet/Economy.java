package com.utbm.projet;

import java.util.*;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Economy {

	private Label carboneLabel;
	private Label diazoteLabel;
	private Label hydrogeneLabel;
	private Label oxygeneLabel;
	
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
    	
    	carboneLabel.setText("Carbone :		" + carboneNumber);
		carboneLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
		carboneLabel.setTextFill(Color.WHITE);
		diazoteLabel.setText("Diazote :		" + diazoteNumber);
		diazoteLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
		diazoteLabel.setTextFill(Color.WHITE);
		hydrogeneLabel.setText("Hydrogene :		" + hydrogeneNumber);
		hydrogeneLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
		hydrogeneLabel.setTextFill(Color.WHITE);
		oxygeneLabel.setText("Oxygene :		" + oxygeneNumber);
		oxygeneLabel.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
		oxygeneLabel.setTextFill(Color.WHITE);
    }
    public void Economy(Oxygene Oxygene, Diazote Diazote, Carbone Carbone, Hydrogene Hydrogene) {
        // TODO implement here
    }

}