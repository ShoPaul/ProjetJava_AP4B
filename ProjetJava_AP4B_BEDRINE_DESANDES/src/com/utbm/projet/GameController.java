package com.utbm.projet;

import java.util.*;

public class GameController {

    GameController() {
    }

    public void startGame() {
        // TODO implement here
    }

    public void loadGame() {
        // TODO implement here
    }

    public void logging() {
        // TODO implement here
    }

    public void createAccount() {
        // TODO implement here
    }

    public void saveGame() {
        // TODO implement here
    }
    
    public static boolean createColony (int [] costs, String name, Economy eco) {
    	int [] resources = {eco.carboneNumber,eco.diazoteNumber,eco.hydrogeneNumber,eco.oxygeneNumber};
    	boolean enoughResources = true;
    	for (int i = 0; i <4; i++) {
    		if (costs [i] > resources [i]) {
    			enoughResources = false;
    		}
    	}
    	//Warning ! The list costs must contain needed resources in the following order : carbon, diazote, hydrogen, oxygen
    	if (enoughResources) {
    		eco.carboneNumber -= costs [0];
    		eco.diazoteNumber -= costs [1];
    		eco.hydrogeneNumber -= costs [2];
    		eco.oxygeneNumber -= costs [3];
    		
    		return true;
    	} else {
    		System.out.println ("Insufficient resources, you cannot create a new colony");
    		return false;
    	}
    	
    }

}