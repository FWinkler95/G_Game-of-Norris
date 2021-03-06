package code;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Startmenu extends JFrame implements ActionListener, MouseListener{
	JPanel jpnlStartmenü;
	
	JButton jbtnStart;
	JButton jbtnEinstellungen;
	JButton jbtnBeenden;

	Rectangle rectStart;
	Rectangle rectEinstellungen;
	Rectangle rectBeenden;
	
	ImageIcon imicStart;
	ImageIcon imicEinstellungen;
	ImageIcon imicBeenden;
	
	BufferedImage bimageAlsChuck;
	BufferedImage bimageGegenChuck;
	BufferedImage bimageBeenden;
	
	ClassLoader cldr;
	
	URL urlStart;
	URL urlEinstellungen;
	URL urlBeenden;
	
	AudioInputStream aisButtonSound;
	AudioFormat afButtonSound;
	
	int intSizeButtonSound;
	
	byte[] byteButtonSound;
	
	DataLine.Info dlButtonSound;
	
	Clip clipButtonSound;
	
	
	public Startmenu(){
		this.setSize(1050,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jpnlStartmenü = new JPanel();
		jpnlStartmenü.setLayout(null);
		
		jbtnStart = new JButton(imicStart);
		jbtnEinstellungen = new JButton(imicEinstellungen);
		jbtnBeenden = new JButton(imicBeenden);
		
		imicStart = null;
		imicEinstellungen = null;
		imicBeenden = null;
		
		rectStart = new Rectangle();
		rectEinstellungen = new Rectangle();		
		rectBeenden = new Rectangle();
		
		cldr = this.getClass().getClassLoader();
		
		urlStart = cldr.getResource("gfx/textures/AlsChuck.png");
		urlEinstellungen = cldr.getResource("gfx/textures/GegenChuck.png");
		urlBeenden = cldr.getResource("gfx/textures/jbtnBeendenGFX.png");
System.out.println(urlStart);		

		try {
			 bimageAlsChuck = ImageIO.read(getClass().getResourceAsStream("/gfx/AlsChuck.png"));
			 bimageGegenChuck= ImageIO.read(getClass().getResourceAsStream("/gfx/GegenChuck.png"));
			 bimageBeenden = ImageIO.read(getClass().getResourceAsStream("/gfx/jbtnBeendenGFX.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		imicStart = new ImageIcon(bimageAlsChuck);
		imicEinstellungen = new ImageIcon(bimageGegenChuck);
		imicBeenden = new ImageIcon(bimageBeenden);
		
//		try {
//			aisButtonSound = AudioSystem.getAudioInputStream(cldr.getResource("sfx/ui/BeepSound.wav"));
//			afButtonSound = aisButtonSound.getFormat();
//			intSizeButtonSound = (int) (afButtonSound.getFrameSize()* aisButtonSound.getFrameLength());
			
//			byteButtonSound = new byte[intSizeButtonSound];
			
//			dlButtonSound = new DataLine.Info(Clip.class,  afButtonSound, intSizeButtonSound);
			
//			aisButtonSound.read(byteButtonSound, 0, intSizeButtonSound);
			
//			clipButtonSound = (Clip) AudioSystem.getLine(dlButtonSound);
//			clipButtonSound.open(afButtonSound, byteButtonSound, 0, intSizeButtonSound);
			
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (LineUnavailableException e) {
//			e.printStackTrace();
//		}
		
		jbtnStart.setIcon(imicStart);
		jbtnEinstellungen.setIcon(imicEinstellungen);
		jbtnBeenden.setIcon(imicBeenden);
		
		rectStart.setBounds(50, 50, imicStart.getIconWidth(), imicStart.getIconHeight());
		rectEinstellungen.setBounds(50,200,imicEinstellungen.getIconWidth(), imicEinstellungen.getIconHeight());
		rectBeenden.setBounds(50,350, imicBeenden.getIconWidth(), imicBeenden.getIconHeight());

		jbtnStart.setBounds(rectStart);
		jbtnEinstellungen.setBounds(rectEinstellungen);
		jbtnBeenden.setBounds(rectBeenden);
		
		jbtnStart.addActionListener(this);
		jbtnEinstellungen.addActionListener(this);
		jbtnBeenden.addActionListener(this);
		
		jbtnEinstellungen.addMouseListener(this);
		
		jpnlStartmenü.add(jbtnStart);
		jpnlStartmenü.add(jbtnEinstellungen);
		jpnlStartmenü.add(jbtnBeenden);

		this.getContentPane().add(jpnlStartmenü);
	}
	
	public void PlayButtonSound(){
//		clipButtonSound.start();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbtnBeenden)System.exit(0);
		if(ae.getSource()==jbtnEinstellungen)Chuck.startGame(2);
		if(ae.getSource()==jbtnStart)Chuck.startGame(1);
	}

	@Override
	public void mouseClicked(MouseEvent me) {		
	}

	@Override
	public void mousePressed(MouseEvent me) {		
	}

	@Override
	public void mouseReleased(MouseEvent me) {		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		if(me.getSource()==jbtnStart){
			jbtnStart.setIcon(imicEinstellungen);
			jbtnEinstellungen.setIcon(imicStart);
			System.out.println("jetzt");
		}
	}

	@Override
	public void mouseExited(MouseEvent me) {
		if(me.getSource()==jbtnEinstellungen){
			jbtnStart.setIcon(imicStart);
			jbtnEinstellungen.setIcon(imicEinstellungen);
		}
	}
}