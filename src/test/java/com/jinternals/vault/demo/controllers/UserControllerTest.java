package com.jinternals.vault.demo.controllers;

import com.jinternals.vault.demo.entities.User;
import com.jinternals.vault.demo.repositories.UserRepository;
import com.jinternals.vault.demo.services.UserService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1l);
        user.setEmail("pandeymradul@gmail.com");
    }

    @Test
    public void apiShouldReturnUserByEmail() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(Lists.newArrayList(user));
        mockMvc.perform(get("/users", user.getEmail()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].email", equalToIgnoringCase(user.getEmail())))
                .andDo(print())
                .andDo(
                        document(
                                "get-all-users",
                                pathParameters(),
                                responseFields(
                                        fieldWithPath("[].id").description("Id"),
                                        fieldWithPath("[].email").description("Email address")
                                )
                        )
                );
    }
}