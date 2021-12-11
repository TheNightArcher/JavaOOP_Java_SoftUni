package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    List<HealthyFood> healthyFoods;

    public HealthFoodRepositoryImpl() {
        this.healthyFoods = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        for (HealthyFood food : healthyFoods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return healthyFoods;
    }

    @Override
    public void add(HealthyFood entity) {
        healthyFoods.add(entity);
    }
}
