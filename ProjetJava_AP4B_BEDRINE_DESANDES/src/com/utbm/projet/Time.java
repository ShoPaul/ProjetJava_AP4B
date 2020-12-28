package com.utbm.projet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class Time {
	
	public Label month;
	public Label day;
	public Label clock;
	
	Time (){
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
		
		month = new Label ();
		month.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		month.setTextFill(Color.WHITE);
		month.setEffect(dropShadow);
		
		day = new Label ();
		day.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		day.setTextFill(Color.WHITE);
		day.setEffect(dropShadow);
		
		clock = new Label ();
		clock.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 15));
		clock.setTextFill(Color.WHITE);
		clock.setEffect(dropShadow);
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LocalDate currentDate = LocalDate.now();
				int daySystem = currentDate.getDayOfMonth();
				Month monthSystem = currentDate.getMonth();
				SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
				Date clockSystem = new Date(System.currentTimeMillis());

				month.setText(monthSystem.toString());
				day.setText(String.format("%d", daySystem));
				clock.setText(formatter.format(clockSystem));
			}
			
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
