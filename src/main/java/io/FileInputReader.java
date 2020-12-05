package io;

import exceptions.AdventException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader implements InputReader {
    private final String separator;
    private final String file;

    public static FileInputReader createWithSpaceSeparator(String file) {
        return new FileInputReader(file, " ") ;
    }

    public static FileInputReader createWithNoSeparator(String file) {
        return new FileInputReader(file, "") ;
    }

    private FileInputReader(String file, String separator) {
        this.file = file;
        this.separator = separator;
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

    @Override
    public List<String[]> readLines() throws AdventException {
        List<String[]> lines = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
            while(br.ready()) {
                lines.add(br.readLine().split(separator));
            }
        } catch (IOException e) {
            throw new AdventException("Problem with reading input: " + e.getMessage(), e);
        }

        return lines;
    }
}
