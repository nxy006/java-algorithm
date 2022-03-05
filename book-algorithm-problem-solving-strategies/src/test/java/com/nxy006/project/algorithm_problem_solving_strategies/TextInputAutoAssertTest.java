package com.nxy006.project.algorithm_problem_solving_strategies;

import com.nxy006.project.alogtithm.utils.model.TextInputAssertSolution;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;

public class TextInputAutoAssertTest extends TextInputAssertTest {
    private static final String DEFAULT_INPUT_FILENAME = "input.txt";
    private static final String DEFAULT_OUTPUT_FILENAME = "output.txt";
    private static final String DEFAULT_ANSWER_FILENAME = "answer.txt";

    private String basePath = null;

    private String getBasePath() {
        if (basePath != null) {
            return basePath;
        }

        String className = this.getClass().getName();
        String[] classNames = className.split("\\.");
        if (classNames.length < 2) {
            throw new RuntimeException("get base path failed");
        }
        return basePath = "cases/" + classNames[classNames.length-2] + "/";
    }

    protected String getInputPath() {
        return getBasePath() + DEFAULT_INPUT_FILENAME;
    }

    protected String getOutputPath() {
        return getBasePath() + DEFAULT_OUTPUT_FILENAME;
    }

    protected String getAnswerPath() {
        return getBasePath() + DEFAULT_ANSWER_FILENAME;
    }
}
