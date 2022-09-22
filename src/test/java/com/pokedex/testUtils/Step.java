package com.pokedex.testUtils;

import lombok.SneakyThrows;

public interface Step {
    @SneakyThrows
    default void exec(Tests tests) {
    }

    @SneakyThrows
    default void verify(Tests tests) {
    }

    @SneakyThrows
    default void execAndVerify(Tests tests) {
        exec(tests);
        verify(tests);
    }
}
