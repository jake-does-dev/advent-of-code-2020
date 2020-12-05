package io;

import exceptions.AdventException;

import java.util.List;

public interface InputReader {
    List<Integer> readNumbers() throws AdventException;
    List<String[]> readLines() throws AdventException;
}
