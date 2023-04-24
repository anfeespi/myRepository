package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class CatchedPanel extends JPanel{

	private String[] generations = {"Generacion I", "Generacion II", "Generacion III", "Generacion IV", "Generacion VI", "Generacion VII", "Generacion VIII", "Generacion IX"};
	private JLabel background;
	private Font titlefont;
	private Font lblfont;
	private JLabel lblDatosPokemon;
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblWeight;
	private JLabel lblHeight;
	private JLabel lblSex;
	private JLabel lblGeneration;
	private JLabel lblHability;
	private JTextField txtName;
	private JTextField txtIndex;
	private JTextField txtWeight;
	private JTextField txtHeight;
	private JTextField txtSex;
	private JTextField txtHability;
	private JLabel steel;
	private JLabel water;
	private JLabel bug;
	private JLabel dragon;
	private JLabel electric;
	private JLabel ghost;
	private JLabel fire;
	private JLabel fairy;
	private JLabel ice;
	private JLabel fighting;
	private JLabel normal;
	private JLabel grass;
	private JLabel psychic;
	private JLabel rock;
	private JLabel dark;
	private JLabel ground;
	private JLabel poison;
	private JLabel flying;
	private JCheckBox chcSteel;
	private JCheckBox chcWater;
	private JCheckBox chcBug;
	private JCheckBox chcDragon;
	private JCheckBox chcElectric;
	private JCheckBox chcGhost;
	private JCheckBox chcFire;
	private JCheckBox chcFairy;
	private JCheckBox chcIce;
	private JCheckBox chcFighting;
	private JCheckBox chcNormal;
	private JCheckBox chcGrass;
	private JCheckBox chcPsychic;
	private JCheckBox chcRock;
	private JCheckBox chcDark;
	private JCheckBox chcGround;
	private JCheckBox chcPoison;
	private JCheckBox chcFlying;
	private JLabel superball;
	private JLabel pokeball;
	private JLabel masterball;
	private JCheckBox chcSuperball;
	private JCheckBox chcPokeball;
	private JCheckBox chcMasterball;
	private JButton btnAtrapado;
	private JComboBox<String> generation;
	

	public CatchedPanel() {
		setBorder(new LineBorder(Color.BLACK, 5, true));
		titlefont = new Font("Acme", Font.BOLD, 50);
		lblfont = new Font("Acme", Font.PLAIN, 25);
		setBackground(new Color(142, 154, 247));
		setBounds(38, 35, 925, 520);
		setLayout(null);
		init();
		setVisible(true);


	}

	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}


		lblDatosPokemon = new JLabel("Datos Pokemon:");
		lblDatosPokemon.setBounds(465, 39, 349, 63);
		lblDatosPokemon.setFont(titlefont);
		add(lblDatosPokemon);
		
		lblName = new JLabel("Nombre:");
		lblName.setFont(lblfont);
		lblName.setBounds(429, 113, 116, 38);
		add(lblName);
		
		lblNumber = new JLabel("Numero:");
		lblNumber.setFont(lblfont);
		lblNumber.setBounds(429, 163, 116, 38);
		add(lblNumber);
		
		lblWeight = new JLabel("Peso:");
		lblWeight.setFont(lblfont);
		lblWeight.setBounds(429, 213, 116, 38);
		add(lblWeight);
		
		lblHeight = new JLabel("Altura:");
		lblHeight.setFont(lblfont);
		lblHeight.setBounds(429, 263, 116, 38);
		add(lblHeight);
		
		lblSex = new JLabel("Sexo:");
		lblSex.setFont(lblfont);
		lblSex.setBounds(429, 313, 116, 38);
		add(lblSex);
		
		lblGeneration = new JLabel("Generacion:");
		lblGeneration.setFont(lblfont);
		lblGeneration.setBounds(429, 363, 138, 38);
		add(lblGeneration);
		
		lblHability = new JLabel("Habilidad:");
		lblHability.setFont(lblfont);
		lblHability.setBounds(429, 413, 138, 38);
		add(lblHability);
		
		txtName = new JTextField();
		txtName.setBounds(570, 118, 280, 30);
		txtName.setFont(lblfont);
		txtName.setColumns(10);
		add(txtName);
		
		txtIndex = new JTextField();
		txtIndex.setColumns(10);
		txtIndex.setFont(lblfont);
		txtIndex.setBounds(570, 168, 280, 30);
		add(txtIndex);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setFont(lblfont);
		txtWeight.setBounds(570, 218, 280, 30);
		add(txtWeight);
		
		txtHeight = new JTextField();
		txtHeight.setFont(lblfont);
		txtHeight.setColumns(10);
		txtHeight.setBounds(570, 268, 280, 30);
		add(txtHeight);
		
		txtSex = new JTextField();
		txtSex.setColumns(10);
		txtSex.setFont(lblfont);
		txtSex.setBounds(570, 318, 280, 30);
		add(txtSex);
		
		txtHability = new JTextField();
		txtHability.setColumns(10);
		txtHability.setFont(lblfont);
		txtHability.setBounds(570, 418, 280, 30);
		add(txtHability);
		
		steel = new JLabel("");
		steel.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_acero.png")));
		steel.setBounds(60, 257, 80, 30);
		add(steel);
		
		water = new JLabel("");
		water.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_agua.png")));
		water.setBounds(180, 257, 80, 30);
		add(water);
		
		bug = new JLabel("");
		bug.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_bicho.png")));
		bug.setBounds(300, 257, 80, 30);
		add(bug);
		
		dragon = new JLabel("");
		dragon.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_dragon.png")));
		dragon.setBounds(60, 292, 80, 30);
		add(dragon);
		
		electric = new JLabel("");
		electric.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_electrico.png")));
		electric.setBounds(180, 292, 80, 30);
		add(electric);
		
		ghost = new JLabel("");
		ghost.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_fantasma.png")));
		ghost.setBounds(300, 292, 80, 30);
		add(ghost);
		
		fire = new JLabel("");
		fire.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_fuego.png")));
		fire.setBounds(60, 327, 80, 30);
		add(fire);
		
		fairy = new JLabel("");
		fairy.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_hada.png")));
		fairy.setBounds(180, 327, 80, 30);
		add(fairy);
		
		ice = new JLabel("");
		ice.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_hielo.png")));
		ice.setBounds(300, 327, 80, 30);
		add(ice);
		
		fighting = new JLabel("");
		fighting.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_lucha.png")));
		fighting.setBounds(60, 362, 80, 30);
		add(fighting);
		
		normal = new JLabel("");
		normal.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_normal.png")));
		normal.setBounds(180, 362, 80, 30);
		add(normal);
		
		grass = new JLabel("");
		grass.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_planta.png")));
		grass.setBounds(300, 362, 80, 30);
		add(grass);
		
		psychic = new JLabel("");
		psychic.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_psiquico.png")));
		psychic.setBounds(60, 397, 80, 30);
		add(psychic);
		
		rock = new JLabel("");
		rock.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_roca.png")));
		rock.setBounds(180, 397, 80, 30);
		add(rock);
		
		dark = new JLabel("");
		dark.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_siniestro.png")));
		dark.setBounds(300, 397, 80, 30);
		add(dark);
		
		ground = new JLabel("");
		ground.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_tierra.png")));
		ground.setBounds(60, 432, 80, 30);
		add(ground);
		
		poison = new JLabel("");
		poison.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_veneno.png")));
		poison.setBounds(180, 432, 80, 30);
		add(poison);
		
		flying = new JLabel("");
		flying.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/types/type_volador.png")));
		flying.setBounds(300, 432, 80, 30);
		add(flying);
		
		chcSteel = new JCheckBox("");
		chcSteel.setBounds(35, 261, 21, 23);
		add(chcSteel);
		
		chcWater = new JCheckBox("");
		chcWater.setBounds(155, 261, 21, 23);
		add(chcWater);
		
		chcBug = new JCheckBox("");
		chcBug.setBounds(275, 261, 21, 23);
		add(chcBug);
		
		chcDragon = new JCheckBox("");
		chcDragon.setBounds(35, 296, 21, 23);
		add(chcDragon);
		
		chcElectric = new JCheckBox("");
		chcElectric.setBounds(155, 296, 21, 23);
		add(chcElectric);
		
		chcGhost = new JCheckBox("");
		chcGhost.setBounds(275, 296, 21, 23);
		add(chcGhost);
		
		chcFire = new JCheckBox("");
		chcFire.setBounds(35, 331, 21, 23);
		add(chcFire);
		
		chcFairy = new JCheckBox("");
		chcFairy.setBounds(155, 331, 21, 23);
		add(chcFairy);
		
		chcIce = new JCheckBox("");
		chcIce.setBounds(275, 331, 21, 23);
		add(chcIce);
		
		chcFighting = new JCheckBox("");
		chcFighting.setBounds(35, 366, 21, 23);
		add(chcFighting);
		
		chcNormal = new JCheckBox("");
		chcNormal.setBounds(155, 366, 21, 23);
		add(chcNormal);
		
		chcGrass = new JCheckBox("");
		chcGrass.setBounds(275, 366, 21, 23);
		add(chcGrass);
		
		chcPsychic = new JCheckBox("");
		chcPsychic.setBounds(35, 401, 21, 23);
		add(chcPsychic);
		
		chcRock = new JCheckBox("");
		chcRock.setBounds(155, 401, 21, 23);
		add(chcRock);
		
		chcDark = new JCheckBox("");
		chcDark.setBounds(275, 401, 21, 23);
		add(chcDark);
		
		chcGround = new JCheckBox("");
		chcGround.setBounds(35, 436, 21, 23);
		add(chcGround);
		
		chcPoison = new JCheckBox("");
		chcPoison.setBounds(155, 436, 21, 23);
		add(chcPoison);
		
		chcFlying = new JCheckBox("");
		chcFlying.setBounds(275, 436, 21, 23);
		add(chcFlying);
		
		superball = new JLabel("");
		superball.setHorizontalAlignment(SwingConstants.CENTER);
		superball.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/pokemons/superball.png")));
		superball.setBounds(35, 104, 109, 90);
		add(superball);
		
		pokeball = new JLabel("");
		pokeball.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/pokemons/pokeball.png")));
		pokeball.setHorizontalAlignment(SwingConstants.CENTER);
		pokeball.setBounds(125, 11, 109, 90);
		add(pokeball);
		
		masterball = new JLabel("");
		masterball.setIcon(new ImageIcon(CatchedPanel.class.getResource("/imgs/pokemons/masterball.png")));
		masterball.setHorizontalAlignment(SwingConstants.CENTER);
		masterball.setBounds(225, 104, 109, 97);
		add(masterball);
		
		chcSuperball = new JCheckBox("");
		chcSuperball.setBounds(81, 205, 21, 23);
		add(chcSuperball);
		
		chcPokeball = new JCheckBox("");
		chcPokeball.setBounds(173, 115, 21, 23);
		add(chcPokeball);
		
		chcMasterball = new JCheckBox("");
		chcMasterball.setBounds(270, 205, 21, 23);
		add(chcMasterball);
		
		generation = new JComboBox<>(generations);
		generation.setEditable(true);
		generation.setBounds(570, 363, 280, 30);
		generation.setPreferredSize(getSize());
		generation.setFont(lblfont);
		generation.setVisible(true);
		add(generation);
		
		btnAtrapado = new JButton("");
		btnAtrapado.setIcon(new ImageIcon(new ImageIcon(TrainPanel.class.getResource("/imgs/pokeballs/lo_atrape.png")).getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT)));
		btnAtrapado.setBounds(851, 454, 50, 50);
		btnAtrapado.setContentAreaFilled(false);
		add(btnAtrapado);
	}

	/**
	 * @return the chcSteel
	 */
	public JCheckBox getChcSteel() {
		return chcSteel;
	}

	/**
	 * @param chcSteel the chcSteel to set
	 */
	public void setChcSteel(JCheckBox chcSteel) {
		this.chcSteel = chcSteel;
	}

	/**
	 * @return the chcWater
	 */
	public JCheckBox getChcWater() {
		return chcWater;
	}

	/**
	 * @param chcWater the chcWater to set
	 */
	public void setChcWater(JCheckBox chcWater) {
		this.chcWater = chcWater;
	}

	/**
	 * @return the chcBug
	 */
	public JCheckBox getChcBug() {
		return chcBug;
	}

	/**
	 * @param chcBug the chcBug to set
	 */
	public void setChcBug(JCheckBox chcBug) {
		this.chcBug = chcBug;
	}

	/**
	 * @return the chcDragon
	 */
	public JCheckBox getChcDragon() {
		return chcDragon;
	}

	/**
	 * @param chcDragon the chcDragon to set
	 */
	public void setChcDragon(JCheckBox chcDragon) {
		this.chcDragon = chcDragon;
	}

	/**
	 * @return the chcElectric
	 */
	public JCheckBox getChcElectric() {
		return chcElectric;
	}

	/**
	 * @param chcElectric the chcElectric to set
	 */
	public void setChcElectric(JCheckBox chcElectric) {
		this.chcElectric = chcElectric;
	}

	/**
	 * @return the chcGhost
	 */
	public JCheckBox getChcGhost() {
		return chcGhost;
	}

	/**
	 * @param chcGhost the chcGhost to set
	 */
	public void setChcGhost(JCheckBox chcGhost) {
		this.chcGhost = chcGhost;
	}

	/**
	 * @return the chcFire
	 */
	public JCheckBox getChcFire() {
		return chcFire;
	}

	/**
	 * @param chcFire the chcFire to set
	 */
	public void setChcFire(JCheckBox chcFire) {
		this.chcFire = chcFire;
	}

	/**
	 * @return the chcFairy
	 */
	public JCheckBox getChcFairy() {
		return chcFairy;
	}

	/**
	 * @param chcFairy the chcFairy to set
	 */
	public void setChcFairy(JCheckBox chcFairy) {
		this.chcFairy = chcFairy;
	}

	/**
	 * @return the chcIce
	 */
	public JCheckBox getChcIce() {
		return chcIce;
	}

	/**
	 * @param chcIce the chcIce to set
	 */
	public void setChcIce(JCheckBox chcIce) {
		this.chcIce = chcIce;
	}

	/**
	 * @return the chcFighting
	 */
	public JCheckBox getChcFighting() {
		return chcFighting;
	}

	/**
	 * @param chcFighting the chcFighting to set
	 */
	public void setChcFighting(JCheckBox chcFighting) {
		this.chcFighting = chcFighting;
	}

	/**
	 * @return the chcNormal
	 */
	public JCheckBox getChcNormal() {
		return chcNormal;
	}

	/**
	 * @param chcNormal the chcNormal to set
	 */
	public void setChcNormal(JCheckBox chcNormal) {
		this.chcNormal = chcNormal;
	}

	/**
	 * @return the chcGrass
	 */
	public JCheckBox getChcGrass() {
		return chcGrass;
	}

	/**
	 * @param chcGrass the chcGrass to set
	 */
	public void setChcGrass(JCheckBox chcGrass) {
		this.chcGrass = chcGrass;
	}

	/**
	 * @return the chcPsychic
	 */
	public JCheckBox getChcPsychic() {
		return chcPsychic;
	}

	/**
	 * @param chcPsychic the chcPsychic to set
	 */
	public void setChcPsychic(JCheckBox chcPsychic) {
		this.chcPsychic = chcPsychic;
	}

	/**
	 * @return the chcRock
	 */
	public JCheckBox getChcRock() {
		return chcRock;
	}

	/**
	 * @param chcRock the chcRock to set
	 */
	public void setChcRock(JCheckBox chcRock) {
		this.chcRock = chcRock;
	}

	/**
	 * @return the chcDark
	 */
	public JCheckBox getChcDark() {
		return chcDark;
	}

	/**
	 * @param chcDark the chcDark to set
	 */
	public void setChcDark(JCheckBox chcDark) {
		this.chcDark = chcDark;
	}

	/**
	 * @return the chcGround
	 */
	public JCheckBox getChcGround() {
		return chcGround;
	}

	/**
	 * @param chcGround the chcGround to set
	 */
	public void setChcGround(JCheckBox chcGround) {
		this.chcGround = chcGround;
	}

	/**
	 * @return the chcPoison
	 */
	public JCheckBox getChcPoison() {
		return chcPoison;
	}

	/**
	 * @param chcPoison the chcPoison to set
	 */
	public void setChcPoison(JCheckBox chcPoison) {
		this.chcPoison = chcPoison;
	}

	/**
	 * @return the chcFlying
	 */
	public JCheckBox getChcFlying() {
		return chcFlying;
	}

	/**
	 * @param chcFlying the chcFlying to set
	 */
	public void setChcFlying(JCheckBox chcFlying) {
		this.chcFlying = chcFlying;
	}

	/**
	 * @return the chcSuperball
	 */
	public JCheckBox getChcSuperball() {
		return chcSuperball;
	}

	/**
	 * @param chcSuperball the chcSuperball to set
	 */
	public void setChcSuperball(JCheckBox chcSuperball) {
		this.chcSuperball = chcSuperball;
	}

	/**
	 * @return the chcPokeball
	 */
	public JCheckBox getChcPokeball() {
		return chcPokeball;
	}

	/**
	 * @param chcPokeball the chcPokeball to set
	 */
	public void setChcPokeball(JCheckBox chcPokeball) {
		this.chcPokeball = chcPokeball;
	}

	/**
	 * @return the chcMasterball
	 */
	public JCheckBox getChcMasterball() {
		return chcMasterball;
	}

	/**
	 * @param chcMasterball the chcMasterball to set
	 */
	public void setChcMasterball(JCheckBox chcMasterball) {
		this.chcMasterball = chcMasterball;
	}

	/**
	 * @return the btnAtrapado
	 */
	public JButton getBtnAtrapado() {
		return btnAtrapado;
	}

	/**
	 * @param btnAtrapado the btnAtrapado to set
	 */
	public void setBtnAtrapado(JButton btnAtrapado) {
		this.btnAtrapado = btnAtrapado;
	}

	/**
	 * @return the txtName
	 */
	public JTextField getTxtName() {
		return txtName;
	}

	/**
	 * @param txtName the txtName to set
	 */
	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	/**
	 * @return the txtIndex
	 */
	public JTextField getTxtIndex() {
		return txtIndex;
	}

	/**
	 * @param txtIndex the txtIndex to set
	 */
	public void setTxtIndex(JTextField txtIndex) {
		this.txtIndex = txtIndex;
	}

	/**
	 * @return the txtWeight
	 */
	public JTextField getTxtWeight() {
		return txtWeight;
	}

	/**
	 * @param txtWeight the txtWeight to set
	 */
	public void setTxtWeight(JTextField txtWeight) {
		this.txtWeight = txtWeight;
	}

	/**
	 * @return the txtHeight
	 */
	public JTextField getTxtHeight() {
		return txtHeight;
	}

	/**
	 * @param txtHeight the txtHeight to set
	 */
	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	/**
	 * @return the txtSex
	 */
	public JTextField getTxtSex() {
		return txtSex;
	}

	/**
	 * @param txtSex the txtSex to set
	 */
	public void setTxtSex(JTextField txtSex) {
		this.txtSex = txtSex;
	}

	/**
	 * @return the txtHability
	 */
	public JTextField getTxtHability() {
		return txtHability;
	}

	/**
	 * @param txtHability the txtHability to set
	 */
	public void setTxtHability(JTextField txtHability) {
		this.txtHability = txtHability;
	}

	/**
	 * @return the generation
	 */
	public JComboBox<String> getGeneration() {
		return generation;
	}

	/**
	 * @param generation the generation to set
	 */
	public void setGeneration(JComboBox<String> generation) {
		this.generation = generation;
	}	
	
	
}
