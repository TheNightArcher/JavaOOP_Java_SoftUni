package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void testShouldCreatHero() {
        Hero hero = new Hero("Galin", 17);

        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIfHeroExist() {
        Hero hero = new Hero("Galin", 17);

        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowIfHeroIsNull() {
        Hero hero = new Hero("Galin", 17);

        heroRepository.create(null);
    }

    @Test
    public void testShouldReturnCountOfHeroes() {
        Hero hero = new Hero("Galin", 17);
        heroRepository.create(hero);
        heroRepository.getCount();

        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowIfHeroNameIsNull() {
        Hero hero = new Hero(null, 17);

        heroRepository.create(hero);
        heroRepository.remove(hero.getName());
    }

    @Test
    public void testShouldReturnRemovedHeroes() {
        Hero hero = new Hero("Galin", 17);
        heroRepository.create(hero);

        Assert.assertTrue(heroRepository.remove(hero.getName()));
    }

    @Test
    public void testShouldReturnTheBiggestLvlHero() {
        Hero hero = new Hero("Galin", 17);
        Hero hero2 = new Hero("Kaloqn", 16);
        heroRepository.create(hero2);
        heroRepository.create(hero);


        Assert.assertEquals(hero, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testShouldReturnHeroByGivenName() {
        Hero hero = new Hero("Galin", 17);
        Hero hero2 = new Hero("Kaloqn", 16);
        heroRepository.create(hero2);
        heroRepository.create(hero);

        Assert.assertEquals(hero, heroRepository.getHero(hero.getName()));
    }

    @Test
    public void testShouldReturnCollectionOfHeroes() {
        List<Hero> heroes = new ArrayList<>();
        Hero hero = new Hero("Galin", 17);
        Hero hero2 = new Hero("Kaloqn", 16);
        heroRepository.create(hero2);
        heroRepository.create(hero);

        heroes.add(hero2);
        heroes.add(hero);

        Collection<Hero> heroCollection = Collections.unmodifiableCollection(heroes);

        Assert.assertEquals(heroCollection.toString(), heroRepository.getHeroes().toString());
    }

}
