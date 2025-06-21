public class Main {
    public static void main(String[] args) {
        ParkingLot p=new ParkingLot();
        Bus b1=new Bus("AK10J4564");
        Bus b2=new Bus("KA30J4564");
        Car c1=new Car("PB10L4547");
        Car c2=new Car("BP10M4564");
        Motorcycle m1=new Motorcycle("IL13P2099");
        Motorcycle m2=new Motorcycle("AK10J4564");

        System.out.println(p.parkVehicle(c1));
        System.out.println(p.parkVehicle(c2));
        System.out.println(p.parkVehicle(m1));
        System.out.println(p.parkVehicle(m2));
        System.out.println(p.parkVehicle(b1));
        System.out.println(p.parkVehicle(b2));

        System.out.println("Hello, World!");
    }
}