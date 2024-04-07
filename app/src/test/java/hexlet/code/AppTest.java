import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    static final String PATH_TO_FIXTURE = "src/test/resources/fixtures/";

    public static String fixture(String nameOfFile) {
        return PATH_TO_FIXTURE + nameOfFile;
    }

    @Test
    public void recursiveTest() throws Exception {
        var expected = Files.readString(Paths.get(fixture("expected.stylish"))
                .toAbsolutePath().normalize()).trim();
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "stylish");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void recursiveTest2() throws Exception {
        var expected = Files.readString(Paths.get(fixture("expected.stylish"))
                .toAbsolutePath().normalize()).trim();
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void yamlTest() throws Exception {
        var expected = Files.readString(Paths.get(fixture("expected.stylish"))
                .toAbsolutePath().normalize()).trim();
        String result = Differ.generate(fixture("file1.yml"),
                fixture("file2.yml"), "yaml");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void plainTest() throws Exception {
        var expected = Files.readString(Paths.get(fixture("expected.plain"))
                .toAbsolutePath().normalize()).trim();
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "plain");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void jsonTest() throws Exception {
        var expected = Files.readString(Paths.get(fixture("expected.json"))
                .toAbsolutePath().normalize()).trim();
        String result = Differ.generate(fixture("file_1.json"),
                fixture("file_2.json"), "json");
        assertThat(result).isEqualTo(expected);
    }
}
