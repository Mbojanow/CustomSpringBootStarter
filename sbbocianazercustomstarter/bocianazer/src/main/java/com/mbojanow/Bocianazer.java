package com.mbojanow;

import java.util.Random;

import static com.mbojanow.BocianazerConfigurationParameters.BOCIAN_NUM;
import static com.mbojanow.BocianazerConfigurationParameters.BOCIAN_SEED;
import static com.mbojanow.BocianazerConfigurationParameters.BOCIAN_TYPE;

public class Bocianazer {

    private BocianConfiguration bocianConfiguration;

    public Bocianazer(final BocianConfiguration bocianConfiguration) {
        this.bocianConfiguration = bocianConfiguration;
    }

    public String getBocianazed() {
        try {
            final int numberOfStorks = getNumberOfStorks();
            if (numberOfStorks <= 0) {
                return "You did not get bocianazed! You win";
            }

            final StringBuilder msgBuilder = new StringBuilder("You got bocianized by ");

            msgBuilder.append(numberOfStorks).append(" ").append(getType())
                    .append(" stork").append(numberOfStorks > 1 ? "s. " : ". ")
                    .append("You just lost ").append(getHealthPointsLost()).append(" points of your HP.");
            return msgBuilder.toString();
        } catch (final NumberFormatException exp) {
            return "You managed to figure out configuration to not to get bocianazed! You won!";
        } catch (final IllegalArgumentException exp) {
            return "You managed to figure out a stork type to not to get bocianazed! You won!";
        }
    }

    private BocianType getType() {
        final String bocianType = bocianConfiguration.getProperty(BOCIAN_TYPE);
        return BocianType.valueOf(bocianType);
    }

    private Integer getNumberOfStorks() {
        return Integer.valueOf(bocianConfiguration.getProperty(BOCIAN_NUM));
    }

    private Integer getHealthPointsLost() {
        final Random generator = new Random(Integer.valueOf(bocianConfiguration.getProperty(BOCIAN_SEED)));
        return Math.abs(generator.nextInt());
    }
}
