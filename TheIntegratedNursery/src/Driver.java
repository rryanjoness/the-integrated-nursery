import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Driver {

private static Plant makePlant(Scanner sc)
{
    String stringId = sc.nextLine();
    long id = Long.parseLong(stringId);
    String genusSpecies = sc.nextLine();
    String commonName = sc.nextLine();
    String dateString = sc.nextLine();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate date = LocalDate.parse(dateString, dtf);

    return new Plant(id,genusSpecies,commonName,date);


}





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         ArrayList<Plant> plantList = new ArrayList<Plant>();
        

        plantList.add(makePlant(sc));
        System.out.println(plantList);


        
        }



        
}
