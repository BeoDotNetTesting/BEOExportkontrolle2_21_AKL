package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static XSSFWorkbook wb;
	public static HSSFWorkbook wbh;
	public static XSSFSheet sh;
	public static HSSFSheet shh;
	public static FileInputStream f;

	public static ArrayList<String> readDataFromExcel(String filePath, String sheetName)
			throws IOException, InvalidFormatException {
		String path = System.getProperty("user.dir") + filePath;
		ArrayList<String> excelRows = new ArrayList<String>();
		// OPCPackage pkg = OPCPackage.open(new File(path));
		f = new FileInputStream(path);
		// wb = new XSSFWorkbook(f);
		wbh = new HSSFWorkbook(f);
		shh = wbh.getSheet(sheetName);

		DataFormatter formatter = new DataFormatter();

		for (Row r : shh) {
			for (Cell c : r) {
				if (c != null && !c.toString().isEmpty()) {
					excelRows.add(formatter.formatCellValue(c));
			    }
			}
		}
		return excelRows;
	}

	public String readDataFromExcelExportkontrol(int cellNumber, String sheetName)
			throws IOException, InvalidFormatException {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\Exportkontrol.xls";
		ArrayList<String> excelRows = new ArrayList<String>();
		f = new FileInputStream(path);
		wbh = new HSSFWorkbook(f);
		shh = wbh.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		for (Row r : shh) {
			for (Cell c : r) {
				if (c != null && !c.toString().isEmpty()) {
					excelRows.add(formatter.formatCellValue(c));
			    }				
			}
		}
		return excelRows.get(cellNumber);
	}

	public  static String readDataFromExcelExportKontrolleRowColumn(int row, int column,String filePath, String sheetName) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + filePath);
		wbh = new HSSFWorkbook(f);
		shh = wbh.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		Row r = shh.getRow(row);
		Cell c = r.getCell(column);
		String value=formatter.formatCellValue(c);		
		return value;
	}

	public static ArrayList<String> readDataFromExcelNew(String filePath, String sheetName)
			throws IOException, InvalidFormatException {
		String path = System.getProperty("user.dir") + filePath;
		ArrayList<String> excelRows = new ArrayList<String>();
		OPCPackage pkg = OPCPackage.open(new File(path));
		// f = new FileInputStream(path);
		wb = new XSSFWorkbook(pkg);
		sh = wb.getSheet(sheetName);

		DataFormatter formatter = new DataFormatter();

		for (Row r : sh) {
			for (Cell c : r) {
				excelRows.add(formatter.formatCellValue(c));
			}
		}
		return excelRows;
	}

	public void writeDataToExcelParameter(String filePath, String sheetName, int rowNumber, int columnNumber,
			String cellData) {
		try {
			String filename = System.getProperty("user.dir") + filePath;
			wbh = new HSSFWorkbook();
			shh = wbh.createSheet(sheetName);
			HSSFRow rowhead = shh.createRow((short) rowNumber);
			rowhead.createCell(columnNumber).setCellValue(cellData);
			FileOutputStream fileOut = new FileOutputStream(filename);
			wbh.write(fileOut);
			fileOut.close();
			wbh.close();
			System.out.println("Excel file has been generated successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fileWriteExcelWithoutAffectExistingData(String filePath, String sheetName, int rowNum, int columnNum,
			String cellValue) throws IOException {
		File excelFile = new File(System.getProperty("user.dir") + filePath);
		FileInputStream inputStream = new FileInputStream(excelFile);
		wbh = new HSSFWorkbook(inputStream);
		shh = wbh.getSheet(sheetName);
		Row row = shh.getRow(rowNum);
		if (row == null) {
			row = shh.createRow(rowNum);
		}
		Cell cell = row.getCell(columnNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellValue(cellValue);
		FileOutputStream outputStream = new FileOutputStream(excelFile);
		wbh.write(outputStream);
		outputStream.close();
	}

	public static void ExcelSheetCreation() throws Exception {
		// Loading an existing Excel workbook
		FileInputStream file = new FileInputStream(new File("existingWorkbook.xlsx"));
		wbh = new HSSFWorkbook(file);
		// Creating a new sheet
		shh = wbh.createSheet("NewSheet");
		// Writing data to the new sheet
		Row row = shh.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Hello, World!");
		// Saving the changes to the workbook
		FileOutputStream outputStream = new FileOutputStream("existingWorkbook.xlsx");
		wbh.write(outputStream);
		outputStream.close();
	}

}
