package com.pretius.file_sorter;

import java.io.File;

interface FileSortStrategy {

    void move(File file);

    boolean shouldMove(File file);
}
