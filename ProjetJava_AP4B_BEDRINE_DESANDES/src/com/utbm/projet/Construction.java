package com.utbm.projet;

import java.util.HashMap;
import java.util.Map;

public class Construction {

    public Construction() {
    }

    public void addBuilding() {
    	
    }

    public void removeBuilding() {
    }

    public void upgradeBuilding() {
    }

    public void isBuildingAvailable() {
    }

    public void cancelConstruction() {
    }

    public enum listeConstructions {
    	House("C", 20, "O", -20),
    	Mine("C", 40, "H", 30);

        private static final Map<String, listeConstructions> BY_FIRST_RESOURCE = new HashMap<>();
        private static final Map<Integer, listeConstructions> BY_FIRST_RESOURCE_NUMBER = new HashMap<>();
        private static final Map<String, listeConstructions> BY_SECOND_RESOURCE = new HashMap<>();
        private static final Map<Integer, listeConstructions> BY_SECOND_RESOURCE_NUMBER = new HashMap<>();
        
        static {
            for (listeConstructions e : values()) {
            	BY_FIRST_RESOURCE.put(e.firstResource, e);
            	BY_FIRST_RESOURCE_NUMBER.put(e.firstResourceNumber, e);
            	BY_SECOND_RESOURCE.put(e.secondResource, e);
            	BY_SECOND_RESOURCE_NUMBER.put(e.secondResourceNumber, e);
            }
        }
        
        public final String firstResource;
        public final int firstResourceNumber;
        public final String secondResource;
        public final int secondResourceNumber;

        private listeConstructions(String firstResource, int firstResourceNumber, String secondResource, int secondResourceNumber) {
            this.firstResource = firstResource;
            this.firstResourceNumber = firstResourceNumber;
            this.secondResource = secondResource;
            this.secondResourceNumber = secondResourceNumber;
        }

		public static listeConstructions valueOfFirstResource(String firstResource) {
            return BY_FIRST_RESOURCE.get(firstResource);
        }

        public static listeConstructions valueOfFirstResourceNumber(int firstResourceNumber) {
            return BY_FIRST_RESOURCE_NUMBER.get(firstResourceNumber);
        }

        public static listeConstructions valueOfSecondResource(String secondResource) {
            return BY_SECOND_RESOURCE.get(secondResource);
        }
        
        public static listeConstructions valueOfSecondResourceNumber(int secondResourceNumber) {
            return BY_SECOND_RESOURCE_NUMBER.get(secondResourceNumber);
        }
    }

}