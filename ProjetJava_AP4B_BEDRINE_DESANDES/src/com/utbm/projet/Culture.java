package com.utbm.projet;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Culture {
	
	public Button cultureButton;

    Culture() {
    	cultureButton = new Button ("Culture");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(cultureButton);
    }

    public void searchNewCulture() {

    }

    public void upgradeCulture() {

    }

    public void cancelCultureResearch() {

    }


    public enum listeCultures {
    }


	public Object onCultureButtonClick(ActionEvent e, Culture clt) {
		// TODO Auto-generated method stub
		return null;
	}

}