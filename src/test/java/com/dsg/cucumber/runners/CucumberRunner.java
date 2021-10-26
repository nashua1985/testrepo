package com.dsg.cucumber.runners;

import com.dsg.cucumber.step_definitions.Hooks;
import com.dsg.cucumber.utilities.ReportUtilities;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@CucumberOptions(
        glue = "com/dsg/cucumber/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        monochrome = true,
        //tags = "@SB_032",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "html:target/cucumber-html-reports/ide-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }

        @BeforeClass
        public static void buildBasicReport() {
                Hooks.teamsReport.append("\n").append("-------------------------------------").append("\n")
                        .append("Test started: ").append(ReportUtilities.formattedDateTime())
                        .append("\n").append("-------------------------------------").append("\n");
        }

        @AfterClass
        public void createBasicReportFile() throws IOException {
                System.out.println(Hooks.teamsReport);

                String path = "target/SparkReport/BasicReport.txt";

                File file = new File(path);
                if (file.createNewFile()) {
                        System.out.println("File created: " + file.getAbsolutePath());
                } else {
                        System.out.println("file not created");
                }

                FileWriter fw = new FileWriter(file.getAbsolutePath());
                fw.write(String.valueOf(Hooks.teamsReport));
                fw.close();

        }

}
