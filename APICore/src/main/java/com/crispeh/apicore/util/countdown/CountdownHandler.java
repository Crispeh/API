package com.crispeh.apicore.util.countdown;

/**
 * Created by Joey on 7/24/2014.
 */
public interface CountdownHandler {

    void countdownStarting(Integer maxSeconds, Countdown countdown);
    void countdownChanged(Integer maxSeconds, Integer secondsRemaining, Countdown countdown);
    void countdownComplete(Integer maxSeconds, Countdown countdown);

}
