package com.us.lot.v2.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chandra khadka
 * @since 2020-09-21
 */
public class Sample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(Sample::generate);
        
        System.out.println("main");
    }

    private static int generate() {
        return 2;
    }
}
