package com.saucedemo.utils;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class DataProvider {
    public static Stream<Arguments> validUsers() {
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("problem_user", "secret_sauce"),
                Arguments.of("performance_glitch_user", "secret_sauce")
        );
    }
}