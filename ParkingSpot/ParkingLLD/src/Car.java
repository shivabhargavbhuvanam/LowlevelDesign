public class Car extends Vehicle{
    public Car(String license){
        this.spotsNeeded=1;
        this.size=VehicleSize.Compact;
        this.license=license;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize()==VehicleSize.Large || spot.getSize()==VehicleSize.Compact;
    }

    @Override
    public void print(){
        System.out.println("C");
    }
}
