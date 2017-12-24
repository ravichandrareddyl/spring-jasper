package com.ravi.jasperdemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ravi.jasperdemo.controllers.DemoReportExporter;
import com.ravi.jasperdemo.controllers.DemoReportFiller;

@SpringBootApplication
public class JasperdemoApplication implements CommandLineRunner{
	
	@Autowired 
    private DemoReportFiller demoReportFiller;
	
    @Autowired
    private DemoReportExporter demoReportExporter; 

    @Override
    public void run(String... args) {
        demoReportFiller.setReportFileName("statement.jrxml"); 
        demoReportFiller.compileReport(); 
        Map<String, Object> parameters = new HashMap<String, Object>(); 
        parameters.put("title", "Employee Report Example"); 
        parameters.put("idEmployee", "301101"); 
        demoReportFiller.setParameters(parameters); 
        demoReportFiller.fillReport();
        demoReportExporter.setJasperPrint(demoReportFiller.getJasperPrint()); 
        demoReportExporter.exportToPdf("statement.pdf", "Ravi chandra"); 
//        if (args.length > 0 && args[0].equals("exitcode")) { 
//            throw new ExitException(); 
//        } 

    } 

	public static void main(String[] args) {
		SpringApplication.run(JasperdemoApplication.class, args);
	}
}
