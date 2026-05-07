package geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    public GeoServiceImpl geoService;

    @BeforeEach
    void setup() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void givenMoscowIP_whenByIp_thenReturnMoscowLocation() {
        Location result = geoService.byIp("172.0.32.11");

        Assertions.assertEquals("Moscow", result.getCity());
        Assertions.assertEquals(Country.RUSSIA, result.getCountry());
        Assertions.assertEquals("Lenina", result.getStreet());
        Assertions.assertEquals(15, result.getBuiling());
    }

    @Test
    void givenNyIP_whenByIp_thenReturnNYLocation() {
        Location result = geoService.byIp("96.44.183.149");

        Assertions.assertEquals("New York", result.getCity());
        Assertions.assertEquals(Country.USA, result.getCountry());
        Assertions.assertEquals(" 10th Avenue", result.getStreet());
        Assertions.assertEquals(32, result.getBuiling());
    }

    @Test
    void givenRuIP_whenByIp_thenReturnRuLocation() {
        Location result = geoService.byIp("172.5.250.30");

        Assertions.assertEquals("Moscow", result.getCity());
        Assertions.assertEquals(Country.RUSSIA, result.getCountry());
        Assertions.assertEquals(null, result.getStreet());
        Assertions.assertEquals(0, result.getBuiling());
    }

    @Test
    void givenUsIP_whenByIp_thenReturnUsLocation() {
        Location result = geoService.byIp("96.130.5.254");

        Assertions.assertEquals("New York", result.getCity());
        Assertions.assertEquals(Country.USA, result.getCountry());
        Assertions.assertEquals(null, result.getStreet());
        Assertions.assertEquals(0, result.getBuiling());
    }
}
