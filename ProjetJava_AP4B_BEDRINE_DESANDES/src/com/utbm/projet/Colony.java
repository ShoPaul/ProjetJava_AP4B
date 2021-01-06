package com.utbm.projet;

import java.util.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Colony {

    private String colonyName;
    public static Stage colonyStage = new Stage();
    public static Button colonyButton;    
    
    public List<String> listOutpost;
    
    Colony(String name) {
    	colonyName = name;
    }
    
    public static void setButton () {
    	colonyButton = new Button ("Colony");
    	ButtonPattern bp = new ButtonPattern();
    	bp.adaptButton(colonyButton);
    }

    public boolean listOupostIsEmpty(List<String> listColony) {
        // TODO implement here
        return false;
    }

    public List<String> getListOupost() {
        // TODO implement here
        return null;
    }
    
    public static void showColonyStage() {
    	colonyStage.setTitle("Survival on a planet: Colony Menu");
    	colonyStage.setResizable(false);
    	colonyStage.show();
    }

	public static void onColonyButtonClick(ActionEvent e, BorderPane root) {
		if (!colonyStage.isShowing()) {
			showColonyStage();
			//root.setDisable(true);
			System.out.println("The user clicked on Colony Button. Colony's window is displayed.");
		} else {
			System.out.println("Error, Colony's window is already displayed.");
		}
	}

}