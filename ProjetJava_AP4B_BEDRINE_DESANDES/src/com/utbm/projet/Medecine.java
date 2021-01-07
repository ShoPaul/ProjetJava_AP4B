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

public class Medecine {
	
	public Button medecineButton;
	public Stage medecineStage = new Stage();
	public VBox medecineVbox = new VBox(20);
	private Scene medecineScene = new Scene(medecineVbox, 450, 600);
	
	private Button antalgiqueButton = new Button(listeMedicaments.Antalgique.nameResearch);
	private Label antalgiqueInfosCost = new Label();
	private Label antalgiqueInfosProd = new Label();
	private VBox antalgiqueInfosVBox = new VBox(20);
	private HBox antalgiqueHBox = new HBox(20);
	
	private Button antipyretiqueButton = new Button(listeMedicaments.Antipyretique.nameResearch);
	private Label antipyretiqueInfosCost = new Label();
	private Label antipyretiqueInfosProd = new Label();
	private VBox antipyretiqueInfosVBox = new VBox(20);
	private HBox antipyretiqueHBox = new HBox(20);
	
	private Button anticoagulantButton = new Button(listeMedicaments.Anticoagulant.nameResearch);
	private Label anticoagulantInfosCost = new Label();
	private Label anticoagulantInfosProd = new Label();
	private VBox anticoagulantInfosVBox = new VBox(20);
	private HBox anticoagulantHBox = new HBox(20);

	Medecine() {
		ButtonPattern bp = new ButtonPattern();
		
		medecineButton = new Button ("Medecine");
		
		bp.adaptButton(medecineButton);
		
		bp.adaptButton(antalgiqueButton);
		bp.adaptButton(antipyretiqueButton);
		bp.adaptButton(anticoagulantButton);
		
		setLabelsMedecineInfos(antalgiqueInfosCost, antalgiqueInfosProd, antalgiqueInfosVBox, listeMedicaments.Antalgique);
		setLabelsMedecineInfos(antipyretiqueInfosCost, antipyretiqueInfosProd, antipyretiqueInfosVBox, listeMedicaments.Antipyretique);
		setLabelsMedecineInfos(anticoagulantInfosCost, anticoagulantInfosProd, anticoagulantInfosVBox, listeMedicaments.Anticoagulant);
		
		antalgiqueHBox.getChildren().addAll(antalgiqueButton, antalgiqueInfosVBox);
		antalgiqueHBox.setAlignment(Pos.CENTER);

		antipyretiqueHBox.getChildren().addAll(antipyretiqueButton, antipyretiqueInfosVBox);
		antipyretiqueHBox.setAlignment(Pos.CENTER);
		
		anticoagulantHBox.getChildren().addAll(anticoagulantButton, anticoagulantInfosVBox);
		anticoagulantHBox.setAlignment(Pos.CENTER);

		medecineVbox.getChildren().addAll(antalgiqueHBox, antipyretiqueHBox, anticoagulantHBox);
		medecineVbox.setAlignment(Pos.TOP_CENTER);
		VBox.setMargin(antalgiqueHBox, new Insets(20, 0, 0, 0));
		
		medecineStage.setTitle("Survival on a planet: Medecine Menu");
		medecineStage.setScene(medecineScene);
		medecineStage.setResizable(false);
    }
	
	private void setLabelsMedecineInfos(Label infosCost, Label infosProd, VBox vboxInfo, listeMedicaments medic) {
		infosCost.setText("Coût : " + medic.oxygeneCost + " ox, " + medic.diazoteCost + " dia, "
				+ medic.hydrogeneCost + " hyd, " + medic.carboneCost + " car");
		infosProd.setText("Production : " + medic.oxygeneProd + " ox, " + medic.diazoteProd + " dia, "
				+ medic.hydrogeneProd + " hyd, " + medic.carboneProd + " car");
		vboxInfo.getChildren().addAll(infosCost, infosProd);
		vboxInfo.setAlignment(Pos.CENTER_LEFT);
	}

    public void searchNewMedic(Economy eco) {
    	this.antalgiqueButton.setOnAction((e) -> this.onAntalgiqueButtonClick(e, listeMedicaments.Antalgique, eco));
		this.antipyretiqueButton.setOnAction((e) -> this.onAntipyretiqueButtonClick(e, listeMedicaments.Antipyretique, eco));
		this.anticoagulantButton.setOnAction((e) -> this.onAnticoagulantButtonClick(e, listeMedicaments.Anticoagulant, eco));
    }

