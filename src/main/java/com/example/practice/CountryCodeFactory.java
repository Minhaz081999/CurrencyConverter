package com.example.practice;

public enum CountryCodeFactory {

    Australia("AUD"),
    Azerbaijan("AZN"),
    Barbados("BBD"),
    Bangladesh("BDT"),
    Bhutan("BTN"),
    Brazil("BRL"),
    Canada	("CAD"),
    China("CNY"),
    Colombia("COP"),
    Djibouti("DJF"),
    Denmark("DKK"),
    Egypt("EGP"),
    Eritrea("ERN"),
    Ethiopia("ETB"),
    Finland("EUR"),
    France("EUR"),
    Greece("EUR"),
    Georgia("GEL"),
    Germany("EUR"),
    Guernsey("GBP"),
    Guinea("GNF"),
    Guadeloupe("EUR"),
    Honduras("HNL"),
    Hong_Kong("HKD"),
    Hungary("HUF"),
    Indonesia("IDR"),
    Iran("IRR"),
    Iraq("IDQ"),
    India("INR"),
    Japan("JPY"),
    Jamaica("JMD"),
    Kenya("KES"),
    Kyrgyzstan("KGS"),
    Korea_North("KPW"),
    Korea_South("KRW"),
    Libya("LYD"),
    Laos("LAK"),
    Lebanon("LBP"),
    Myanmar("MMK"),
    Mexico("MXN"),
    Malaysia("MYR"),
    Monaco("EUR"),
    Morocco("MAD"),
    Nepal("NPR"),
    Netherlands("EUR"),
    New_Zealand("NZD"),
    Norway("NOK"),
    Oman("OMR"),
    Pakistan("PKR"),
    Philippines("PHP"),
    Portugal("EUR"),
    Qatar("QAR"),
    Russia("RUB"),
    Romania("RON"),
    Rwanda("RWF"),
    Saudi_Arabia("SAR"),
    Singapore("SGD"),
    Spain("EUR"),
    Sri_Lanka("LKR"),
    Sweden("SEK"),
    Switzerland("CHF"),
    Thailand("THB"),
    Turkey("TRY"),
    UAE("AED"),
    USA("USD"),
    Ukraine("UAH"),
    Vietnam("VND"),
    Wallis_and_Futuna_Islands("XPF"),
    Yemen("YER"),
    Zambia("ZMW"),
    Zimbabwe("ZWD");


    public final String name;

    private CountryCodeFactory(String name) {

        this.name = name;
    }

    String getValue()
    {
        return name;
    }
    public static CountryCodeFactory findByName(String name) {
        CountryCodeFactory result = null;
        for (CountryCodeFactory direction : values()) {
            if (direction.name().equalsIgnoreCase(name)) {
                result = direction;
                break;
            }
        }
        return result;
    }
}
