package com.soiadmahedi.uchcharonbd;

import java.util.HashMap;
import java.util.Map;

public class BanglaToEnglishUchcharon {

    // বিভিন্ন ধরনের বাংলা অক্ষরের জন্য আলাদা ম্যাপ তৈরি করা হয়েছে
    private static final Map<Character, String> VOWELS = new HashMap<>();
    private static final Map<Character, String> CONSONANTS = new HashMap<>();
    private static final Map<Character, String> DIACRITICS = new HashMap<>(); // স্বরচিহ্ন বা কার-চিহ্ন
    private static final Map<Character, String> OTHERS = new HashMap<>();

    static {
        // স্বরবর্ণ (Vowels)
        VOWELS.put('অ', "o"); // 'অ' এর উচ্চারণ 'o' ধরা হয়েছে, তবে কিছু ক্ষেত্রে 'a' হতে পারে
        VOWELS.put('আ', "a");
        VOWELS.put('ই', "i");
        VOWELS.put('ঈ', "ee");
        VOWELS.put('উ', "u");
        VOWELS.put('ঊ', "oo");
        VOWELS.put('ঋ', "ri");
        VOWELS.put('এ', "e");
        VOWELS.put('ঐ', "oi");
        VOWELS.put('ও', "o");
        VOWELS.put('ঔ', "ou");

        // ব্যঞ্জনবর্ণ (Consonants)
        CONSONANTS.put('ক', "k");
        CONSONANTS.put('খ', "kh");
        CONSONANTS.put('গ', "g");
        CONSONANTS.put('ঘ', "gh");
        CONSONANTS.put('ঙ', "ng");
        CONSONANTS.put('চ', "ch");
        CONSONANTS.put('ছ', "chh");
        CONSONANTS.put('জ', "j");
        CONSONANTS.put('ঝ', "jh");
        CONSONANTS.put('ঞ', "n");
        CONSONANTS.put('ট', "t");
        CONSONANTS.put('ঠ', "th");
        CONSONANTS.put('ড', "d");
        CONSONANTS.put('ঢ', "dh");
        CONSONANTS.put('ণ', "n");
        CONSONANTS.put('ত', "t");
        CONSONANTS.put('থ', "th");
        CONSONANTS.put('দ', "d");
        CONSONANTS.put('ধ', "dh");
        CONSONANTS.put('ন', "n");
        CONSONANTS.put('প', "p");
        CONSONANTS.put('ফ', "ph"); // 'f' ও ব্যবহার করা যায়
        CONSONANTS.put('ব', "b");
        CONSONANTS.put('ভ', "bh");
        CONSONANTS.put('ম', "m");
        CONSONANTS.put('য', "j"); // কিছু ক্ষেত্রে 'y' ও হতে পারে
        CONSONANTS.put('র', "r");
        CONSONANTS.put('ল', "l");
        CONSONANTS.put('শ', "sh");
        CONSONANTS.put('ষ', "sh");
        CONSONANTS.put('স', "s");
        CONSONANTS.put('হ', "h");
        CONSONANTS.put('ড়', "r");
        CONSONANTS.put('ঢ়', "rh");
        CONSONANTS.put('য়', "y");
        CONSONANTS.put('ৎ', "t");

        // স্বরচিহ্ন (Vowel Diacritics)
        DIACRITICS.put('া', "a");
        DIACRITICS.put('ি', "i");
        DIACRITICS.put('ী', "ee");
        DIACRITICS.put('ু', "u");
        DIACRITICS.put('ূ', "oo");
        DIACRITICS.put('ৃ', "ri");
        DIACRITICS.put('ে', "e");
        DIACRITICS.put('ৈ', "oi");
        DIACRITICS.put('ো', "o");
        DIACRITICS.put('ৌ', "ou");

        // অন্যান্য চিহ্ন (Other Symbols)
        OTHERS.put('ং', "ng"); // অনুস্বার
        OTHERS.put('ঃ', "h");  // বিসর্গ
        OTHERS.put('ঁ', "n");  // চন্দ্রবিন্দু (nasalization)
    }

    public static String transliterate(String banglaText) {
        if (banglaText == null || banglaText.isEmpty()) {
            return "";
        }

        StringBuilder english = new StringBuilder();
        int len = banglaText.length();

        for (int i = 0; i < len; i++) {
            char currentChar = banglaText.charAt(i);

            if (CONSONANTS.containsKey(currentChar)) {
                // বর্তমান অক্ষর যদি ব্যঞ্জনবর্ণ হয়
                english.append(CONSONANTS.get(currentChar));

                // পরের অক্ষরটি কী, তা দেখতে হবে
                if (i + 1 < len) {
                    char nextChar = banglaText.charAt(i + 1);
                    if (DIACRITICS.containsKey(nextChar)) {
                        // পরের অক্ষরটি যদি স্বরচিহ্ন হয়
                        english.append(DIACRITICS.get(nextChar));
                        i++; // পরের অক্ষরটি যেহেতু নিয়ে নিয়েছি, তাই লুপে এটিকে আবার দেখার দরকার নেই
                    } else if (nextChar == '্') {
                        // পরের অক্ষরটি যদি হসন্ত হয়
                        // কিছুই যোগ করার দরকার নেই, কারণ হসন্ত মানে অন্তর্নিহিত 'অ' ধ্বনি নেই
                        i++; // হসন্তকে এড়িয়ে যাওয়ার জন্য i বাড়াতে হবে
                    } else if (!CONSONANTS.containsKey(nextChar) && !VOWELS.containsKey(nextChar)) {
                        // পরের অক্ষরটি যদি ব্যঞ্জনবর্ণ বা স্বরবর্ণ না হয় (যেমন স্পেস, দাঁড়ি), তাহলে 'o' যোগ হবে
                        english.append("o");
                    } else if (CONSONANTS.containsKey(nextChar)) {
                        // পরের অক্ষরটিও ব্যঞ্জনবর্ণ হলে (যুক্তাক্ষর ছাড়া সাধারণ ক্ষেত্রে) 'o' যোগ হবে
                        english.append("o");
                    }
                } else {
                    // শব্দের শেষ ব্যঞ্জনবর্ণের সাথে 'o' যোগ হবে
                    english.append("o");
                }
            } else if (VOWELS.containsKey(currentChar)) {
                // বর্তমান অক্ষর যদি স্বরবর্ণ হয়
                english.append(VOWELS.get(currentChar));
            } else if (OTHERS.containsKey(currentChar)) {
                // বর্তমান অক্ষর যদি অন্যান্য চিহ্নের মধ্যে থাকে
                english.append(OTHERS.get(currentChar));
            } else {
                // অক্ষরটি ম্যাপে না পাওয়া গেলে, যেমন স্পেস, দাঁড়ি, ইত্যাদি
                english.append(currentChar);
            }
        }
        
        // আপনার উদাহরণ "আমি > Ami" এর মতো আউটপুটের প্রথম অক্ষর বড় হাতের করার জন্য:
        // String result = english.toString();
        // if (result.length() > 0) {
        //     return Character.toUpperCase(result.charAt(0)) + result.substring(1);
        // }
        // return result;

        return english.toString();
    }
}
