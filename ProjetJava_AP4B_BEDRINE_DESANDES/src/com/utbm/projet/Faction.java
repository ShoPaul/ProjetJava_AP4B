package com.utbm.projet;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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

public class Faction {

	private String factionName;
	private int boostNumber;
	private String boostDomain;
	public BorderPane factionBorder = new BorderPane();
	private VBox factionTopBorder = new VBox();
	private HBox factionButtons = new HBox(20);
	private VBox factionInfos = new VBox(20);
	private Label questionFactionLabel = new Label();
	public Button nextToScene3Button = new Button();
	private Effects effects = new Effects();

	public Faction() {
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public void setFactionBoostNumber(int factionBoostNumber) {
		this.boostNumber = factionBoostNumber;
	}

	public void setFactionBoostDomain(String factionBoostDomain) {
		this.boostDomain = factionBoostDomain;
	}

	public String getFactionName() {
		if (this.factionName != null) {
			System.out.println("The user choose the faction : " + this.factionName);
		} else {
			System.out.println("Error, the user did not select a faction !");
		}

		return this.factionName;
	}

	public int getFactionBoostNumber() {
		return this.boostNumber;
	}

	public String getFactionBoostDomain() {
		return this.boostDomain;
	}

	public void factionChoice(Faction faction) {
		Engineer eng = new Engineer();
		Doctor doc = new Doctor();
		Farmer farm = new Farmer();
		Politician pol = new Politician();
		Researcher res = new Researcher();

		// Set questionFactionLabel's infos
		faction.questionFactionLabel.setText("Choisir une faction".toUpperCase());
		faction.questionFactionLabel.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 50));
		faction.questionFactionLabel.setTextFill(Color.web("2E7BD8"));
		faction.questionFactionLabel.setEffect(effects.setTextEffect());

		eng.engineerInfos();
		doc.doctorInfos();
		farm.farmerInfos();
		pol.politicianInfos();
		res.researcherInfos();

		faction.nextToScene3Button.setText("suivant".toUpperCase());
		faction.nextToScene3Button.setFont(
				Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 50));
		faction.nextToScene3Button.setTextFill(Color.WHITE);
		faction.nextToScene3Button.setBackground(new Background(new BackgroundFill(Color.web("2E7BD8"), null, null)));
		faction.nextToScene3Button.effectProperty().bind(Bindings.when(faction.nextToScene3Button.hoverProperty())
				.then(effects.setButtonHoverEffect()).otherwise(effects.setButtonBasicEffect()));
		faction.nextToScene3Button.setCursor(Cursor.HAND);
		faction.nextToScene3Button.setMinSize(100, 50);

		faction.factionButtons.getChildren().addAll(eng.engineerButton, doc.doctorButton, farm.farmerButton,
				pol.politicianButton, res.researcherButton);
		faction.factionButtons.setAlignment(Pos.CENTER);

		faction.factionTopBorder.getChildren().addAll(faction.questionFactionLabel, faction.factionButtons);
		faction.factionTopBorder.setAlignment(Pos.CENTER);

		faction.factionBorder.setTop(faction.factionTopBorder);
		faction.factionBorder.setRight(faction.factionInfos);
		faction.factionBorder.setBottom(faction.nextToScene3Button);
		BorderPane.setAlignment(faction.nextToScene3Button, Pos.CENTER);
		BorderPane.setMargin(faction.nextToScene3Button, new Insets(0, 0, 100, 0));

		faction.factionBorder.setBackground(new Background(new BackgroundImage(
				new Image(
						this.getClass().getResourceAsStream("/resources/images/backgrounds/blackStarsBackground.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(0, 0, false, false, false, true))));

		eng.engineerButton.setOnAction((e) -> eng.onEngineerButtonClick(e, faction.factionBorder, faction));
		doc.doctorButton.setOnAction((e) -> doc.onDoctorButtonClick(e, faction.factionBorder, faction));
		farm.farmerButton.setOnAction((e) -> farm.onFarmerButtonClick(e, faction.factionBorder, faction));
		pol.politicianButton.setOnAction((e) -> pol.onPoliticianButtonClick(e, faction.factionBorder, faction));
		res.researcherButton.setOnAction((e) -> res.onResearcherButtonClick(e, faction.factionBorder, faction));
	}

	public void nextScene(ActionEvent e, Stage primaryStage, Scene scene3, Faction faction) {
		if (faction.getFactionName() != null) {
			primaryStage.setScene(scene3);
		}
	}
}