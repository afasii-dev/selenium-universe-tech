package util;

public class RandomStringUtils {

    public static String getRandomEmail(int count) {
        return String.format("%s@gmail.com", org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(count));
    }

    public static String getRandomNumeric(int count) {
        return org.apache.commons.lang3.RandomStringUtils.randomNumeric(count);
    }

    public static String randomAlphanumeric(int count) {
        return org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(count);
    }
}
