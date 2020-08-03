package com.example.spring91.sample;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@JsonTest
//@AutoConfigureMockMvc
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;
//    @Autowired
//    TestRestTemplate testRestTemplate;
    @Rule
    public  OutputCapture outputCapture = new OutputCapture();

    //최근 api
//    @Autowired
//    WebTestClient webTestClient;
//
    @MockBean
    SampleService mockSampleService;

    //json test
//    @Autowired
//    JacksonTester</*Sample 도메인*/>
    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("whiteship");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello whiteship"));

        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("skip");

//        webTestClient.get().uri("/hello").exchange().expectStatus().isOk()
//                .expectBody(String.class).isEqualTo("hello whiteship");

//         String result = testRestTemplate.getForObject("/hello",String.class);
//            assertThat(result).isEqualTo("hello whiteship");


//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello keesun"))
//                .andDo(print());
    }
}