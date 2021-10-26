package com.dsg.framework.loggers;

import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.InitProperties;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtilities {

  public static String formattedDateTime() {

    Date now = new Date();

    SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy_HHmmss");

    String dateFormat = date.format(now);

    return dateFormat;
  }

  public static String copyTestNgEmailableReportToReportsDirectory(String fileName)
      throws Exception {

    AutomationProperties ap = InitProperties.setProperties();
    // Get the emailable-report.html file

    File source = getTestNGOutputFile(ap.getOutputDirectory());

    // Create a time stamped file in time stamped reports directory // timestamp is set prior - for
    // now

    File destination = createReportFile(ap.getResultsDirectory(), fileName + ".html");

    // Copy TestNG HTML file to reports directory

    FileUtils.copyFile(source, destination);

    return destination.getPath();
  }

  public static File getTestNGOutputFile(String testNGOutputFilePath) throws FileNotFoundException {

    String resultsFilePath = testNGOutputFilePath + "emailable-report.html";

    File testNGResultsFile = new File(resultsFilePath);
    if (FileUtils.waitFor(testNGResultsFile, 5)) {
      return testNGResultsFile;
    } else {
      throw new FileNotFoundException("Unable to find file: " + resultsFilePath);
    }
  }

  public static File createReportFile(String path, String fileName) {

    if (!path.endsWith("/")) {
      path = path + "/";
    }

    return new File(path + fileName);
  }
}
