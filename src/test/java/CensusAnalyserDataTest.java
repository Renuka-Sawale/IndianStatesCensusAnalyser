import com.opencsv.bean.CsvBindByName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CensusAnalyserDataTest {
    private static final String CENSUS_CSV_FILE = "F:\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
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
}
