package com.pretius.file_sorter;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Optional;
import java.util.function.Predicate;

class UnevenJarFileStrategy implements FileSortStrategy {

    @Override
    public void move(File file) {
        FileUtils.move(file, new File(Directory.TEST.name()));
    }

    @Override
    public boolean shouldMove(File file) {
        return Optional.ofNullable(file)
                .filter(jarFile -> FilenameUtils.getExtension(jarFile.getName()).equals("jar"))
                .filter(creationHourUnevenPredicate())
                .isPresent();
    }

    private Predicate<File> creationHourUnevenPredicate() {
        return jarFile -> FileUtils.getCreationHour(jarFile) % 2 != 0;
    }
}
