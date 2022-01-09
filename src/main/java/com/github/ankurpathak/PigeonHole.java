package com.github.ankurpathak;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PigeonHole {

    public static void main(String[] args) {
        System.out.println(findNumberWith1and0DigitsDivisibleByN(9));
        System.out.println(findNumberWith1and0DigitsDivisibleByN(8));
    }

    static String findNumberWith1and0DigitsDivisibleByN(int n){
        StringBuilder result = new StringBuilder("");
        Map<Integer, Integer> frequency = new HashMap<>();
        int remainder = 0;
        for(int i = 1; i <= n; i++){
            remainder = (remainder * 10 + 1 ) % n;
            if(remainder == 0){
                result.append("1".repeat(i));
                return result.toString();
            }
            Integer otherI = frequency.get(remainder);
            if(Objects.nonNull(otherI)){
                result.append("1".repeat(i - otherI));
                result.append("0".repeat(otherI));
                return result.toString();
            }
            frequency.put(remainder, i);
        }
        return result.toString();
    }
}

