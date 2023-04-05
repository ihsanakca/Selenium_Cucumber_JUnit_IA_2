package com.krafttech.steps_defs;

import com.krafttech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
       // System.out.println("This note comes from Before method");
        Driver.get().manage().window().setPosition(new Point(-1000, 0));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(Scenario scenario){
      //  System.out.println("This note comes from After method");
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

    @AfterAll
    public static void tearDownAll(){
//        Driver.closeDriver();
    }

    @Before("@jdbc")
    public void setUpJDBC(){
        System.out.println("JDBC is on");
    }
    @After("@jdbc")
    public void tearDownJDBC(){
        System.out.println("JDBC is off");
    }


}
