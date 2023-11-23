package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.Libro;
import co.edu.unbosque.model.PeliculaGeneros;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@RequestScoped
public class ChartJsView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Empleado> empleados;
    
    private List<PeliculaGeneros> peliculas;
    
    private List<Libro> libros;
    
    private Random rand = new Random();
    
    @Inject
    private EmpleadoService service;
    
    @Inject
    private PeliculasLibrosService service_pel_lib;

    private PieChartModel grafico_uno_nomina;

    private BarChartModel grafico_dos_nomina;

    private BarChartModel grafico_eps;
    
    private BarChartModel grafico_pensiones;
    
    private BarChartModel grafico_eps_comparativo;
    
    private BarChartModel grafico_pensiones_comparativo;
    
    private BarChartModel grafico_peliculas;
    
    private BarChartModel grafico_libros;

    @PostConstruct
    public void init() {
    	empleados = service.getEmpleados();
    	peliculas = service_pel_lib.getPelGen();
    	libros = service_pel_lib.getLibros();
        graficoUnoNomina();
        graficoDosNomina();
        graficoEps();
        graficoPensiones();
        graficoEpsComp();
        graficoPensionesComp();
        graficoPeliculas();
        graficoLibros();
    }

    private void graficoUnoNomina() {
        grafico_uno_nomina = new PieChartModel();
        ChartData data = new ChartData();

        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        List<String> bgColors = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service.getDependencias().length; i++) {
        	int aux = 0;
			for (Empleado emp : empleados) {
				if (service.getDependencias()[i].equals(emp.getDependencia())) {
					aux++;
				}
			}			
			values.add(aux);
			bgColors.add("rgb("+rand.nextInt(256)+", "+rand.nextInt(256)+", "+rand.nextInt(256)+")");
			labels.add(service.getDependencias()[i]);
		}
        dataSet.setData(values);
        dataSet.setBackgroundColor(bgColors);
        data.addChartDataSet(dataSet);
        data.setLabels(labels);

        grafico_uno_nomina.setData(data);
    }

    public void graficoDosNomina() {
        grafico_dos_nomina = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet[] barDataSet = new BarChartDataSet[service.getCargos().length];
        
        for (int i = 0; i < service.getCargos().length; i++) {
        	barDataSet[i] = new BarChartDataSet();
        	int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
        	barDataSet[i].setLabel(service.getCargos()[i]);
            barDataSet[i].setBackgroundColor("rgba("+r+", "+g+", "+b+", 0.2)");
            barDataSet[i].setBorderColor("rgb("+r+", "+g+", "+b+")");
            barDataSet[i].setBorderWidth(1);
            List<Number> values = new ArrayList<>();
            for (int j = 0; j < service.getDependencias().length; j++) {
				int aux = 0;
				for (Empleado emp : empleados) {
					if ((service.getDependencias()[j].equals(emp.getDependencia())) && service.getCargos()[i].equals(emp.getCargo())) {
						aux++;
					}
				}
				values.add(aux);
			}
            barDataSet[i].setData(values);
            data.addChartDataSet(barDataSet[i]);
		}
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service.getDependencias().length; i++) {			
        	labels.add(service.getDependencias()[i]);
		}
        data.setLabels(labels);
        grafico_dos_nomina.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        grafico_dos_nomina.setOptions(options);
    }
    
    public void graficoEps() {
        grafico_eps = new BarChartModel();
        ChartData data = new ChartData();
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service.getEps().length; i++) {
        	BarChartDataSet barDataSet = new BarChartDataSet();
        	barDataSet.setLabel(service.getEps()[i]);
        	List<Number> values = new ArrayList<>();
        	List<String> bgColor = new ArrayList<>();
        	List<String> borderColor = new ArrayList<>();
            int aux = 0;
			for (Empleado emp : empleados) {
				if ((service.getEps()[i].equals(emp.getEps()))) {
					aux++;
				}
			}
			values.add(aux);
			int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
			bgColor.add("rgba("+r+", "+g+", "+b+", 0.2)");
			borderColor.add("rgb("+r+", "+g+", "+b+")");
			barDataSet.setData(values);
			barDataSet.setBackgroundColor(bgColor);
			barDataSet.setBorderColor(borderColor);
			barDataSet.setBorderWidth(1);
			data.addChartDataSet(barDataSet);
		}
        labels.add("EPS");
        data.setLabels(labels);
        grafico_eps.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        grafico_eps.setOptions(options);
    }
    
    public void graficoPensiones() {
        grafico_pensiones = new BarChartModel();
        ChartData data = new ChartData();
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service.getPensiones().length; i++) {
        	BarChartDataSet barDataSet = new BarChartDataSet();
        	barDataSet.setLabel(service.getPensiones()[i]);
        	List<Number> values = new ArrayList<>();
        	List<String> bgColor = new ArrayList<>();
        	List<String> borderColor = new ArrayList<>();
            int aux = 0;
			for (Empleado emp : empleados) {
				if ((service.getPensiones()[i].equals(emp.getPension()))) {
					aux++;
				}
			}
			values.add(aux);
			int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
			bgColor.add("rgba("+r+", "+g+", "+b+", 0.2)");
			borderColor.add("rgb("+r+", "+g+", "+b+")");
			barDataSet.setData(values);
			barDataSet.setBackgroundColor(bgColor);
			barDataSet.setBorderColor(borderColor);
			barDataSet.setBorderWidth(1);
			data.addChartDataSet(barDataSet);
		}
        labels.add("Pensiones");
        data.setLabels(labels);
        grafico_pensiones.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        grafico_pensiones.setOptions(options);
    }
    
    public void graficoEpsComp() {
        grafico_eps_comparativo = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet[] barDataSet = new BarChartDataSet[service.getEps().length];
        
        for (int i = 0; i < service.getEps().length; i++) {
        	barDataSet[i] = new BarChartDataSet();
        	int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
        	barDataSet[i].setLabel(service.getEps()[i]);
            barDataSet[i].setBackgroundColor("rgba("+r+", "+g+", "+b+", 0.2)");
            barDataSet[i].setBorderColor("rgb("+r+", "+g+", "+b+")");
            barDataSet[i].setBorderWidth(1);
            List<Number> values = new ArrayList<>();
            for (int j = 0; j < service.getDependencias().length; j++) {
				int aux = 0;
				for (Empleado emp : empleados) {
					if ((service.getDependencias()[j].equals(emp.getDependencia())) && service.getEps()[i].equals(emp.getEps())) {
						aux++;
					}
				}
				values.add(aux);
			}
            barDataSet[i].setData(values);
            data.addChartDataSet(barDataSet[i]);
		}
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service.getDependencias().length; i++) {			
        	labels.add(service.getDependencias()[i]);
		}
        data.setLabels(labels);
        grafico_eps_comparativo.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        grafico_eps_comparativo.setOptions(options);
    }

    public void graficoPensionesComp() {
        grafico_pensiones_comparativo = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet[] barDataSet = new BarChartDataSet[service.getPensiones().length];
        
        for (int i = 0; i < service.getPensiones().length; i++) {
        	barDataSet[i] = new BarChartDataSet();
        	int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
        	barDataSet[i].setLabel(service.getPensiones()[i]);
            barDataSet[i].setBackgroundColor("rgba("+r+", "+g+", "+b+", 0.2)");
            barDataSet[i].setBorderColor("rgb("+r+", "+g+", "+b+")");
            barDataSet[i].setBorderWidth(1);
            List<Number> values = new ArrayList<>();
            for (int j = 0; j < service.getDependencias().length; j++) {
				int aux = 0;
				for (Empleado emp : empleados) {
					if ((service.getDependencias()[j].equals(emp.getDependencia())) && service.getPensiones()[i].equals(emp.getPension())) {
						aux++;
					}
				}
				values.add(aux);
			}
            barDataSet[i].setData(values);
            data.addChartDataSet(barDataSet[i]);
		}
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service.getDependencias().length; i++) {			
        	labels.add(service.getDependencias()[i]);
		}
        data.setLabels(labels);
        grafico_pensiones_comparativo.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        grafico_pensiones_comparativo.setOptions(options);
    }
    
    public void graficoPeliculas() {
    	grafico_peliculas = new BarChartModel();
        ChartData data = new ChartData();
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service_pel_lib.getGeneros().length; i++) {
        	BarChartDataSet barDataSet = new BarChartDataSet();
        	barDataSet.setLabel(service_pel_lib.getGeneros()[i]);
        	List<Number> values = new ArrayList<>();
        	List<String> bgColor = new ArrayList<>();
        	List<String> borderColor = new ArrayList<>();
            int aux = 0;
			for (PeliculaGeneros pel : peliculas) {
				if (pel.getGeneros().contains(service_pel_lib.getGeneros()[i])) {
					aux++;
				}
			}
			values.add(aux);
			int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
			bgColor.add("rgba("+r+", "+g+", "+b+", 0.2)");
			borderColor.add("rgb("+r+", "+g+", "+b+")");
			barDataSet.setData(values);
			barDataSet.setBackgroundColor(bgColor);
			barDataSet.setBorderColor(borderColor);
			barDataSet.setBorderWidth(1);
			data.addChartDataSet(barDataSet);
		}
        labels.add("Generos");
        data.setLabels(labels);
        grafico_peliculas.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(10);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        grafico_peliculas.setOptions(options);
    }
    
    public void graficoLibros() {
    	grafico_libros = new BarChartModel();
        ChartData data = new ChartData();
        
        List<String> labels = new ArrayList<>();
        for (int i = 0; i < service_pel_lib.getAnios().length; i++) {
        	BarChartDataSet barDataSet = new BarChartDataSet();
        	barDataSet.setLabel(service_pel_lib.getAnios()[i]);
        	List<Number> values = new ArrayList<>();
        	List<String> bgColor = new ArrayList<>();
        	List<String> borderColor = new ArrayList<>();
            int aux = 0;
			for (Libro lib : libros) {
				if (lib.getFecha_publicacion().contains(service_pel_lib.getAnios()[i]+"")) {
					aux++;
				}
			}
			values.add(aux);
			int r = rand.nextInt(256);
        	int g = rand.nextInt(256);
        	int b = rand.nextInt(256);
			bgColor.add("rgba("+r+", "+g+", "+b+", 0.2)");
			borderColor.add("rgb("+r+", "+g+", "+b+")");
			barDataSet.setData(values);
			barDataSet.setBackgroundColor(bgColor);
			barDataSet.setBorderColor(borderColor);
			barDataSet.setBorderWidth(1);
			data.addChartDataSet(barDataSet);
		}
        labels.add("Años Publicacion");
        data.setLabels(labels);
        grafico_libros.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(10);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        grafico_libros.setOptions(options);
    }

    public PieChartModel getGrafico_uno_nomina() {
		return grafico_uno_nomina;
	}

	public void setGrafico_uno_nomina(PieChartModel grafico_uno_nomina) {
		this.grafico_uno_nomina = grafico_uno_nomina;
	}

	public BarChartModel getGrafico_dos_nomina() {
		return grafico_dos_nomina;
	}

	public void setGrafico_dos_nomina(BarChartModel grafico_dos_nomina) {
		this.grafico_dos_nomina = grafico_dos_nomina;
	}

	public BarChartModel getGrafico_eps() {
		return grafico_eps;
	}

	public void setGrafico_eps(BarChartModel grafico_eps) {
		this.grafico_eps = grafico_eps;
	}

	public BarChartModel getGrafico_pensiones() {
		return grafico_pensiones;
	}

	public void setGrafico_pensiones(BarChartModel grafico_pensiones) {
		this.grafico_pensiones = grafico_pensiones;
	}

	public BarChartModel getGrafico_eps_comparativo() {
		return grafico_eps_comparativo;
	}

	public void setGrafico_eps_comparativo(BarChartModel grafico_eps_comparativo) {
		this.grafico_eps_comparativo = grafico_eps_comparativo;
	}

	public BarChartModel getGrafico_pensiones_comparativo() {
		return grafico_pensiones_comparativo;
	}

	public void setGrafico_pensiones_comparativo(BarChartModel grafico_pensiones_comparativo) {
		this.grafico_pensiones_comparativo = grafico_pensiones_comparativo;
	}

	public BarChartModel getGrafico_peliculas() {
		return grafico_peliculas;
	}

	public void setGrafico_peliculas(BarChartModel grafico_peliculas) {
		this.grafico_peliculas = grafico_peliculas;
	}

	public BarChartModel getGrafico_libros() {
		return grafico_libros;
	}

	public void setGrafico_libros(BarChartModel grafico_libros) {
		this.grafico_libros = grafico_libros;
	}
}
