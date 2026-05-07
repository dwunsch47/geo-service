package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    void startup() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void givenRussia_whenLocale_thenReturnRussianWelcome() {
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(result, "Добро пожаловать");
    }

    @Test
    void givenUs_whenLocale_thenReturnEnglishWelcome() {
        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals(result, "Welcome");
    }

    @Test
    void givenGermany_whenLocale_thenReturnEnglishWelcome() {
        String result = localizationService.locale(Country.GERMANY);
        Assertions.assertEquals(result, "Welcome");
    }

    @Test
    void givenBrazil_whenLocale_thenReturnEnglishWelcome() {
        String result = localizationService.locale(Country.BRAZIL);
        Assertions.assertEquals(result, "Welcome");
    }
}
