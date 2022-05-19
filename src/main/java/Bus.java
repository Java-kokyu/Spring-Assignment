import java.util.UUID;

public class Bus {
    private int max_passenger = 30;
    private int current_passenger = 0;
    private int total_fee = 0;
    private final int fee = 1000;
    final private String bus_number = UUID.randomUUID().toString();
    private int oil = 100;
    private int speed = 0;
    private boolean status = true;

    Bus(){
        this.oil = 100;
        this.speed = 0;
    }

    public int refuel(int oil){
        this.oil += oil;
        if(this.oil < 10){
            System.out.println("주유 필요!");
            this.status = false;
            if(this.oil == 0){
                System.out.println("현재 기름이 존재하지 않으므로 " + this.current_passenger + "명의 승객 모두 내립니다");
                this.current_passenger = 0;
            }
        }else{
            this.status = true;
        }
        return this.oil;
    }

    public int update_passenger(int passenger){
        int wait_passenger = this.current_passenger + passenger;
        if(status != true){
            System.out.println("운행중인 버스가 아닙니다.");
            return 0;
        }else if(wait_passenger > max_passenger){
            int rideable_passenger = max_passenger - current_passenger;
            System.out.println("최대 승객수가 " + max_passenger + "이므로 " + rideable_passenger + "명만 탑승합니다.");
            this.current_passenger = max_passenger;
            this.total_fee += fee * rideable_passenger;
            return this.current_passenger;
        }
        this.current_passenger += passenger;
        this.total_fee += fee * passenger;
        return this.current_passenger;
    }

    public int set_speed(int speed){
        if(oil < 10){
            System.out.println("주유량을 확인해주세요.");
            return 0;
        }
        this.speed = speed;
        System.out.println(this.speed + " 속도로 버스가 출발합니다.");
        return this.speed;
    }

    public int speed_up(int speed){
        this.speed += speed;
        return this.speed;
    }

    public int speed_down(int speed){
        this.speed -= speed;
        return this.speed;
    }

    public void change_status(){
        this.status = this.status ? false : true;
    }

    public void get_passenger(){
        System.out.println("탑승 승객 수: " + this.current_passenger);
    }

    public void get_speed(){
        System.out.println(this.speed);
    }

    public void get_status(){
        String status = this.status ? "상태: 운행중":"상태: 차고지행";
        System.out.println(status);
    }

    public void get_number(){
        System.out.println("버스 고유 번호: " + this.bus_number);
    }

    public void get_total_fee() {
        System.out.println("요금 확인: " + this.total_fee);
    }

    public void get_oil(){
        System.out.println("주유량: " + oil);
    }

    public void get_available_seat() {
        System.out.println("잔여 승객수: " + (this.max_passenger - this.current_passenger));
    }

    }
