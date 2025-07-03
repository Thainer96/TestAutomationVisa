package jsonProcess;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class BodyJsonManager {
    private static final String BODIES_FILE_PATH = "src/test/resources/jsonrequest/user/bodyReqUser.json";
    private final Map bodies;
    private JsonExtractor jsonExtractor;

    public BodyJsonManager() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonExtractor = new JsonExtractor();
            String jsonContent = new String(Files.readAllBytes(Paths.get(BODIES_FILE_PATH)));
            bodies = mapper.readValue(jsonContent, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing BodyJsonManager: " + e.getMessage(), e);
        }
    }

    public String buildBodyWithData(String bodyName, Map<String, String> placeholders)  {
        try{
            String JsonTemplate = jsonExtractor.getBodyJsonTemplate(bodyName);
            if (JsonTemplate==null || JsonTemplate.isEmpty()) {
                throw new IllegalArgumentException("Body not found: " + bodyName);
            }
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                JsonTemplate = JsonTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue().toString());

            }
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(JsonTemplate);
            return objectMapper.writeValueAsString(rootNode);
        }catch (Exception o){
            throw new RuntimeException("Error in the method buildBodyWithData" + o);
        }

    }
}
