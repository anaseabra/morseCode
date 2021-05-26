package br.com.meli.bootcamp.morseCode.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeService {

    public static String morseCodeTranslator(String morseCode) {

        String[] portuguese = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?"};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};

        Map<String, String> dictionary = new HashMap<>();
        for (int count = 0; count < portuguese.length; count++) {
            dictionary.put(morse[count], portuguese[count]);
        }

        StringBuilder stringASC = new StringBuilder();
        String[] palavras = morseCode.split("   ");
        for (int a = 0; a < palavras.length; a++) {
            String[] subs = palavras[a].split(" ");
            for (int i = 0; i < subs.length; i++) {
                stringASC.append(dictionary.get(subs[i]));
            }
            stringASC.append(" ");
        }
        return stringASC.toString();
    }
}
