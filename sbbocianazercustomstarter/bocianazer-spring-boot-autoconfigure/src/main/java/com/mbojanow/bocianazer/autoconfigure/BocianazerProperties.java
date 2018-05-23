package com.mbojanow.bocianazer.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mbojanow.bocianazer")
@Getter
@Setter
public class BocianazerProperties {

    private String bocianType;
    private String bocianNumber;
    private String bocianSeed;
}
