package com.utbm.projet;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Research {
	
	public Button researchButton;
	public Stage researchStage = new Stage();
	
    Research() {
    	researchButton = new Button ("Research");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(researchButton);
    	researchStage.setTitle("Survival on a planet: Research Menu");
    	researchStage.setResizable(false);
    }

    public void doResearch() {
        // TODO implement here
    }

    public void cancelResearch() {
        // TODO implement here
    }

    public enum listeRecherches {
    }
    
    public void showResearchStage() {
    	this.researchStage.show();
    	this.researchStage.centerOnScreen();
    }

	public void onResearchButtonClick(ActionEvent e, Economy eco, BorderPane root) {
		if (!this.researchStage.isShowing()) {
			showResearchStage();
			root.setDisable(true);
			System.out.println("The user clicked on Research Button. Research's window is displayed.");
		} else {
			System.out.println("Error, Research's window is already displayed.");
		}
		
	}

}