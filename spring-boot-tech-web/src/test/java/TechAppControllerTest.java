package com.tech.app.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tech.app.so.AppDetails;

/**
 * @author Bhushan Bafna
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
public class TechAppControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TechAppController techAppController;

	@SuppressWarnings("unused")
	@Test
	public void testGetAppName() throws Exception {
		AppDetails expected = new AppDetails("Tech App API", "1.0");
		when(techAppController.getAppName()).thenReturn(expected);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/app/details").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("{appName: 'Tech App API', appVersion: '1.0'}")).andReturn();
	}


}
