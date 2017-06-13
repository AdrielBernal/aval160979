package br.univel.report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.univel.db.ConexaoDB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager {

	private static final String JASPER_Aluno = "C:\\Users\\abernal\\JaspersoftWorkspace\\MyReports\\prova.jasper";

	public void imprimir() {
		JasperPrint jasperPrintPDF = getPrint();
		Locale locale = Locale.getDefault();
		JasperViewer.viewReport(jasperPrintPDF, false, locale);
	}

	public void exportar() {
		JasperPrint jasperPrintPDF = getPrint();

		SimpleDateFormat sdf = new SimpleDateFormat("(yyyy-MM-dd)_HH-mm-ss");
		String data = sdf.format(new Date());

		String nomePdf = "relatorio_Alunos_" + data + ".pdf";

		try {
			JasperExportManager.exportReportToPdfFile(jasperPrintPDF, nomePdf);
			Desktop.getDesktop().open(new File(nomePdf));
		} catch (JRException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private JasperPrint getPrint() {
		Connection con = ConexaoDB.getInstance().getConnection();
		try {
			return JasperFillManager.fillReport(JASPER_Aluno, null, con);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

}
