import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class CBabyBallBounce extends JFrame implements ActionListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JMenuBar cbbMenuBar; // declaring JMenuBar
	// declaring JMenu
	private JMenu scenario;
	private JMenu edit;
	private JMenu control;
	private JMenu help;
	private JMenuItem exit; // declaring JMenuItem

	private JMenuItem act1;
	private JMenuItem run1;
	private JMenuItem pause1;
	private JMenuItem reset1;

	private JMenuItem helpTopic;
	private JMenuItem about;

	static JTextField hr;
	JTextField min;
	JTextField sec;
	JTextField leftScore;
	JTextField rightScore;
	JTextField optionField;
	JTextField squareField;
	JTextField directionField;

	JPanel rightControlPanel; // declaring JPanel for right side controller
	JPanel gameField; // declaring JPanel for left side controller

	JButton blankButton1;
	JButton blankButton2;
	JButton blankButton3;
	JButton blankButton4;

	JButton upArrow;
	JButton downArrow;
	JButton leftArrow;
	JButton rightArrow;
	JButton ballButton1;
	JButton compass;

	JButton player2;
	JButton player4;
	JButton multi;
	JButton exitGame;

	JButton act;
	JButton run;
	JButton pause;
	JButton reset;

	JSlider speed;

	JButton tiles[][] = new JButton[13][16];

	int x_pos = 6, y_pos = 4;

	static JPanel buttomPanel;// declaring JPanel for ACT RUN and RESET

	Color black = (Color.black);
	Color white = (Color.white);

//		~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		Image Icons 

	ImageIcon actIcon = new ImageIcon("./images/act.png");

	ImageIcon runIcon = new ImageIcon("./images/run.png");
	ImageIcon pauseIcon = new ImageIcon("./images/pause.png");
	ImageIcon resetIcon = new ImageIcon("./images/reset.png");

	ImageIcon leftArrowIcon = new ImageIcon("./images/left-a.png");
	ImageIcon rightArrowIcon = new ImageIcon("./images/right-a.png");
	ImageIcon upArrowIcon = new ImageIcon("./images/up-a.png");
	ImageIcon downArrowIcon = new ImageIcon("./images/down-a.png");

	ImageIcon eastIcon = new ImageIcon("./images/east.jpg");
	ImageIcon westIcon = new ImageIcon("./images/west.jpg");
	ImageIcon northIcon = new ImageIcon("./images/north.jpg");
	ImageIcon southIcon = new ImageIcon("./images/south.jpg");

//		ImageIcon greenfootIcon = new ImageIcon("./images/greenfoot.png");
	ImageIcon ballButton = new ImageIcon("./images/ballButton.png");
	ImageIcon ball = new ImageIcon("./images/ball.png");
	ImageIcon brick = new ImageIcon("./images/bricks2.jpg");
	ImageIcon ballbricks = new ImageIcon("./images/ballbricks.jpg");
	ImageIcon baby1 = new ImageIcon("./images/baby1.png");
	ImageIcon baby2 = new ImageIcon("./images/baby2.png");
	
	public String getIconImage(ImageIcon icon) {
		return getIconImage(icon);
	
	} 


	
//		Boundry leftRight and TopButton wall
	ImageIcon boundryLRWall = new ImageIcon(
			new ImageIcon("./images/boundryWall.png").getImage().getScaledInstance(24, 50, Image.SCALE_DEFAULT));
	ImageIcon boundryTBWall = new ImageIcon(
			new ImageIcon("./images/boundryWall.png").getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
//		Image newImage = yourImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);

//		boundryWall.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);

//		~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void createCbbMenu() {

//	    creating menuBar and menuItem

		cbbMenuBar = new JMenuBar(); // creating new JMenuBar and name it as cbbMenuBar
		setJMenuBar(cbbMenuBar); // Setting cbbMenuBar in JMenuBar

		scenario = new JMenu("Scenario"); // creating new JMenu named as scenario
		exit = new JMenuItem("Exit");// creating new JMenuItem inside scenario JMenu and named as Exit
		exit.addActionListener(this);
		scenario.add(exit); // including exit JMenuItem in scenario jMenu
		cbbMenuBar.add(scenario); // including Scenario JMenu in CbbMenuBar

		edit = new JMenu("Edit");
		cbbMenuBar.add(edit);

		control = new JMenu("Control");
		act1 = new JMenuItem("Act");
		act1.addActionListener(this);
		run1 = new JMenuItem("Run");
		run1.addActionListener(this);
		pause1 = new JMenuItem("Pause");
		pause1.addActionListener(this);
		reset1 = new JMenuItem("Reset");
		reset1.addActionListener(this);

		control.add(act1);
		control.add(run1);
		control.add(pause1);
		control.add(reset1);

		cbbMenuBar.add(control);

		help = new JMenu("Help");
		helpTopic = new JMenuItem("Help Topic");
		helpTopic.addActionListener(this);
		about = new JMenuItem(" About");
		about.addActionListener(this);

		help.add(about);
		help.add(helpTopic);
		cbbMenuBar.add(help);

	}

	public int getX() {
		return x_pos;
	}

