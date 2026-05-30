package com.mariaeduarda;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws OllamaBaseException, IOException, InterruptedException {
        String host = "http://127.0.0.1:11434/";
        String modelName = "qwen3:1.7b";

        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(60);

        String result = ollamaAPI.generate(modelName,"O que é Java?", false);

        System.out.println(result);
    }
}
