package training.romantoarab.service;

import java.util.HashMap;
import java.util.Map;

public class RomanToArabConverter {

    private static final Map<Character, Integer> ROMAN_TO_ARAB_MAP = new HashMap<>();

    static {
        ROMAN_TO_ARAB_MAP.put('I', 1);
        ROMAN_TO_ARAB_MAP.put('V', 5);
        ROMAN_TO_ARAB_MAP.put('X', 10);
        ROMAN_TO_ARAB_MAP.put('L', 50);
        ROMAN_TO_ARAB_MAP.put('C', 100);
    }

    public int convert(String roman) throws RomanToArabConversionException {
        int number = 0;
        checkIfTheSameRomanCharsAreNoMoreThen3(roman);
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            if (!ROMAN_TO_ARAB_MAP.containsKey(c)) {
                throw new RomanToArabConversionException("Can't convert this roman numeral: " + roman);
            }
            int currentValue = ROMAN_TO_ARAB_MAP.get(c);
            int previousValue = 0;
            if (i > 0) {
                previousValue = ROMAN_TO_ARAB_MAP.get(roman.charAt(i - 1));
            }
            boolean isCurrentGreaterThanPrevious = currentValue > previousValue;
            if (isCurrentGreaterThanPrevious) {
                number += currentValue - 2 * previousValue;
            } else {
                number += currentValue;
            }
        }
        return number;
    }

    private void checkIfTheSameRomanCharsAreNoMoreThen3(String roman) throws RomanToArabConversionException {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        char[] strArray = roman.toCharArray();

        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        if (!charCountMap.entrySet().stream().allMatch(value -> value.getValue() < 4)) {
            throw new RomanToArabConversionException("Can't convert this roman numeral: " + roman);
        }
    }
}
