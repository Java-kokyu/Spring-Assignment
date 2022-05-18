import java.util.UUID;

public class Bus {
    private int max_passenger = 60;
    private int current_passenger = 0;
    private int fee = 1350;
    final private String bus_number = UUID.randomUUID().toString();
    private int oil = 0;
    private int speed = 0;
    private boolean operation = true;

    Bus(){
        this.oil = 0;
        this.speed = 0;
    }

    Bus(int oil, int speed){
        this.oil = oil;
        if(this.oil > 10){
            System.out.println(this.speed + " 속도로 버스가 출발합니다.");
            this.speed = speed;
        }
        else{
            System.out.println("주유량을 확인해주세요.");
            this.speed = 0;
        }
    }

    public int refuel(int oil){
        this.oil += oil;
        if(this.oil < 10){
            this.operation = false;
            System.out.println("현재 기름이 존재하지 않으므로 " + this.current_passenger + "명의 승객 모두 내립니다");
            this.current_passenger = 0;
        }else{
            this.operation = true;
        }
        return this.oil;
    }

    public int update_passenger(int passenger){
        int wait_passenger = this.current_passenger + passenger;
        if(operation != true){
            System.out.println("운행중인 버스가 아닙니다.");
            return 0;
        }else if(wait_passenger > max_passenger){
            int rideable_passenger = max_passenger - current_passenger;
            System.out.println("최대 승객수가 " + max_passenger + "이므로 " + rideable_passenger + "명만 탑승합니다.");
            this.current_passenger = max_passenger;
            return this.current_passenger;
        }
        this.current_passenger += passenger;
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

    public void get_passenger(){
        System.out.println(this.current_passenger);
    }

    public void get_speed(){
        System.out.println(this.speed);
    }

    public void get_operation(){
        String status = this.operation ? "운행중":"차고지행";
        System.out.println(status);
    }

    public void get_number(){
        System.out.println(this.bus_number);
    }

    public void get_oil(){
        System.out.println(oil);
    }

    }
