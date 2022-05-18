import java.text.DecimalFormat;

public class Taxi {
    private int taxiNumber = 0;
    private int oil = 0;
    private int speed = 0;
    private String placeName = "";
    private float baseDistance = 2.0f;
    private float placeDistance = 0.0f;
    private int baseRate = 3800;
    private int ratePerMeter = 100;
    private boolean status = false;
    private String status_str = "";

    Taxi(int taxiNumber) {
        this.taxiNumber = taxiNumber;
        this.status_str = "탑승불가";
    }

    public void refuel(int oil) {
        this.oil += oil;
        if (this.oil < 0) {
            this.oil = 0;
            this.status = false;
            this.status_str = "탑승 불가";
        }
        if (this.oil > 10 && this.placeName.length() == 0) {
            this.status = true;
            this.status_str = "일반";
        }
    }


    public void getPassenger(String destination, float placeDistance) {
        if (this.status == false) {
            System.out.println("탑승 불가");
            return;
        } else {
            this.status_str = "운행중";
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

        System.out.println("요금은 " + fee + "원입니다.");

        if (this.oil > 10) {
            this.status = true;
            this.status_str = "일반";
        } else {
            this.status_str = "탑승 불가";
            System.out.println("주유가 필요합니다.");
        }

        this.placeName = "";
        this.placeDistance = 0.0f;

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
        System.out.println(this.taxiNumber);
    }

    public void getOil() {
        System.out.println(oil);
    }

    public void getPlace() {
        System.out.println(this.placeName);
    }

}
