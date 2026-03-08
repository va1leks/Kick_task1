package org.example.kick_task1.reader;

import org.example.kick_task1.exception.MyException;
import org.example.kick_task1.reader.impl.MyFileReaderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyFileReaderImplTest {
    private MyFileReaderImpl fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new MyFileReaderImpl();
    }

    @Test
    void readFileShouldReturnLines(@TempDir Path tempDir) throws IOException, MyException {
        // Создаем временный файл
        Path testFile = tempDir.resolve("test.txt");
        List<String> expectedLines = List.of("line1", "line2", "line3");
        Files.write(testFile, expectedLines);

        // Читаем файл
        List<String> actualLines = fileReader.readFile(testFile.toString());

        assertEquals(expectedLines, actualLines);
    }

    @Test
    void readFileShouldThrowExceptionWhenFileNotFound() {
        assertThrows(MyException.class, () ->
                fileReader.readFile("nonexistent_file.txt")
        );
    }

    @Test
    void readFileShouldHandleEmptyFile(@TempDir Path tempDir) throws IOException, MyException {
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.createFile(emptyFile);

        List<String> lines = fileReader.readFile(emptyFile.toString());
        assertTrue(lines.isEmpty());
    }
}