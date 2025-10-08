package com.soiadmahedi.uchcharonbd;

import java.util.HashMap;
import java.util.Map;

public class BanglaToSylhetiUchcharon {

    // বিভিন্ন ধরনের বাংলা অক্ষরের জন্য আলাদা ম্যাপ তৈরি করা হয়েছে
    private static final Map<Character, String> BENGALI_VOWELS = new HashMap<>();
    private static final Map<Character, String> BENGALI_CONSONANTS = new HashMap<>();
    private static final Map<Character, String> BENGALI_DIACRITICS = new HashMap<>();
    private static final Map<Character, String> BENGALI_OTHERS = new HashMap<>();

    static {
        // ১. সঠিক ম্যাপিং: বাংলা স্বরবর্ণ -> সিলেটি নাগরী স্বরবর্ণ
        BENGALI_VOWELS.put('অ', "ꠅ"); // নাগরীতে 'অ' এর স্বাধীন রূপ নেই, এটি ব্যঞ্জনের সাথে থাকে। তবে স্বতন্ত্র ব্যবহারে 'ꠅ' (এ) ব্যবহার করা হয়।
        BENGALI_VOWELS.put('আ', "ꠀ");
        BENGALI_VOWELS.put('ই', "ꠁ");
        BENGALI_VOWELS.put('ঈ', "ꠂ");
        BENGALI_VOWELS.put('উ', "ꠃ");
        BENGALI_VOWELS.put('ঊ', "ꠄ");
        BENGALI_VOWELS.put('এ', "ꠅ");
        BENGALI_VOWELS.put('ও', "꠆");
        // 'ঋ', 'ঐ', 'ঔ' এর সরাসরি প্রতিরূপ নেই, এগুলোকে লজিকে হ্যান্ডেল করা হবে।

        // ২. সঠিক ম্যাপিং: বাংলা ব্যঞ্জনবর্ণ -> সিলেটি নাগরী ব্যঞ্জনবর্ণ
        BENGALI_CONSONANTS.put('ক', "ꠇ");
        BENGALI_CONSONANTS.put('খ', "ꠈ");
        BENGALI_CONSONANTS.put('গ', "ꠉ");
        BENGALI_CONSONANTS.put('ঘ', "ꠉ"); // 'ঘ' এর প্রতিরূপ নেই, 'গ' ব্যবহৃত হয়
        BENGALI_CONSONANTS.put('ঙ', "ꠋ");
        BENGALI_CONSONANTS.put('চ', "ꠌ");
        BENGALI_CONSONANTS.put('ছ', "ꠍ");
        BENGALI_CONSONANTS.put('জ', "ꠎ");
        BENGALI_CONSONANTS.put('ঝ', "ꠎ"); // 'ঝ' এর প্রতিরূপ নেই, 'জ' ব্যবহৃত হয়
        BENGALI_CONSONANTS.put('ঞ', "ঞ");
        BENGALI_CONSONANTS.put('ট', "ꠐ");
        BENGALI_CONSONANTS.put('ঠ', "ꠑ");
        BENGALI_CONSONANTS.put('ড', "ꠒ");
        BENGALI_CONSONANTS.put('ঢ', "ꠒ"); // 'ঢ' এর প্রতিরূপ নেই, 'ড' ব্যবহৃত হয়
        BENGALI_CONSONANTS.put('ণ', "ꠘ"); // 'ণ' এর জায়গায় 'ন'
        BENGALI_CONSONANTS.put('ত', "ꠔ");
        BENGALI_CONSONANTS.put('থ', "ꠕ");
        BENGALI_CONSONANTS.put('দ', "ꠖ");
        BENGALI_CONSONANTS.put('ধ', "ꠖ"); // 'ধ' এর প্রতিরূপ নেই, 'দ' ব্যবহৃত হয়
        BENGALI_CONSONANTS.put('ন', "ꠘ");
        BENGALI_CONSONANTS.put('প', "ꠙ");
        BENGALI_CONSONANTS.put('ফ', "ꠚ");
        BENGALI_CONSONANTS.put('ব', "ꠛ");
        BENGALI_CONSONANTS.put('ভ', "ꠜ");
        BENGALI_CONSONANTS.put('ম', "ꠝ");
        BENGALI_CONSONANTS.put('য', "ꠎ"); // 'য' এর জায়গায় 'জ'
        BENGALI_CONSONANTS.put('র', "ꠞ");
        BENGALI_CONSONANTS.put('ল', "ꠟ");
        BENGALI_CONSONANTS.put('শ', "ꠡ");
        BENGALI_CONSONANTS.put('ষ', "ꠡ"); // 'ষ' এর জায়গায় 'শ'
        BENGALI_CONSONANTS.put('স', "ꠡ"); // 'স' এর জায়গায় 'শ'
        BENGALI_CONSONANTS.put('হ', "ꠢ");
        BENGALI_CONSONANTS.put('ড়', "ꠞ");
        BENGALI_CONSONANTS.put('ঢ়', "ꠞ");
        BENGALI_CONSONANTS.put('য়', "ꠁ");
        BENGALI_CONSONANTS.put('ৎ', "ꠔ");

        // ৩. সঠিক ম্যাপিং: বাংলা স্বরচিহ্ন -> সিলেটি নাগরী স্বরচিহ্ন
        BENGALI_DIACRITICS.put('া', "ꠣ");
        BENGALI_DIACRITICS.put('ি', "ꠤ");
        BENGALI_DIACRITICS.put('ী', "ꠥ");
        BENGALI_DIACRITICS.put('ু', "ꠦ");
        BENGALI_DIACRITICS.put('ূ', "ꠧ");
        BENGALI_DIACRITICS.put('ে', "ꠦ"); // 'ু' এবং 'ে' কারের জন্য একই চিহ্ন
        BENGALI_DIACRITICS.put('ো', "ꠧ"); // 'ূ' এবং 'ো' কারের জন্য একই চিহ্ন
        BENGALI_DIACRITICS.put('ৃ', "ꠞꠤ"); // ঋ-কার = র + ই-কার

        // ৪. অন্যান্য চিহ্ন
        BENGALI_OTHERS.put('ং', "ꠋ"); // অনুস্বার
        BENGALI_OTHERS.put('ঃ', "");  // বিসর্গ নাগরীতে নেই
        BENGALI_OTHERS.put('ঁ', "◌̃"); // চন্দ্রবিন্দু (Combining Tilde)
    }

