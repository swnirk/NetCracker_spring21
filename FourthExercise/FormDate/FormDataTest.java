import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

public class FormDataTest {

    private static final String right = "34 8 16 18 54";

    private static final String wrong = "bek mek";

    @Test
    public void test1() {


        ByteArrayInputStream in = new ByteArrayInputStream(right.getBytes());
        System.setIn(in);

        FormData dc = new FormData();
        Assert.assertEquals(new Date(34, 8, 16, 18, 54), dc.formData(right));
    }

    @Test
    public void test2() {


        ByteArrayInputStream in = new ByteArrayInputStream(right.getBytes());
        System.setIn(in);

        FormData dc = new FormData();
        Assert.assertEquals(new GregorianCalendar(34, 8, 16, 18, 54), dc.formCalendar(right));
    }

    @Test(expected = InputMismatchException.class)
    public void personExceptionNoField(){
        ByteArrayInputStream in = new ByteArrayInputStream(wrong.getBytes());
        System.setIn(in);

        FormData dc = new FormData();
        dc.formData(wrong);
    }
}
