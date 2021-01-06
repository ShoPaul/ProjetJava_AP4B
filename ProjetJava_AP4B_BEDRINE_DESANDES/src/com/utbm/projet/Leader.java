package com.utbm.projet;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Leader{
	
	public Button leaderButton;
	public Stage leaderStage = new Stage();

    Leader() {
    	leaderButton = new Button ("Leader");
    	ButtonPattern bp = new ButtonPattern();
    	bp.adaptButton(leaderButton);
    	leaderStage.setTitle("Survival on a planet: Leader Menu");
    	leaderStage.setResizable(false);
    }

    public void delockLeader() {
        // TODO implement here
    }

    public enum listeDirigeants {
    }
    
    public void showLeaderStage() {
    	this.leaderStage.show();
    	this.leaderStage.centerOnScreen();
    }

	public void onLeaderButtonClick(ActionEvent e, BorderPane root) {
		if (!this.leaderStage.isShowing()) {
			showLeaderStage();
			root.setDisable(true);
			System.out.println("The user clicked on Leader Button. Leader's window is displayed.");
		} else {
			System.out.println("Error, Leader's window is already displayed.");
		}
		
	}

}