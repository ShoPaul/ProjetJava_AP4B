package com.utbm.projet;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Doctor extends Faction {

	public String factionName;
    public int boostNumber;
    public String boostDomain;
	public Button doctorButton = new Button();
	public Label factionNameLabel = new Label();
	public Label infoFactionLabel = new Label();
	public Label boostFactionLabel = new Label();
	public VBox factionInfosDoctor = new VBox(20);

	public void doctorInfos() {
		DropShadow dropShadow1 = new DropShadow();
		dropShadow1.setRadius(1.9);
		dropShadow1.setColor(Color.WHITE);
		DropShadow dropShadow2 = new DropShadow();
		dropShadow2.setRadius(8.0);
		dropShadow2.setHeight(20.0);
		dropShadow2.setWidth(20.0);
		dropShadow2.setColor(Color.WHITE);
		
		factionName = "Docteur";
		boostNumber = -15;
		boostDomain = "Temps des recherches sur la médecine";
		doctorButton.setBackground(new Background(new BackgroundImage(
				new Image(this.getClass().getResourceAsStream("/resources/images/factions/logoDoctor.png")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(0, 0, false, false, false, true))));
		doctorButton.setMinSize(100, 100);
		doctorButton.setCursor(Cursor.HAND);
		doctorButton.effectProperty()
				.bind(Bindings.when(doctorButton.hoverProperty()).then(dropShadow2).otherwise(dropShadow1));

		factionNameLabel.setText(factionName);
		factionNameLabel.setTextFill(Color.web("2E7BD8"));

		infoFactionLabel.setText("Informations sur la faction :");
		infoFactionLabel.setTextFill(Color.web("2E7BD8"));

		boostFactionLabel.setText(boostDomain + " : " + boostNumber + " %");
		boostFactionLabel.setTextFill(Color.web("2E7BD8"));
		
		factionInfosDoctor.getChildren().addAll(infoFactionLabel, boostFactionLabel);
	}

	public void onDoctorButtonClick(ActionEvent e, BorderPane factionBorder) {
		factionBorder.setRight(factionInfosDoctor);
	}
}