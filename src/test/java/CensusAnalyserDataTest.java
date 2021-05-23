import com.opencsv.bean.CsvBindByName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CensusAnalyserDataTest {
    private static final String CENSUS_CSV_FILE = "F:\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String CENSUS_CSV_INVALID_FILE = "F:\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensus.csv";
    private static final String CENSUS_CSV_VALID_FILE = "F:\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensus.txt";
    private static final String CENSUS_CSV_WRONG_DELIMITER_FILE = "F:\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStatusCensusDataWrongDelimeter.csv";
    private static final String CENSUS_CSV_WRONG_HEADER_FILE = "F:\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStatusCensusDataWrongHeader";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadCensusData(CENSUS_CSV_FILE);
            System.out.println(numOfRecords);
            Assertions.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaCensusData_WithIncorrectFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCensusData(CENSUS_CSV_INVALID_FILE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenTypeIncorrect_ShouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            CensusAnalyser.loadCensusData(CENSUS_CSV_VALID_FILE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenWrongDelimiter_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCensusData(CENSUS_CSV_WRONG_DELIMITER_FILE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE, e.type);
        }
    }

    @Test
    public void givenWrongHeader_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCensusData(CENSUS_CSV_WRONG_HEADER_FILE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE, e.type);
        }
    }
}
