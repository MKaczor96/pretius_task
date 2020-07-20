package com.pretius.file_sorter;

import java.io.File;
import java.util.List;
import java.util.Optional;

class FileSorterExecutor {

    private FileSorterExecutor() {

    }

    private static final List<FileSortStrategy> strategies = List.of(
            new EvenJarFileStrategy(),
            new UnevenJarFileStrategy(),
            new XmlFileStrategy()
    );

    static void execute(File file) {
        Optional<FileSortStrategy> first = strategies.stream()
                .filter(fileSortStrategy -> fileSortStrategy.shouldMove(file)).findFirst();

        first.ifPresentOrElse(
                strategy -> strategy.move(file),
                IllegalStateException::new);
    }
}
