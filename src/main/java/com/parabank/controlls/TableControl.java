package com.parabank.controlls;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableControl {
    private final WebDriver driver;

    public TableControl(WebDriver driver) {
        this.driver = driver;
    }

    public String getCellValue(WebElement tableLocator, int rowIndex, int columnIndex) {
        WebElement row = tableLocator.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(rowIndex);
        WebElement cell = row.findElements(By.tagName("td")).get(columnIndex);
        return cell.getText();
    }

    public String getCellElement(WebElement table, int rowIndex, int columnIndex) {
        WebElement row = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(rowIndex);
        return row.findElements(By.tagName("td")).get(columnIndex).getText();
    }

    public void clickRowByCellValue(WebElement tableLocator, String cellValue) {
        try {
            boolean found = false;
            int cursor = 0;
            List<WebElement> rows = tableLocator.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                cursor++;
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement el : cells) {
                    if (el.getText().equals(cellValue)) {
                        row.click();
                        found = true;
                        break;
                    }
                    if (found == false && cursor > rows.size()) {
                        Assert.fail("Value " + cellValue + " not found in table ");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkCellValueExistsOnFirstPage(WebElement tableLocator, String cellValue) {
        try {
            boolean found = false;
            int cursor = 0;
            List<WebElement> rows = tableLocator.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                cursor++;
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement el : cells) {
                    if (el.getText().equals(cellValue)) {
                        found = true;
                        System.out.println("Value was found in table  " + cellValue);
                        break;
                    }
                    if (found == false && cursor > rows.size()) {
                        Assert.fail("Value " + cellValue + " not found in table ");
                    }
                    if (found == true) {
                        break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void checkCellValueExistsAndClick(WebElement tableLocator, String cellValue) {
        try {
            boolean found = false;
            int cursor = 0;
            List<WebElement> rows = tableLocator.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                cursor++;
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement el : cells) {
                    if (el.getText().equals(cellValue)) {
                        found = true;
                        System.out.println("Value was found in table  " + cellValue);
                        el.click();
                    }
                    if (found == false && cursor > rows.size()) {
                        Assert.fail("Value " + cellValue + " not found in table ");
                    }
                    if (found == true) {
                        break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getRowCount(WebElement table) {
        int count = 0;
        try {
            count = driver.findElements(By.cssSelector("table tbody tr")).size();
            System.out.println("Count from getRowCount"+count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }



    public int getColumnCount(WebElement table) {
        List<WebElement> headerCells = table.findElements(By.tagName("th"));
        return headerCells.size();
    }

    public void failIfNoRows(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        if (rows.isEmpty()) {
            throw new AssertionError("No rows found in the table.");
        }
    }

    public void clickFirstRow(WebElement table) {
        List<WebElement> rows = (table.findElement(By.tagName("tbody"))).findElements(By.tagName("tr"));
        rows.get(0).click();
    }

    public void clickRowById( String id) {
       WebElement row = driver.findElement(By.id(id));
       row.click();

    }
    public void clickRadioBoxFirstRow(WebElement table,By radioBox) {
        List<WebElement> rows = (table.findElement(By.tagName("tbody"))).findElements(By.tagName("tr"));
        if(rows.size()>0 && !rows.isEmpty()){
            rows.get(1).click();
        }

    }

    public void clickCell(By tableLocator, int rowNumber, int columnNumber) {
        // Find the table element
        WebElement table = driver.findElement(tableLocator);
        // Find the rows and columns within the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        if (rowNumber >= 0 && rowNumber < rows.size()) {
            WebElement row = rows.get(rowNumber);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (columnNumber >= 0 && columnNumber < cells.size()) {
                WebElement cell = cells.get(columnNumber);
                cell.click();
            } else {
                throw new IllegalArgumentException("Invalid column number: " + columnNumber);
            }
        } else {
            throw new IllegalArgumentException("Invalid row number: " + rowNumber);
        }
    }


    public void searchPaginatedTable(WebElement table, WebElement pagination, String valueToFind) {
        int allPages = pagination.findElements(By.tagName("li")).size() - 4;
        int nextIndex = pagination.findElements(By.tagName("li")).size() - 2;
        boolean found = false;
        while (allPages > 0) {
            // Locate and process table rows on the current page
           List<WebElement> tableRows = table.findElements(By.cssSelector("table tbody tr"));
            for (WebElement row : tableRows) {
                // Process data in the current row
                if (row.getText().contains(valueToFind)) {
                    found=true;
                    row.click();
                    break;
                }
            }
            if(found==true){
                break;
            }
            // Check if there's a "Next Page" button
            // Click the "Next Page" button
            pagination.findElements(By.tagName("li")).get(nextIndex).click();
            allPages--;
        }
    }


    public boolean tableHasContent(WebElement table) {


        boolean hasContent = false;
        // Locate and process table rows on the current page
        List<WebElement> tableRows = table.findElements(By.cssSelector("table tbody tr"));

        if (tableRows.size() > 1) {
        if (tableRows.size() >= 2) {

            for (WebElement row : tableRows) {
                // Process data in the current row
                if (!row.getText().isEmpty() && !(row.getText() == null)) ;
                hasContent = true;
            }

        } else Assert.fail("There are no rows to check table is empty, row count is " + tableRows.size());
        return hasContent;
    }
        return hasContent;
    }

    public boolean tableHasContent1(WebElement table) {


        boolean hasContent = false;
        // Locate and process table rows on the current page
        List<WebElement> tableRows = table.findElements(By.className("proto-table-row"));
        if (tableRows.size() >= 1) {
            for (WebElement row : tableRows) {
                // Process data in the current row
                if (!row.getText().isEmpty() && !(row.getText() == null)) ;
                hasContent = true;
            }
        }
        return hasContent;
    }




}

