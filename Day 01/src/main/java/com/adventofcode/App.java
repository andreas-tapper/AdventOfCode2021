package com.adventofcode;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Day 1 of Advent of Code 2021." );

        if(args.length < 1) {
            System.out.println("usage <filename with inputs>");
            return;
        }

        if("1".equals(args[0])) {
            partOne(args[1]);
        } else if("2".equals(args[0])) {
            partTwo(args[1]);
        }

    }

    private static void partOne(String input) throws IOException {
        try(var reader = new BufferedReader(new FileReader(input, Charset.forName("UTF-8")))) {
            var lines = reader.lines()
                    .map(Integer::valueOf)
                    .collect(toList());

            var count = 0;
            for(var i=1; i < lines.size(); i += 1) {
                if(lines.get(i-1) < lines.get(i)) {
                    count += 1;
                }
            }

            System.out.println(String.format("Answer is: %d", count));
        }
    }

    private static void partTwo(String input) throws IOException {
        try(var reader = new BufferedReader(new FileReader(input, Charset.forName("UTF-8")))) {
            var lines = reader.lines()
                    .map(Integer::valueOf)
                    .collect(toList());

            var count = 0;
            var last = 0;
            for(var i=3; i < lines.size(); i += 1) {
                var sum = lines.subList(i - 3, i)
                        .stream()
                        .reduce(0, Integer::sum);

                if(last < sum) {
                    count += 1;
                }

                last = sum;
            }

            System.out.println(String.format("Answer is: %d", count));
        }
    }
}
