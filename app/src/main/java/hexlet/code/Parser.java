package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    public static Map<String, Object> parse(String textToParse, String format) throws Exception {
        switch (format) {
            case "json" -> {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(textToParse, new TypeReference<>() { });
            }
            case "yml", "yaml" -> {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                return mapper.findAndRegisterModules()
                        .readValue(textToParse, new TypeReference<>() { });
            }
            default -> {
                System.out.println("There are files of unknown format");
                return Map.of();
            }
        }
    }
}
