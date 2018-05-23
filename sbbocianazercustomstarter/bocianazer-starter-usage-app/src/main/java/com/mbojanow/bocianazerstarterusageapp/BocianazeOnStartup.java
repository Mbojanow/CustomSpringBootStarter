package com.mbojanow.bocianazerstarterusageapp;

import com.mbojanow.Bocianazer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BocianazeOnStartup implements CommandLineRunner {

    private Bocianazer bocianazer;

    public BocianazeOnStartup(Bocianazer bocianazer) {
        this.bocianazer = bocianazer;
    }


    @Override
    public void run(String... args) {
        System.out.println(bocianazer.getBocianazed());
    }
}
