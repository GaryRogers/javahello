import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Simple script to create a Kubernetes container that hearbeats to the console
 */
public class Main {
    public static void main(String[] args) {
 
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);

        while(true){
            try {
                String message = String.format("[%s] Heartbeat", df.format(new Date()));
                System.out.println(message);
                TimeUnit.SECONDS.sleep(10);
            } catch(InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}