//	public void setX(int x_pos) {
//		this.x_pos = x_pos;
//	}
//
//	public void setY(int y_pos) {
//		this.y_pos = y_pos;
//	}
	
	public int setX(int x_pos) {
		 return this.x_pos = x_pos;
	}

	public int setY(int y_pos) {
	return	this.y_pos = y_pos;
	}

	public int getY() {
		return y_pos;
	}


	
	public void addGameField() {

		JPanel gameFieldContainer = new JPanel();
		gameFieldContainer.setLayout(null);
		gameFieldContainer.setBackground(Color.decode("#40f7a8"));
		getContentPane().add(gameFieldContainer);

		gameField = new JPanel();
		JPanel line = new JPanel();
		JPanel line1 = new JPanel();
		rightControlPanel = new JPanel();
		JPanel buttomControlPanel = new JPanel();

		gameFieldContainer.add(rightControlPanel);
		gameFieldContainer.add(buttomControlPanel);
		gameFieldContainer.add(gameField);
		gameFieldContainer.add(line);
		gameFieldContainer.add(line1);

		rightControlPanel.setLayout(null);
		buttomControlPanel.setLayout(null);
		line.setLayout(null);
		line1.setLayout(null);

		line.setBounds(625, 0, 2, 475);
		line1.setBounds(0, 473, 626, 2);
		line.setBorder(BorderFactory.createLineBorder(Color.white));
		line1.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		////// GameField Area

		gameField.setBounds(30, 3, 580, 465);
//	         gameField.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0),  new EtchedBorder()));
		gameField.setBackground(Color.white);
		gameField.setBorder(BorderFactory.createLineBorder(Color.gray));
		gameField.setLayout(new GridLayout(13, 16));
//	        gameFieldContainer.add(gameField, BorderLayout.SOUTH);
//	         cbb.add(gameField);

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 16; j++) {

				JButton tile = new JButton("" + i + j);
				tile.setIcon(new ImageIcon("./images/white32x32.jpg"));
				tile.setBorder(null);
				tile.setBorderPainted(false);
				tile.setFocusPainted(false);
				tile.setRolloverEnabled(true);
				tile.addActionListener(this);
				tile.setOpaque(false);
				tile.setHorizontalAlignment(SwingConstants.CENTER);
				tile.setContentAreaFilled(false);
				tile.setLabel(null);

				tiles[i][j] = tile;

				gameField.add(tiles[i][j]);
			}
		}

		for (int i = 0; i < 13; i++) {
			for (int j = 7; j < 9; j++) {
				tiles[i][j].setIcon(brick);
			}
		}

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 1; j++) {
				tiles[i][j].setHorizontalAlignment(SwingConstants.LEFT);
				tiles[i][j].setIcon(boundryLRWall);
			}
		}

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 16; j++) {
				tiles[i][j].setIcon(boundryTBWall);
			}
		}

		for (int i = 1; i < 13; i++) {
			for (int j = 15; j < 16; j++) {
				tiles[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
				tiles[i][j].setIcon(boundryLRWall);

			}
		}

		for (int i = 12; i < 13; i++) {
			for (int j = 0; j < 16; j++) {
				tiles[i][j].setIcon(boundryTBWall);
			}
		}

		tiles[6][4].setIcon(ball);

		tiles[6][3].setIcon(baby1);
		tiles[6][12].setIcon(baby2);
		// -------------------- right Control Panel GUI Starts from
		// here-------------------------------------//
		rightControlPanel.setBounds(649, 0, 160, 475);
		rightControlPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		rightControlPanel.setBackground(Color.decode("#40f7a8"));
//				~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//							JLables 

//							JLabel timerTitle,isTo,isTo2,scoreTitle,scoreTitle2,option,square,direction;

		JLabel timerTitle = new JLabel("DIGITAL TIMER");
		JLabel isTo = new JLabel(":");
		JLabel isTo2 = new JLabel(":");
		JLabel scoreTitle = new JLabel("SCORE");
		JLabel scoreTitle2 = new JLabel("< L : R >");

		JLabel option = new JLabel("Option : ");
		JLabel square = new JLabel("Square : ");
		JLabel direction = new JLabel("Direction : ");

//			~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~						
		// JtextField

		hr = new JTextField("00");
		min = new JTextField("00");
		sec = new JTextField("00");
		leftScore = new JTextField("00");
		rightScore = new JTextField("00");

		optionField = new JTextField();
		optionField.setText("2 Player");

		squareField = new JTextField();
		squareField.setText("101");

//				directionField = new JTextField("SE");
		directionField = new JTextField();
		directionField.setText("SE");

		// ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~ ~~~~ ~ ~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		hr.setHorizontalAlignment(JTextField.CENTER);
		min.setHorizontalAlignment(JTextField.CENTER);
		sec.setHorizontalAlignment(JTextField.CENTER);
		leftScore.setHorizontalAlignment(JTextField.CENTER);
		rightScore.setHorizontalAlignment(JTextField.CENTER);
		optionField.setHorizontalAlignment(JTextField.CENTER);
		squareField.setHorizontalAlignment(JTextField.CENTER);
		directionField.setHorizontalAlignment(JTextField.CENTER);

		// ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~ ~~~~ ~ ~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// JLabel's ,JButton and textField foreGround,font, and background
		hr.setBackground(black);
		min.setBackground(black);
		sec.setBackground(black);
		leftScore.setBackground(black);
		rightScore.setBackground(black);

		hr.setForeground(white);
		min.setForeground(white);
		sec.setForeground(white);
		leftScore.setForeground(white);
		rightScore.setForeground(white);

		timerTitle.setForeground(black);
		isTo.setForeground(black);
		isTo2.setForeground(black);
		scoreTitle2.setForeground(black);

		optionField.setBackground(white);
		squareField.setBackground(white);
		directionField.setBackground(white);

		optionField.setForeground(black);
		squareField.setForeground(black);
		directionField.setForeground(black);

		option.setForeground(black);
		square.setForeground(black);
		direction.setForeground(black);

		// ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~ ~~~~ ~ ~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//								
//								make JTextField uneditable

		hr.setEditable(false);
		min.setEditable(false);
		sec.setEditable(false);
		leftScore.setEditable(false);
		rightScore.setEditable(false);
		optionField.setEditable(false);
		squareField.setEditable(false);
		directionField.setEditable(false);

//		   	~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// JButtons and Add action listners

		blankButton1 = new JButton();
		blankButton2 = new JButton();
		blankButton3 = new JButton();
		blankButton4 = new JButton();

		upArrow = new JButton(upArrowIcon);
		downArrow = new JButton(downArrowIcon);
		leftArrow = new JButton(leftArrowIcon);
		rightArrow = new JButton(rightArrowIcon);
		ballButton1 = new JButton(ballButton);

		compass = new JButton(eastIcon);

		player2 = new JButton("2 Player");
		player4 = new JButton("3 Player");
		multi = new JButton("Multi");
		exitGame = new JButton("Exit");

		upArrow.addActionListener(this);
		downArrow.addActionListener(this);
		leftArrow.addActionListener(this);
		rightArrow.addActionListener(this);
		ballButton1.addActionListener(this);
		compass.addActionListener(this);

		player2.addActionListener(this);
		player4.addActionListener(this);
		multi.addActionListener(this);
		exitGame.addActionListener(this);

		// ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~ ~~~~ ~ ~~
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		player2.setBackground(white);
		player4.setBackground(white);
		multi.setBackground(white);
		exitGame.setBackground(white);

		player2.setForeground(black);
		player4.setForeground(black);
		multi.setForeground(black);
		exitGame.setForeground(black);

//				~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//							   SetBounds 

		timerTitle.setBounds(40, -5, 100, 30);
		hr.setBounds(10, 20, 35, 20);
		isTo.setBounds(50, 20, 25, 20);
		min.setBounds(60, 20, 35, 20);
		isTo2.setBounds(103, 20, 30, 20);
		sec.setBounds(115, 20, 35, 20);

		scoreTitle.setBounds(60, 40, 40, 20);
		leftScore.setBounds(10, 60, 35, 20);
		rightScore.setBounds(115, 60, 35, 20);
		scoreTitle2.setBounds(60, 60, 50, 20);

		option.setBounds(2, 85, 55, 30);
		square.setBounds(2, 112, 55, 30);
		direction.setBounds(2, 142, 60, 30);

		optionField.setBounds(85, 85, 70, 25);
		squareField.setBounds(85, 115, 70, 25);
		directionField.setBounds(85, 145, 70, 25);

		blankButton1.setBounds(110, 175, 45, 30);
		blankButton2.setBounds(2, 235, 45, 30);
		blankButton3.setBounds(2, 175, 45, 30);
		blankButton4.setBounds(110, 235, 45, 30);

		leftArrow.setBounds(5, 208, 43, 23);
		rightArrow.setBounds(110, 208, 43, 23);
		upArrow.setBounds(55, 179, 43, 23);
		downArrow.setBounds(55, 239, 43, 23);
		ballButton1.setBounds(55, 208, 43, 23);

		compass.setBounds(23, 275, 115, 115);

		player2.setBounds(4, 400, 73, 35);
		player2.setFont(new Font("Serif", Font.BOLD, 10));
		player4.setBounds(85, 400, 73, 35);
		player4.setFont(new Font("Serif", Font.BOLD, 10));

		multi.setBounds(4, 437, 73, 35);
		exitGame.setBounds(85, 437, 73, 35);

//				~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//					Jbuttom Backgroundcolor and boarder
		leftArrow.setBackground(white);
		rightArrow.setBackground(white);
		upArrow.setBackground(white);
		downArrow.setBackground(white);
		ballButton1.setBackground(white);
		compass.setBackground(white);

		upArrow.setBorderPainted(false);
		downArrow.setBorderPainted(false);
		rightArrow.setBorderPainted(false);
		leftArrow.setBorderPainted(false);
		ballButton1.setBorderPainted(false);

		blankButton1.setBorder(BorderFactory.createBevelBorder(1));
		blankButton2.setBorder(BorderFactory.createBevelBorder(1));
		blankButton3.setBorder(BorderFactory.createBevelBorder(1));
		blankButton4.setBorder(BorderFactory.createBevelBorder(1));
//			~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		rightControlPanel.add(timerTitle);
		rightControlPanel.add(hr);
		rightControlPanel.add(isTo);
		rightControlPanel.add(min);
		rightControlPanel.add(isTo2);
		rightControlPanel.add(sec);
		rightControlPanel.add(scoreTitle);
		rightControlPanel.add(scoreTitle2);
		rightControlPanel.add(rightScore);
		rightControlPanel.add(leftScore);
		rightControlPanel.add(optionField);
		rightControlPanel.add(squareField);
		rightControlPanel.add(directionField);
		rightControlPanel.add(option);
		rightControlPanel.add(square);
		rightControlPanel.add(direction);
		rightControlPanel.add(blankButton1);
		rightControlPanel.add(blankButton2);
		rightControlPanel.add(blankButton3);
		rightControlPanel.add(blankButton4);
		rightControlPanel.add(leftArrow);
		rightControlPanel.add(rightArrow);
		rightControlPanel.add(upArrow);
		rightControlPanel.add(downArrow);
		rightControlPanel.add(ballButton1);
		rightControlPanel.add(compass);
		rightControlPanel.add(player2);
		rightControlPanel.add(player4);
		rightControlPanel.add(multi);
		rightControlPanel.add(exitGame);

//							
//							 

//			~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~					

		buttomControlPanel.setBounds(-1, 475, 811, 50);
		buttomControlPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		buttomControlPanel.setBackground(Color.decode("#40f7a8"));

		act = new JButton();
		run = new JButton();
		pause = new JButton();
		reset = new JButton();

		JLabel speedLabel = new JLabel("Speed : ");
		speed = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		speed.setBounds(550, 15, 230, 25);
		speed.setMajorTickSpacing(10);
		speed.setMinorTickSpacing(1);
//				speed.setPaintTicks(true);
		speed.setBackground(Color.decode("#40f7a8"));

		act.addActionListener(this);
		run.addActionListener(this);
		pause.addActionListener(this);
		reset.addActionListener(this);

		act.setBounds(140, 10, 60, 25);
		run.setBounds(230, 10, 60, 25);
		pause.setBounds(230, 10, 60, 25);
		reset.setBounds(310, 10, 60, 25);
		speedLabel.setBounds(500, 10, 60, 25);

		pause.setVisible(false);

		act.setIcon(actIcon);
		run.setIcon(runIcon);
		reset.setIcon(resetIcon);
		pause.setIcon(pauseIcon);

		act.setBackground(white);
		run.setBackground(white);
		pause.setBackground(white);
		reset.setBackground(white);

		act.setHorizontalAlignment(SwingConstants.CENTER);

		buttomControlPanel.add(act);
		buttomControlPanel.add(run);
		buttomControlPanel.add(pause);
		buttomControlPanel.add(reset);
		buttomControlPanel.add(speedLabel);
		buttomControlPanel.add(speed);

	}
	
	
	

	public void moveStepX(int x_ChangeBY) {

		tiles[getX()][getY()].setIcon(new ImageIcon("./images/white32x32.jpg"));
		if (getY() == 7 || getY() == 8) {
			tiles[getX()][getY()].setIcon(brick);
		}
//		if (getY() == 11 || getY() == 12) {
//			tiles[getX()][getY() + 1].setIcon(baby2);
//		}
		
		
		if (getX() == 6 && getY()==12) {
			tiles[getX()][getY() + 1].setIcon(baby2);
		}
		
		tiles[getX()][getY() + x_ChangeBY].setIcon(ball);
		y_pos = y_pos + x_ChangeBY;

//		for (int i = 1; i < 13; i++) {
//			for (int j = 15; j < 16; j++) {
//				tiles[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
//				tiles[i][j].setIcon(boundryLRWall);
//			}
//		}

	}

	boolean moving =false;
	
