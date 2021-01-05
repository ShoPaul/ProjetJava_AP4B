package com.utbm.projet;

import java.awt.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Population {
	
	private List listColony;
	public Button populationButton;
	public Stage populationStage = new Stage();
	
    Population() {
    	populationButton = new Button ("Population");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(populationButton);
    	populationStage.setTitle("Survival on a planet: Population Menu");
    	populationStage.setResizable(false);
    }    

    public List getListColony() {
        // TODO implement here
        return null;
    }

    public boolean listColonyIsEmpty(List listColony) {
        // TODO implement here
        return false;
    }
    
    public void showPopulationStage() {
    	this.populationStage.show();
    }

	public void onPopulationButtonClick(ActionEvent e) {
		if (!this.populationStage.isShowing()) {
			showPopulationStage();
			System.out.println("The user clicked on Population Button. Population's window is displayed.");
		} else {
			System.out.println("Error, Population's window is already displayed.");
		}
		
	}
}