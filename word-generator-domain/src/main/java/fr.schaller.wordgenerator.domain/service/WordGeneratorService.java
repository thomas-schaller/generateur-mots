package fr.schaller.wordgenerator.domain.service;

import fr.schaller.wordgenerator.domain.model.Category;
import fr.schaller.wordgenerator.domain.port.WordRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordGeneratorService {
    private final WordRepository repository;

    public WordGeneratorService(WordRepository repository)
    {
        this.repository=repository;
    }

    public List<Category> availableCategories(){
        return repository.listCategories();
    }

    public String generateWord(Category category) {
        List<String> words = repository.findWordsByCategory(category);
        if (words == null || words.isEmpty())
        {
            throw new IllegalArgumentException("Aucun mot trouvé pour la catégorie:"+category);
        }
        int index = ThreadLocalRandom.current().nextInt(words.size());
        return words.get(index);
    }
}
