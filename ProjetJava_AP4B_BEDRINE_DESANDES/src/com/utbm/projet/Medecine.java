package com.utbm.projet;

import java.util.*;

import javafx.scene.control.Button;

public class Medecine {
	
	public Button button;

	Medecine() {
		button = new Button ("Medecine");
		ButtonPattern bp = new ButtonPattern();
		bp.adaptButton(button);
    }

    public void searchNewMedic() {
        // TODO implement here
    }

    public void upgradeMedic() {
        // TODO implement here
    }

    public void cancelMedicResearch() {
        // TODO implement here
    }

    public enum listeMedicaments {
    }

}