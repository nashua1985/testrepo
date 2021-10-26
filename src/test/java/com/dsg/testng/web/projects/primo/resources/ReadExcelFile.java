package com.dsg.testng.web.projects.primo.resources;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcelFile {

  public static ArrayList<FlagStyleSet> readExcelFileFlagStyleSet() {

    ArrayList<FlagStyleSet> flagStyleSetArrayList = new ArrayList<>();

    try {

      File file =
          new File(
              "/Users/dks0270432/Documents/AutomationFiles/PrimoStyleSet2.xlsx"); // creating a new
      // file instance
      FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
      // creating Workbook instance that refers to .xlsx file
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
      // iterating over excel file
      for (Row row : sheet) {
        FlagStyleSet flagStyleSet = new FlagStyleSet();
        Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: // field that represents string cell type
              switch (cell.getColumnIndex()) {
                case 0:
                  flagStyleSet.setStyle(cell.toString());
                  break;
                case 1:
                  flagStyleSet.setPack(cell.toString());
                  break;
                case 2:
                  flagStyleSet.sethCase(cell.toString());
                  break;
                case 3:
                  flagStyleSet.sethUnit(cell.toString());
                  break;
                default:
              }
              // System.out.print(cell.getStringCellValue() + "\t\t\t");
              break;
            case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
              // System.out.print(cell.getNumericCellValue() + "\t\t\t");
              break;
            default:
          }
        }
        flagStyleSetArrayList.add(flagStyleSet);
        // System.out.println(flagStyleSet.toString());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return flagStyleSetArrayList;
  }
}
