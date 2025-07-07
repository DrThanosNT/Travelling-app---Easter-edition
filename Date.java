import java.io.Serializable;
public class Date implements Serializable{
    private String day;
    private int duration;

    public Date(String day, int duration) {
        this.day = day;
        this.duration = duration;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
