package com.utbm.projet;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Medecine {
	
	public Button medecineButton;
	public Stage medecineStage = new Stage();

	Medecine() {
		medecineButton = new Button ("Medecine");
		ButtonPattern bp = new ButtonPattern();
		bp.adaptButton(medecineButton);
		medecineStage.setTitle("Survival on a planet: Medecine Menu");
		medecineStage.setResizable(false);
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
    
    public void showMedecineStage(Medecine medecine) {
    	medecine.medecineStage.show();
    }

	public void onMedecineButtonClick(ActionEvent e, Medecine med) {
		if (!med.medecineStage.isShowing()) {
			showMedecineStage(med);
			System.out.println("The user clicked on Medecine Button. Medecine's window is displayed.");
		} else {
			System.out.println("Error, Medecine's window is already displayed.");
		}
		
	}

}