public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        FILE_NOT_PROPER;
        public static ExceptionType WRONG_FILE;
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}