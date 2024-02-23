public class Zone {

    public enum Zones{
        ZONE_1(Integer.MIN_VALUE, -50),
        ZONE_2(-50, -40),
        ZONE_3(-40, -30),
        ZONE_4(-30, -20),
        ZONE_5(-20, -10),
        ZONE_6(-10, 0),
        ZONE_7(0, 10),
        ZONE_8(10, 20),
        ZONE_9(20, 30),
        ZONE_10(30, 40),
        ZONE_11(40, 50);
    
        private final int lowestTemperature;
        private final int highestTemperature;
    
        Zones(int lowestTemperature, int highestTemperature) {
            this.lowestTemperature = lowestTemperature;
            this.highestTemperature = highestTemperature;
        }
    
        public int getLowestTemperature() {
            return lowestTemperature;
        }
    
        public int getHighestTemperature() {
            return highestTemperature;
        }
    }
    
}
