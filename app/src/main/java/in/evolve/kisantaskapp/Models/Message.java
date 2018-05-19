package in.evolve.kisantaskapp.Models;

public class Message {

    private String name;
    private String time;
    private String otp;

    public Message(String name, String time, String otp) {
        this.name = name;
        this.time = time;
        this.otp = otp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
