package cs.vapo.bringit.core.dao.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class TestConfiguration {


    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Profile("test")
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("/h2/schema.sql"));
        populator.addScript(new ClassPathResource("/h2/data.sql"));

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(populator);
        return initializer;

    }
}
