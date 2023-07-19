package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerator {

    private static final int LENGTH_NAME_PROJECT = 10;
    private static final int LENGTH_CODE_PROJECT = 3;
    private static final int LENGTH_NAME_SUITE = 8;
    private static final int NUMBER_WORDS_TITLE_CASE = 5;
    private static Faker faker = new Faker();
    public static String generateNameProject() {
        return faker.lorem().characters(LENGTH_NAME_PROJECT);
    }
    public static String generateCodeProject() {
        return faker.lorem().characters(LENGTH_CODE_PROJECT).toUpperCase(Locale.ENGLISH);
    }
    public static String generateNameSuite() {
        return faker.lorem().characters(LENGTH_NAME_SUITE);
    }

    public static String generateTitleCase() {
        return faker.lorem().words(NUMBER_WORDS_TITLE_CASE).toString();
    }
}
