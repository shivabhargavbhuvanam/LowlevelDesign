public class Motorcycle extends Vehicle{
    public Motorcycle(String license){
        this.spotsNeeded=1;
        this.size=VehicleSize.Motorcycle;
        this.license=license;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    @Override
    public void print() {
        System.out.println("M");
    }
}
