package fr.schaller.wordgenerator.infrastructure.spring.configuration;

import fr.schaller.wordgenerator.application.usecase.GenerateWordUseCase;
import fr.schaller.wordgenerator.domain.port.WordRepository;
import fr.schaller.wordgenerator.domain.service.WordGeneratorService;
import fr.schaller.wordgenerator.infrastructure.filesystem.FileSystemWordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public WordRepository wordRepository(
            @Value("${word-generator.path}") String path) {
        return new FileSystemWordRepository(path);
    }

    @Bean
    public WordGeneratorService wordGeneratorService(WordRepository repository) {
        return new WordGeneratorService(repository);
    }

    @Bean
    public GenerateWordUseCase generateWordUseCase(WordGeneratorService service) {
        return new GenerateWordUseCase(service);
    }
}
