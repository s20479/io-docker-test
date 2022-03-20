package com.example.io_backend.util;

import java.util.Random;

public class EnumUtils {
    public static <T extends Enum<?>> T randomValue(Class<T> clazz){
        Random rng = new Random();
        int x = rng.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
