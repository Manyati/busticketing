package za.ca.cput.busticketing.controller.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ca.cput.busticketing.entity.user.UserIdentificationtype;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */

TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserIdentificationtypeControllerTest {

    private  static UserIdentificationtype userIdentificationtype = UserIdentificationtypeFactory.create("Yellow Card","  Honest");

    @Autowired
    private TestRestTemplate restTemplate;
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "user generated";
    private final String BASE_URL = "http://localhost:8080/card ";

    @Test
    void create() {

        String url = BASE_URL +"/";
        ResponseEntity<UserIdentificationtype> postResponse = restTemplate
                .withBasicAuth("Super","Pass")
                .postForEntity(url,userIdentificationtype,UserIdentificationtype.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        cardType = postResponse.getBody();
        System.out.println("Saved data: " + userIdentificationtype);
        assertEquals(userIdentificationtypegetId(),postResponse.getBody().getId());
    }

    @Test
    void read() {
        String url = BASE_URL + "/" + userIdentificationtype.getId();
        System.out.println(" URL:" + url);
        ResponseEntity<UserIdentificationtype> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url,UserIdentificationtype.class);
        assertNotNull(response.getBody());
    }

    @Test
    void update() {
        UserIdentificationtype updated =new UserIdentificationtype.Builder().copy(userIdentificationtype).setDescription("315").build();
        String url = BASE_URL + "/update";
        System.out.println("URL:"+url);
        System.out.println("Post data:"+ updated);
        ResponseEntity<CardType> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url,updated,UserIdentificationtype.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete" +userIdentificationtype.getId();
        System.out.println("URL:" +url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url =BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show Yellow Card");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}