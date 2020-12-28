package com.utbm.projet;

import java.util.*;

import javafx.scene.control.Button;

public class Population {
	
	private List<String> listColony;
	public Button button;
	
    Population() {
    	button = new Button ("Population");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(button);
    }    

    public List<String> getListColony() {
        // TODO implement here
        return null;
    }

    public boolean listColonyIsEmpty(List<String> listColony) {
        // TODO implement here
        return false;
    }
}