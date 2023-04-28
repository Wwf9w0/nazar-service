package com.nazar.service.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nazar.service.model.enums.NumerologyType;
import com.nazar.service.model.response.NumerologyResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumerologyService {

    public NumerologyResponse calculateNumerology(String name) {
        String cleanedName = name.toUpperCase().replaceAll("[^A-Z]", "");
        Map<Character, Integer> letterValues = letterChar();
        int letterValueSum = 0;
        for (char c : cleanedName.toCharArray()) {
            int letterValue = letterValues.get(c);
            letterValueSum += letterValue;
        }
        int finalValue = letterValueSum;
        NumerologyResponse response = numerologyAnalysis(finalValue, name);
        return response;
    }

    private NumerologyResponse numerologyAnalysis(int value, String name) {

        int number = value;
        String numberAsString = Integer.toString(number);
        char firstDigit = numberAsString.charAt(0);
        char secondDigit = numberAsString.charAt(1);
        int digit1 = Character.getNumericValue(firstDigit);
        int digit2 = Character.getNumericValue(secondDigit);

        NumerologyType firsNumerologyType = NumerologyType.fromValue(digit1);
        NumerologyType secondNumerologyType = NumerologyType.fromValue(digit2);
        return NumerologyResponse.builder()
                .name(name)
                .numerology(firsNumerologyType.getDescription() + "," + secondNumerologyType.getDescription())
                .build();
    }

    private Map<Character, Integer> letterChar() {
        Map<Character, Integer> letterValues = new HashMap<>();
        letterValues.put('A', 1);
        letterValues.put('B', 2);
        letterValues.put('C', 3);
        letterValues.put('Ç', 4);
        letterValues.put('D', 5);
        letterValues.put('E', 6);
        letterValues.put('F', 7);
        letterValues.put('G', 8);
        letterValues.put('Ğ', 9);
        letterValues.put('H', 10);
        letterValues.put('I', 11);
        letterValues.put('İ', 12);
        letterValues.put('J', 13);
        letterValues.put('K', 14);
        letterValues.put('L', 15);
        letterValues.put('M', 16);
        letterValues.put('N', 17);
        letterValues.put('O', 18);
        letterValues.put('Ö', 19);
        letterValues.put('P', 20);
        letterValues.put('R', 21);
        letterValues.put('S', 22);
        letterValues.put('Ş', 23);
        letterValues.put('T', 24);
        letterValues.put('U', 25);
        letterValues.put('Ü', 26);
        letterValues.put('V', 27);
        letterValues.put('Y', 28);
        letterValues.put('Z', 29);
        return letterValues;
    }
}