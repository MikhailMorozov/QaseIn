package utilities;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String generateName() {
        return faker.lorem().characters(10);
    }
}
