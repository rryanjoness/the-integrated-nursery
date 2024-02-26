public class Driver {

    public static void main(String[] args) {
        
        Plant plant = new Plant();

        plant.setGenusSpecies("Poa fax");
        System.out.println(plant.getGenusSpecies());

        plant.setCommonName("Plastic plant");
        System.out.println(plant.getCommonName());
        

    }
    
}
