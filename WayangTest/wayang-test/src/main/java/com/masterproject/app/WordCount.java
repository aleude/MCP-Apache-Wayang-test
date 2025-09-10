package com.masterproject.app;

import org.apache.wayang.core.api.WayangContext;
import org.apache.wayang.core.plugin.Plugin;
import org.apache.wayang.core.platform.ExecutionEnvironment;
import org.apache.wayang.java.JavaPlatform;

import java.util.Arrays;

public class WordCount {

    public static void run(String inputFile) {
        // 1. Lav WayangContext og tilføj Java-platformen
        WayangContext wayangContext = new WayangContext();
        wayangContext.register(JavaPlatform.getInstance());

        // 2. Lav ExecutionEnvironment
        try (ExecutionEnvironment env = wayangContext.createExecutionEnvironment()) {

            // 3. Læs filen, split ord, count og print
            env.readTextFile(inputFile)
               .flatMap(line -> Arrays.asList(line.split("\\s+")))
               .map(word -> new Tuple(word, 1))
               .reduceByKey(
                       Tuple::getKey,
                       (t1, t2) -> new Tuple(t1.getKey(), t1.getValue() + t2.getValue())
               )
               .forEach(t -> System.out.println(t.getKey() + " : " + t.getValue()));
        }
    }

    // Simpel Tuple-klasse
    public static class Tuple {
        private final String key;
        private final int value;

        public Tuple(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() { return key; }
        public int getValue() { return value; }
    }
}
