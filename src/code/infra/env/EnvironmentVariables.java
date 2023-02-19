package code.infra.env;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentVariables {

    private static Dotenv dotenv = Dotenv.configure()
            .systemProperties()
            .filename("props.env")
            .load();

    public static String get(String key) {
        return dotenv.get(key);
    }

}
