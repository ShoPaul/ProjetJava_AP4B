package com.utbm.projet;

import java.awt.List;

import javafx.scene.control.Button;

public class Population {
	
	private List listColony;
	public Button button;
	
    Population() {
    	button = new Button ("Population");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(button);
    }    

    public List getListColony() {
        // TODO implement here
        return null;
    }

    public boolean listColonyIsEmpty(List listColony) {
        // TODO implement here
        return false;
    }
}