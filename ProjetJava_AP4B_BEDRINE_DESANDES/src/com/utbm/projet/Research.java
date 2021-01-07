package com.utbm.projet;

import java.util.HashMap;
import java.util.Map;

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

	public Button fertileLandButton = new Button();
	private Label fertileLandInfosCost = new Label();
	private Label fertileLandInfosProd = new Label();
	private VBox fertileLandInfosVBox = new VBox(20);
	private HBox fertileLandHBox = new HBox(20);
	
	public Button alienLifeButton = new Button();
	private Label alienLifeInfosCost = new Label();
	private Label alienLifeInfosProd = new Label();
	private VBox alienLifeInfosVBox = new VBox(20);
	private HBox alienLifeHBox = new HBox(20);

	Research() {
		ButtonPattern bp = new ButtonPattern();

		researchButton = new Button("Research");

		bp.adaptButton(researchButton);

		bp.adaptButton(fertileLandButton);
		bp.adaptButton(alienLifeButton);

		setLabelsInfos(fertileLandButton, fertileLandInfosCost, fertileLandInfosProd, listeResearch.FertileLand1);
		setLabelsInfos(alienLifeButton, alienLifeInfosCost, alienLifeInfosProd, listeResearch.AlienLife1);

		fertileLandInfosVBox.getChildren().addAll(fertileLandInfosCost, fertileLandInfosProd);
		fertileLandInfosVBox.setAlignment(Pos.CENTER_LEFT);

		fertileLandHBox.getChildren().addAll(fertileLandButton, fertileLandInfosVBox);
		fertileLandHBox.setAlignment(Pos.CENTER);
		
		alienLifeInfosVBox.getChildren().addAll(alienLifeInfosCost, alienLifeInfosProd);
		alienLifeInfosVBox.setAlignment(Pos.CENTER_LEFT);
		
		alienLifeHBox.getChildren().addAll(alienLifeButton, alienLifeInfosVBox);
		alienLifeHBox.setAlignment(Pos.CENTER);

		researchVBox.getChildren().addAll(fertileLandHBox, alienLifeHBox);
		fertileLandHBox.setAlignment(Pos.TOP_CENTER);
		VBox.setMargin(fertileLandHBox, new Insets(20, 0, 0, 0));

		researchStage.setTitle("Survival on a planet: Research Menu");
		researchStage.setScene(researchScene);
		researchStage.setResizable(false);
	}

	private void setLabelsInfos(Button button, Label infosCost, Label infosProd, listeResearch research) {
		button.setText(research.nameResearch);
		infosCost.setText("Coût : " + research.oxygeneCost + " ox, " + research.diazoteCost + " dia, "
				+ research.hydrogeneCost + " hyd, " + research.carboneCost + " car");
		infosProd.setText("Production : " + research.oxygeneProd + " ox, " + research.diazoteProd + " dia, "
				+ research.hydrogeneProd + " hyd, " + research.carboneProd + " car");
	}

	public void searchNewResearch(Economy eco) {
		this.fertileLandButton.setOnAction((e) -> this.onFertileLandButtonClick(e, eco));
		this.alienLifeButton.setOnAction((e) -> this.onAlienLifeLandButtonClick(e, eco));
	}

	private void onAlienLifeLandButtonClick(ActionEvent e, Economy eco) {
		if (this.alienLifeButton.getText() == listeResearch.AlienLife1.nameResearch) {
			if (setEconomy(eco, listeResearch.AlienLife1)) {
				setLabelsInfos(alienLifeButton, alienLifeInfosCost, alienLifeInfosProd,
						listeResearch.AlienLife2);
			}
		} else if (this.alienLifeButton.getText() == listeResearch.AlienLife2.nameResearch) {
			if (setEconomy(eco, listeResearch.AlienLife2)) {
				setLabelsInfos(alienLifeButton, alienLifeInfosCost, alienLifeInfosProd,
						listeResearch.AlienLife3);
			}
		} else if (this.alienLifeButton.getText() == listeResearch.AlienLife3.nameResearch) {
			if (setEconomy(eco, listeResearch.AlienLife3)) {
				setLabelsInfos(alienLifeButton, alienLifeInfosCost, alienLifeInfosProd,
						listeResearch.AlienLife4);
			}	
		
		} else {
			if (setEconomy(eco, listeResearch.AlienLife4)) {
				this.alienLifeButton.setBackground(new Background(new BackgroundImage(
						new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
						BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						new BackgroundSize(0, 0, false, false, false, true))));
				this.alienLifeButton.setTextFill(Color.WHITE);

				this.alienLifeButton.setDisable(true);
			}
		}
	}

	private void onFertileLandButtonClick(ActionEvent e, Economy eco) {
		if (this.fertileLandButton.getText() == listeResearch.FertileLand1.nameResearch) {
			if (setEconomy(eco, listeResearch.FertileLand1)) {
				setLabelsInfos(fertileLandButton, fertileLandInfosCost, fertileLandInfosProd,
						listeResearch.FertileLand2);
			}
		} else if (this.fertileLandButton.getText() == listeResearch.FertileLand2.nameResearch) {
			if (setEconomy(eco, listeResearch.FertileLand2)) {
				setLabelsInfos(fertileLandButton, fertileLandInfosCost, fertileLandInfosProd,
						listeResearch.FertileLand3);
			}
		} else {
			if (setEconomy(eco, listeResearch.FertileLand3)) {
				this.fertileLandButton.setBackground(new Background(new BackgroundImage(
						new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
						BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						new BackgroundSize(0, 0, false, false, false, true))));
				this.fertileLandButton.setTextFill(Color.WHITE);

				this.fertileLandButton.setDisable(true);
			}
		}
	}

	private boolean setEconomy(Economy eco, listeResearch research) {
		if (eco.oxygeneNumber > research.oxygeneCost && eco.diazoteNumber > research.diazoteCost
				&& eco.hydrogeneNumber > research.hydrogeneCost && eco.carboneNumber > research.carboneCost) {
			eco.oxygeneNumber -= research.oxygeneCost;
			eco.diazoteNumber -= research.diazoteCost;
			eco.hydrogeneNumber -= research.hydrogeneCost;
			eco.carboneNumber -= research.carboneCost;

			eco.oxygeneProdSeconde += research.oxygeneProd;
			eco.diazoteProdSeconde += research.diazoteProd;
			eco.hydrogeneProdSeconde += research.hydrogeneProd;
			eco.carboneProdSeconde += research.carboneProd;

			System.out.println(research.nameResearch + " has been purchased !");

			return true;
		} else {
			System.out.println(
					"Error, the user doesn't have enough resources to purchase " + research.nameResearch + " !");

			return false;
		}
	}

	public enum listeResearch {
		FertileLand1("Terre fertile niv 1", 500, 450, 200, 350, 100, 0, 0, 100),
		FertileLand2("Terre fertile niv 2", 1000, 900, 400, 700, 150, 0, 25, 125),
		FertileLand3("Terre fertile niv 3", 2500, 2250, 1400, 1800, 250, 25, 100, 175),
		AlienLife1("Vie d'Aliens niv 1", 250, 800, 50, 700, 50, 250, 10, 150),
		AlienLife2("Vie d'Aliens niv 2", 750, 2500, 350, 2000, 100, 500, 50, 300),
		AlienLife3("Vie d'Aliens niv 3", 2150, 7500, 1500, 5550, 200, 750, 100, 600),
		AlienLife4("Vie d'Aliens niv 4", 5600, 22500, 4500, 16800, 250, 1250, 150, 900);

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