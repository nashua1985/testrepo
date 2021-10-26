package com.dsg.framework.loggers;

public interface ITestNGLogMethods {

  static void clearLogStepCount() {}

  static void logStep(String msg) {}

  static void logStepAddScreenShotLink(String msg, String screenshotfilePath) {}

  static void logInfo(String msg) {}

  static void logDebug(String msg) {}
}
