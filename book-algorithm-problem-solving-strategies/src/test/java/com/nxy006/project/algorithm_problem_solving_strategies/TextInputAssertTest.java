package com.nxy006.project.algorithm_problem_solving_strategies;

import com.nxy006.project.alogtithm.utils.model.TextInputAssertSolution;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextInputAssertTest {
    private static final String RESULT_AC = "Accepted";
    private static final String RESULT_WA = "Wrong Answer";
    private static final String RESULT_PE = "Presentation Error";

    private URL inputUrl, outputUrl, answerUrl;
    private PrintStream originOut = System.out;

    @BeforeEach
    void setUp() {
        try {
            inputUrl  = TextInputAssertSolution.class.getClassLoader().getResource(getInputPath());
            outputUrl = TextInputAssertSolution.class.getClassLoader().getResource(getOutputPath());
            answerUrl = TextInputAssertSolution.class.getClassLoader().getResource(getAnswerPath());

            if (inputUrl == null || outputUrl == null || answerUrl == null) {
                throw new FileNotFoundException();
            }
            System.setIn(new FileInputStream(inputUrl.getFile()));
            System.setOut(new PrintStream(new FileOutputStream(outputUrl.getFile()), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    private void tearDown() {
        try {
            List<String> outputLines = Files.readAllLines(Paths.get(outputUrl.getFile().replaceAll("^/", "")));
            List<String> answerLines = Files.readAllLines(Paths.get(answerUrl.getFile().replaceAll("^/", "")));

            List<String> results = new ArrayList<>();
            for(int i = 0; i < Integer.max(outputLines.size(), answerLines.size()); i++) {
                String outputLine = i < outputLines.size() ? outputLines.get(i) : null;
                String answerLine = i < answerLines.size() ? answerLines.get(i) : null;

                results.add(lineAssert(outputLine, answerLine));
            }

            String result = RESULT_AC;
            for(int i = 0; i < results.size(); i++) {
                switch (results.get(i)) {
                    case RESULT_WA:
                        result = RESULT_WA;
                        break;
                    case RESULT_PE:
                        result = RESULT_WA.equals(result) ? RESULT_WA : RESULT_PE;
                        break;
                }
            }

            outputContentCompare(outputLines, answerLines, results);
            if (!RESULT_AC.equals(result)) {
                Assertions.fail("Result: " + result);
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private String lineAssert(String outputLine, String answerLine) {
        if (answerLine == null) {
            if (outputLine == null) {
                return RESULT_AC;
            }
            return "".equals(outputLine.replaceAll("\\s+", "")) ? RESULT_PE : RESULT_WA;
        }
        if (answerLine.equals(outputLine)) {
            return RESULT_AC;
        }

        if (outputLine == null) {
            return RESULT_WA;
        }
        outputLine = outputLine.replaceAll("\\s+", " ");
        if (answerLine.equals(outputLine)) {
            return RESULT_PE;
        }
        return RESULT_WA;
    }

    private void outputContentCompare(List<String> outputLines, List<String> answerLines, List<String> results) {
        int outputMaxLength = outputLines.stream().mapToInt((s) -> s == null ? 0 : s.length()).max().getAsInt() + 1;
        int answerMaxLength = answerLines.stream().mapToInt((s) -> s == null ? 0 : s.length()).max().getAsInt() + 1;

        System.setOut(originOut);
        System.out.println("File compare result:");
        for(int i = 0; i < Integer.max(outputLines.size(), answerLines.size()); i++) {
            String outputLine = i < outputLines.size() ? outputLines.get(i) : "";
            String answerLine = i < answerLines.size() ? answerLines.get(i) : "";
            System.out.printf("%02d | %-" + outputMaxLength + "s | %-" + answerMaxLength + "s | %s\n",
                    i+1, outputLine + "^", answerLine + "^", convertBriefResult(results.get(i)));
        }
    }

    private String convertBriefResult(String result) {
        switch (result) {
            case RESULT_PE: return "<PE>";
            case RESULT_WA: return "<WA>";
            default: return "";
        }
    }

    protected String getInputPath() {
        throw new RuntimeException("input path not set, cannot assert");
    }

    protected String getOutputPath() {
        throw new RuntimeException("input path not set, cannot assert");
    }

    protected String getAnswerPath() {
        throw new RuntimeException("input path not set, cannot assert");
    }
}
