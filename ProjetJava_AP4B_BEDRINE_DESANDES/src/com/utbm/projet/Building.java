package com.utbm.projet;

public class Building {
	
	public int oxGenerator;
	public int azGenerator;
	public int hyGenerator;
	public int caGenerator;
	
	public int popCapacity;
	
	Building (int oxygen, int diazote, int hydrogen, int carbon, int population){
		oxGenerator = oxygen;
		azGenerator = diazote;
		hyGenerator = hydrogen;
		caGenerator = carbon;
		popCapacity = population;
	}
	
	void upgrade (int bonus, int option) {
		switch (option) {
		case 1:
			this.oxGenerator += bonus;
			break;
		case 2:
			this.azGenerator += bonus;
			break;
		case 3:
			this.hyGenerator += bonus;
			break;
		case 4:
			this.caGenerator += bonus;
			break;
		case 5:
			this.popCapacity += bonus;
			break;
		}
	}

}
