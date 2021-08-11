public class TextToWords {
    public static void main(String[] args) {
        String str = " Each of these methods returns a boolean indicating success or failure.\n " +
                "More information about a successful match can be obtained by querying the state of the matcher.\n" +
                "A matcher finds matches in a subset of its input called the region. By default, the region contains\n" +
                "all of the matcher's input. The region can be modified via theregion method and queried via the regionStart\n" +
                " and regionEnd methods. The way that the region boundaries interact with some pattern constructs can\n" +
                " be changed. See useAnchoringBounds and useTransparentBounds for more details.\n" +
                "This class also defines methods for replacing matched subsequences with new strings whose contents can, \n" +
                "if desired, be computed from the match result. The appendReplacement and appendTail methods can be used in \n" +
                "tandem in order to collect the result into an existing string buffer, or the more convenient replaceAll method \n" +
                "can be used to create a string in which every matching subsequence in the input sequence is replaced.\n" +
                "The explicit state of a matcher includes the start and end indices of the most recent successful match. \n" +
                "It also includes the start and end indices of the input subsequence captured by each capturing group \n" +
                "in the pattern as well as a total count of such subsequences. As a convenience, methods are also \n" +
                "provided for returning these captured subsequences in string form.\n" +
                "The explicit state of a matcher is initially undefined; attempting to \n" +
                "query any part of it before a successful match will cause an IllegalStateException to be thrown. The \n" +
                "explicit state of a matcher is recomputed by every match operation.\n" +
                "The implicit state of a matcher includes the input character sequence as well as the append position, \n" +
                "which is initially zero and is updated by the appendReplacement method.\n" +
                "A matcher may be reset explicitly by invoking its reset() method or, if a new input sequence is\n" +
                " desired, its reset(CharSequence) method. Resetting a matcher discards its explicit state information \n" +
                "and sets the append position to zero. ";
        String[] reg = str.split("\\s*(\\s|,|!|\\.)\\s*");
        for(String words : reg) {
            System.out.println(words);
        }
    }
}
