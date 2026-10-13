package lssn9;

public class HW9lssn {
    static int y = 123456789;

    public static void main(String[] args) {

        // Переполнение
        int max = Integer.MAX_VALUE;
        int x = max + 1;
        System.out.println("Переполнение int: " + x);   // -2147483648

        // Математические операторы: % и /
        System.out.println("Последняя цифра числа " + y + ": " + (y % 10));   // 9
        System.out.println("Без последней цифры: " + (y / 10));              // 12345678

        // Инкремент и декремент — по отдельным строкам, чтобы видеть суть
        System.out.println("y до: " + y);      // 123456789
        y++;
        System.out.println("после y++: " + y); // 123456790
        y--;
        System.out.println("после y--: " + y); // 123456789

        // Постфикс: сначала отдай старое, потом увеличь
        int a = 5;
        int w = a++;   // w = 5, a = 6
        System.out.println("Постфикс: w = " + w + ", a = " + a);

        // Префикс: сначала увеличь, потом отдай новое
        int b = 5;
        int z = ++b;   // z = 6, b = 6
        System.out.println("Префикс: z = " + z + ", b = " + b);
    }
}
