public class SentenceFinderLongest implements SentenceFilter {
    protected String[] sentences;

    public SentenceFinderLongest(String text) {
        this.sentences = text.split("\\.");
    }

    @Override
    public void filterByLength(int length) {
        System.out.println("\nПредложения длиной больше " + length + " символов:");
        for (String sentence : sentences) {
            if (sentence.trim().length() > length) {
                System.out.println(sentence.trim() + ".");
            }
        }
    }

    public void findLongestSentence() {
        String longestSentence = "";
        int maxLength = 0;
        for (String sentence : sentences) {
            int sentenceLength = sentence.length();
            if (sentenceLength > maxLength) {
                longestSentence = sentence;
                maxLength = sentenceLength;
            }
        }
        System.out.println("Самое длинное предложение: \"" + longestSentence.trim() + "\"");
        System.out.println("Длина: " + maxLength + " символов.");
    }
}
