import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    List<ParkingSpot> parkingspots=new ArrayList<>();
    VehicleSize size;
    String license;
    int spotsNeeded;

    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    public VehicleSize getSize(){
        return size;
    }
    public void parkInSpot(ParkingSpot spot){
        parkingspots.add(spot);
    }
    public void clearSpots(){
        for(int i=0; i<parkingspots.size(); i++){
            parkingspots.get(i).removeVehicle();
        }
        parkingspots.clear();
    }
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();

}
