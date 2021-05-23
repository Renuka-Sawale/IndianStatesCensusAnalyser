import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public static int loadCensusData(String filePathCSV) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<CensusAnalyserData> csvToBean = new CsvToBeanBuilder<CensusAnalyserData>(reader).withType(CensusAnalyserData.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CensusAnalyserData> CensusAnalyserDataIterator = csvToBean.iterator();
            Iterable<CensusAnalyserData> censusCSVIterable = () -> CensusAnalyserDataIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.FILE_NOT_PROPER);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE);
        }
    }

    public static int loadStateCode(String filePathCSV) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<IndiaStateCodeData> csvToBean = new CsvToBeanBuilder<IndiaStateCodeData>(reader).withType(IndiaStateCodeData.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<IndiaStateCodeData> CensusAnalyserDataIterator = csvToBean.iterator();
            Iterable<IndiaStateCodeData> censusCSVIterable = () -> CensusAnalyserDataIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.FILE_NOT_PROPER);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE);
        }
    }
}
