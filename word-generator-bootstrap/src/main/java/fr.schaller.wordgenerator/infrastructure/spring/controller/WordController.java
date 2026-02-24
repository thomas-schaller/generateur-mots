package fr.schaller.wordgenerator.infrastructure.spring.controller;

import fr.schaller.wordgenerator.application.usecase.GenerateWordUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordController {
    private final GenerateWordUseCase useCase;

    public WordController(GenerateWordUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/categories")
    public List<String> categories() {
        return useCase.listCategories();
    }

    @GetMapping("/{category}")
    public String generate(@PathVariable("category") String category) {
        return useCase.generate(category);
    }
}
