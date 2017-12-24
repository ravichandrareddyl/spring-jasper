package com.ravi.jasperdemo.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Component
public class DemoReportExporter {
	 private JasperPrint jasperPrint;

	    public DemoReportExporter() {
	    }

	    public DemoReportExporter(JasperPrint jasperPrint) {
	        this.jasperPrint = jasperPrint;
	    }

	    public JasperPrint getJasperPrint() {
	        return jasperPrint;
	    }

	    public void setJasperPrint(JasperPrint jasperPrint) {
	        this.jasperPrint = jasperPrint;
	    }

	    public void exportToPdf(String fileName, String author) {

	        // print report to file
	        JRPdfExporter exporter = new JRPdfExporter();

	        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName));

//	        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
//	        reportConfig.setSizePageToContent(true);
//	        reportConfig.setForceLineBreakPolicy(false);
//
//	        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
//	        exportConfig.setMetadataAuthor(author);
//	        exportConfig.setEncrypted(true);
//	        exportConfig.setAllowedPermissionsHint("PRINTING");
//
//	        exporter.setConfiguration(reportConfig);
//	        exporter.setConfiguration(exportConfig);
	        try {
	            exporter.exportReport();
	        } catch (JRException ex) {
	            Logger.getLogger(DemoReportFiller.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}
