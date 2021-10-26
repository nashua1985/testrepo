package com.dsg.framework.loggers;

import org.testng.Reporter;

import java.io.File;
import java.net.MalformedURLException;

public class TestNGLogMethods implements ITestNGLogMethods {

  private static final ThreadLocal<Integer> s_step = new InheritableThreadLocal<Integer>();

  /** Clears log step count */
  public static void clearLogStepCount() {
    TestNGLogMethods.s_step.set(null);
  }

  /**
   * Logs test step
   *
   * @param msg This should be the message you want to print in the log
   */
  public static void logStep(String msg) {

    Integer step = s_step.get();

    if (step == null || step < 1) {
      step = 1;
    } else {
      step++;
    }

    s_step.set(step);

    Reporter.log(String.format("Step %d: %s", step, msg), 2, true);
  }

  /**
   * Logs test step and adds link to screenshot
   *
   * @param msg This should be the message you want to display in the log
   * @param screenshotfilePath This should be the filepath to the screenshot
   * @throws MalformedURLException
   */
  public static void logStepAddScreenShotLink(String msg, String screenshotfilePath)
      throws MalformedURLException {

    File screenShotfile = new File(screenshotfilePath);

    Integer step = s_step.get();

    try {

      if (step == null || step < 1) {
        step = 1;
      } else {
        step++;
      }

      s_step.set(step);

      msg =
          msg
              + String.format(
                  "<a href=\"%s\"> Click here for Screenshot</a>", screenShotfile.toURI().toURL());

      Reporter.log(String.format("Step %d: %s", step, msg), 2, true);

    } catch (MalformedURLException ex) {
      throw ex;
    }
  }

  /**
   * Logs info
   *
   * @param msg This should be the Info message you want to display in the log
   */
  public static void logInfo(String msg) {

    Reporter.log(msg, 2, true);
  }

  /**
   * Logs debug message
   *
   * @param msg This should be the Debug message you want to display in the log
   */
  public static void logDebug(String msg) {

    Reporter.log(msg, 5, true);
  }
}
