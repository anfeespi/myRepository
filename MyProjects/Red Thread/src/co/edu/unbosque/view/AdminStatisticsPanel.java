package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para las estadisticas de administrador
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class AdminStatisticsPanel extends JPanel{
	/**
	 * Logo de la compañia
	 */
	private JLabel icon;
	/**
	 * Opciones
	 */
	private JButton options;
	/**
	 * Texto
	 */
	private JLabel text;
	/**
	 * Filtros
	 */
	private JComboBox<String> filters;
	/**
	 * Filtros
	 */
	private String[] filters_text;
	/**
	 * Boton de actualizar
	 */
	private JButton update;
	/**
	 * Panel con las estadisticas
	 */
	private ChartPanel cPanel;
	/**
	 * Panel con las opciones
	 */
	private OptionAdminPanel op_panel;
	/**
	 * Fuente principal
	 */
	private Font font;
	/**
	 * Las propiedades del idioma
	 */
	private Properties prop;

	/**
	 * Constructor
	 */
	public AdminStatisticsPanel(int lang) {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		filters_text = new String[2];
		filters_text[0]=prop.getProperty("properties.admin.stadistics.filters.gender");
		filters_text[1]=prop.getProperty("properties.admin.stadistics.filters.orientations");
		
		initComponents(lang);
	}

	/**
	 * Metodo para inicializar componentes
	 */
	private void initComponents(int lang) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		font = new Font("Raleway", 0, 30);
		setBackground(Color.BLACK);

		icon = new JLabel();
		icon.setBounds(64, 13, 124, 110);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThreadIcon.png"));
			Image title_resized = bi.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		icon.setVisible(true);

		options = new JButton();
		options.setBackground(Color.BLACK);
		options.setBounds(1066, 33, 70, 70);
		options.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/optionicon.png"));
		options.setVisible(true);

		text = new JLabel(prop.getProperty("properties.admin.stadistics")); //Usar properties
		text.setBounds(133, 153, 317, 40);
		text.setFont(font);
		text.setOpaque(false);
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setVisible(true);

		filters = new JComboBox<>(filters_text);
		filters.setBounds(450, 153, 350, 40);
		filters.setFont(font);
		filters.setVisible(true);

		update = new JButton(prop.getProperty("properties.admin.stadistics.update")); //Usar properties
		update.setFont(font);
		update.setBounds(820, 149, 220, 50);
		update.setVisible(true);

		ChartPanel cPanel = null;

		op_panel = new OptionAdminPanel(lang);

		add(icon);
		add(options);
		add(text);
		add(filters);
		add(update);
	}

	/**
	 * Mostrar mujeres vs hombres
	 * @param d1
	 * @param d2
	 */
	public void showWomenVsMen(int d1, int d2) {
		if (cPanel != null) {			
			remove(cPanel);
		}
		JFreeChart graf = null;
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		int women = d1;
		int men = d2;
		data.addValue(women, prop.getProperty("properties.admin.stadistics.versus"), prop.getProperty("properties.admin.stadistics.women")+"("+women+")");
		data.addValue(men, prop.getProperty("properties.admin.stadistics.versus"), prop.getProperty("properties.admin.stadistics.men")+"("+men+")");

		DefaultPieDataset datapie = new DefaultPieDataset();
		datapie.setValue(prop.getProperty("properties.admin.stadistics.women")+"("+women+")", d1);
		datapie.setValue(prop.getProperty("properties.admin.stadistics.men")+"("+men+")", d2);
		graf = ChartFactory.createPieChart(prop.getProperty("properties.admin.stadistics.versus"), datapie, true, true, false);

		cPanel = new ChartPanel(graf);
		cPanel.setBounds(50, 215, 1100, 440);
		cPanel.setBackground(Color.BLACK);
		cPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		cPanel.setVisible(true);
		add(cPanel);
		try {
			ChartUtilities.saveChartAsJPEG(new File("src/co/edu/unbosque/util/reports/pie.jpeg"), graf, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Mostrar estadisticas de las orientaciones
	 * @param hetero
	 * @param homo
	 * @param bi
	 * @param pan
	 * @param demi
	 * @param asex
	 */
	public void showOrientationsStats(int hetero, int homo, int bi, int pan, int demi, int asex) {
		if (cPanel != null) {			
			remove(cPanel);
		}
		JFreeChart graf = null;
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		data.addValue(hetero, prop.getProperty("properties.admin.stadistics.orientations"), "Heterosexual "+hetero);
		data.addValue(homo, prop.getProperty("properties.admin.stadistics.orientations"), "Homosexual "+homo);
		data.addValue(bi, prop.getProperty("properties.admin.stadistics.orientations"), "Bisexual "+bi);
		data.addValue(pan, prop.getProperty("properties.admin.stadistics.orientations"), "Pansexual "+pan);
		data.addValue(demi, prop.getProperty("properties.admin.stadistics.orientations"), "Demisexual "+demi);
		data.addValue(asex, prop.getProperty("properties.admin.stadistics.orientations"), "Asexual "+asex);
		graf = ChartFactory.createBarChart("Orientations", "Orientations", "Amount", data, PlotOrientation.VERTICAL, true, true, false);

		cPanel = new ChartPanel(graf);
		cPanel.setBounds(50, 215, 1100, 440);
		cPanel.setBackground(Color.BLACK);
		cPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		cPanel.setVisible(true);
		add(cPanel);
		try {
			ChartUtilities.saveChartAsJPEG(new File("src/co/edu/unbosque/util/reports/bars.jpeg"), graf, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Mostrar opciones
	 */
	public void showOptions() {
		op_panel.setBounds(826, 33, 240, 240);
		op_panel.setVisible(true);
		add(op_panel, 1);
	}

	/**
	 * @return the options
	 */
	public JButton getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(JButton options) {
		this.options = options;
	}

	/**
	 * @return the filters
	 */
	public JComboBox<String> getFilters() {
		return filters;
	}

	/**
	 * @param filters the filters to set
	 */
	public void setFilters(JComboBox<String> filters) {
		this.filters = filters;
	}

	/**
	 * @return the update
	 */
	public JButton getUpdate() {
		return update;
	}

	/**
	 * @param update the update to set
	 */
	public void setUpdate(JButton update) {
		this.update = update;
	}

	/**
	 * @return the op_panel
	 */
	public OptionAdminPanel getOp_panel() {
		return op_panel;
	}

	/**
	 * @param op_panel the op_panel to set
	 */
	public void setOp_panel(OptionAdminPanel op_panel) {
		this.op_panel = op_panel;
	}

	/**
	 * @return the cPanel
	 */
	public ChartPanel getcPanel() {
		return cPanel;
	}

	/**
	 * @param cPanel the cPanel to set
	 */
	public void setcPanel(ChartPanel cPanel) {
		this.cPanel = cPanel;
	}
}
