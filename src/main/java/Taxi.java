import java.text.DecimalFormat;

public class Taxi {
    private int taxiNumber = 0;
    private int oil = 100;
    private int speed = 0;
    private String placeName = "";
    private int maxPassenger = 4;
    private int currentPassenger = 0;
    private float baseDistance = 1.0f;
    private float placeDistance = 0.0f;
    private int baseRate = 3000;
    private int totalFee = 0;
    private int ratePerMeter = 100;
    private boolean status = true;
    private String status_str = "";

    Taxi(int taxiNumber) {
        this.taxiNumber = taxiNumber;
        this.status_str = "일반";
    }

    public void refuel(int oil) {
        this.oil += oil;
        if (this.oil < 0) {
            this.oil = 0;
            this.status = false;
            this.status_str = "탑승 불가";
        }
    }


    public void getPassenger(int passenger, String destination, float placeDistance) {
        if(passenger > this.maxPassenger){
            System.out.println("!! 최대 승객 수 초과 !!");
            return;
        }
        if (this.status == false) {
            System.out.println("탑승 불가");
            return;
        } else {
            this.status_str = "운행중";
            this.placeName = destination;
            this.currentPassenger = passenger;
            this.placeDistance = placeDistance;
            this.status = false;
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("택시 운행을 시작합니다. 목적지: " + destination + ", 목적지까지 거리: " + df.format(placeDistance) + "km");
            this.placeDistance = (float) Math.floor(placeDistance * 10) / 10;
        }
    }

    public int payFee() {
        this.speed = 0;
        float distance = this.placeDistance - this.baseDistance;
        int fee = (distance <= 0) ? this.baseRate : this.baseRate + (int) (distance * 10 * ratePerMeter);

        totalFee += fee;

        System.out.println("주유량: " + oil);
        System.out.println("요금은 " + fee + "원입니다.");
        System.out.println("택시번호 "+ taxiNumber +"의 오늘 수입은 총 " + totalFee + "원 입니다.");

        if (this.oil > 10) {
            this.status = true;
            this.status_str = "일반";
        } else {
            this.status_str = "탑승 불가";
            System.out.println("!! 주유가 필요합니다. !!");
        }

        this.placeName = "";
        this.placeDistance = 0.0f;
        this.currentPassenger = 0;

        return fee;
    }

    public int setSpeed(int speed) {
        if (oil < 10) {
            System.out.println("주유가 필요합니다");
            return 0;
        }
        this.speed = speed;

        return this.speed;
    }

    public int speedUp(int speed) {
        this.speed += speed;
        return this.speed;
    }

    public int speedDown(int speed) {
        if (this.speed - speed < 0) {
            this.speed = 0;
            return 0;
        }
        this.speed -= speed;
        return this.speed;
    }

    public void getSpeed() {
        System.out.println(this.speed);
    }

    public void getStatus() {
        System.out.println(this.status_str);
    }

    public void getNumber() {
        System.out.println("택시 번호: " + this.taxiNumber);
    }

    public void getOil() {
        System.out.println("주유량: " + oil);
        if(oil < 10) System.out.println("!! 주유가 필요합니다. !!");
    }

    public void getPlace() {
        System.out.println(this.placeName);
    }

    public void getTotalFee(){
        System.out.println("택시번호 "+ taxiNumber +"의 오늘 수입은 총 " + totalFee + "원 입니다.");
    }

    public void printCurrentStatus(){
        DecimalFormat df = new DecimalFormat("#.##");

        float distance = this.placeDistance - this.baseDistance;
        int fee = (distance <= 0) ? this.baseRate : this.baseRate + (int) (distance * 10 * ratePerMeter);

        System.out.println("==============================");
        System.out.println("탑승 승객 수: " + this.currentPassenger);
        System.out.println("잔여 승객 수: " + (this.maxPassenger - this.currentPassenger));
        System.out.println("기본 요금 확인: " + this.baseRate);
        System.out.println("목적지: " + this.placeName);
        System.out.println("목적지까지 거리: " + df.format(placeDistance) + "km");
        System.out.println("지불할 요금: " + fee);
        System.out.println("==============================");
    }

}
