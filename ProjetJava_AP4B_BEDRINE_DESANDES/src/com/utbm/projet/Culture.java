package com.utbm.projet;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Culture {
	
	public Button cultureButton;
	public Stage cultureStage = new Stage();
	public Button vegetablesButton = new Button(listeCultures.Vegetables.nameResearch);
	public VBox cultureVbox = new VBox(20);
	private Scene cultureScene = new Scene(cultureVbox, 400, 600);

    Culture() {
    	cultureButton = new Button ("Culture");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(cultureButton);
    	bp.adaptButton(vegetablesButton);
    	cultureVbox.getChildren().addAll(vegetablesButton);
    	cultureVbox.setAlignment(Pos.TOP_CENTER);
    	VBox.setMargin(vegetablesButton, new Insets(20, 0, 0, 0));
    	cultureStage.setTitle("Survival on a planet: Culture Menu");
    	cultureStage.setScene(cultureScene);
    	cultureStage.setResizable(false);
    }

    public void searchNewCulture(Economy eco) {
    	this.vegetablesButton.setOnAction((e) -> this.onVegetablesButtonClick(e, listeCultures.Vegetables, eco));
    }

    private void onVegetablesButtonClick(ActionEvent e, listeCultures vegetables, Economy eco) {
    	if(eco.oxygeneNumber > vegetables.oxygeneCost && eco.diazoteNumber > vegetables.diazoteCost && eco.hydrogeneNumber > vegetables.hydrogeneCost && eco.carboneNumber > vegetables.carboneCost) {
    		int newOxygeneNumber = eco.oxygeneNumber - vegetables.oxygeneCost;
        	int newDiazoteNumber = eco.diazoteNumber - vegetables.diazoteCost;
        	int newHydrogeneNumber = eco.hydrogeneNumber - vegetables.hydrogeneCost;
        	int newCarboneNumber = eco.carboneNumber - vegetables.carboneCost;
        	eco.setEconomy(newOxygeneNumber, newDiazoteNumber, newHydrogeneNumber, newCarboneNumber);
    		this.vegetablesButton.setVisible(false);
    		System.out.println("Vegetables research purchased !");
    	} else {
    		System.out.println("Error, the user doesn't have enough resources to purchase this research !");
    	}
	}

	public void upgradeCulture() {

    }

    public void cancelCultureResearch() {

    }


    public enum listeCultures {
    	Vegetables("Légumes", 20, 20, 0, 10, 10, 5, 5, 0),
    	Test("Légumes", 20, 20, 0, 10, 10, 5, 5, 0);
    	
    	private static final Map<String, listeCultures> BY_NAME = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_OX_COST = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_DIA_COST = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_HYD_COST = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_CAR_COST = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_OX_PROD = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_DIA_PROD = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_HYD_PROD = new HashMap<>();
    	private static final Map<Integer, listeCultures> BY_CAR_PROD = new HashMap<>();
    	
    	static {
            for (listeCultures e : values()) {
            	BY_NAME.put(e.nameResearch, e);
            	BY_OX_COST.put(e.oxygeneCost, e);
            	BY_DIA_COST.put(e.diazoteCost, e);
            	BY_HYD_COST.put(e.hydrogeneCost, e);
            	BY_CAR_COST.put(e.carboneCost, e);
            	BY_OX_PROD.put(e.oxygeneProd, e);
            	BY_DIA_PROD.put(e.diazoteProd, e);
            	BY_HYD_PROD.put(e.hydrogeneProd, e);
            	BY_CAR_PROD.put(e.carboneProd, e);
            }
        }
    	
    	public final String nameResearch;
    	public final int oxygeneCost;
    	public final int diazoteCost;
    	public final int hydrogeneCost;
    	public final int carboneCost;
    	public final int oxygeneProd;
    	public final int diazoteProd;
    	public final int hydrogeneProd;
    	public final int carboneProd;
    	
    	private listeCultures(String nameResearch, int oxygeneCost, int diazoteCost, int hydrogeneCost, int carboneCost, int oxygeneProd, int diazoteProd, int hydrogeneProd, int carboneProd) {
    		this.nameResearch = nameResearch;
            this.oxygeneCost = oxygeneCost;
            this.diazoteCost = diazoteCost;
            this.hydrogeneCost = hydrogeneCost;
            this.carboneCost = carboneCost;
            this.oxygeneProd = oxygeneProd;
            this.diazoteProd = diazoteProd;
            this.hydrogeneProd = hydrogeneProd;
            this.carboneProd = carboneProd;
        }
    	
    	public static listeCultures valueOfResearchName(String nameResearch) {
            return BY_NAME.get(nameResearch);
        }
    	public static listeCultures valueOfOxygeneCost(int oxygeneCost) {
            return BY_OX_COST.get(oxygeneCost);
        }
    	public static listeCultures valueOfDiazoteCost(int diazoteCost) {
            return BY_DIA_COST.get(diazoteCost);
        }
    	public static listeCultures valueOfHydrogeneCost(int hydrogeneCost) {
            return BY_HYD_COST.get(hydrogeneCost);
        }
    	public static listeCultures valueOfCarboneCost(int carboneCost) {
            return BY_CAR_COST.get(carboneCost);
        }
    	public static listeCultures valueOfOxygeneProd(int oxygeneProd) {
            return BY_OX_PROD.get(oxygeneProd);
        }
    	public static listeCultures valueOfDiazoteProd(int diazoteProd) {
            return BY_DIA_PROD.get(diazoteProd);
        }
    	public static listeCultures valueOfHydrogeneProd(int hydrogeneProd) {
            return BY_HYD_PROD.get(hydrogeneProd);
        }
    	public static listeCultures valueOfCarboneProd(int carboneProd) {
            return BY_CAR_PROD.get(carboneProd);
        }
    }
    
    public void showCultureStage() {
    	this.cultureStage.show();
    	this.cultureStage.centerOnScreen();
    }

	public void onCultureButtonClick(ActionEvent e, Economy eco) {
		if (!this.cultureStage.isShowing()) {
			this.searchNewCulture(eco);
			this.showCultureStage();
			System.out.println("The user clicked on Culture Button. Culture's window is displayed.");
		} else {
			System.out.println("Error, Culture's window is already displayed.");
		}
	}


}