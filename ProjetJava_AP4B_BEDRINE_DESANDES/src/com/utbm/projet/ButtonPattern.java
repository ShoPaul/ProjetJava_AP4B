package com.utbm.projet;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class ButtonPattern {
	
	private Rectangle b;
	private Double buttonSize;
	
	ButtonPattern (){
		b = new Rectangle();
		b.setX(50);
		b.setY(50);
		b.setWidth(200);
		b.setHeight(200);
		b.setArcHeight(20);
		b.setArcWidth(20);
		
		buttonSize = 100.0;
	}
	
	public void adaptButton (Button inp) {
		inp.setShape(b);
		inp.setMinSize(buttonSize,buttonSize);
	}
}
