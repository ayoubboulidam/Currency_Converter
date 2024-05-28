package ayb.JAVAProjects;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static ExchangeRateFetcher rateFetcher;

    public static void main(String[] args) {
        rateFetcher = new ExchangeRateFetcher();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            Map<String, Double> rates = rateFetcher.getExchangeRates(baseCurrency);
            if (rates.containsKey(targetCurrency)) {
                double rate = rates.get(targetCurrency);
                double convertedAmount = amount * rate;
                System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
            } else {
                System.out.println("Invalid target currency.");
            }
        } catch (IOException e) {
            System.out.println("Error fetching exchange rates: " + e.getMessage());
        }
    }
}
