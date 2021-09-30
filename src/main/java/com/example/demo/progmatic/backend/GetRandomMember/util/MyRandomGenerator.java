package com.example.demo.progmatic.backend.GetRandomMember.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public class MyRandomGenerator {
    @Value("${custom.random.magic.number}")
    private int magicNumber;

    public int getRandom(int size) {
        if (magicNumber != -1 && magicNumber < size) {
            System.out.println("Magic number used: " + magicNumber);
            return magicNumber;
        }
        Random rnd = new Random();
        return rnd.nextInt(size);
    }

}
