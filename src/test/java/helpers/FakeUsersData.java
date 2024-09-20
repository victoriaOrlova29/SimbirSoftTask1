package helpers;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FakeUsersData {
    static Faker faker = new Faker();
    @Getter
    public static final String LastName = faker.name().lastName();
    @Getter
    public static String postCode = generatePostCode();
    @Getter
    public static String firstName = convertNumbersToLetters(postCode);

    public static String generatePostCode() {
        Random random = new Random();
        return IntStream.range(0, 10)
                .map(i -> random.nextInt(10))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String convertNumbersToLetters(String postCode) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < postCode.length(); i += 2) {
            String group = postCode.substring(i, Math.min(i + 2, postCode.length()));
            int num = Integer.parseInt(group);

            char letter = (char) ('a' + (num % 26));
            result.append(letter);
        }
        String resultString = result.toString();

        return resultString.substring(0, 1).toUpperCase() + resultString.substring(1);
    }
}


