package co.edu.unbosque.EntreColPlusBack.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.unbosque.EntreColPlusBack.model.Libro;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonReader {
	
	public ArrayList<Libro> readJson(String file) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Book> books = objectMapper.readValue(new File(file), new TypeReference<List<Book>>() {
			});
			for (Book book : books) {
				try {
					String autores = book.getAuthors().length()<=40 ? book.getAuthors():book.getAuthors().substring(0,39);
					
					libros.add(new Libro((Integer)book.getBookID(), book.getTitle(), autores,Float.parseFloat(book.getAverageRating()), 
							book.getIsbn(),book.getIsbn13(), book.getLanguageCode(), 
							Integer.parseInt(book.getNumPages()), book.getRatingsCount(), book.getTextReviewsCount(),book.getPublicationDate().isBlank() ? null:convertirStringADate(book.getPublicationDate()), 
									book.getPublisher()));					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			System.out.println("Falla en la lectura del Json");
			e.printStackTrace();
		}
		return libros;
	}
	
	public static Date convertirStringADate(String fechaEnTexto) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        try {
            fecha = formatoFecha.parse(fechaEnTexto);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fecha;
    }

}
