public class ParkingSpot {
    private VehicleSize size;
    private Vehicle vehicle;
    private Level lvl;
    private int row;
    private int spotNumber;
    public ParkingSpot(VehicleSize size, Level lvl, int row, int spotNumber){
        this.lvl=lvl;
        this.size=size;
        this.spotNumber=spotNumber;
        this.row=row;
    }

    public void removeVehicle(){
        lvl.spotFreed();
        vehicle=null;
    }
    public boolean isAvailable(){
        return vehicle==null;
    }
    public VehicleSize getSize(){
        return size ;
    }

    public boolean canFitVehicle() {
        if(vehicle==null){
            return false;
        }
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle v){
        if(!canFitVehicle()){
            return false;
        }
        vehicle=v;
        vehicle.parkInSpot(this);
        return true;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void print(){
        if(vehicle==null){
            if(size== VehicleSize.Compact){
                System.out.println("C");
            }
            else if(size==VehicleSize.Large){
                System.out.println("L");
            }
            else{
                System.out.println("M");
            }
        }
    }
}
