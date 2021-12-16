package epam.task_finaly.servise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void addCity_return_true() {
        Country country = new Country("41627", "USA");

        boolean cityAdded1 = country.addCity(
                new City("20001", null, "Вашингтон", 613_048, true));
        boolean cityAdded2 = country.addCity(
                new City("10000", null, "Нью-Йорк", 8_100_000, false));

        assertTrue(cityAdded1);
        assertTrue(cityAdded2);
        assertEquals(2, country.getCities().size());
    }

    @Test
    void addCity_return_false() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));

        boolean cityAdded = country.addCity(
                new City("20001", null, "Нью-Йорк", 8_100_000, false));

        assertFalse(cityAdded);
        assertEquals(1, country.getCities().size());
    }

    @Test
    void deleteCity_return_true() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));
        country.addCity(new City("10000", null, "Нью-Йорк", 8_100_000, false));

        boolean cityDeleted = country.deleteCity("10000");

        assertTrue(cityDeleted);
        assertEquals(1, country.getCities().size());
    }

    @Test
    void deleteCity_return_false() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));
        country.addCity(new City("10000", null, "Нью-Йорк", 8_100_000, false));

        boolean cityDeleted = country.deleteCity("10001");

        assertFalse(cityDeleted);
        assertEquals(2, country.getCities().size());
    }

    @Test
    void findCity() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));
        country.addCity(new City("10000", null, "Нью-Йорк", 8_100_000, false));

        var city = country.findCity("20001");

        assertEquals("Вашингтон", city.getName());
    }

    @Test
    void findCity_return_null() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));
        country.addCity(new City("10000", null, "Нью-Йорк", 8_100_000, false));

        var city = country.findCity("20000");

        assertNull(city);
    }

    @Test
    void changeCity_return_true() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));
        country.addCity(new City("10000", null, "Нью-Йорк", 8_100_000, false));

        boolean cityChanged = country.changeCity("10000", "Йорк", 8_000_000, false);

        assertTrue(cityChanged);
        assertEquals("Йорк", country.getCities().get(1).getName());
    }

    @Test
    void changeCity_return_false() {
        Country country = new Country("41627", "USA");
        country.addCity(new City("20001", null, "Вашингтон", 613_048, true));
        country.addCity(new City("10000", null, "Нью-Йорк", 8_100_000, false));

        boolean cityChanged = country.changeCity("20000", "Йорк", 8_000_000, false);

        assertFalse(cityChanged);
        assertEquals("Нью-Йорк", country.getCities().get(1).getName());
    }
}