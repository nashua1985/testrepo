package com.dsg.cucumber.utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

/*
 * This is a utility for reading from writing to excel files.
 * it works with xls and xlsx files.
 */
public class ExcelUtil {

	private Sheet workSheet;
	private Workbook workBook;
	private String path;

	public ExcelUtil(String path, String sheetName) {
		this.path = path;
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			// Access the required test data sheet
			workBook = WorkbookFactory.create(ExcelFile);
			workSheet = (Sheet) workBook.getSheet(sheetName);
			// check if sheet is null or not. null means sheetname was wrong
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public String getCellData(int rowNum, int colNum) {
		Cell cell;
		String cellData = "";
		try {
			cell = workSheet.getRow(rowNum).getCell(colNum);
			cellData = cell.toString();
				
		} catch (Exception e) {
//			throw new RuntimeException(e);
//			if (e.toString().contains("NullPointerException")) {
				setCellData("MISSING", rowNum, colNum);
//			} 
		} 
			return cellData;
	}

	public String[][] getDataArray() {

		String[][] data = new String[rowCount()][columnCount()];

		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < columnCount(); j++) {
				String value = getCellData(i, j);
				data[i][j] = value;
			}
		}
		return data;
	}

	public List<String> getDataArrayList(int columnNumber) {

//        String[] data = getDataArray()[column];

		List<String> list = new ArrayList<>();
		int col = columnNumber;
		// column name should be present as i=0
		for (int i = 1; i < rowCount(); i++) {
			String value = getCellData(i, col);
			list.add(value);
		}
		return list;
	}

	public List<Map<String, String>> getDataList() {
		// get all columns
		List<String> columns = getColumnsNames();
		// this will be returned
		List<Map<String, String>> data = new ArrayList<>();

		for (int i = 1; i < rowCount(); i++) {
			// get each row
			Row row = workSheet.getRow(i);
			// create map of the row using the column and value
			// column map key, cell value --> map bvalue
			Map<String, String> rowMap = new HashMap<String, String>();
			for (Cell cell : row) {
				int columnIndex = cell.getColumnIndex();
				rowMap.put(columns.get(columnIndex), cell.toString());
			}

			data.add(rowMap);
		}

		return data;
	}

	public List<String> getColumnsNames() {
		List<String> columns = new ArrayList<>();

		for (Cell cell : workSheet.getRow(0)) {
			columns.add(cell.toString());
		}
		return columns;
	}

	public void setCellData(String value, int rowNum, int colNum) {
		Cell cell;
		Row row;

		try(FileOutputStream fileOut = new FileOutputStream(path)) {
			row = workSheet.getRow(rowNum);
			cell = row.getCell(colNum);

			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
		
			workBook.write(fileOut);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCellData(int value, int rowNum, int colNum) {
		Cell cell;
		Row row;

		try(FileOutputStream fileOut = new FileOutputStream(path)) {
			row = workSheet.getRow(rowNum);
			cell = row.getCell(colNum);

			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}

			workBook.write(fileOut);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCellData(String value, String columnName, int row) {
		int column = getColumnsNames().indexOf(columnName);
		setCellData(value, row, column);
	}

	public int columnCount() {
		return workSheet.getRow(0).getLastCellNum();
	}

	public int rowCount() {
		return workSheet.getLastRowNum() + 1;
	}

}
