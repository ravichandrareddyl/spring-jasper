package com.ravi.jasperdemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ravi.jasperdemo.config.JasperReportsSimpleConfig;
import com.ravi.jasperdemo.controllers.DemoReportExporter;
import com.ravi.jasperdemo.controllers.DemoReportFiller;

@SpringBootApplication
public class JasperdemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(JasperdemoApplication.class, args);
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JasperReportsSimpleConfig.class);
        ctx.refresh();

        DemoReportFiller demoReportFiller = ctx.getBean(DemoReportFiller.class);
        demoReportFiller.setReportFileName("statement.jrxml");
        demoReportFiller.compileReport();

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("title", "Employee Report Example");
        parameters.put("idEmployee", 100);

        demoReportFiller.setParameters(parameters);
        demoReportFiller.fillReport();

        DemoReportExporter demoExporter = ctx.getBean(DemoReportExporter.class);
        demoExporter.setJasperPrint(demoReportFiller.getJasperPrint());

        demoExporter.exportToPdf("statement.pdf", "Ravi chandra");
	}
}
