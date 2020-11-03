package chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Questions {

    public static void main(String[] args) {
        System.out.println(isUnique("Shamil "));
        System.out.println(isPermutation("ssamil", "slimas"));
        System.out.println(isPermutation1("ssamil", "slimas"));

        char[] chars = "Mr John is    ".toCharArray();
        System.out.println(replaceSpaces(chars, 10));
        System.out.println(palindromePermutation("TactCoaaooo".toLowerCase()));
        System.out.println(oneEditAway("pale", "bae"));
        System.out.println(compressed("aabbvccccaac"));
        System.out.println(compressedBetter("aabbvccccaac"));
        System.out.println(Arrays.deepToString(rotate(initArr(3))));
        System.out.println(Arrays.deepToString(rotateInPlace(initArr(3))));
        System.out.println(Arrays.deepToString(makeZero(initArr(3))));
        System.out.println(isRotation("waterbottle", "rbottlewate"));

    }

    static boolean isUnique(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];

        for (int j = 0; j < str.length(); j++) {
            int i = str.charAt(j);

            if (char_set[i]) return false;

            char_set[i] = true;
        }
        return true;
    }

    static boolean isPermutation(String str, String str1) {
        if (str.length() != str1.length()) return false;
        return sort(str).equals(sort(str1));
    }

    private static String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    static boolean isPermutation1(String str, String str1) {
        int[] char_set = new int[128];

        for (int i = 0; i < str.length(); i++)
            char_set[str.charAt(i)]++;

        for (int i = 0; i < str1.length(); i++) {
            int c = str1.charAt(i);
            char_set[c]--;
            if (char_set[c] < 0)
                return false;
        }

        return true;
    }

    static char[] replaceSpaces(char[] str, int trueLength) {
        int length = str.length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                str[length] = str[i];
                length--;
            } else if (str[i] == ' ') {
                str[length] = '0';
                str[length - 1] = '2';
                str[length - 2] = '%';
                length -= 3;
            }
        }
        return str;
    }

    static boolean palindromePermutation(String str) {
        HashMap<Character, Integer> charCount = countChars(str);
        boolean flag = false;
        for (char c : charCount.keySet()) {
            int val = charCount.get(c);
            if (val % 2 == 1) {
                if (flag)
                    return false;
                flag = true;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> countChars(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                map.put(c, ++val);
            } else map.put(c, 1);
        }
        return map;
    }

    static boolean oneEditAway(String first, String second) {
        if (second.length() + 1 == first.length())
            return smaller(first, second);
        if (second.length() - 1 == first.length())
            return smaller(second, first);
        if (second.length() == first.length())
            return sameLength(first, second);
        return false;
    }

    static boolean smaller(String first, String second) {
        int index1 = 0, index2 = 0;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (index1 != index2)
                    return false;
                index1++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    static boolean sameLength(String first, String second) {
        boolean isFound = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (isFound) {
                    return false;
                }
                isFound = true;
            }
        }

        return false;
    }

    //problematic one
    static boolean oneEditAwayBetter(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1)
            return false;

        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;
        boolean isFound = false;
        int shorterIndex = 0;
        int longerIndex = 0;


        while (longerIndex < shorter.length() && shorterIndex < shorter.length()) {
            if (longer.charAt(longerIndex) != shorter.charAt(shorterIndex)) {
                if (isFound) {
                    return false;
                }
                isFound = true;
                if (first.length() != second.length())
                    return false;

                longerIndex++;
            }
            longerIndex++;
            shorterIndex++;
        }
        return true;
    }

    static String compressed(String str) {
        StringBuilder resStr = new StringBuilder();
        char c = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i))
                count++;
            else {
                resStr.append(c).append(count);
                c = str.charAt(i);
                count = 1;
            }
        }
        resStr.append(c).append(count);
        return resStr.toString();
    }

    static String compressedBetter(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count++;

            if (i + 1 == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                stringBuilder.append(str.charAt(i)).append(count);
                count = 0;
            }
        }
        return stringBuilder.toString();
    }

    static int[][] rotate(int[][] arr) {
        int length = arr.length;
        int[][] resArr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            int k = length - 1 - i;
            for (int j = 0; j < arr.length; j++) {
                resArr[j][k] = arr[i][j];
            }
        }
        return resArr;
    }

    static int[][] rotateInPlace(int[][] arr) { //todo do it again
        int length = arr.length;

        for (int layer = 0; layer < length / 2; layer++) {
            for (int i = layer; i < length - layer; i++) {
                int index = arr.length - i - 1;
                int temp = arr[layer][i];

                arr[layer][i] = arr[index][i];
                System.out.println(arr[layer][i]);
                arr[index][i] = arr[index][index];
                System.out.println(arr[index][i]);
                arr[index][index] = arr[i][index];
                System.out.println(arr[index][index]);
                arr[i][index] = temp;
                System.out.println(arr[i][index]);
            }
        }
        return arr;
    }

    static int[][] initArr(int length) {
        int[][] arr = new int[length][length];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = count;
//                if (count == 5)
//                    arr[i][j] = 0;
                count++;
            }
        }
        return arr;
    }

    static int[][] makeZero(int[][] arr) {
        boolean[] row = new boolean[arr.length];
        boolean[] col = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    col[j] = true;
                    row[i] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i] == true) {
                makeRowZero(arr, i);
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i] == true) {
                makeColZero(arr, i);
            }
        }

        return arr;
    }

    static void makeRowZero(int[][] arr, int index) {
        for (int i = 0; i < arr[index].length; i++) {
            arr[index][i] = 0;
        }
    }

    static void makeColZero(int[][] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][index] = 0;
        }
    }

    static boolean isRotation(String s1, String s2) {
        String resStr = s1;
        int i = 0;
        while (!resStr.equals(s2) && i < s1.length()) {
            char first = s1.charAt(i);
            resStr = resStr.substring(1) + first;
            i++;
        }
        if (resStr.equals(s2))
            return true;
        return false;
    }
}
