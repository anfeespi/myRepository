package co.edu.unbosque.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.UserDAOImpl;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.UserManDTO;
import co.edu.unbosque.model.UserWomanDTO;
import co.edu.unbosque.view.AdminStatisticsFrame;

/**
 * Clase para crear documentos en pdf con las estadisticas
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 */
public class GenerateReports {
	/**
	 * Fuente de inicio de capitulo
	 */
	private static final com.itextpdf.text.Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.ITALIC);
	/**
	 * Fuente de parrafos
	 */
    private static final com.itextpdf.text.Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, 0);
    /**
     * Fuente para las tablas
     */
    private static final com.itextpdf.text.Font tableFont = FontFactory.getFont(FontFactory.TIMES, 8, 0);
    /**
     * Ruta de la imagen
     */
    private static final String iTextExampleImage = "src/co/edu/unbosque/util/media/GUIImgs/iconpdf.jpeg";
    
    private static UserDAOImpl userslist;
    
    private static AdminStatisticsFrame asf;
	
    /**
     * Metodo para crear el pdf
     * @param pdfNewFile
     * @param users
     * @return Generar pdf
     * @throws DocumentException
     */
	public static boolean generatePdf (File pdfNewFile, ArrayList<UserDTO> users) throws DocumentException {
		userslist = new UserDAOImpl();
		asf = new AdminStatisticsFrame(2);
		Document document = null;
    	try {
    	    document = new Document();
    	    try {
    	        PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
    	    } catch (FileNotFoundException fileNotFoundException) {
    	        System.out.println("No such file was found to generate the PDF "
    	                + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
    	    }
    	    document.open();
    	 
    	    document.addTitle("Informe "+ZonedDateTime.now());
        	document.addAuthor("Uebfa - Red Thread");
        	document.addCreator("Uebfa - Red Thread");
        	
        	
        	Chunk chunk = new Chunk("Informe General - Red Thread", chapterFont);
        	chunk.setBackground(BaseColor.WHITE);
        	// Let's create de first Chapter (Creemos el primer capítulo)
        	Paragraph p = new Paragraph(chunk);
        	p.setAlignment(Element.ALIGN_CENTER);
        	Chapter chapter = new Chapter(p, 1);
        	
        	Image image = null;
        	try {
        		image = Image.getInstance(iTextExampleImage);  
        		image.setAbsolutePosition(75, 150);
        		chapter.add(image);
        	} catch (BadElementException ex) {
        		System.out.println("Image BadElementException" +  ex);
        	} catch (IOException ex) {
        		System.out.println("Image IOException " +  ex);
        	}
        	chapter.setNumberDepth(0);
        	chapter.add(new Paragraph("\n\nEl siguiente informe contiene:\n"
        			+ "		1. Lista de usuarios\n"
        			+ "		2. Moda, Media y Mediana\n"
        			+ "		3. Gráficas representativas", paragraphFont));
        	document.add(chapter);
        	
        	Anchor anchor = new Anchor("Ubefa - Red Thread");           
        	Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
        	Paragraph paragraph = new Paragraph("Tabla de usuarios");
        	Section paragraphMore = chapTitle.addSection(paragraph);
        	paragraphMore.add(new Paragraph("Base de datos(Manejar con discreción) \n\n"));
        	Integer numColumns = 8;
        	Integer numRows = users.size();
        	// We create the table (Creamos la tabla).
        	PdfPTable table = new PdfPTable(numColumns); 
        	// Now we fill the PDF table 
        	// Ahora llenamos la tabla del PDF
        	PdfPCell columnHeader;
        	// Fill table rows (rellenamos las filas de la tabla).                
        	columnHeader = new PdfPCell(new Phrase("NOMBRE", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("APELLIDO 1" , tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("APELLIDO 2", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("ALIAS", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("EDAD", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("CONTACTO", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("GENERO", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	columnHeader = new PdfPCell(new Phrase("ORIENTACION", tableFont));
        	columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        	table.addCell(columnHeader);
        	    
        	table.setHeaderRows(1);
        	// Fill table rows (rellenamos las filas de la tabla).                
        	for (int row = 0; row < numRows; row++) {
        		table.addCell(new Phrase(users.get(row).getName(), tableFont));
        		table.addCell(new Phrase(users.get(row).getLastname1(), tableFont));
        		table.addCell(new Phrase(users.get(row).getLastname2(), tableFont));
        		table.addCell(new Phrase(users.get(row).getAlias(), tableFont));
        		table.addCell(new Phrase(users.get(row).getAge()+"", tableFont));
        		table.addCell(new Phrase(users.get(row).getContact(), tableFont));
        		if(users.get(row).isGender()) table.addCell(new Phrase("MALE", tableFont));
        		else if(!users.get(row).isGender()) table.addCell(new Phrase("FEMALE", tableFont));
        		table.addCell(new Phrase(users.get(row).getOrientation(), tableFont));
        	}
        	// We add the table (Añadimos la tabla)
        	paragraphMore.add(table);
        	// We add the paragraph with the table (Añadimos el elemento con la tabla).
        	document.add(chapTitle);
        	
        	Chapter chapterimgs = new Chapter(p, 1);
        	
        	int men = 0, women = 0;
			for (UserDTO us : userslist.getUsers()) {
				if (us instanceof UserManDTO) men++;
				else if (us instanceof UserWomanDTO) women++;
			}
			asf.getAsp().showWomenVsMen(women, men);
        	
        	Image imagePie = null;
        	try {
        		imagePie = Image.getInstance("src/co/edu/unbosque/util/reports/pie.jpeg");  
        		imagePie.setAbsolutePosition(90, 400);
        		chapterimgs.add(imagePie);
        	} catch (BadElementException ex) {
        		System.out.println("Image BadElementException" +  ex);
        	} catch (IOException ex) {
        		System.out.println("Image IOException " +  ex);
        	}
        	
        	int hetero = 0, homo = 0, bi = 0, pan = 0, demi = 0, asex = 0;
			for (UserDTO us : userslist.getUsers()) {
				switch (us.getOrientation()) {
				case "Heterosexual":
					hetero++;
					break;
				case "Homosexual":
					homo++;
					break;
				case "Asexual":
					asex++;
					break;
				case "Demisexual":
					demi++;
					break;
				case "Bisexual":
					bi++;
					break;
				case "Pansexual":
					pan++;
					break;
				}
			}
			asf.getAsp().showOrientationsStats(hetero, homo, bi, pan, demi, asex);
			
			Image imageBars = null;
        	try {
        		imageBars = Image.getInstance("src/co/edu/unbosque/util/reports/bars.jpeg");  
        		imageBars.setAbsolutePosition(90, 70);
        		chapterimgs.add(imageBars);
        	} catch (BadElementException ex) {
        		System.out.println("Image BadElementException" +  ex);
        	} catch (IOException ex) {
        		System.out.println("Image IOException " +  ex);
        	}
        	document.add(chapterimgs);
        	
        	document.close();
        	return true;
    	} catch (DocumentException documentException) {
    		return false;
    	}
	}
}
