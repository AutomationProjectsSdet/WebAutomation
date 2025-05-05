package com.parabank.controlls;

import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class DateControl {

    private WebDriver driver;

    public DateControl(WebDriver driver) {
        this.driver = driver;
    }


    public int generateFutureDate(int incrementDays) {
        int dayResult = 0;
        try {
            Date currentDate = new Date();
            // Create a Calendar instance and set it to the current date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);

            // Check if the new date is in the next month
            int currentMonth = calendar.get(Calendar.MONTH) +1;

            int originalMonth =currentDate.getMonth() +1;
            // If the new date is in the next month, adjust the day to 1st of the next month
            if (currentMonth != originalMonth) {
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            }
            if(currentMonth== originalMonth){
                calendar.add(Calendar.DAY_OF_MONTH, incrementDays);
            }
           Date newDate = calendar.getTime();
            dayResult=newDate.getDate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dayResult;
    }

}