//~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~			

	public void moveStepY(int y_ChangeBY) {

		
		tiles[getX()][getY()].setIcon(new ImageIcon("./images/white32x32.jpg"));

		if (getY() == 7 || getY() == 8) {
			tiles[getX()][getY()].setIcon(brick);
		}
		tiles[getX() + y_ChangeBY][getY()].setIcon(ball);
		x_pos = x_pos + y_ChangeBY;

	}

//~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public void relectBallAtX(int x,int y,int moveStep) {
		if (getX()==x && getY()==y) {
			moveStepX(moveStep);
		}	
	} 	
	public void relectBallAtY(int x,int y,int moveStep) {
		if (getX()==x && getY()==y) {
			moveStepY(moveStep);
		}	
	} 	
	
	
	
//~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ~~  ~~~~ ~ ~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void moveContinue(int speedToIncrease, int moveStep,int movingDelay) {
	
		Runnable helloRunnable1 = new Runnable() {
			
			public void run() {
				
				moveStepX(moveStep);
//				compass.setIcon(eastIcon);

				if (getY() == 5) {
					compass.setIcon(eastIcon);
				}

				if (getY() == 12 && getX() ==6) {
					
					compass.setIcon(westIcon);
					moveContinue(2000000, -8,0);
					System.out.println("hello" + getX() + "," + getY());
				}

			}

		};

		
		
			
			ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
			executor1.scheduleAtFixedRate(helloRunnable1,movingDelay, speedToIncrease, TimeUnit.MILLISECONDS);
		
		

	}

	public static void main(String[] args) {

		CBabyBallBounce cbb = new CBabyBallBounce();
		cbb.setTitle(
				"                                                                                      demo - Baby Ball Bounce Application");
		cbb.setSize(825, 585);
		cbb.setResizable(false);

		cbb.createCbbMenu();
		cbb.addGameField();

		cbb.setIconImage(new ImageIcon("images/greenfoot.png").getImage());

		cbb.setVisible(true);
		
		cbb.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		        int result = JOptionPane.showConfirmDialog(cbb,
		        		"     The Game is going to Exit!! \n Do You Want To Exit The Game ???", "!!!! ExitWarning : !!!!",
		            JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION)
		          cbb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        else if (result == JOptionPane.NO_OPTION)
		          cbb.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		      }
		    });

		
		cbb.setDefaultCloseOperation(EXIT_ON_CLOSE);

		cbb.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == run || e.getSource() == run1) {
			run.setVisible(false);
			pause.setVisible(true);
			moveContinue(150, 1,0);
			System.out.println("run Clicked");
			

		}

		if (e.getSource() == pause || e.getSource() == pause1) {

			pause.setVisible(false);
			run.setVisible(true);
			System.out.println("Paused");
//			moveContinue(100,0 );
			
		}
		if (e.getSource() == act || e.getSource() == act1) {
			System.out.println("X,Y Position" + " " + getX() + ", " + getY());
			compass.setIcon(eastIcon);
			if (getY() == 12&& getX() == 6) {
//				tiles[getX()][getY()+1].setIcon(boundryLRWall);
				compass.setIcon(westIcon);
				moveContinue(2000000, -8,0);
				System.out.println("hello" + getX() + "," + getY());
			}
			moveStepX(1);
		}

		if (e.getSource() == reset || e.getSource() == reset1) {
			moveContinue(200, 1,50000);
//			int worldWidth = gameField.getWidth();
//			System.out.println(worldWidth);
			tiles[getX()][getY()].setIcon(null);
			run.setVisible(true);
//			tiles[6][4].setIcon(ball);
			tiles[setX(6)][setY(4)].setIcon(ball);
			System.out.println("ResetClicked");
			

		}

		if (e.getSource() == ballButton1) {
			System.out.println("X,Y Position" + " " + getX() + ", " + getY());

		}

		if (e.getSource() == leftArrow) {
//			bounceBall();
			compass.setIcon(westIcon);
			relectBallAtY(6,4,-1);
			relectBallAtY(6,13,1);
			System.out.println("X,Y Position" + " " + getX() + ", " + getY() + ", " + directionField.getText());
			moveStepX(-1);

		}

		if (e.getSource() == rightArrow) {
             
			
			compass.setIcon(eastIcon);

			System.out.println("X,Y Position" + " " + getX() + ", " + getY() + ", " + directionField.getText());
			moveStepX(1);
			relectBallAtY(6,11,-1);
//			relectBallAtX(6,11,-1);
			relectBallAtY(6,2,-1);

			
			
		}
		if (e.getSource() == upArrow) {
			compass.setIcon(northIcon);
			System.out.println("X,Y Position" + " " + getX() + ", " + getY());
		
			moveStepY(-1);
//			relectBallAtY(2,3,1);

		}
		if (e.getSource() == downArrow) {
			compass.setIcon(southIcon);
			moveStepY(1);
			relectBallAtY(7,11,1);
			System.out.println("X,Y Position" + " " + getX() + ", " + getY());
		}

		if (e.getSource() == player2) {

		}

		if (e.getSource() == player4) {

		}

		if (e.getSource() == multi) {

		}

		if (e.getSource() == exit || e.getSource() == exitGame) {

			Object[] options = { "Yes, please", "No way!!" };

			int op = JOptionPane.showOptionDialog(this,
					"     The Game is going to Exit!! \n Do You Want To Exit The Game ???", "!!!! ExitWarning !!!!",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,

					null, options, options[0]);
			if (op == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else if (op == JOptionPane.NO_OPTION) {

			}

		}

	}
}