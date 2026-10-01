package framework.utils;

import framework.testdata.TestData;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExcelUtils {

    private static final Logger logger = LogManager.getLogger(ExcelUtils.class);

    public static Workbook openWorkbook(String filePath) {
        logger.info("Opening Excel workbook: " + filePath);
        try {
            return WorkbookFactory.create(new File(filePath));
        } catch (Exception e) {
            logger.error("Unable to open Excel workbook: " + filePath, e);
            throw new RuntimeException("Unable to open Excel file: " + filePath, e);
        }
    }

    public static Sheet getSheet(Workbook workbook, String sheetName) {
        logger.info("Reading Excel sheet: " + sheetName);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            logger.error("Sheet not found: " + sheetName);
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        return sheet;
    }

    public static Row getRow(Sheet sheet, int rowNumber) {
        logger.info("Reading Excel row: " + rowNumber);
        Row row = sheet.getRow(rowNumber);

        if (row == null) {
            logger.error("Row not found: " + rowNumber);
            throw new RuntimeException("Row not found: " + rowNumber);
        }

        return row;
    }
    //TestData fields sab String hain:
    public static String getCellValue(Row row, int cellNumber) {

        Cell cell = row.getCell(cellNumber);

        if (cell == null) {
            logger.warn("Cell not found at column: " + cellNumber);
            return "";//Cell nahi mila toh application crash mat karo; empty String return karo.this is basically NullPointerException prevention.
        }

        return cell.toString();
    }

    public static TestData getTestData(Sheet sheet,  String testCaseId) {
        logger.info("Fetching test data for test case: " + testCaseId);
        Row row = getRowByTestCaseId(sheet, testCaseId);

        return new TestData(getCellValue(row, 1), getCellValue(row, 2), getCellValue(row, 3), getCellValue(row, 4), getCellValue(row, 5), getCellValue(row, 6)
        );
    }

    public static Row getRowByTestCaseId(Sheet sheet, String testCaseId) {
        logger.info("Searching Excel for test case: " + testCaseId);
        for (Row row : sheet) {

            String currentTestCaseId = getCellValue(row, 0);

            if (currentTestCaseId.equals(testCaseId)) {
                return row;
            }
        }
        logger.error("Test case not found: " + testCaseId);
        throw new RuntimeException("Test case not found: " + testCaseId);
    }
}