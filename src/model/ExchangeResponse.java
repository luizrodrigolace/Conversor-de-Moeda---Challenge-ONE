package model;

import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class ExchangeResponse {
    @SerializedName("base_code")
    private String baseCurrency;
    @SerializedName("conversion_rates")
    private Map<String,Double> conversionRates;

    //construtor padrão para o Gson
    public ExchangeResponse() {
    }

    public ExchangeResponse(String baseCurrency, Map<String, Double> conversionRates) {
        this.baseCurrency = baseCurrency;
        this.conversionRates = conversionRates;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    @Override
    public String toString() {
        return "baseCurrency='" + baseCurrency + '\'' +
                ", conversionRates=" + conversionRates;

    }
}
