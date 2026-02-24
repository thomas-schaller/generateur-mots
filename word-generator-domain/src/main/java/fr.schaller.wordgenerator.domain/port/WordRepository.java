package fr.schaller.wordgenerator.domain.port;

import fr.schaller.wordgenerator.domain.model.Category;

import java.util.List;

public interface WordRepository {

        List<Category> listCategories();

        List<String> findWordsByCategory(Category category);
}
