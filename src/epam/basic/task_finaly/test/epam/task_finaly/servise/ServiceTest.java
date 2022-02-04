package epam.basic.task_finaly.test.epam.task_finaly.servise;

import epam.basic.task_finaly.context.StubContext;
import epam.basic.task_finaly.servise.City;
import epam.basic.task_finaly.servise.Country;
import epam.basic.task_finaly.servise.Service;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void addCountry_return_true() {
        Service service = new Service(new StubContext());

        boolean countryAdded1 = service.addCountry(new Country("41627", "USA"));
        boolean countryAdded2 = service.addCountry(new Country("27013", "Ukraine"));

        assertTrue(countryAdded1);
        assertTrue(countryAdded2);
        assertEquals(2, service.getCountries().size());
    }

    @Test
    void addCountry_return_false() {
        Service service = new Service(new StubContext());
        var country = new Country("41627", "USA");
        country.addCity(new City("27013", null, "Kanzassity", 280_000, false));
        service.addCountry(country);


        boolean countryAdded1 = service.addCountry(new Country("27013", "Ukraine"));
        boolean countryAdded2 = service.addCountry(new Country("41627", "Ukraine"));

        assertFalse(countryAdded1);
        assertFalse(countryAdded2);
        assertEquals(1, service.getCountries().size());
    }

    @Test
    void findCountry() {
        Service service = new Service(new StubContext());
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));

        var country = service.findCountry("27013");

        assertEquals("Ukraine", country.getName());
    }

    @Test
    void findCountry_return_false() {
        Service service = new Service(new StubContext());
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));

        var country = service.findCountry("27015");

        assertNull(country);
    }

    @Test
    void deleteCountry_return_true() {
        Service service = new Service(new StubContext());
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));

        boolean countryDeleted = service.deleteCountry("41627");

        assertTrue(countryDeleted);
        assertEquals(1, service.getCountries().size());
    }

    @Test
    void deleteCountry_return_false() {
        Service service = new Service(new StubContext());
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));

        boolean countryDeleted = service.deleteCountry("41687");

        assertFalse(countryDeleted);
        assertEquals(2, service.getCountries().size());
    }

    @Test
    void changeCountry_return_true() {
        Service service = new Service(new StubContext());
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));

        boolean countryChanged = service.changeCountry("27013", "Poland");

        assertTrue(countryChanged);
        assertEquals("Poland", service.getCountries().get(1).getName());
    }

    @Test
    void changeCountry_return_false() {
        Service service = new Service(new StubContext());
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));

        boolean countryChanged = service.changeCountry("27083", "Poland");

        assertFalse(countryChanged);
        assertEquals("Ukraine", service.getCountries().get(1).getName());
    }

    @Test
    void saveDataBase() throws IOException {
        StubContext stubContext = new StubContext();
        Service service = new Service(stubContext);
        service.addCountry(new Country("41627", "USA"));
        service.addCountry(new Country("27013", "Ukraine"));
        service.saveDataBase();
        assertEquals(service.getCountries(), stubContext.read());
    }

    @Test
    void findCity(){
        var country1 = new Country("0000", "A");
        country1.addCity(new City("00001", null, "AA", 500_000, false));
        country1.addCity(new City("00002", null, "AB", 500_000, false));
        var country2 = new Country("0001", "B");
        country2.addCity(new City("00011", null, "BA", 500_000, true));
        country2.addCity(new City("00012", null, "BB", 500_000, false));
        Service service = new Service();
        service.addCountry(country1);
        service.addCountry(country2);

        var city = service.findCity("00011");
        assertEquals("BA", city.getName());
    }

    @Test
    void findCity_return_null(){
        var country1 = new Country("0000", "A");
        country1.addCity(new City("00001", null, "AA", 500_000, false));
        country1.addCity(new City("00002", null, "AB", 500_000, false));
        var country2 = new Country("0001", "B");
        country2.addCity(new City("00011", null, "BA", 500_000, true));
        country2.addCity(new City("00012", null, "BB", 500_000, false));
        Service service = new Service();
        service.addCountry(country1);
        service.addCountry(country2);

        var city = service.findCity("00013");
        assertNull(city);
    }
}