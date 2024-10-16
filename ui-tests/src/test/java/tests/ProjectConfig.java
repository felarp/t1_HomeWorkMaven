package tests;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")

public interface ProjectConfig extends Config{
    @Key("baseUrl")
    String baseUrl();
}
