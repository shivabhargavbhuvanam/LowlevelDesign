public class ParkingLot {
    private Level[] lvls;
    private final int NUM_LVLS=5;

    public ParkingLot(){
        lvls=new Level[NUM_LVLS];
        for(int i=0; i<NUM_LVLS; i++){
             lvls[i]=new Level(i, 30);
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(int i=0; i< lvls.length; i++){
            if(lvls[i].parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }
}
