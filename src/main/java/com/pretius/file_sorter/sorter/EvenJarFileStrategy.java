package com.pretius.file_sorter.sorter;

import com.pretius.file_sorter.enums.Directory;
import com.pretius.file_sorter.util.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Optional;
import java.util.function.Predicate;

class EvenJarFileStrategy implements FileSortStrategy {

    @Override
    public void move(File file) {
        FileUtils.move(file, new File(Directory.DEV.name()));
    }

    @Override
    public boolean shouldMove(File file) {
        return Optional.ofNullable(file)
                .filter(jarFile -> FilenameUtils.getExtension(jarFile.getName()).equals("jar"))
                .filter(creationHourEvenPredicate())
                .isPresent();
    }

    private Predicate<File> creationHourEvenPredicate() {
        return jarFile -> FileUtils.getCreationHour(jarFile) % 2 == 0;
    }
}
