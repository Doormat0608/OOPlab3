import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Выберите операцию: \n");
        System.out.print("Введите 1 для поиска предложений, длина которых больше порога:\n");
        System.out.print("Введите 2 для поиска предложений, длина которых меньше порога:\n");
        int initialChoice = TryParseInt();

        System.out.print("Введите текст: ");
        String text = in.nextLine();

        // создание фильтра через фабрику
        SentenceFilter sentenceFilter = SentenceFilterFactory.createFilter(initialChoice, text);

        // проверяем, успешно ли создан фильтр
        if (sentenceFilter != null) {

            System.out.println("\nВыберите операцию:");
            System.out.println("1 - Фильтрация предложений");
            System.out.println("2 - Поиск самого длинного предложения");
            int secondChoice = TryParseInt();

            if (secondChoice == 1) {

                System.out.print("Введите порог: ");
                int threshold = TryParseInt();
                sentenceFilter.filterByLength(threshold);
            } else if (secondChoice == 2 && sentenceFilter instanceof SentenceFinderLongest) {
                // поиск самого длинного предложения
                ((SentenceFinderLongest) sentenceFilter).findLongestSentence();
            }
        } else {
            System.out.println("Некорректный выбор.");
        }
    }

    public static Integer TryParseInt() {
        try {
            Scanner _in = new Scanner(System.in);
            return Integer.parseInt(_in.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
