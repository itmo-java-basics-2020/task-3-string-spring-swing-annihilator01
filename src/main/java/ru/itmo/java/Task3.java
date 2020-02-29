package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        }

        for (int i = inputArray.length - 1; i >= 1; i--) {
            swap(inputArray, i, (i + 1) % inputArray.length);
        }

        return inputArray;
    }

    private void swap(int[] inputArray, int i, int j) {
        int tmp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = tmp;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        } else if (inputArray.length == 1) {
            return inputArray[0];
        }

        Arrays.sort(inputArray);

        return inputArray[inputArray.length - 1] * inputArray[inputArray.length - 2];
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int countA = 0;
        int countB = 0;

        for (char letter : input.toCharArray()) {
            if (Character.toLowerCase(letter) == 'a') {
                countA++;
            } else if (Character.toLowerCase(letter) == 'b') {
                countB++;
            }
        }

        return ((countA + countB) * 100 / input.length());
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null) {
            return "";
        }

        int i = 0;
        StringBuilder encodedStringBuilder = new StringBuilder();

        while (i < input.length()) {
            int count = 0;
            char letter = input.charAt(i);

            while (i < input.length() && letter == input.charAt(i)) {
                count++;
                i++;
            }

            encodedStringBuilder.append(letter).append(count);
        }

        return encodedStringBuilder.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.isEmpty() || two.isEmpty() || one.length() != two.length()) {
            return false;
        }

        char[] oneArray = one.toCharArray();
        char[] twoArray = two.toCharArray();

        Arrays.sort(oneArray);
        Arrays.sort(twoArray);

        for (int i = 0; i < one.length(); i++) {
            if (oneArray[i] != twoArray[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        for (int i = 1; i < sArray.length; i++) {
            if (sArray[i] == sArray[i - 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[0][0];
        }

        int[][] transposed = new int[m.length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                transposed[j][i] = m[i][j];
            }
        }

        return transposed;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null) {
            return "";
        }

        if (separator == null) {
            separator = ' ';
        }

        StringBuilder finalStringBuilder = new StringBuilder();
        for (int i = 0; i < inputStrings.length; i++) {
            finalStringBuilder.append(inputStrings[i]);

            if (i != inputStrings.length - 1) {
                finalStringBuilder.append(separator);
            }
        }

        return finalStringBuilder.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }

        int count = inputStrings.length;
        for (String string : inputStrings) {
            if (string.length() < prefix.length()) {
                count--;
                continue;
            }

            for (int i = 0; i < prefix.length(); i++) {
                if (string.charAt(i) != prefix.charAt(i)) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}
