package co.edu.unbosque.EntreColPlusFileReader.util;

import java.io.File;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonReader {


	public static void main(String[] args) {
		readJson("src/main/java/co/edu/unbosque/EntreColPlusFileReader/files/books.json");
	}

	@SuppressWarnings("deprecation")
	public static ArrayList<Libros> readJson(String file) {
		ArrayList<Libros> libros = new ArrayList<Libros>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Book> books = objectMapper.readValue(new File(file), new TypeReference<List<Book>>() {
			});
			for (Book book : books) {
				String[] d = book.getPublicationDate().split("/");
				
				libros.add(new Libros((Integer)book.getBookID(), book.getTitle(), book.getAuthors(),Float.parseFloat(book.getAverageRating()), 
						new BigInteger(book.getIsbn()),new BigInteger(book.getIsbn13()), book.getLanguageCode(), 
						Integer.parseInt(book.getNumPages()), book.getRatingsCount(), book.getTextReviewsCount(),new Date(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])), 
						book.getPublisher()));
				
			}

		} catch (Exception e) {
			System.out.println("Falla en la lectura del Json");
			e.printStackTrace();
		}
		return libros;
	}

}
