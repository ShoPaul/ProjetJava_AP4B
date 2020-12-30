package com.utbm.projet;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class Effects {

	public DropShadow setButtonHoverEffect() {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(8.0);
		dropShadow.setHeight(20.0);
		dropShadow.setWidth(20.0);
		dropShadow.setColor(Color.WHITE);
		
		return dropShadow;
	}
	
	public DropShadow setButtonBasicEffect() {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(1.9);
		dropShadow.setColor(Color.WHITE);
		
		return dropShadow;
	}
	
	public DropShadow setTextEffect() {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(5.0);
		dropShadow.setColor(Color.BLACK);
		
		return dropShadow;
	}
}
