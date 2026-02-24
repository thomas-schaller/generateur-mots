package fr.schaller.wordgenerator.infrastructure.filesystem;

import fr.schaller.wordgenerator.domain.model.Category;
import fr.schaller.wordgenerator.domain.port.WordRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileSystemWordRepository implements WordRepository {

    private final Path directory;
    private final Map<String, List<String>> cache = new HashMap<>();

    public FileSystemWordRepository(String path) {
        this.directory = Paths.get(path);
        load();
    }

    private void load() {
        try (Stream<Path> files = Files.list(directory)) {
            files.filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            String category = file.getFileName()
                                    .toString()
                                    .replace(".txt", "");

                            List<String> words = Files.readAllLines(file);
                            cache.put(category, words);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> listCategories() {
        return cache.keySet()
                .stream()
                .map(Category::new)
                .toList();
    }

    @Override
    public List<String> findWordsByCategory(Category category) {
        return cache.getOrDefault(category.name(), List.of());
    }
}
