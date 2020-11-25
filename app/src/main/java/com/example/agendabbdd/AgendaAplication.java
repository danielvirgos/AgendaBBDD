package com.example.agendabbdd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgendaAplication {

    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();

    public static final ExecutorService threadExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
}
