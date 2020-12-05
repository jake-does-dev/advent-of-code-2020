package io;

import exceptions.AdventException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader implements InputReader {
    private final String file;

    public FileInputReader(String file) {
        this.file = file;
    }

    public List<Integer> readNumbers() throws AdventException {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
            while(br.ready()) {
                numbers.add(Integer.parseInt(br.readLine()));
            }
        } catch (IOException e) {
            throw new AdventException("Problem with reading input: " + e.getMessage(), e);
        }

        return numbers;
    }
}
