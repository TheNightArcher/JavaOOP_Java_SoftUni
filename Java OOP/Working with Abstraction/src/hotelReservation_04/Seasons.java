package hotelReservation_04;

import java.util.Locale;

public enum Seasons {

    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int seasonPrice;

    Seasons(int seasonPrice) {
        this.seasonPrice = seasonPrice;
    }

    public int getSeasonPrice() {
        return seasonPrice;
    }

    public static Seasons fromString(String seasonAsString){
        return  Seasons.valueOf(seasonAsString.toUpperCase());
    }
}
