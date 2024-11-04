/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sen_projectmaven.Model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author mckyl
 */
public class MaintenanceScheduler extends System_Forecast {

        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // Run this to start the schedule
        public MaintenanceScheduler() {
            // Schedule the forecast task to run twice a day
            scheduleForecast();
        }

        private void scheduleForecast() {
            Runnable forecastTask = this::forecast;

            // Calculate the initial delay and period in hours
            long initialDelay = calculateInitialDelay();
            long period = 12; // Run every 12 hours

            // Schedule the task
            scheduler.scheduleAtFixedRate(forecastTask, initialDelay, period, TimeUnit.HOURS);
        }

        private long calculateInitialDelay() {
            //Add delay to scheduler in real world cases
            return 0; 
        }

        public void forecast() {
            Technician t = new Technician();
            t.notifyAllTechniciansSystems(getMaintananceNeeded());
        }

        public void shutdown() {
            // Shut down the scheduler gracefully
            scheduler.shutdown();
        }
        //usage example
        //public static void main(String[] args) {
        //    MaintenanceScheduler scheduler = new MaintenanceScheduler();

            // Runtime shutdown hook to ensure graceful shutdown
        //    Runtime.getRuntime().addShutdownHook(new Thread(scheduler::shutdown));
        //}
    }