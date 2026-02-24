package fr.schaller.wordgenerator.application.usecase;

import fr.schaller.wordgenerator.domain.model.Category;
import fr.schaller.wordgenerator.domain.service.WordGeneratorService;

import java.util.List;

public class GenerateWordUseCase {
    private final WordGeneratorService service;

    public GenerateWordUseCase(WordGeneratorService service) {
        this.service = service;
    }

    public List<String> listCategories() {
        return service.availableCategories()
                .stream()
                .map(Category::name)
                .toList();
    }

    public String generate(String categoryName) {
        return service.generateWord(new Category(categoryName));
    }
}
