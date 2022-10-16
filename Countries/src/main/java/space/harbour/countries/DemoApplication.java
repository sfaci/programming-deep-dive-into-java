package space.harbour.countries;

import space.harbour.countries.domain.Country;
import space.harbour.countries.service.CountriesService;

import java.util.List;

/**
 * Demo application
 * @author Santiago Faci
 * @version 2021
 */
public class DemoApplication {
    public static void main(String[] args) {
        CountriesService countriesService = new CountriesService();
        List<Country> countries = countriesService.getAllCountries();

        System.out.println(countries.toString());
    }
}
