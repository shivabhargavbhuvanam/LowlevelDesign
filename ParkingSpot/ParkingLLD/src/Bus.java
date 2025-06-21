public class Bus extends Vehicle{
    public Bus(String license){
        this.spotsNeeded=5;
        this.license=license;
        this.size=VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize()==VehicleSize.Large;
    }

    @Override
    public void print(){
        System.out.println("B");
    }
}
