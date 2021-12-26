package pizzaCalories_04;

public class Topping {
    private String toppingType;
    private double weigh;

    public Topping(String toppingType, double weigh) {
        this.setToppingType(toppingType);
        this.setWeigh(weigh);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeigh(double weigh) {
        if (weigh < 1 || weigh > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weigh = weigh;
    }

    public double calculateCalories() {
        return (2 * weigh) * getToppingCalories(toppingType);
    }

    private double getToppingCalories(String toppingType) {
        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
        }
        return 0.0;
    }
}
