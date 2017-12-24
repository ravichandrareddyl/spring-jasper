package com.ravi.jasperdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ravi.jasperdemo.controllers.DemoReportExporter;
import com.ravi.jasperdemo.controllers.DemoReportFiller;

@Configuration
public class JasperReportsSimpleConfig {
	
	 @Bean
	    public DemoReportFiller reportFiller() {
	        return new DemoReportFiller();
	    }

	    @Bean
	    public DemoReportExporter reportExporter() {
	        return new DemoReportExporter();
	    }

}
