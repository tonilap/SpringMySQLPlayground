package com.toni.playground.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class SqlLoader {
    private static Logger logger = Logger.getLogger(SqlLoader.class);
    private static final String separator = System.getProperty("line.separator");

    public static String load(final String path) {
    	InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        String sql = null;
        BufferedReader reader = null;
        try {
            if (is == null) {
                throw new FileNotFoundException(path);
            } else {
                final StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                reader = new BufferedReader(new InputStreamReader(is));
                while((line = reader.readLine()) != null ) {
                    stringBuilder.append(line);
                    stringBuilder.append(separator);
                }
                sql = stringBuilder.toString();
            }
        } catch (IOException e) {
            logger.error("Error reading " + path, e);
        }  finally {
            if (reader != null) {
                try {
                    reader.close();
                    is = null;
                } catch (IOException e) {
                    logger.error("Error reading " + path, e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("Error reading " + path, e);
                }
            }
        }
        return sql;

    }
}
