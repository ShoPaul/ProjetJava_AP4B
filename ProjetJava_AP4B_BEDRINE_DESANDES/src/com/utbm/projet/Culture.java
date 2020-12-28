package com.utbm.projet;

import java.util.*;

import javafx.scene.control.Button;

public class Culture {
	
	public Button button;

    Culture() {
    	button = new Button ("Culture");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(button);
    }

    public void searchNewCulture() {

    }

    public void upgradeCulture() {

    }

    public void cancelCultureResearch() {

    }


    public enum listeCultures {
    }

}