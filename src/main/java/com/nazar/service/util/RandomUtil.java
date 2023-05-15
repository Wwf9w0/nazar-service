package com.nazar.service.util;

import java.util.Random;

public class RandomUtil {

    public static int randomInt(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }
}
