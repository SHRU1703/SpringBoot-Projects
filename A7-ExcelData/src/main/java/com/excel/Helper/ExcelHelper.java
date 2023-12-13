package com.excel.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.excel.model.Model;



public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	  static String SHEET = "Models";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<Model> excelToTutorials(InputStream is) {
	        try {
	            Workbook workbook = new XSSFWorkbook(is);
	            Sheet sheet = workbook.getSheet(SHEET);
	            Iterator<Row> rows = sheet.iterator();

	            List<Model> models = new ArrayList<>();

	            int rowNumber = 0;
	            while (rows.hasNext()) {
	                Row currentRow = rows.next();

	                // skip header
	                if (rowNumber == 0) {
	                    rowNumber++;
	                    continue;
	                }

	                Iterator<Cell> cellsInRow = currentRow.iterator();

	                Model model = new Model();

	                int cellIdx = 0;
	                while (cellsInRow.hasNext()) {
	                    Cell currentCell = cellsInRow.next();

	                    switch (cellIdx) {
	                        case 0:
	                            model.setId((long) currentCell.getNumericCellValue()); // Corrected type casting
	                            break;

	                        case 1:
	                            model.setTitle(currentCell.getStringCellValue());
	                            break;

	                        case 2:
	                            model.setDescription(currentCell.getStringCellValue());
	                            break;

	                        case 3:
	                            model.setPublished(currentCell.getBooleanCellValue());
	                            break;

	                        default:
	                            break;
	                    }

	                    cellIdx++;
	                }

	                models.add(model);
	            }

	            workbook.close();

	            return models;
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
	        }
	  }
}
	

