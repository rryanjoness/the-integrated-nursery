import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Driver {

private static Plant makePlant(Scanner sc)
{
    boolean flag = true;
    
    String genusSpecies = "";
    String commonName = "";
    while(flag)
    {System.out.println("Enter the scientific name of the plant");
    genusSpecies = sc.nextLine();
    if (Plant.validateGenusSpecies(genusSpecies)) flag = false;
    }
    flag = true;
    while(flag)
    {
        System.out.println("Enter the common name of the plant");
        commonName = sc.nextLine();
    if (Plant.vaildateCommonName(commonName)) flag = false;
    }
    
    String dateString = sc.nextLine();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate date = LocalDate.parse(dateString, dtf);

    return new Plant(genusSpecies,commonName,date);


}





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         ArrayList<Plant> plantList = new ArrayList<Plant>();
        

        plantList.add(makePlant(sc));
        System.out.println(plantList);


        
        }



        
}
