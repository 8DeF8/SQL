package ru.netology.banklogin.data;

import java.util.Locale;
import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {
    private static final Faker FAKER = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }

    private static String generateRandomLogin() {
        return FAKER.name().username();
    }

    private static String generateRandomPassword() {
        return FAKER.internet().password();
    }

    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(FAKER.numerify("######"));
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }
}
