package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double OXYGEN_UNITS = 70;

    public Biologist(String name) {
        super(name, OXYGEN_UNITS);
    }

    @Override
    public void breath() {
        super.setOxygen(super.getOxygen() - 5);

        if (super.getOxygen() < 0) {
            super.setOxygen(0);
        }
    }
}
