package com.utbm.projet;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Culture {

	public Button cultureButton;
	public Stage cultureStage = new Stage();
	public VBox cultureVbox = new VBox(20);
	private Scene cultureScene = new Scene(cultureVbox, 400, 600);

	private Button vegetablesButton = new Button(listeCultures.Vegetables.nameResearch);
	private Label vegetablesInfosCost = new Label("test");
	private Label vegetablesInfosProd = new Label("test");
	private VBox vegetablesInfosVBox = new VBox(20);
	private HBox vegetablesHBox = new HBox(20);
	
	private Button fruitsButton = new Button(listeCultures.Fruits.nameResearch);
	private Label fruitsInfosCost = new Label();
	private Label fruitsInfosProd = new Label();
	private VBox fruitsInfosVBox = new VBox(20);
	private HBox fruitsHBox = new HBox(20);

	Culture() {
		ButtonPattern bp = new ButtonPattern();

		cultureButton = new Button("Culture");

		bp.adaptButton(cultureButton);

		bp.adaptButton(vegetablesButton);
		bp.adaptButton(fruitsButton);
		
		setLabelsCultureInfos(vegetablesInfosCost, vegetablesInfosProd, vegetablesInfosVBox, listeCultures.Vegetables);
		setLabelsCultureInfos(fruitsInfosCost, fruitsInfosProd, fruitsInfosVBox, listeCultures.Fruits);

		vegetablesHBox.getChildren().addAll(vegetablesButton, vegetablesInfosVBox);
		vegetablesHBox.setAlignment(Pos.CENTER);
		
		fruitsHBox.getChildren().addAll(fruitsButton, fruitsInfosVBox);
		fruitsHBox.setAlignment(Pos.CENTER);
		
		cultureVbox.getChildren().addAll(vegetablesHBox, fruitsHBox);
		cultureVbox.setAlignment(Pos.TOP_CENTER);
		VBox.setMargin(vegetablesHBox, new Insets(20, 0, 0, 0));

		cultureStage.setTitle("Survival on a planet: Culture Menu");
		cultureStage.setScene(cultureScene);
		cultureStage.setResizable(false);
	}
	
	private void setLabelsCultureInfos(Label infosCost, Label infosProd, VBox vboxInfo, listeCultures cultureSearch) {
		infosCost.setText("Coût : " + cultureSearch.oxygeneCost + " ox, "
				+ cultureSearch.diazoteCost + " dia, " + cultureSearch.hydrogeneCost + " hyd, "
				+ cultureSearch.carboneCost + " car");
		infosProd.setText("Production : " + cultureSearch.oxygeneProd + " ox, "
				+ cultureSearch.diazoteProd + " dia, " + cultureSearch.hydrogeneProd + " hyd, "
				+ cultureSearch.carboneProd + " car");
		vboxInfo.getChildren().addAll(infosCost, infosProd);
		vboxInfo.setAlignment(Pos.CENTER_LEFT);
	}

	public void searchNewCulture(Economy eco) {
		this.vegetablesButton.setOnAction((e) -> this.onVegetablesButtonClick(e, listeCultures.Vegetables, eco));
		this.fruitsButton.setOnAction((e) -> this.onFruitsButtonClick(e, listeCultures.Fruits, eco));
	}

	private void onFruitsButtonClick(ActionEvent e, listeCultures fruits, Economy eco) {
		if (eco.oxygeneNumber > fruits.oxygeneCost && eco.diazoteNumber > fruits.diazoteCost
				&& eco.hydrogeneNumber > fruits.hydrogeneCost && eco.carboneNumber > fruits.carboneCost) {
			eco.oxygeneNumber -= fruits.oxygeneCost;
			eco.diazoteNumber -= fruits.diazoteCost;
			eco.hydrogeneNumber -= fruits.hydrogeneCost;
			eco.carboneNumber -= fruits.carboneCost;
			
			eco.oxygeneProdSeconde += fruits.oxygeneProd;
			eco.diazoteProdSeconde += fruits.diazoteProd;
			eco.hydrogeneProdSeconde += fruits.hydrogeneProd;
			eco.carboneProdSeconde += fruits.carboneProd;
			
			this.fruitsButton.setVisible(false);
			System.out.println("Fruits research purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	private void onVegetablesButtonClick(ActionEvent e, listeCultures vegetables, Economy eco) {
		if (eco.oxygeneNumber > vegetables.oxygeneCost && eco.diazoteNumber > vegetables.diazoteCost
				&& eco.hydrogeneNumber > vegetables.hydrogeneCost && eco.carboneNumber > vegetables.carboneCost) {
			eco.oxygeneNumber -= vegetables.oxygeneCost;
			eco.diazoteNumber -= vegetables.diazoteCost;
			eco.hydrogeneNumber -= vegetables.hydrogeneCost;
			eco.carboneNumber -= vegetables.carboneCost;
			
			eco.oxygeneProdSeconde += vegetables.oxygeneProd;
			eco.diazoteProdSeconde += vegetables.diazoteProd;
			eco.hydrogeneProdSeconde += vegetables.hydrogeneProd;
			eco.carboneProdSeconde += vegetables.carboneProd;
			
			this.vegetablesButton.setVisible(false);
			System.out.println("Vegetables research purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	public enum listeCultures {
		Vegetables("Légumes", 20, 20, 0, 10, 10, 5, 5, 0), Fruits("Fruits", 100, 50, 0, 15, 22, 5, 10, 2);

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

		private listeCultures(String nameResearch, int oxygeneCost, int diazoteCost, int hydrogeneCost, int carboneCost,
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
			//this.searchNewCulture(eco);
			this.showCultureStage();
			System.out.println("The user clicked on Culture Button. Culture's window is displayed.");
		} else {
			System.out.println("Error, Culture's window is already displayed.");
		}
	}

}