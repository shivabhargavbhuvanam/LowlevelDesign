public class Level {
    private int floor;
    private ParkingSpot[] parkingSpots;
    private int spotsAvailable=0;
    private static final int SPOTS_PER_ROW=10;

    public Level(int floor, int numberOfSpots){
        this.floor=floor;
        this.spotsAvailable=numberOfSpots;
        parkingSpots=new ParkingSpot[numberOfSpots];
        int largeSpots=numberOfSpots/4;
        int bikeSpots=numberOfSpots/4;
        int compactSpots=numberOfSpots-largeSpots-bikeSpots;
        for(int i=0; i<numberOfSpots; i++){
            VehicleSize vs=VehicleSize.Motorcycle;
            if(i<largeSpots){
                vs=VehicleSize.Large;
            }
            else if(i<largeSpots+bikeSpots){
                vs=VehicleSize.Compact;
            }
            int row=i/SPOTS_PER_ROW;
            parkingSpots[i]=new ParkingSpot(vs, this, row, i);
        }
    }

    public int getSpotsAvailable(){
        return spotsAvailable;
    }
    public void spotFreed(){
        spotsAvailable++;
    }
    public boolean parkVehicle(Vehicle vehicle){
        if(getSpotsAvailable() < vehicle.getSpotsNeeded()){
            return false;
        }
        int spotNumber=findAvailableSpots(vehicle);
        if(spotNumber<0){
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    public int findAvailableSpots(Vehicle vehicle){
        int spotsNeeded= vehicle.getSpotsNeeded();
        int lastSpot=-1;
        int spotsFound=0;
        for(int i=0; i<parkingSpots.length; i++){
            ParkingSpot currentSpot=parkingSpots[i];
            if(lastSpot!=parkingSpots[i].getRow()){
                spotsFound=0;
                lastSpot=parkingSpots[i].getRow();
            }
            if(parkingSpots[i].canFitVehicle()){
                spotsFound++;
            }
            else{
                spotsFound=0;
            }
            if(spotsFound==spotsNeeded){
                return i-(spotsNeeded-1);
            }
        }
        return -1 ;
    }

    public boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle){
        vehicle.clearSpots();
        boolean success=true;
        for(int i=spotNumber; i<spotNumber+vehicle.getSpotsNeeded(); i++){
            success &=parkingSpots[i].park(vehicle);
        }
        spotsAvailable-=vehicle.getSpotsNeeded();
        return success;
    }

    public void print(){
        int lastRow=-1;
        for(int i=0; i<parkingSpots.length; i++){
            ParkingSpot spot=parkingSpots[i];
            if(spot.getRow()!=lastRow){
                System.out.println(" ");
                lastRow=spot.getRow();
            }
            spot.print();
        }
    }
}
