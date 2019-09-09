package ltw.aspectj;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateTimeToStringAspectTest {
    @Test
    public void testDateTimeToString() throws Exception {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString());
        System.out.println(dateTime.getClass().getName());
        assertThat(dateTime.toString(), is(DateTimeToStringAspect.TO_STRING_RESULT));
    }
}
