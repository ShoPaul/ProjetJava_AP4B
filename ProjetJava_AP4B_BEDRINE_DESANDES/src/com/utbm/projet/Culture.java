package com.utbm.projet;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Culture {
	
	public Button cultureButton;
	public Stage cultureStage = new Stage();

    Culture() {
    	cultureButton = new Button ("Culture");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(cultureButton);
    	cultureStage.setTitle("Survival on a planet: Culture Menu");
    	cultureStage.setResizable(false);
    }

    public void searchNewCulture() {

    }

    public void upgradeCulture() {

    }

    public void cancelCultureResearch() {

    }


    public enum listeCultures {
    }
    
    public void showCultureStage(Culture culture) {
    	culture.cultureStage.show();
    }

	public void onCultureButtonClick(ActionEvent e, Culture clt) {
		if (!clt.cultureStage.isShowing()) {
			showCultureStage(clt);
			System.out.println("The user clicked on Culture Button. Culture's window is displayed.");
		} else {
			System.out.println("Error, Culture's window is already displayed.");
		}
		
	}


}