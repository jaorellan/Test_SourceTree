import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> tasasCambio = new HashMap<>();
        tasasCambio.put("USD", 1.0);      // Dólar base
        tasasCambio.put("EUR", 0.91);     // Euro
        tasasCambio.put("MXN", 16.80);    // Peso mexicano
        tasasCambio.put("JPY", 150.27);   // Yen japonés

        Scanner scanner = new Scanner(System.in);
        System.out.println("Conversor de Monedas");

        while (true) {
            System.out.println("\nMonedas disponibles: " + tasasCambio.keySet());
            System.out.print("Moneda origen (ej: USD): ");
            String origen = scanner.nextLine().toUpperCase();

            if (!tasasCambio.containsKey(origen)) {
                System.out.println("Moneda no válida.");
                continue;
            }

            System.out.print("Moneda destino (ej: EUR): ");
            String destino = scanner.nextLine().toUpperCase();

            if (!tasasCambio.containsKey(destino)) {
                System.out.println("Moneda no válida.");
                continue;
            }

            System.out.print("Cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // limpia buffer

            double tasaOrigen = tasasCambio.get(origen);
            double tasaDestino = tasasCambio.get(destino);
            double resultado = cantidad / tasaOrigen * tasaDestino;

            System.out.printf("Resultado: %.2f %s = %.2f %s\n",
                    cantidad, origen, resultado, destino);

            System.out.print("¿Deseas hacer otra conversión? (s/n): ");
            String otra = scanner.nextLine();
            if (otra.equalsIgnoreCase("n")) break;
        }

        System.out.println("¡Gracias por usar el conversor!");
    }
}
