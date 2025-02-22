public class SentenceFilterShorter extends SentenceFinderLongest {
    public SentenceFilterShorter(String text) {
        super(text);
    }

    @Override
    public void filterByLength(int length) {
        System.out.println("\nПредложения длиной меньше " + length + " символов:");
        for (String sentence : sentences) {
            if (sentence.trim().length() < length) {
                System.out.println(sentence.trim() + ".");
            }
        }
    }
}
