import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод первого многочлена
        HashMap<Integer, Integer> poly1 = new HashMap<>();
        System.out.print("Введите количество членов первого многочлена: ");
        int n1 = scanner.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.print("Введите степень члена: ");
            int power = scanner.nextInt();
            System.out.print("Введите коэффициент члена: ");
            int coefficient = scanner.nextInt();
            poly1.put(power, coefficient);
        }

        // Ввод второго многочлена
        HashMap<Integer, Integer> poly2 = new HashMap<>();
        System.out.print("Введите количество членов второго многочлена: ");
        int n2 = scanner.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.print("Введите степень члена: ");
            int power = scanner.nextInt();
            System.out.print("Введите коэффициент члена: ");
            int coefficient = scanner.nextInt();
            poly2.put(power, coefficient);
        }

        HashMap<Integer, Integer> result = addPolynomials(poly1, poly2);

        // Вывод результата
        int count = 0;
        int pow = 0;
        if (n1 > n2)
        {
            pow = n1;
        }
        else pow = n2;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.print(entry.getValue() + "x" + "^" + entry.getKey());
            count += 1;

            if (count < pow)
                System.out.print("+");
        }
    }

    public static HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> poly1, HashMap<Integer, Integer> poly2) {
        HashMap<Integer, Integer> result = new HashMap<>();

        // Добавление или обновление коэффициентов из первого многочлена
        for (Map.Entry<Integer, Integer> entry : poly1.entrySet()) {
            result.put(entry.getKey(), entry.getValue() + result.getOrDefault(entry.getKey(), 0));
        }

        // Добавление или обновление коэффициентов из второго многочлена
        for (Map.Entry<Integer, Integer> entry : poly2.entrySet()) {
            result.put(entry.getKey(), entry.getValue() + result.getOrDefault(entry.getKey(), 0));
        }

        // Удаление нулевых коэффициентов
        result.values().removeIf(value -> value == 0);

        return result;
    }
}