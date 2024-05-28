package ayb.JAVAProjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateFetcher {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/20e3ba5a2ffa102909c391dc/latest/";

    private OkHttpClient client;
    private ObjectMapper mapper;

    public ExchangeRateFetcher() {
        client = new OkHttpClient();
        mapper = new ObjectMapper();
    }

    public Map<String, Double> getExchangeRates(String baseCurrency) throws IOException {
        String url = API_URL + baseCurrency;
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        JsonNode jsonNode = mapper.readTree(response.body().string());
        JsonNode ratesNode = jsonNode.get("conversion_rates");

        Map<String, Double> rates = new HashMap<>();
        ratesNode.fields().forEachRemaining(entry -> rates.put(entry.getKey(), entry.getValue().asDouble()));

        return rates;
    }
}
