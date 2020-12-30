package com.utbm.projet;

import javafx.scene.control.Button;

public class Research {
	
	public Button button;
	
    Research() {
    	button = new Button ("Research");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(button);
    }

    public void doResearch() {
        // TODO implement here
    }

    public void cancelResearch() {
        // TODO implement here
    }

    public enum listeRecherches {
    }

}