public class Main {
    public static void main(String args[]) {
//        Bus bus1 = new Bus();
//        bus1.set_speed(10);
//        bus1.refuel(20);
//        bus1.set_speed(10);
//
//        Bus bus2 = new Bus(5, 20);
//        bus2.get_speed();
//        bus2.refuel(30);
//        bus2.get_oil();
//        bus2.set_speed(60);
//        bus2.update_passenger(40);
//        bus2.get_passenger();
//        bus2.update_passenger(-20);
//        bus2.get_passenger();
//        bus2.update_passenger(55);
//        bus2.get_passenger();
//        bus2.refuel(-50);
//        bus2.get_operation();
//        bus2.update_passenger(10);
//        bus2.get_passenger();

        Taxi taxi1 = new Taxi(1997);
        taxi1.setSpeed(30);
        taxi1.refuel(-10);
        taxi1.getOil();
        taxi1.refuel(50);
        taxi1.setSpeed(50);
        taxi1.getOil();
        taxi1.getPassenger("위시티 4단지", 3.8f);
        taxi1.getStatus();
        taxi1.payFee();
        taxi1.getStatus();
        taxi1.refuel(-30);
        taxi1.getPassenger("경남아파트", 1.8f);
        taxi1.getOil();
        taxi1.payFee();
        taxi1.refuel(-30);
        taxi1.getPassenger("목련아파트 2단지", 6.8f);
        taxi1.refuel(70);
        taxi1.getPassenger("목련아파트 2단지", 6.8f);
        taxi1.payFee();






    }
}