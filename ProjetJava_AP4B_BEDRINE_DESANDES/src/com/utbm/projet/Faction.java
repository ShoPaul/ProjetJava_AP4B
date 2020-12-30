package com.utbm.projet;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
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

public class Faction {

	private String factionName;
	private int boostNumber;
	private String boostDomain;
	public BorderPane factionBorder = new BorderPane();
	private VBox factionTopBorder = new VBox();
	private HBox factionButtons = new HBox(20);
	private VBox factionInfos = new VBox(20);
	private Label questionFactionLabel = new Label();

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
		return this.factionName;
	}

	public int getFactionBoostNumber() {
		return this.boostNumber;
	}

	public String getFactionBoostDomain() {
		return this.boostDomain;
	}

	public void factionChoice(Faction faction) {
		// Buttons's and text's effects
		DropShadow dropShadow1 = new DropShadow();
		dropShadow1.setRadius(5.0);
		dropShadow1.setOffsetX(3.0);
		dropShadow1.setOffsetY(5.0);

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
		faction.questionFactionLabel.setEffect(dropShadow1);

		eng.engineerInfos();
		doc.doctorInfos();
		farm.farmerInfos();
		pol.politicianInfos();
		res.researcherInfos();

		faction.factionButtons.getChildren().addAll(eng.engineerButton, doc.doctorButton, farm.farmerButton, pol.politicianButton, res.researcherButton);
		faction.factionButtons.setAlignment(Pos.CENTER);

		faction.factionTopBorder.getChildren().addAll(faction.questionFactionLabel, faction.factionButtons);
		faction.factionTopBorder.setAlignment(Pos.CENTER);

		faction.factionBorder.setTop(factionTopBorder);
		faction.factionBorder.setRight(factionInfos);

		faction.factionBorder.setBackground(new Background(new BackgroundImage(
				new Image(this.getClass().getResourceAsStream("/resources/images/backgrounds/blackStarsBackground.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(0, 0, false, false, false, true))));
		
		eng.engineerButton.setOnAction((e) -> eng.onEngineerButtonClick(e, faction.factionBorder));
		doc.doctorButton.setOnAction((e) -> doc.onDoctorButtonClick(e, faction.factionBorder));
		farm.farmerButton.setOnAction((e) -> farm.onFarmerButtonClick(e, faction.factionBorder));
	}
}