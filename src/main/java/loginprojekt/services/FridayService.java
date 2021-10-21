package loginprojekt.services;

import java.util.Calendar;

public class FridayService {
    public static String IsItFriday() {
        Calendar calender = Calendar.getInstance();
        int dayOfWeek = calender.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.FRIDAY) {
            return "It's FRIDAY!!!";
        } else{
            return "Unfortunately today is not a friday";
        }
    }
}
