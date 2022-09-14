package br.univille.apidacs2022;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.univille.apidacs2022.api.PatientControllerApi;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;

@SpringBootTest
@AutoConfigureMockMvc
class Apidacs2022ApplicationTests {

	@Autowired
	private PatientControllerApi patientController;

	@Autowired
	private MockMvc mock;

	@Test
	void contextLoads() {
		assertThat(patientController).isNotNull();
	}

	@Test
	void patientControllerApiTest() throws Exception {
		MvcResult mvcResult = mock.perform(
			post("/api/v1/patients")
			.content("{\"name\":\"Zezinho\", \"sex\":\"MASC\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(result);
		
		mock.perform(get("/api/v1/patients/" + jsonObject.getString("id")))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("Zezinho")))
			.andExpect(jsonPath("$.sex", is("MASC")));

		mock.perform(
			put("/api/v1/patients/" + jsonObject.getString("id"))
			.content("{\"name\":\"Zé\", \"sex\":\"MASC\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();

		mock.perform(get("/api/v1/patients/" + jsonObject.getString("id")))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("Zé")));
		
		mock.perform(delete("/api/v1/patients/" + jsonObject.getString("id")))
		.andExpect(status().isAccepted());
	}
}
