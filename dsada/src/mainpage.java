package dsada;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class mainpage extends JPanel {
	private mainframe F;
	/**
	 * Create the panel.
	 */
	public mainpage(mainframe f) {
		setBackground(Color.BLACK);
		F=f;
		setLayout(null);
		setBounds(100, 100, 1008, 592);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(12, 221, 247, 361);
		add(panel);
		panel.setLayout(new GridLayout(4, 0, 0, 15));
		
		// button sector start
		ImageIcon basic = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\basic.png");
		ImageIcon basic2 = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\basic2.png");
		JButton prac_basic_button = new JButton(basic);
		prac_basic_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				prac_basic_button.setIcon(basic2);
			}
			public void mouseExited(MouseEvent evt) {
				prac_basic_button.setIcon(basic);
			}
		});
		prac_basic_button.setBorderPainted(false); // 테두리 없애기
		prac_basic_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		prac_basic_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		prac_basic_button.setSize(new Dimension(basic.getIconWidth(), basic.getIconHeight())); //크기 맞추기
		panel.add(prac_basic_button);
		prac_basic_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.gotobasic_prac();
			}});
//카테고리 띄우기 끝
		
		ImageIcon voca = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\voca.png");
		ImageIcon voca2 = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\voca2.png");
		JButton prac_voca_button= new JButton(voca);
		prac_voca_button.setBorderPainted(false); // 테두리 없애기
		prac_voca_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		prac_voca_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		prac_voca_button.setSize(new Dimension(voca.getIconWidth(), voca.getIconHeight())); //크기 맞추기
		panel.add(prac_voca_button);
		
		prac_voca_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				prac_voca_button.setIcon(voca2);
			}
			public void mouseExited(MouseEvent evt) {
				prac_voca_button.setIcon(voca);
			}
		});
		prac_voca_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.changepaneltowords_prac();
			}
		});
		
//button listener end
		ImageIcon senten = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\senten.png");
		ImageIcon senten2 = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\senten2.png");
		JButton prac_senten_button = new JButton(senten);
		prac_senten_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem_Login lo=new Problem_Login(f);
			}
		});
		panel.add(prac_senten_button);
		prac_senten_button.setBorderPainted(false); // 테두리 없애기
		prac_senten_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		prac_senten_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		prac_senten_button.setSize(new Dimension(senten.getIconWidth(), senten.getIconHeight())); //크기 맞추기
		panel.add(prac_senten_button);
		
		prac_senten_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				prac_senten_button.setIcon(senten2);
			}
			public void mouseExited(MouseEvent evt) {
				prac_senten_button.setIcon(senten);
			}
		});
		
		ImageIcon setting = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\setting.png");
		ImageIcon setting2 = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\setting2.png");
		JButton setting_button = new JButton(setting);
		setting_button.setBorderPainted(false); // 테두리 없애기
		setting_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		setting_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		setting_button.setSize(new Dimension(setting.getIconWidth(), setting.getIconHeight())); //크기 맞추기
		panel.add(setting_button);
		setting_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				setting_button.setIcon(setting2);
			}
			public void mouseExited(MouseEvent evt) {
				setting_button.setIcon(setting);
			}
		});
		
// starting of mainimage
		
		ImageIcon maininfoimage = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\main_image.png");
		JLabel infoimage = new JLabel(maininfoimage);
		infoimage.setBounds(271, 221, 466, 361);
		add(infoimage);

// end of mainimage and staring right button
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(749, 221, 247, 361);
		add(panel_1);
		panel_1.setLayout(new GridLayout(4, 0, 0, 15));
		
		ImageIcon basicgame = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\basicgame.png");
		ImageIcon basicgame2 = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\basicgame2.png");
		JButton basicgame_button = new JButton(basicgame);
		panel_1.add(basicgame_button);
		basicgame_button.setBorderPainted(false); // 테두리 없애기
		basicgame_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		basicgame_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		basicgame_button.setSize(new Dimension(basicgame.getIconWidth(), basicgame.getIconHeight())); //크기 맞추기
		basicgame_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				basicgame_button.setIcon(basicgame2);
			}
			public void mouseExited(MouseEvent evt) {
				basicgame_button.setIcon(basicgame);
			}
		});
		
		ImageIcon sentengame_easy = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\sentengame_easy.png");
		ImageIcon sentengame_easy2= new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\sentengame_easy2.png");
		JButton sentengame_easy_button = new JButton(sentengame_easy);
		panel_1.add(sentengame_easy_button);
		sentengame_easy_button.setBorderPainted(false); // 테두리 없애기
		sentengame_easy_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		sentengame_easy_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		sentengame_easy_button.setSize(new Dimension(sentengame_easy.getIconWidth(), sentengame_easy.getIconHeight())); //크기 맞추기
		sentengame_easy_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				sentengame_easy_button.setIcon(sentengame_easy2);
			}
			public void mouseExited(MouseEvent evt) {
				sentengame_easy_button.setIcon(sentengame_easy);
			}
		});
		
		ImageIcon sentengame_hard= new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\sentengame_hard.png");
		ImageIcon sentengame_hard2= new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\sentengame_hard2.png");
		JButton sentengame_hard_button = new JButton(sentengame_hard);
		panel_1.add(sentengame_hard_button);
		sentengame_hard_button.setBorderPainted(false); // 테두리 없애기
		sentengame_hard_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		sentengame_hard_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		sentengame_hard_button.setSize(new Dimension(sentengame_hard.getIconWidth(), sentengame_hard.getIconHeight())); //크기 맞추기
		sentengame_hard_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				sentengame_hard_button.setIcon(sentengame_hard2);
			}
			public void mouseExited(MouseEvent evt) {
				sentengame_hard_button.setIcon(sentengame_hard);
			}
		});
		
		ImageIcon exit= new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\exit.png");
		ImageIcon exit2 = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\exit2.png");
		JButton exit_button = new JButton(exit);
		panel_1.add(exit_button);
		exit_button.setBorderPainted(false); // 테두리 없애기
		exit_button.setMargin(new Insets(0,0,0,0)); // 여백없애기
		exit_button.setContentAreaFilled(false); // 버튼 바탕 없애기
		exit_button.setSize(new Dimension(exit.getIconWidth(), exit.getIconHeight())); //크기 맞추기
		exit_button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				exit_button.setIcon(exit2);
			}
			public void mouseExited(MouseEvent evt) {
				exit_button.setIcon(exit);
			}
		});
		
// end of right button panel
		
		JPanel panel_2 = new JPanel();
		ImageIcon mainlogoicon = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\잡동사니\\University\\3학년 1학기\\Software Engineering\\project\\GUI\\logo.png");
		JLabel mainlogo = new JLabel(mainlogoicon);
		panel_2.add(mainlogo);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(12, 31, 984, 170);
		add(panel_2);
		setVisible(true);
	}
}
