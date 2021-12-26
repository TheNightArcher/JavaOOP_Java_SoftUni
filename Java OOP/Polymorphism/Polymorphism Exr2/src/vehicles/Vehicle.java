package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double littersPerKm;

    protected Vehicle(double fuelQuantity, double littersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.littersPerKm = littersPerKm;
    }

    public String drive(double distance) {
        double neededFuel = distance * littersPerKm;

        if (fuelQuantity >= neededFuel) {
            DecimalFormat format = new DecimalFormat("##.##");

            return String.format("%s travelled %s km", getClass().getSimpleName(), format.format(neededFuel));
        } else {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
    }

    public void refuel(double fuelPour) {
        fuelQuantity += fuelPour;
    }
}