    public static String convertToNagri(String banglaText) {
        if (banglaText == null || banglaText.isEmpty()) {
            return "";
        }

        StringBuilder nagri = new StringBuilder();
        int len = banglaText.length();

        for (int i = 0; i < len; i++) {
            char currentChar = banglaText.charAt(i);

            // বিশেষ স্বরবর্ণ হ্যান্ডেল করা
            if (currentChar == 'ঐ') {
                nagri.append("ꠅꠁ"); // এ + ই
                continue;
            }
            if (currentChar == 'ঔ') {
                nagri.append("ꠅꠃ"); // এ + উ
                continue;
            }
             if (currentChar == 'ঋ') {
                nagri.append("ꠞꠤ"); // র + ই
                continue;
            }


            if (BENGALI_CONSONANTS.containsKey(currentChar)) {
                nagri.append(BENGALI_CONSONANTS.get(currentChar));

                if (i + 1 < len) {
                    char nextChar = banglaText.charAt(i + 1);

                    // বিশেষ স্বরচিহ্ন হ্যান্ডেল করা
                    if (nextChar == 'ৈ') {
                        nagri.append("ꠦꠁ"); // ে-কার + ই
                        i++;
                    } else if (nextChar == 'ৌ') {
                        nagri.append("ꠧꠃ"); // ো-কার + উ
                        i++;
                    } else if (BENGALI_DIACRITICS.containsKey(nextChar)) {
                        nagri.append(BENGALI_DIACRITICS.get(nextChar));
                        i++;
                    } else if (nextChar == '্') {
                        nagri.append("ꠢ"); // হসন্ত বা "Hasanta"
                        i++;
                    }
                }
            } else if (BENGALI_VOWELS.containsKey(currentChar)) {
                nagri.append(BENGALI_VOWELS.get(currentChar));
            } else if (BENGALI_OTHERS.containsKey(currentChar)) {
                nagri.append(BENGALI_OTHERS.get(currentChar));
            } else {
                // ম্যাপে না পাওয়া গেলে (যেমন স্পেস, দাঁড়ি, ইত্যাদি) অক্ষরটি সরাসরি যোগ হবে
                nagri.append(currentChar);
            }
        }
        return nagri.toString();
    }
    
}
