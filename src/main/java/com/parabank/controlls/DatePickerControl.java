package com.parabank.controlls;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatePickerControl {
    private WebDriver driver;

    public DatePickerControl(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDate(Date targetDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //openDatePicker();
        selectYear(year);
        //selectMonth(String.valueOf(month));
        selectDay(day);
    }

    public void openDatePicker(WebElement datePickerInput) {
        datePickerInput.click();
    }

    private void selectYear(int year) {
        WebElement yearContainer = driver.findElement(By.className("react-datepicker-year-header"));
        String actualYear = yearContainer.getText();
        if (Integer.parseInt(actualYear) == year) {
            System.out.println("no need to do anything required year is displaied");
        }
        if (Integer.parseInt(actualYear) > year) {
            int difference =  Integer.parseInt(actualYear) - year ;
            WebElement presiousNavigator = driver.findElement(By.className("react-datepicker__navigation--previous"));
            while (difference > 0) {
                presiousNavigator.click();
                difference--;
            }
        }
        if (Integer.parseInt(actualYear) < year) {
            int difference = year-Integer.parseInt(actualYear);
            WebElement nextNavigator = driver.findElement(By.className("react-datepicker__navigation--next"));
            while (difference > 0) {
                nextNavigator.click();
                difference--;
            }
        }
    }


    private void selectMonth(String  month) {
        List<WebElement>  monthsList = driver.findElements(By.className("react-datepicker__month-text"));
        for (WebElement elMonth:monthsList){
            if(month.contains((elMonth.getText()).toUpperCase()))
            {
                elMonth.click();
                break;
            }
        }


        // Select month from dropdown
    }
    public LocalDate convertStringToDate(String dateString){
        List<DateTimeFormatter> formatters = new ArrayList<>();
        formatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        formatters.add(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate date = null;
        for (DateTimeFormatter formatter : formatters) {
            try {
                date = LocalDate.parse(dateString, formatter);
                break;
            } catch (Exception e) {
            }
        }
        if (date != null) {
            System.out.println("Converted date: " + date);

        } else {
            System.out.println("Date parsing failed for input: " + dateString);
        }
        return date;
    }


    public void selectDay(int day) {
        List<WebElement> daysElement = driver.findElements(By.xpath("(//div[text()='" + day + "'])"));
        if(daysElement.size()>1){
            daysElement.get(1).click();
        }
        else {
            daysElement.get(0).click();
        }
    }

    /* This method set date in type calendar which displies dates and month*/
    public void setDate(Date targetDate,WebElement datepickerLocator) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        openDatePicker(datepickerLocator);
        selectDay(day);
    }
    /* This method set year in type calendar which displies months and year*/

    public void setMonthYear(String targetDate,WebElement datepickerLocator) {
        LocalDate date= convertStringToDate(targetDate);
        int year = date.getYear();
        String month = date.getMonth().name();
        openDatePicker(datepickerLocator);
        selectYear(year);
        selectMonth(month);

    }

    public void setDateText(WebElement element,String date) {
    element.clear();
    element.sendKeys(date);


    }
}

