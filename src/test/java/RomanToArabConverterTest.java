import training.romantoarab.service.RomanToArabConverter;
import training.romantoarab.service.RomanToArabConversionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RomanToArabConverterTest {

    RomanToArabConverter testConverter;

    @BeforeEach
    void setUp() {
        testConverter = new RomanToArabConverter();
    }

    @ParameterizedTest
    @MethodSource("romanToNumber")
    void testConvertShouldConvertRomanNumber(String testRoman, int expectedValue) throws RomanToArabConversionException {
        //GIVEN
        //WHEN
        int actualValue = testConverter.convert(testRoman);
        //THEN
        Assertions.assertEquals(expectedValue, actualValue, "Testing convert with roman " + testRoman);
    }

    @Test
    void testConvertThrowsRomanToNumberConvertExceptionIfTheSameRomanNumeralRepeatedMoreThan3Times() {
        //GIVEN
        String testRoman = "IIII";
        //WHEN
        //THEN
        Assertions.assertThrows(RomanToArabConversionException.class, () -> {
            testConverter.convert(testRoman);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "D", "E", "F", "G"})
    void testConvertThrowsRomanToNumberConvertExceptionIfTheRomanNumeralsAreIncorrect(String testRoman) {
        //GIVEN
        //WHEN
        //THEN
        Assertions.assertThrows(RomanToArabConversionException.class, () -> {
            testConverter.convert(testRoman);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"I", "V", "X", "L", "C"})
    void testConvertMethodDoesNotThrowIfRomanNumeralsAreCorrect(String testRoman) {
        //GIVEN
        //WHEN
        //THEN
        Assertions.assertDoesNotThrow(() -> testConverter.convert(testRoman));
    }

    private static Stream<Arguments> romanToNumber() {
        return Stream.of(
                arguments("I", 1),
                arguments("II", 2),
                arguments("III", 3),
                arguments("IV", 4),
                arguments("V", 5),
                arguments("VI", 6),
                arguments("VII", 7),
                arguments("VIII", 8),
                arguments("IX", 9),
                arguments("X", 10)
        );
    }

}
