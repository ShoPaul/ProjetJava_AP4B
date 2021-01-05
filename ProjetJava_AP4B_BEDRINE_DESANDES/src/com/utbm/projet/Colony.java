package com.utbm.projet;

import java.util.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Colony {

    private String colonyName;
    public Stage colonyStage = new Stage();
    public Button colonyButton;
    
    public List<String> listOutpost;
    
    Colony(String name) {
    	colonyName = name;
    	colonyButton = new Button ("Colony");
		ButtonPattern bp = new ButtonPattern();
		bp.adaptButton(colonyButton);
    	colonyStage.setTitle("Survival on a planet: Colony Menu");
    	colonyStage.setResizable(false);
    }

    public void setColonyName(String colonieName) {
        // TODO implement here
    }


    public String getColonyName() {
        // TODO implement here
        return "";
    }

    public boolean listOupostIsEmpty(List<String> listColony) {
        // TODO implement here
        return false;
    }

    public List<String> getListOupost() {
        // TODO implement here
        return null;
    }
    
    public void showColonyStage() {
    	this.colonyStage.show();
    }

	public void onColonyButtonClick(ActionEvent e) {
		if (!this.colonyStage.isShowing()) {
			showColonyStage();
			System.out.println("The user clicked on Colony Button. Colony's window is displayed.");
		} else {
			System.out.println("Error, Colony's window is already displayed.");
		}
	}

}