	private void onAnticoagulantButtonClick(ActionEvent e, listeMedicaments anticoagulant, Economy eco) {
		if (eco.oxygeneNumber > anticoagulant.oxygeneCost && eco.diazoteNumber > anticoagulant.diazoteCost
				&& eco.hydrogeneNumber > anticoagulant.hydrogeneCost && eco.carboneNumber > anticoagulant.carboneCost) {
			eco.oxygeneNumber -= anticoagulant.oxygeneCost;
			eco.diazoteNumber -= anticoagulant.diazoteCost;
			eco.hydrogeneNumber -= anticoagulant.hydrogeneCost;
			eco.carboneNumber -= anticoagulant.carboneCost;

			eco.oxygeneProdSeconde += anticoagulant.oxygeneProd;
			eco.diazoteProdSeconde += anticoagulant.diazoteProd;
			eco.hydrogeneProdSeconde += anticoagulant.hydrogeneProd;
			eco.carboneProdSeconde += anticoagulant.carboneProd;

			anticoagulantButton.setBackground(new Background(new BackgroundImage(
					new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 0, false, false, false, true))));
			anticoagulantButton.setTextFill(Color.WHITE);
			
			anticoagulantButton.setDisable(true);
			System.out.println(anticoagulant.nameResearch + " has been purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	private void onAntipyretiqueButtonClick(ActionEvent e, listeMedicaments antipyretique, Economy eco) {
		if (eco.oxygeneNumber > antipyretique.oxygeneCost && eco.diazoteNumber > antipyretique.diazoteCost
				&& eco.hydrogeneNumber > antipyretique.hydrogeneCost && eco.carboneNumber > antipyretique.carboneCost) {
			eco.oxygeneNumber -= antipyretique.oxygeneCost;
			eco.diazoteNumber -= antipyretique.diazoteCost;
			eco.hydrogeneNumber -= antipyretique.hydrogeneCost;
			eco.carboneNumber -= antipyretique.carboneCost;

			eco.oxygeneProdSeconde += antipyretique.oxygeneProd;
			eco.diazoteProdSeconde += antipyretique.diazoteProd;
			eco.hydrogeneProdSeconde += antipyretique.hydrogeneProd;
			eco.carboneProdSeconde += antipyretique.carboneProd;

			antipyretiqueButton.setBackground(new Background(new BackgroundImage(
					new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 0, false, false, false, true))));
			antipyretiqueButton.setTextFill(Color.WHITE);
			
			antipyretiqueButton.setDisable(true);
			System.out.println(antipyretique.nameResearch + " has been purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	private void onAntalgiqueButtonClick(ActionEvent e, listeMedicaments antalgique, Economy eco) {
		if (eco.oxygeneNumber > antalgique.oxygeneCost && eco.diazoteNumber > antalgique.diazoteCost
				&& eco.hydrogeneNumber > antalgique.hydrogeneCost && eco.carboneNumber > antalgique.carboneCost) {
			eco.oxygeneNumber -= antalgique.oxygeneCost;
			eco.diazoteNumber -= antalgique.diazoteCost;
			eco.hydrogeneNumber -= antalgique.hydrogeneCost;
			eco.carboneNumber -= antalgique.carboneCost;

			eco.oxygeneProdSeconde += antalgique.oxygeneProd;
			eco.diazoteProdSeconde += antalgique.diazoteProd;
			eco.hydrogeneProdSeconde += antalgique.hydrogeneProd;
			eco.carboneProdSeconde += antalgique.carboneProd;

			antalgiqueButton.setBackground(new Background(new BackgroundImage(
					new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 0, false, false, false, true))));
			antalgiqueButton.setTextFill(Color.WHITE);
			
			antalgiqueButton.setDisable(true);
			System.out.println(antalgique.nameResearch + " has been purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	public enum listeMedicaments {
		Antalgique("Antalgique", 25000, 8900, 46000, 25000, 0, 500, 250, 0), 
		Antipyretique("Antipyrétique", 75000, 37800, 22700, 19600, 750, 600, 0, 150),
		Anticoagulant("Anticoagulant", 128600, 168200, 269025, 265820, 500, 1500, 2225, 2200);

		private static final Map<String, listeMedicaments> BY_NAME = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_OX_COST = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_DIA_COST = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_HYD_COST = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_CAR_COST = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_OX_PROD = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_DIA_PROD = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_HYD_PROD = new HashMap<>();
		private static final Map<Integer, listeMedicaments> BY_CAR_PROD = new HashMap<>();

		static {
			for (listeMedicaments e : values()) {
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

		private listeMedicaments(String nameResearch, int oxygeneCost, int diazoteCost, int hydrogeneCost, int carboneCost,
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

		public static listeMedicaments valueOfResearchName(String nameResearch) {
			return BY_NAME.get(nameResearch);
		}

		public static listeMedicaments valueOfOxygeneCost(int oxygeneCost) {
			return BY_OX_COST.get(oxygeneCost);
		}

		public static listeMedicaments valueOfDiazoteCost(int diazoteCost) {
			return BY_DIA_COST.get(diazoteCost);
		}

		public static listeMedicaments valueOfHydrogeneCost(int hydrogeneCost) {
			return BY_HYD_COST.get(hydrogeneCost);
		}

		public static listeMedicaments valueOfCarboneCost(int carboneCost) {
			return BY_CAR_COST.get(carboneCost);
		}

		public static listeMedicaments valueOfOxygeneProd(int oxygeneProd) {
			return BY_OX_PROD.get(oxygeneProd);
		}

		public static listeMedicaments valueOfDiazoteProd(int diazoteProd) {
			return BY_DIA_PROD.get(diazoteProd);
		}

		public static listeMedicaments valueOfHydrogeneProd(int hydrogeneProd) {
			return BY_HYD_PROD.get(hydrogeneProd);
		}

		public static listeMedicaments valueOfCarboneProd(int carboneProd) {
			return BY_CAR_PROD.get(carboneProd);
		}
	}
    
    public void showMedecineStage() {
    	this.medecineStage.show();
    	this.medecineStage.centerOnScreen();
    }

	public void onMedecineButtonClick(ActionEvent e, Economy eco, BorderPane root) {
		if (!this.medecineStage.isShowing()) {
			showMedecineStage();
			root.setDisable(true);
			System.out.println("The user clicked on Medecine Button. Medecine's window is displayed.");
		} else {
			System.out.println("Error, Medecine's window is already displayed.");
		}
	}

}