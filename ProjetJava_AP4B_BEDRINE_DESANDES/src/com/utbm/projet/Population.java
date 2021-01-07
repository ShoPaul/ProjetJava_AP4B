package com.utbm.projet;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Population {
	
	public Button populationButton;
	public Stage populationStage = new Stage();
	public VBox populationVbox = new VBox(20);
	private Scene populationScene = new Scene(populationVbox, 400, 600);
	
	private Button houseButton = new Button(listePopulations.House.nameResearch);
	private Label houseInfosCost = new Label();
	private Label houseInfosProd = new Label();
	private VBox houseInfosVBox = new VBox(20);
	private HBox houseHBox = new HBox(20);

	private Button skyscraperButton = new Button(listePopulations.Skyscraper.nameResearch);
	private Label skyscraperInfosCost = new Label();
	private Label skyscraperInfosProd = new Label();
	private VBox skyscraperInfosVBox = new VBox(20);
	private HBox skyscraperHBox = new HBox(20);
	
	public int population;
	public int bonusPopulation;
	public Label populationLabel = new Label ();
	public HBox popBox = new HBox (50);
	
    Population() {
    	population = 0;
    	populationButton = new Button ("Population");
    	ButtonPattern bp = new ButtonPattern ();
    	bp.adaptButton(populationButton);
    	
    	bp.adaptButton(houseButton);
		bp.adaptButton(skyscraperButton);

		setLabelsPopulationInfos(houseInfosCost, houseInfosProd, houseInfosVBox, listePopulations.House);
		setLabelsPopulationInfos(skyscraperInfosCost, skyscraperInfosProd, skyscraperInfosVBox, listePopulations.Skyscraper);

		houseHBox.getChildren().addAll(houseButton, houseInfosVBox);
		houseHBox.setAlignment(Pos.CENTER);

		skyscraperHBox.getChildren().addAll(skyscraperButton, skyscraperInfosVBox);
		skyscraperHBox.setAlignment(Pos.CENTER);

		populationVbox.getChildren().addAll(houseHBox, skyscraperHBox);
		populationVbox.setAlignment(Pos.TOP_CENTER);
		VBox.setMargin(houseHBox, new Insets(20, 0, 0, 0));
    	populationStage.setTitle("Survival on a planet: Population Menu");
    	populationStage.setScene(populationScene);
    	populationStage.setResizable(false);
    }    

    public void refreshPopulation(Population pop, Economy eco) {
    	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				population += bonusPopulation;
				populationLabel.setText("Population :	" + population);
				populationLabel.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 12));
				populationLabel.setTextFill(Color.WHITE);
				pop.searchNewPopulation(eco);
			}
    		
    	}));
    	
    	timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		popBox.getChildren().add(populationLabel);
		popBox.setAlignment(Pos.CENTER);
    }
    
    private void setLabelsPopulationInfos(Label infosCost, Label infosProd, VBox vboxInfo, listePopulations populationSearch) {
		infosCost.setText("Coût : " + populationSearch.oxygeneCost + " ox, " + populationSearch.diazoteCost + " dia, "
				+ populationSearch.hydrogeneCost + " hyd, " + populationSearch.carboneCost + " car");
		infosProd.setText("Production : " + populationSearch.oxygeneProd + " ox, " + populationSearch.diazoteProd + " dia, "
				+ populationSearch.hydrogeneProd + " hyd, " + populationSearch.carboneProd + " car, " + populationSearch.bonusPop + " pop");
		vboxInfo.getChildren().addAll(infosCost, infosProd);
		vboxInfo.setAlignment(Pos.CENTER_LEFT);
	}

	public void searchNewPopulation(Economy eco) {
		this.houseButton.setOnAction((e) -> this.onHouseButtonClick(e, listePopulations.House, eco));
		this.skyscraperButton.setOnAction((e) -> this.onSkyscraperButtonClick(e, listePopulations.Skyscraper, eco));
	}

	private void onSkyscraperButtonClick(ActionEvent e, listePopulations skyscraper, Economy eco) {
		if (eco.oxygeneNumber > skyscraper.oxygeneCost && eco.diazoteNumber > skyscraper.diazoteCost
				&& eco.hydrogeneNumber > skyscraper.hydrogeneCost && eco.carboneNumber > skyscraper.carboneCost) {
			eco.oxygeneNumber -= skyscraper.oxygeneCost;
			eco.diazoteNumber -= skyscraper.diazoteCost;
			eco.hydrogeneNumber -= skyscraper.hydrogeneCost;
			eco.carboneNumber -= skyscraper.carboneCost;

			eco.oxygeneProdSeconde += skyscraper.oxygeneProd;
			eco.diazoteProdSeconde += skyscraper.diazoteProd;
			eco.hydrogeneProdSeconde += skyscraper.hydrogeneProd;
			eco.carboneProdSeconde += skyscraper.carboneProd;
			this.bonusPopulation += skyscraper.bonusPop;

			skyscraperButton.setBackground(new Background(new BackgroundImage(
					new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 0, false, false, false, true))));
			skyscraperButton.setTextFill(Color.WHITE);
			
			skyscraperButton.setDisable(true);
			System.out.println("Skyscraper research purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	private void onHouseButtonClick(ActionEvent e, listePopulations house, Economy eco) {
		if (eco.oxygeneNumber > house.oxygeneCost && eco.diazoteNumber > house.diazoteCost
				&& eco.hydrogeneNumber > house.hydrogeneCost && eco.carboneNumber > house.carboneCost) {
			eco.oxygeneNumber -= house.oxygeneCost;
			eco.diazoteNumber -= house.diazoteCost;
			eco.hydrogeneNumber -= house.hydrogeneCost;
			eco.carboneNumber -= house.carboneCost;

			eco.oxygeneProdSeconde += house.oxygeneProd;
			eco.diazoteProdSeconde += house.diazoteProd;
			eco.hydrogeneProdSeconde += house.hydrogeneProd;
			eco.carboneProdSeconde += house.carboneProd;
			this.bonusPopulation += house.bonusPop;

			houseButton.setBackground(new Background(new BackgroundImage(
					new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/greyScreen.jpg")),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 0, false, false, false, true))));
			houseButton.setTextFill(Color.WHITE);
			
			houseButton.setDisable(true);
			System.out.println("house research purchased !");
		} else {
			System.out.println("Error, the user doesn't have enough resources to purchase this research !");
		}
	}

	public enum listePopulations {
		House("House", 0, 0, 15, 15, 10, 0, 0, 5, 5), 
		Skyscraper("Skyscraper", 0, 0, 100, 90, 30, 5, 5, 15, 30);

		private static final Map<String, listePopulations> BY_NAME = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_OX_COST = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_DIA_COST = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_HYD_COST = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_CAR_COST = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_OX_PROD = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_DIA_PROD = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_HYD_PROD = new HashMap<>();
		private static final Map<Integer, listePopulations> BY_CAR_PROD = new HashMap<>();
		
		private static final Map<Integer, listePopulations> BY_POP_BONUS = new HashMap<>();

		static {
			for (listePopulations e : values()) {
				BY_NAME.put(e.nameResearch, e);
				BY_OX_COST.put(e.oxygeneCost, e);
				BY_DIA_COST.put(e.diazoteCost, e);
				BY_HYD_COST.put(e.hydrogeneCost, e);
				BY_CAR_COST.put(e.carboneCost, e);
				BY_OX_PROD.put(e.oxygeneProd, e);
				BY_DIA_PROD.put(e.diazoteProd, e);
				BY_HYD_PROD.put(e.hydrogeneProd, e);
				BY_CAR_PROD.put(e.carboneProd, e);
				
				BY_POP_BONUS.put(e.bonusPop, e);
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
		
		public final int bonusPop;

		private listePopulations(String nameResearch, int oxygeneCost, int diazoteCost, int hydrogeneCost, int carboneCost,
				int oxygeneProd, int diazoteProd, int hydrogeneProd, int carboneProd, int bonusPop) {
			this.nameResearch = nameResearch;
			this.oxygeneCost = oxygeneCost;
			this.diazoteCost = diazoteCost;
			this.hydrogeneCost = hydrogeneCost;
			this.carboneCost = carboneCost;
			this.oxygeneProd = oxygeneProd;
			this.diazoteProd = diazoteProd;
			this.hydrogeneProd = hydrogeneProd;
			this.carboneProd = carboneProd;
			
			this.bonusPop = bonusPop;
		}

		public static listePopulations valueOfResearchName(String nameResearch) {
			return BY_NAME.get(nameResearch);
		}

		public static listePopulations valueOfOxygeneCost(int oxygeneCost) {
			return BY_OX_COST.get(oxygeneCost);
		}

		public static listePopulations valueOfDiazoteCost(int diazoteCost) {
			return BY_DIA_COST.get(diazoteCost);
		}

		public static listePopulations valueOfHydrogeneCost(int hydrogeneCost) {
			return BY_HYD_COST.get(hydrogeneCost);
		}

		public static listePopulations valueOfCarboneCost(int carboneCost) {
			return BY_CAR_COST.get(carboneCost);
		}

		public static listePopulations valueOfOxygeneProd(int oxygeneProd) {
			return BY_OX_PROD.get(oxygeneProd);
		}

		public static listePopulations valueOfDiazoteProd(int diazoteProd) {
			return BY_DIA_PROD.get(diazoteProd);
		}

		public static listePopulations valueOfHydrogeneProd(int hydrogeneProd) {
			return BY_HYD_PROD.get(hydrogeneProd);
		}

		public static listePopulations valueOfCarboneProd(int carboneProd) {
			return BY_CAR_PROD.get(carboneProd);
		}
		
		public static listePopulations valueOfBonusPop(int bonusPop) {
			return BY_POP_BONUS.get(bonusPop);
		}
	}
    
    public void showPopulationStage() {
    	this.populationStage.show();
    }

	public void onPopulationButtonClick(ActionEvent e, BorderPane root) {
		if (!this.populationStage.isShowing()) {
			showPopulationStage();
			root.setDisable(true);
			System.out.println("The user clicked on Population Button. Population's window is displayed.");
		} else {
			System.out.println("Error, Population's window is already displayed.");
		}
		
	}
}