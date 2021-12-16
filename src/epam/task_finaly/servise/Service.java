package epam.task_finaly.servise;

import epam.task_finaly.context.Contextable;
import epam.task_finaly.context.XMLContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Service {
    private Contextable context;
    private List<Country> countries;

    public Service() {
        context = new XMLContext("src/epam/task_finaly/resourses/DataBase.xml");
        readDataBase();
    }

    public Service(Contextable context) {
        this.context = context;
        readDataBase();
    }

    private void readDataBase() {
        try {
            countries = (List<Country>) context.read();
            if(countries == null){
                countries = new ArrayList<>();
            }
        } catch (IOException exception) {
            countries = new ArrayList<>();
        }
    }

    public boolean objectHaveUniqueId(String identification) {
        for (var country : countries) {
            if (Objects.equals(country.getIdentification(), identification)
                    || !country.cityHaveUniqueId(identification)) {
                return false;
            }
        }
        return true;
    }

    public boolean addCountry(Country country) {
        if (!objectHaveUniqueId(country.getIdentification())) {
            return false;
        }

        countries.add(country);
        return true;
    }

    public Country findCountry(String identification) {
        for (var country : countries) {
            if (Objects.equals(country.getIdentification(), identification)) {
                return country;
            }
        }
        return null;
    }

    public boolean deleteCountry(String countryId) {
        return countries.remove(findCountry(countryId));
    }

    public boolean changeCountry(String countryId, String name) {
        var country = findCountry(countryId);
        if (country == null)
            return false;

        country.setName(name);
        return true;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void saveDataBase() throws IOException {
        context.write(countries);
    }


}
