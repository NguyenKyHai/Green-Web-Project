package laptrinh.com.service;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
    public static String RandomString() {
        String input = "0123456789";
        return RandomStringUtils.random(8, input);
    }
}
