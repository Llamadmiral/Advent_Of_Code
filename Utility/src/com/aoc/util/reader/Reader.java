package com.aoc.util.reader;

import com.aoc.util.log.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
public final class Reader {

    private static final Logger LOG = new Logger(Reader.class);

    private static final String INPUT_DIRECTORY = "input/";

    private Reader() {
    }

    public static String readFromInput(final String filename) {
        return read(INPUT_DIRECTORY + filename);
    }

    private static String read(final String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String row;
            while ((row = reader.readLine()) != null) {
                if (builder.length() != 0) {
                    builder.append("\n");
                }
                builder.append(row);
            }
        } catch (final Exception e) {
            LOG.log(e);
        }
        return builder.toString();
    }

    public static List<String> readFileIntoList(final String path) {
        final List<String> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(INPUT_DIRECTORY + path)))) {
            String row;
            while ((row = reader.readLine()) != null) {
                rows.add(row);
            }
        } catch (final Exception e) {
            LOG.log(e);
        }
        return rows;
    }
}
