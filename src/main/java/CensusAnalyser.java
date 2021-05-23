import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public static void main(String[] args) {
        System.out.println("Indian census analyser");
    }
   /* public static int loadCensusData(String filePathCSV) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<CensusAnalyserData> csvToBean = new CsvToBeanBuilder<CensusAnalyserData>(reader)
                    .withType(CensusAnalyserData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CensusAnalyserData> CensusAnalyserDataIterator = csvToBean.iterator();
            Iterable<CensusAnalyserData> censusCSVIterable = () -> CensusAnalyserDataIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE);
        }
    }*/
}
