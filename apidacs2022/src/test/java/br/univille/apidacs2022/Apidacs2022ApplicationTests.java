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
import static org.junit.jupiter.api.Assertions.assertTrue;
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
	private String jwtToken = null;

	@Test
	void contextLoads() throws Exception {
		assertThat(patientController).isNotNull();

		MvcResult resultAuth =  mock.perform(
			post("/api/v1/auth/signin")
			.content("{\"user\":\"admin\",\"password\":\"admin\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();
		jwtToken = resultAuth.getResponse().getContentAsString();		
	}

	@Test
	void cityControllerApiTest() throws Exception {
		MvcResult resultAuth =  mock.perform(
			post("/api/v1/auth/signin")
			.content("{\"user\":\"admin\",\"password\":\"admin\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();
		jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult mvcResult = mock.perform(
			post("/api/v1/city")
			.content("{\"name\":\"Joinville\", \"state\":\"SC\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(result);

		mock.perform(
			get("/api/v1/city/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("Joinville")))
		.andExpect(jsonPath("$.state", is("SC")));

		mock.perform(
			put("/api/v1/city/" + jsonObject.getString("id"))
			.content("{\"name\":\"Blumenau\", \"state\":\"SC\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();

		mock.perform(
			get("/api/v1/city/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("Blumenau")));
		
		mock.perform(
			delete("/api/v1/city/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isAccepted());
	}

	@Test
	void doctorControllerApiTest() throws Exception {
		MvcResult resultAuth =  mock.perform(
			post("/api/v1/auth/signin")
			.content("{\"user\":\"admin\",\"password\":\"admin\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();
		jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult mvcResult = mock.perform(
			post("/api/v1/doctor")
			.content("{\"name\":\"Paulo\", \"crm\":\"4592\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(result);

		mock.perform(
			get("/api/v1/doctor/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("Paulo")))
		.andExpect(jsonPath("$.crm", is("4592")));

		mock.perform(
			put("/api/v1/doctor/" + jsonObject.getString("id"))
			.content("{\"name\":\"Paulo Muzy\", \"crm\":\"4628\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();

		mock.perform(
			get("/api/v1/doctor/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("Paulo Muzy")))
		.andExpect(jsonPath("$.crm", is("4628")));
		
		mock.perform(
			delete("/api/v1/doctor/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isAccepted());
	}

	@Test
	void healthPlanControllerApiTest() throws Exception {
		MvcResult resultAuth =  mock.perform(
			post("/api/v1/auth/signin")
			.content("{\"user\":\"admin\",\"password\":\"admin\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();
		jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult mvcResult = mock.perform(
			post("/api/v1/healthplan")
			.content("{\"name\":\"UNIMED\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(result);

		mock.perform(
			get("/api/v1/healthplan/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("UNIMED")));

		mock.perform(
			put("/api/v1/healthplan/" + jsonObject.getString("id"))
			.content("{\"name\":\"SUS\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();

		mock.perform(
			get("/api/v1/healthplan/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("SUS")));

		mock.perform(
			delete("/api/v1/healthplan/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isAccepted());
	}

	@Test
	void patientControllerApiTest() throws Exception {
		MvcResult resultAuth =  mock.perform(
			post("/api/v1/auth/signin")
			.content("{\"user\":\"admin\",\"password\":\"admin\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();
		jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult mvcResult = mock.perform(
			post("/api/v1/patients")
			.content("{\"name\":\"Zezinho\", \"sex\":\"MASC\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(result);
		
		mock.perform(
			get("/api/v1/patients/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("Zezinho")))
		.andExpect(jsonPath("$.sex", is("MASC")));

		mock.perform(
			put("/api/v1/patients/" + jsonObject.getString("id"))
			.content("{\"name\":\"Zé\", \"sex\":\"MASC\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();

		mock.perform(
				get("/api/v1/patients/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("Zé")));
		
		mock.perform(
			delete("/api/v1/patients/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isAccepted());
	}

	@Test
	void procedureControllerApiTest() throws Exception {
		MvcResult resultAuth =  mock.perform(
			post("/api/v1/auth/signin")
			.content("{\"user\":\"admin\",\"password\":\"admin\"}")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();
		jwtToken = resultAuth.getResponse().getContentAsString();

		MvcResult mvcResult = mock.perform(
			post("/api/v1/procedure")
			.content("{\"title\":\"NOME PADRAO\", \"description\":\"DESCRICAO PADRAO\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated()).andReturn();

		String result = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(result);

		mock.perform(
			get("/api/v1/procedure/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.title", is("NOME PADRAO")))
		.andExpect(jsonPath("$.description", is("DESCRICAO PADRAO")));

		mock.perform(
			put("/api/v1/procedure/" + jsonObject.getString("id"))
			.content("{\"title\":\"NOME\", \"description\":\"DESCRICAO\"}")
			.header("Authorization", "Bearer " + jwtToken)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andReturn();

		mock.perform(
			get("/api/v1/procedure/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.title", is("NOME")))
		.andExpect(jsonPath("$.description", is("DESCRICAO")));

		mock.perform(
			delete("/api/v1/procedure/" + jsonObject.getString("id")).header("Authorization", "Bearer " + jwtToken)
		).andExpect(status().isAccepted());
	}
}
