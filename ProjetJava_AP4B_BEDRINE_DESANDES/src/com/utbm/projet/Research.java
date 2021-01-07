package com.utbm.projet;

import java.util.HashMap;
import java.util.Map;

import com.utbm.projet.Culture.listeCultures;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Research {
	
	public Button researchButton;
	public Stage researchStage = new Stage();
	public VBox researchVBox = new VBox(20);
	private Scene researchScene = new Scene(researchVBox, 400, 600);
	
	public Button fertileLandButton = new Button(listeResearch.FertileLand1.nameResearch);
	private Label fertileLandInfosCost = new Label();
	private Label fertileLandInfosProd = new Label();
	private VBox fertileLandInfosVBox = new VBox(20);
	private HBox fertileLandHBox = new HBox(20);
	
    Research() {
    	ButtonPattern bp = new ButtonPattern ();
    	
    	researchButton = new Button ("Research");
    	
    	bp.adaptButton(researchButton);
    	
    	bp.adaptButton(fertileLandButton);
    	
    	setLabelsInfos(fertileLandInfosCost, fertileLandInfosProd, fertileLandInfosVBox, listeResearch.FertileLand1);
    	
    	fertileLandHBox.getChildren().addAll(fertileLandButton, fertileLandInfosVBox);
    	fertileLandHBox.setAlignment(Pos.CENTER);
    	
    	researchVBox.getChildren().addAll(fertileLandHBox);
    	fertileLandHBox.setAlignment(Pos.TOP_CENTER);
    	VBox.setMargin(fertileLandHBox, new Insets(20, 0, 0, 0));
    	
    	researchStage.setTitle("Survival on a planet: Research Menu");
    	researchStage.setScene(researchScene);
    	researchStage.setResizable(false);
    }

    private void setLabelsInfos(Label infosCost, Label infosProd, VBox vboxInfo,
			listeResearch research) {
    	infosCost.setText("Coût : " + research.oxygeneCost + " ox, " + research.diazoteCost + " dia, "
				+ research.hydrogeneCost + " hyd, " + research.carboneCost + " car");
		infosProd.setText("Production : " + research.oxygeneProd + " ox, " + research.diazoteProd + " dia, "
				+ research.hydrogeneProd + " hyd, " + research.carboneProd + " car");
		vboxInfo.getChildren().addAll(infosCost, infosProd);
		vboxInfo.setAlignment(Pos.CENTER_LEFT);
	}
    
    public void searchNewResearch(Economy eco) {
    	if (this.fertileLandButton.getText() == listeResearch.FertileLand1.nameResearch) {
    		this.fertileLandButton.setOnAction((e) -> this.onFertileLandButtonClick(e, listeResearch.FertileLand1, eco));
    	} else if (this.fertileLandButton.getText() == listeResearch.FertileLand2.nameResearch) {
    		this.fertileLandButton.setOnAction((e) -> this.onFertileLandButtonClick(e, listeResearch.FertileLand2, eco));
    	} else {
    		this.fertileLandButton.setOnAction((e) -> this.onFertileLandButtonClick(e, listeResearch.FertileLand3, eco));
    		
    		this.fertileLandButton.setBackground(new Background(new BackgroundImage(
					new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 0, false, false, false, true))));
			this.fertileLandButton.setTextFill(Color.WHITE);
    		
    		this.fertileLandButton.setDisable(true);
    	}
	}

	private void onFertileLandButtonClick(ActionEvent e, listeResearch fertileLand, Economy eco) {
		if (eco.oxygeneNumber > fertileLand.oxygeneCost && eco.diazoteNumber > fertileLand.diazoteCost && eco.hydrogeneNumber > fertileLand.hydrogeneCost && eco.carboneNumber > fertileLand.carboneCost) {
			eco.oxygeneNumber -= fertileLand.oxygeneCost;
			eco.diazoteNumber -= fertileLand.diazoteCost;
			eco.hydrogeneNumber -= fertileLand.hydrogeneCost;
			eco.carboneNumber -= fertileLand.carboneCost;

			eco.oxygeneProdSeconde += fertileLand.oxygeneProd;
			eco.diazoteProdSeconde += fertileLand.diazoteProd;
			eco.hydrogeneProdSeconde += fertileLand.hydrogeneProd;
			eco.carboneProdSeconde += fertileLand.carboneProd;
			
			System.out.println(fertileLand.nameResearch);
		}
	}

	public enum listeResearch {
    	FertileLand1("Terre fertile niv 1", 500, 450, 200, 350, 100, 0, 0, 100),
    	FertileLand2("Terre fertile niv 2", 1000, 900, 400, 700, 150, 0, 25, 125),
    	FertileLand3("Terre fertile niv 3", 2500, 2250, 1400, 1800, 250, 25, 100, 175);
    	
    	private static final Map<String, listeResearch> BY_NAME = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_OX_COST = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_DIA_COST = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_HYD_COST = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_CAR_COST = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_OX_PROD = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_DIA_PROD = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_HYD_PROD = new HashMap<>();
		private static final Map<Integer, listeResearch> BY_CAR_PROD = new HashMap<>();
		
		static {
			for (listeResearch e : values()) {
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
		
		private listeResearch(String nameResearch, int oxygeneCost, int diazoteCost, int hydrogeneCost, int carboneCost,
				int oxygeneProd, int diazoteProd, int hydrogeneProd, int carboneProd) {
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
		
		public static listeResearch valueOfResearchName(String nameResearch) {
			return BY_NAME.get(nameResearch);
		}

		public static listeResearch valueOfOxygeneCost(int oxygeneCost) {
			return BY_OX_COST.get(oxygeneCost);
		}

		public static listeResearch valueOfDiazoteCost(int diazoteCost) {
			return BY_DIA_COST.get(diazoteCost);
		}

		public static listeResearch valueOfHydrogeneCost(int hydrogeneCost) {
			return BY_HYD_COST.get(hydrogeneCost);
		}

		public static listeResearch valueOfCarboneCost(int carboneCost) {
			return BY_CAR_COST.get(carboneCost);
		}

		public static listeResearch valueOfOxygeneProd(int oxygeneProd) {
			return BY_OX_PROD.get(oxygeneProd);
		}

		public static listeResearch valueOfDiazoteProd(int diazoteProd) {
			return BY_DIA_PROD.get(diazoteProd);
		}

		public static listeResearch valueOfHydrogeneProd(int hydrogeneProd) {
			return BY_HYD_PROD.get(hydrogeneProd);
		}

		public static listeResearch valueOfCarboneProd(int carboneProd) {
			return BY_CAR_PROD.get(carboneProd);
		}
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