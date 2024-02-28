import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.*;

public class Plant {

//FIELDS
    long id;
    String genusSpecies;
    String commonName;
    LocalDate dateIntroduced;
    
    enum plantGroup {
        ANGIOSPERMS,
        GYMNOSPERMS,
        PTERIDOPHYTES,
        BRYOPHTES
    }
    
    ArrayList<Zone> zones;
    
    private static Plant mostExperiencedPlant;
    private static Plant leastExperiencedPlant;

    public static HashMap<String, Predicate<Plant>> evaluators;
    static {
        evaluators = new HashMap<>();
        //TODO: check that i didn't mess up the compareTo() method usage here
        evaluators.put("most_experienced", plant -> plant.getDateIntroduced().compareTo(mostExperiencedPlant.getDateIntroduced()) == 0);
        evaluators.put("least_experienced",plant -> plant.getDateIntroduced().compareTo(leastExperiencedPlant.getDateIntroduced()) == 0);
    }

    //Constructor
     public Plant(String commonName, String genusSpecies, LocalDate dateIntroduced) {
        this.genusSpecies = genusSpecies;
        this.commonName = commonName;
        this.dateIntroduced = dateIntroduced;

        experienceCheck();
    }

    //Temporary empty Plant() constructor to silence errors in Trees and Flowering classes
    public Plant(){
    }
    
//Old Plant comparator method (commented out for backup purposes.)   
/**
    private static final PlantComparator plantComparator = new PlantComparator();
    

    
    public static Predicate<Plant> mostExperienced() 
    {
        return plant -> plant.equals(Collections.max(plantList, plantComparator));
    }

    
    public static Predicate<Plant> leastExperienced() {
        return plant -> plant.equals(Collections.min(plantList, plantComparator));
    }

*/


   
    public long getId() {
        return this.id;
    }

    public String getGenusSpecies() {
        return this.genusSpecies;
    }

    public void setGenusSpecies(String genusSpecies) {
        if (validateGenusSpecies(genusSpecies) == true)
        this.genusSpecies = genusSpecies;

    }

    public String getCommonName() {
        return this.commonName;
    }

    public void setCommonName(String commonName) {
        if(vaildateCommonName(commonName) == true)
        this.commonName = commonName;

    }

    public LocalDate getDateIntroduced() {
        return this.dateIntroduced;
    }

    public void setDateIntroduced(LocalDate dateIntroduced) {
        this.dateIntroduced = dateIntroduced;
        experienceCheck();
    }

    public HashMap<Integer, Zone> getZones() {
        return zones;
    }

    public void setZones(HashMap<Integer, Zone> zones) {
        this.zones = zones;
      }

    @Override
    public String toString() {
        return String.format("%s (%s)", commonName, genusSpecies);

    }

    public boolean growsInZone(int zoneNumber) {
        if (zones.containsKey(zoneNumber))
            return true;
        return false;
    }


//Methods

    /*
    * Checks and sets if current Plant is most or least experienced Plant
    */
    public void experienceCheck(){            
        // Update most and least experienced plants based on the earliest dateIntroduced
            if (mostExperiencedPlant == null || dateIntroduced.compareTo(mostExperiencedPlant.dateIntroduced) < 0) {
                mostExperiencedPlant = this;
            }
            if (leastExperiencedPlant == null || dateIntroduced.compareTo(leastExperiencedPlant.dateIntroduced) > 0) {
                leastExperiencedPlant = this;
            }
    }
    
// doesnt work if capital letters are sequential. rare case.
    public static boolean validateGenusSpecies(String genusSpecies)
     {
        if ((genusSpecies.length() >= 7 && genusSpecies.length() <= 39)) 
        {

            String regex = "[A-Z]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(genusSpecies);


            
            while (matcher.find()) 
            {
                if (!((matcher.start()) == 0 && matcher.end() >= 1)) 
                {
                    System.err.println("Invalid. In scientific name, only the first letter must be capitalized.");
                    return false;
                }

            }
        } 
        else 
        {
            System.err.println("Invalid length. Scientific name must be between 7 and 39 characters inclusive.");

            return false;
        }
        return true;

    }

    public static boolean vaildateCommonName(String commonName)
    {
        String regex = "[A-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(commonName);

        while (matcher.find()) {
            if (((matcher.start()) != 0)) {
                System.err.println("Invalid name. Common name must start with a capital letter.");
                return false;
            } else {
                return true;
            }
            

        }
        return false;
    }
    

}
