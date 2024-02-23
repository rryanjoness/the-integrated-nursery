import java.time.LocalDate;
import java.util.HashMap;
import java.util.regex.*;

public class Plant 
{
    long id;
    String genusSpecies;
    String commonName;
    LocalDate dateIntroduced;

    enum plantGroup
    {
        ANGIOSPERMS,
        GYMNOSPERMS,
        PTERIDOPHYTES,
        BRYOPHTES
    }


    //TODO needs changing, needs to move to Zone Class... unsure how to implement
    

    public static HashMap<Integer,Zone> zones = new HashMap<Integer,Zone>();



    public long getId() {
        return this.id;
    }

    public String getGenusSpecies() {
        return this.genusSpecies;
    }

    public void setGenusSpecies(String genusSpecies) {
        this.genusSpecies = genusSpecies;
    }

    public String getCommonName() {
        return this.commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public LocalDate getDateIntroduced() {
        return this.dateIntroduced;
    }

    public void setDateIntroduced(LocalDate dateIntroduced) {
        this.dateIntroduced = dateIntroduced;
    }

    public HashMap<Integer,Zone> getZones() {
        return this.zones;
    }

    public void setZones(HashMap<Integer,Zone> zones) {
        this.zones = zones;
    }

    @Override
    public String toString()
    {
        return String.format("%s (%s)", commonName, genusSpecies);

    }

    public boolean growsInZone(int zoneNumber)
    {
        if (zones.containsKey(zoneNumber))
            return true;
        return false;
    }

    public static boolean validateName(String name)
    {

        if (!(name.length() >= 7 && name.length() <= 39)) return false;

        String regex = "[A-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        while (matcher.find()) {
            if (!((matcher.start()) == 0 && matcher.end() == 1)) return false;
  
        }
        return true;
        
    }

}
