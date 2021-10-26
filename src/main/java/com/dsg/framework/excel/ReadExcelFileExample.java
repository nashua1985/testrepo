package com.dsg.framework.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelFileExample {

  public static void main(String[] args) {
    try {
      File file =
          new File(
              "/Users/dks0270432/Documents/AutomationFiles/PrimoStyleSet.xlsx"); // creating a new
                                                                                 // file instance
      FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
      // creating Workbook instance that refers to .xlsx file
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
      // iterating over excel file
      for (Row row : sheet) {
        Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: // field that represents string cell type
              System.out.print(cell.getStringCellValue() + "\t\t\t");
              break;
            case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
              System.out.print(cell.getNumericCellValue() + "\t\t\t");
              break;
            default:
          }
        }
        System.out.println();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
