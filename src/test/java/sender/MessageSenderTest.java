package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MessageSenderTest {
    @Mock
    private GeoServiceImpl geoService;
    @Mock
    private LocalizationServiceImpl localizationService;
    @InjectMocks
    private MessageSenderImpl messageSender;

    @Test
    void test_send_correct_ru_text() {
        Mockito.when(geoService.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String result = messageSender.send(headers);
        Assertions.assertEquals(result, "Добро пожаловать");
    }

    @Test
    void test_send_correct_ru_text2() {
        Mockito.when(geoService.byIp("172.10.190.50")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.10.190.50");
        String result = messageSender.send(headers);
        Assertions.assertEquals(result, "Добро пожаловать");
    }

    @Test
    void test_send_correct_en_text() {
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String result = messageSender.send(headers);
        Assertions.assertEquals(result, "Welcome");
    }

    @Test
    void test_send_correct_en_text2() {
        Mockito.when(geoService.byIp("96.230.25.24")).thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.230.25.24");
        String result = messageSender.send(headers);
        Assertions.assertEquals(result, "Welcome");
    }
}
