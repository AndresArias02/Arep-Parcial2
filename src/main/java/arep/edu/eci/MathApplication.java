package arep.edu.eci;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MathApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MathApplication.class)
                .initializers(new PortInitializer())
                .run(args);
    }

    public static class PortInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext context) {
            Environment env = context.getEnvironment();
            String port = env.getProperty("PORT", "8081");
            System.setProperty("server.port", port);
        }
    }
}
