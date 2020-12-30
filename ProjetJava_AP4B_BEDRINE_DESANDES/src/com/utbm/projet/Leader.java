package com.utbm.projet;

import javafx.scene.control.Button;

public class Leader{
	
	public Button button;

    Leader() {
    	button = new Button ("Leader");
    	ButtonPattern bp = new ButtonPattern();
    	bp.adaptButton(button);
    }

    public void delockLeader() {
        // TODO implement here
    }

    public enum listeDirigeants {
    }

}