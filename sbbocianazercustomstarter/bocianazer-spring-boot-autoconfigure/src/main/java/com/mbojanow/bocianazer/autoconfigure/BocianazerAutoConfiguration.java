package com.mbojanow.bocianazer.autoconfigure;


import com.mbojanow.BocianConfiguration;
import com.mbojanow.BocianType;
import com.mbojanow.Bocianazer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mbojanow.BocianazerConfigurationParameters.BOCIAN_NUM;
import static com.mbojanow.BocianazerConfigurationParameters.BOCIAN_SEED;
import static com.mbojanow.BocianazerConfigurationParameters.BOCIAN_TYPE;

@Configuration
@ConditionalOnClass(Bocianazer.class)
@EnableConfigurationProperties(BocianazerProperties.class)
public class BocianazerAutoConfiguration {

    private final BocianazerProperties bocianazerProperties;

    @Autowired
    public BocianazerAutoConfiguration(BocianazerProperties bocianazerProperties) {
        this.bocianazerProperties = bocianazerProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public BocianConfiguration bocianConfiguration() {
        final String bocianType = bocianazerProperties.getBocianType() == null ? BocianType.WHITE.name() : bocianazerProperties.getBocianType();
        final String bocianNumber = bocianazerProperties.getBocianNumber() == null ? "5": bocianazerProperties.getBocianNumber();
        final String bocianSeed = bocianazerProperties.getBocianSeed() == null ? "1337" : bocianazerProperties.getBocianSeed();

        final BocianConfiguration bocianConfiguration = new BocianConfiguration();
        bocianConfiguration.put(BOCIAN_TYPE, bocianType);
        bocianConfiguration.put(BOCIAN_NUM, bocianNumber);
        bocianConfiguration.put(BOCIAN_SEED, bocianSeed);
        return bocianConfiguration;
    }

    @Bean
    @ConditionalOnMissingBean
    public Bocianazer bocianazer(final BocianConfiguration bocianConfiguration) {
        return new Bocianazer(bocianConfiguration);
    }
}
