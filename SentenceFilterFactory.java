public class SentenceFilterFactory {
    public static SentenceFilter createFilter(int choice, String text) {
        if (choice == 1) {
            return new SentenceFinderLongest(text); // фильтр длинных предложений
        } else if (choice == 2) {
            return new SentenceFilterShorter(text); // фильтр коротких предложений
        } else {
            return null;
        }
    }
}
