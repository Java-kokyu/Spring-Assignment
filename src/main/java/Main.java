public class Main {
    public static void main(String args[]) {
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();

        bus1.get_number();
        bus2.get_number();

        bus1.update_passenger(2);
        bus1.get_passenger();
        bus1.get_available_seat();
        bus1.get_total_fee();

        bus1.refuel(-50);
        bus1.get_oil();

        bus1.change_status();
        bus1.refuel(10);
        bus1.get_status();
        bus1.get_oil();

        bus1.update_passenger(45); // max_passenger보다 많은 수의 승객이 탑승했을 때 태울 수 있는 승객만 태울 수 있도록 구성
        bus1.get_passenger();
        bus1.get_available_seat();
        bus1.get_total_fee();

        bus1.refuel(-55); //기름이 부족할 때
        bus1.get_passenger();
        bus1.get_oil();
        bus1.get_status();

        System.out.println("--------------------------------------------------------------------");
        Taxi taxi1 = new Taxi(1997);
        Taxi taxi2 = new Taxi(1867);

        taxi1.getNumber();
        taxi2.getNumber();
        taxi1.getOil();
        taxi2.getOil();
        taxi1.getStatus();
        taxi2.getStatus();

        taxi1.getPassenger(2, "서울역", 2.0f);
        taxi1.printCurrentStatus();

        taxi1.refuel(-80);

        taxi1.payFee();

        taxi1.getPassenger(5, "구로디지털단지역", 12.0f);

        taxi1.getPassenger(3, "구로디지털단지역", 12.0f);
        taxi1.printCurrentStatus();
        taxi1.refuel(-20);
        taxi1.payFee(); //요금 지불할 때 기름이 부족하면 알럿을 프린트 할 수 있게 설정
        taxi1.getStatus();
        taxi1.getTotalFee();

    }
}