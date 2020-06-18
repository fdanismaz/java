package com.fcommons.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * @author fdanismaz
 * @since 6/18/20
 */
public class FileUtil {
    public static InputStream getResourceAsStream(String filePath) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
    }

    public static String readResource(String filePath) {
        InputStream stream = getResourceAsStream(filePath);
        String content = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));
        return content;
    }
}
