package framework.utils;

import framework.testdata.TestData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestDataManager {

    private static final Logger logger = LogManager.getLogger(TestDataManager.class);

    public static TestData getTestData(String testCaseId) {
        logger.info("Loading test data for test case: " + testCaseId);

        String filePath = ConfigReader.getProperty("testDataPath");

        logger.info("Test data file: " + filePath);

        Workbook workbook = ExcelUtils.openWorkbook(filePath);

        String sheetName = ConfigReader.getProperty("testDataSheet");

        logger.info("Test data sheet: " + sheetName);

        Sheet sheet = ExcelUtils.getSheet(workbook, sheetName);

        TestData testData = ExcelUtils.getTestData(sheet, testCaseId);

        logger.info("Test data loaded successfully for: " + testCaseId);

        return testData;
    }
}