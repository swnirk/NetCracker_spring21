import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormData {

    private Date date1;
    private Calendar date2;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Calendar getDate2() {
        return date2;
    }

    public void setDate2(Calendar date2) {
        this.date2 = date2;
    }

    public Date formData(String data1) {

        String[] items = data1.split(" ");
        int year = Integer.parseInt(items[0]);
        int month = Integer.parseInt(items[1]);
        int day = Integer.parseInt(items[2]);
        int hour = Integer.parseInt(items[3]);
        int minute = Integer.parseInt(items[4]);
        return new Date(year,month,day,hour,minute);

    }

    public Calendar formCalendar(String data2) {

        String[] items = data2.split(" ");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, Integer.parseInt(items[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(items[1]));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(items[2]));
        calendar.set(Calendar.HOUR, Integer.parseInt(items[3]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(items[4]));

        return calendar;
    }
}
