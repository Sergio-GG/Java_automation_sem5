import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.bibles.all.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class GetBiblesTest extends AbstractTest{
    private static final Logger logger =
            LoggerFactory.getLogger(GetBiblesTest.class);
    @Test
    void test401error() throws IOException {
        logger.info("Test 401error is started");
        // given
        logger.debug("Composing mock for debug");

        stubFor(WireMock.get(urlPathEqualTo("/v1/bibles"))
                .withHeader("api-key", notMatching("12345"))
                .willReturn(aResponse().withStatus(401).withBody("Error")));

        // Создали клиента
        CloseableHttpClient client = HttpClients.createDefault();
        // Создали запрос
        HttpGet get = new HttpGet(getBaseUrl()+"/v1/bibles");
        get.addHeader("api-key", "54321");
        logger.debug("Http client is created");

        // when
        HttpResponse response = client.execute(get);

        // then
        verify(getRequestedFor(urlPathEqualTo("/v1/bibles")));
        Assertions.assertEquals(401, response.getStatusLine().getStatusCode());
    }

    @Test
    void testCode200() throws IOException, URISyntaxException {
        logger.info("Test code200 is started");
        // given
        logger.debug("Composing mock for debug");

        ObjectMapper objectMapper = new ObjectMapper();
        Data bodyOk = new Data();
        bodyOk.setId("10");

        Data bodyErr = new Data();
        bodyErr.setId("-10");

        stubFor(WireMock.get(urlPathEqualTo("/v1/bibles"))
                .withHeader("api-key", matching("12345"))
                .withQueryParam("bibleId", equalTo("15"))
                .willReturn(aResponse().withStatus(200).withBody(objectMapper.writeValueAsString(bodyOk))));

        stubFor(WireMock.get(urlPathEqualTo("/v1/bibles"))
                .withHeader("api-key", matching("12345"))
                .withQueryParam("bibleId", equalTo("12000"))
                .willReturn(aResponse().withStatus(200).withBody(objectMapper.writeValueAsString(bodyErr))));

        logger.debug("Mocking is finished");

        // when

        HttpGet get = new HttpGet(getBaseUrl()+"/v1/bibles");

        URI uri = new URIBuilder(get.getURI())
                .addParameter("bibleId", "15")
                        .build();

        get.setURI(uri);
        get.addHeader("api-key", "12345");

        CloseableHttpClient client = HttpClients.createDefault();

        HttpResponse response = client.execute(get);

        // creating Error URL
        URI uriErr = new URIBuilder(get.getURI())
                .addParameter("bibleId", "12000")
                .build();

        get.removeHeaders("api-key");
        get.setURI(uriErr);
        get.addHeader("api-key", "12345");

        HttpResponse responseError = client.execute(get);

        // then

        verify(2, getRequestedFor(urlPathEqualTo("/v1/bibles")));
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
        Assertions.assertEquals(200, responseError.getStatusLine().getStatusCode());

        Data dataOk = objectMapper.readValue(response.getEntity().getContent(), Data.class);
        Data dataErr = objectMapper.readValue(responseError.getEntity().getContent(), Data.class);

        Assertions.assertEquals("10", dataOk.getId());
        Assertions.assertEquals("-10", dataErr.getId());
    }
}
