package co.edu.unbosque.EntreColPlusBack.util;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.edu.unbosque.EntreColPlusBack.model.Bono;
import co.edu.unbosque.EntreColPlusBack.model.Empleado;

public class ExcelReader {

	public ArrayList<Empleado> readExcelEmpleados(String file) {
		ArrayList<Empleado> e = new ArrayList<>();
		try {
			XSSFWorkbook myFile = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = myFile.getSheetAt(0);

			XSSFCell cell;
			XSSFRow row;

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				Empleado aux = new Empleado();
				row = sheet.getRow(i);

				for (int j = 0; j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					switch (j) {
					case 0:
						aux.setCodigo_empleado(Integer.parseInt(cell.toString().split("\\.")[0]));
						break;
					case 1:
						aux.setNombre(cell.toString());
						break;
					case 2:
						aux.setDependencia(cell.toString());
						break;
					case 3:
						aux.setCargo(cell.toString());
						break;
					case 4:
						aux.setFecha_ingreso(cell.toString().isBlank() ? null:convertirStringADate(cell.toString()));
						break;
					case 5:
						aux.setEps(cell.toString());
						break;
					case 6:
						aux.setArl(cell.toString());
						break;
					case 7:
						aux.setPension(cell.toString());
						break;
					case 8:
						aux.setSueldo(Float.parseFloat(cell.toString()));
						break;
					default:
						break;
					}
				}
				e.add(aux);
			}

		} catch (Exception ex) {
		}
		return e;
	}

	public ArrayList<Bono> readExcelBonos(String file) {
		ArrayList<Bono> b = new ArrayList<>();
		try {
			XSSFWorkbook myFile = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = myFile.getSheetAt(1);

			XSSFCell cell;
			XSSFRow row;

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				Bono aux = new Bono();
				row = sheet.getRow(i);

				for (int j = 0; j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					switch (j) {
					case 0:
						aux.setCodigo_novedad(i);
						break;
					case 1:
						aux.setNovedad_incapacidad(cell.toString() == "X" ? 1:0);
						break;
					case 2:
						aux.setNovedad_vacaciones(cell.toString() == "X" ? 1:0);
						break;
					case 3:
						aux.setDias_trabajados(Integer.parseInt(cell.toString().split("\\.")[0]));
						break;
					case 4:
						aux.setDias_incapacidad(Integer.parseInt(cell.toString().split("\\.")[0]));
						break;
					case 5:
						aux.setDias_vacaciones(Integer.parseInt(cell.toString().split("\\.")[0]));
						break;
					case 6:
						aux.setFecha_inicio_vacaciones(cell.toString().isBlank() ? null:convertirStringADate(cell.toString()));
						break;
					case 7:
						aux.setFecha_fin_vacaciones(cell.toString().isBlank() ? null:convertirStringADate(cell.toString()));
						break;
					case 8:
						aux.setFecha_inicio_incapacidad(cell.toString().isBlank() ? null:convertirStringADate(cell.toString()));
						break;
					case 9:
						aux.setFecha_fin_incapacidad(cell.toString().isBlank() ? null:convertirStringADate(cell.toString()));
						break;
					case 10:
						aux.setBonificacion(Float.parseFloat(cell.toString()));
						break;
					case 11:
						aux.setTransporte(Float.parseFloat(cell.toString()));
						break;
					default:
						break;
					}
				}
				b.add(aux);
			}

		} catch (Exception ex) {
			System.out.println("Falla en la lectura del excel");
		}
		return b;
	}
	
	public static Date convertirStringADate(String fechaEnTexto) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        try {
            fecha = formatoFecha.parse(fechaEnTexto);
        } catch (ParseException e) {
        }

        return fecha;
    }
}
