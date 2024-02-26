import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         ArrayList<Plant> plantList = new ArrayList<Plant>();
        

        

        System.out.println("How should we evaluate?");
        String evaluatorType = sc.nextLine();

        Predicate<Plant> evaluationPredicate;
        if (evaluatorType.equalsIgnoreCase("most")) {
            evaluationPredicate = Plant.mostExperienced();
        } else if (evaluatorType.equalsIgnoreCase("least")) {
            evaluationPredicate = Plant.leastExperienced();
        } else {
            evaluationPredicate = plant -> true;
        }

        for (Plant plant : plantList ) {
            boolean meetsCriteria = evaluationPredicate.test(plant);
        }
        
        sc.close();

        
    }
    
}
