package com.crispeh.apicore.util.countdown;

import com.crispeh.apicore.util.APIModule;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Joey on 7/24/2014.
 */
@Data
public final class Countdown implements Runnable {

    private final CountdownHandler countdownHandler;
    private final Integer seconds;
    private Integer secondsPassed = 0;
    private boolean isCountingDown = false;
    private BukkitTask bukkitTask = null;

    @Override
    public void run() {
        secondsPassed++;
        this.countdownHandler.countdownChanged(seconds, seconds - secondsPassed, this);
        if (this.secondsPassed >= seconds) {
            this.countdownHandler.countdownComplete(seconds, this);
            reset();
            return;
        }

        if (this.isCountingDown) reschedule();
    }

    public void startCoundown() {
        reset();
        this.isCountingDown = true;
        this.countdownHandler.countdownStarting(seconds, this);
        this.countdownHandler.countdownChanged(seconds, seconds - secondsPassed, this);
        reschedule();
    }

    public void pauseCountdown() {
        this.isCountingDown = false;
    }


    public void reset() {
        pauseCountdown();
        secondsPassed = 0;
    }

    private void reschedule() {
        bukkitTask = Bukkit.getScheduler().runTaskLater(APIModule.getInstance(), this, 20L);
    }

}
