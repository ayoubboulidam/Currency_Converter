package ayb.JAVAProjects;

import ayb.JAVAProjects.ExchangeRateFetcher;

import java.io.IOException;
import java.util.*;

public class CurrencyConverter {

    private static final Map<String, String> CURRENCY_NAMES = new HashMap<String, String>() {{
        put("USD", "United States Dollar");
        put("EUR", "Euro");
        put("GBP", "British Pound Sterling");
        put("JPY", "Japanese Yen");
        put("AUD", "Australian Dollar");
        put("CAD", "Canadian Dollar");
        put("CHF", "Swiss Franc");
        put("CNY", "Chinese Yuan");
        put("SEK", "Swedish Krona");
        put("NZD", "New Zealand Dollar");
        put("MAD", "Moroccan Dirham");
        put("...", "Other Currency"); // Add more as needed
    }};

    private static ExchangeRateFetcher rateFetcher;

    public static void main(String[] args) {
        rateFetcher = new ExchangeRateFetcher();
        Scanner scanner = new Scanner(System.in);

        String baseCurrency = getCurrencyFromUser(scanner, "base");
        String targetCurrency = getCurrencyFromUser(scanner, "target");

        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            Map<String, Double> rates = rateFetcher.getExchangeRates(baseCurrency);
            if (rates.containsKey(targetCurrency)) {
                double rate = rates.get(targetCurrency);
                double convertedAmount = amount * rate;
                System.out.printf("Converted Amount: %.2f %s (%s)%n", convertedAmount, targetCurrency, CURRENCY_NAMES.get(targetCurrency));
            } else {
                System.out.println("Invalid target currency.");
            }
        } catch (IOException e) {
            System.out.println("Error fetching exchange rates: " + e.getMessage());
        }
    }

    private static String getCurrencyFromUser(Scanner scanner, String type) {
        System.out.printf("Select the %s currency from the list below:%n", type);
        for (String code : CURRENCY_NAMES.keySet()) {
            String name = CURRENCY_NAMES.getOrDefault(code, "Unknown Currency");
            System.out.printf("%s (%s)%n", code, name);
        }

        String currency;
        do {
            System.out.printf("Enter the %s currency code: ", type);
            currency = scanner.nextLine().trim().toUpperCase();
        } while (!CURRENCY_NAMES.containsKey(currency));

        return currency;
    }
}
