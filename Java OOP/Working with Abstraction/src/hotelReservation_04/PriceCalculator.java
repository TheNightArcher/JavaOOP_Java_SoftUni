package hotelReservation_04;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Seasons seasons;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Seasons seasons, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.seasons = seasons;
        this.discountType = discountType;
    }


    public double totalPrice(){
        double pricePerDayForSeason = this.pricePerDay * this.seasons.getSeasonPrice();

        double priceForNumberOfDays = pricePerDayForSeason * this.numberOfDays;

        double discountForTypePerson = priceForNumberOfDays - priceForNumberOfDays * discountType.getDiscount();
        return discountForTypePerson;
    }
}
