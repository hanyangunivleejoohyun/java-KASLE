

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextPane;

import com.leapmotion.leap.Controller;

import javax.swing.JLabel;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class test extends JPanel {
	
	public int cproblem=1;
	
	//public void paint(Graphics  g)
	//{
		//Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\LeeJooHyun\\Desktop\\�⵿���\\University\\3�г� 1�б�\\Software Engineering\\project\\GUI\\basicicon\\"+cproblem+".png");
		//g.setColor(Color.black);
		//g.drawImage(image, 100, 100, null);
	//}
	
	private JTextField textField_2;
	private JTextField textField_3;
    
	private basic_practice bank = new basic_practice(this);  //creates new basic_practice object 
	
	private mainframe F;
	
	JPanel panel = new JPanel();
	
	ImageIcon asd = new ImageIcon("C:\\Users\\LeeJooHyun\\Desktop\\�⵿���\\University\\3�г� 1�б�\\Software Engineering\\project\\GUI\\basicicon\\1.png");
	JLabel slide_1= new JLabel(asd);
	JLabel slide_2= new JLabel("New label");

	SignListner leaplisten= new SignListner();
	Controller leapcont = new Controller();
	private String what_category="";  // identify category
	public String entered=""; // it is used for stop at input
	public int leap=2;

	public test(mainframe f) {
		F=f;
		setBounds(100, 100, 1008, 568);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 233, 444, 268);
		add(panel_2);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(0, 0, 444, 268);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(540, 233, 444, 268);
		add(panel_3);
		panel_3.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(0, 0, 444, 268);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		panel.setBounds(59, 52, 840, 153);
		add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		panel.add(slide_1);
		panel.add(slide_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(911, 52, 73, 150);
		add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnMain = new JButton("main");
		panel_1.add(btnMain);
		btnMain.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				bank.make_sel_category();
			}
		});
		
		JButton btnNewButton = new JButton("back to start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnChangeDifficulty = new JButton("change categoty");
		panel_1.add(btnChangeDifficulty);
	}
	
	public class basic_practice {
	       String question;  //initializes question string  
	       String answer;  //initializes answer string  
	       int correct=0, number;
	       boolean time = true;//initializes scoring variables 
	       basic_practice[] Vowel = new basic_practice[19];  //initializes ����  array  
	       basic_practice[] Consonant  = new basic_practice[21];  //initializes ���� array  
	       basic_practice[] Consonant_Vowel  = new basic_practice[40];  //initializes ���� ���� array  
	       List<basic_practice> VowelList = Arrays.asList(Vowel);  //sets the array as a list 
	       List<basic_practice> ConsonantList = Arrays.asList(Consonant);    
	       List<basic_practice> Consonant_VowelList = Arrays.asList(Consonant_Vowel);  //sets the array as a list 
	       
	       test panel;
	       
	       public basic_practice(test panel)
	       {
	    	   this.panel=panel;
	       }
	       
	       public void start_prac_basic(){  
	    	   bank.VowelList();  //assigns name of portion of program to build the collection of questions and answers 
	           bank.ConsonantList();
	           bank.Consonant_VowelList();
	           bank.Basic_askQuestion();//assigns name of portion of program to ask the questions 
	       }
	       
	       public void VowelList() //start of bankList 
	       { 
	          for(int i = 0; i < 19; i++){
	             Vowel[i] = new basic_practice((test)panel);//������Ʈ 10�� ����
	          }
	           Vowel[0].question = "��";  //Initialize object variables (�׸��� ���ų� �۽�)
	           Vowel[0].answer = "2";  //Initialize object variables (���� �޴� ���� ������� �Ӱ����� )
	            
	           Vowel[1].question = "��";  //Initialize object variables 
	           Vowel[1].answer = "��";  //Initialize object variables     
	            
	           Vowel[2].question = "��";  //Initialize object variables 
	           Vowel[2].answer = "��";  //Initialize object variables     
	            
	           Vowel[3].question = "��";  //Initialize object variables 
	           Vowel[3].answer = "��";  //Initialize object variables     
	            
	           Vowel[4].question = "��";  //Initialize object variables 
	           Vowel[4].answer = "��";  //Initialize object variables     
	            
	           Vowel[5].question = "��";  //Initialize object variables 
	           Vowel[5].answer = "��";  //Initialize object variables 
	            
	           Vowel[6].question = "��";  //Initialize object variables 
	           Vowel[6].answer = "��";  //Initialize object variables     
	            
	           Vowel[7].question = "��";  //Initialize object variables 
	           Vowel[7].answer = "��";  //Initialize object variables     
	            
	           Vowel[8].question = "��";  //Initialize object variables 
	           Vowel[8].answer = "��";  //Initialize object variables     
	            
	           Vowel[9].question = "��";  //Initialize object variables 
	           Vowel[9].answer = "��";  //Initialize object variables    
	           
	           Vowel[10].question = "��";  //Initialize object variables 
	           Vowel[10].answer = "��";  //Initialize object variables    Vowel[9].question = "��";  //Initialize object variables 
	           
	           Vowel[11].question = "��";  //Initialize object variables    Vowel[9].question = "��";  //Initialize object variables 
	           Vowel[11].answer = "��";  //Initialize object variables    Vowel[9].question = "��";  //Initialize object variables 
	           
	           Vowel[12].question = "��";  //Initialize object variables
	           Vowel[12].answer = "��";  //Initialize object variables 
	           
	           Vowel[13].question = "��";  //Initialize object variables 
	           Vowel[13].answer = "��";  //Initialize object variables   
	           
	           Vowel[14].question = "��";  //Initialize object variables 
	           Vowel[14].answer = "��";  //Initialize object variables   
	           
	           Vowel[15].question = "��";  //Initialize object variables 
	           Vowel[15].answer = "��";  //Initialize object variables   
	           
	           Vowel[16].question = "��";  //Initialize object variables 
	           Vowel[16].answer = "��";  //Initialize object variables   
	           
	           Vowel[17].question = "��";  //Initialize object variables 
	           Vowel[17].answer = "��";  //Initialize object variables 
	           
	           Vowel[18].question = "��";  //Initialize object variables 
	           Vowel[18].answer = "��";  //Initialize object variables      
	       }  //end of bankList 

	       public void ConsonantList(){
	          
	          for(int i = 0; i < 21; i++){
	             Consonant[i] = new basic_practice((test)panel);//������Ʈ 10�� ����
	          }
	           Consonant[0].question = "��";  //Initialize object variables (�׸��� ���ų� �۽�)
	           Consonant[0].answer = "��";  //Initialize object variables (���� �޴� ���� ������� �Ӱ����� )
	            
	           Consonant[1].question = "��";  //Initialize object variables 
	           Consonant[1].answer = "��";  //Initialize object variables     
	            
	           Consonant[2].question = "��";  //Initialize object variables 
	           Consonant[2].answer = "��";  //Initialize object variables     
	            
	           Consonant[3].question = "��";  //Initialize object variables 
	           Consonant[3].answer = "��";  //Initialize object variables     
	            
	           Consonant[4].question = "��";  //Initialize object variables 
	           Consonant[4].answer = "��";  //Initialize object variables     
	            
	           Consonant[5].question = "��";  //Initialize object variables 
	           Consonant[5].answer = "��";  //Initialize object variables 
	            
	           Consonant[6].question = "��";  //Initialize object variables 
	           Consonant[6].answer = "��";  //Initialize object variables     
	            
	           Consonant[7].question = "��";  //Initialize object variables 
	           Consonant[7].answer = "��";  //Initialize object variables     
	            
	           Consonant[8].question = "��";  //Initialize object variables 
	           Consonant[8].answer = "��";  //Initialize object variables     
	            
	           Consonant[9].question = "��";  //Initialize object variables 
	           Consonant[9].answer = "��";  //Initialize object variables 
	          
	           Consonant[10].question = "��";  //Initialize object variables 
	           Consonant[10].answer = "��";  //Initialize object variables    
	           
	           Consonant[11].question = "��";  //Initialize object variables 
	           Consonant[11].answer = "��";  //Initialize object variables    
	           
	           Consonant[12].question = "��";  //Initialize object variables 
	           Consonant[12].answer = "��";  //Initialize object variables    
	           
	           Consonant[13].question = "��";  //Initialize object variables 
	           Consonant[13].answer = "��";  //Initialize object variables    
	           
	           Consonant[14].question = "��";  //Initialize object variables 
	           Consonant[14].answer = "��";  //Initialize object variables        

	           Consonant[15].question = "��";  //Initialize object variables 
	           Consonant[15].answer = "��";  //Initialize object variables    
	           
	           Consonant[16].question = "��";  //Initialize object variables 
	           Consonant[16].answer = "��";  //Initialize object variables    
	           
	           Consonant[17].question = "��";  //Initialize object variables 
	           Consonant[17].answer = "��";  //Initialize object variables    
	           
	           Consonant[18].question = "��";  //Initialize object variables 
	           Consonant[18].answer = "��";  //Initialize object variables    
	           
	           Consonant[19].question = "��";  //Initialize object variables 
	           Consonant[19].answer = "��";  //Initialize object variables    
	           
	           Consonant[20].question = "��";  //Initialize object variables 
	           Consonant[20].answer = "��";  //Initialize object variables    
	          
	       }
	       public void Consonant_VowelList(){
	           for(int i = 0; i < 40; i++){
	              Consonant_Vowel[i] = new basic_practice((test)panel);//������Ʈ 10�� ����
	              if(i < 19){
	                 Consonant_Vowel[i] = Vowel[i];
	              }
	              else{
	                 Consonant_Vowel[i] = Consonant[i - 19];
	              }
	           }
	           Collections.shuffle(Consonant_VowelList);  //shuffles the list 
	        }

	       public void Correct(){
	          //����� �´� �� ǥ���ϴ� �׸��� ��������
	       }
	       public void InCorrect(){
	          //����� �´� �� ǥ���ϴ� �׸��� ��������
	       }
	       public void Basic_askQuestion()//start of askQuestion 
	       { //���⼭ �� �׸��� ������;
	           number=0;
	           leapcont.addListener(leaplisten);
	           if(what_category.equals("Vowel")){// �̺��� ��ư���� �����ؾߵ� 
	        	   while(number<19){
	        		   
	        		   while(true)
	        		   {
	        			   try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	        			   String enter = Integer.toString(leaplisten.current_state);
	        			   //if(Vowel[0].answer==enter){  //checks the users input 	      
	        			   if(leap==2){
	        			       System.out.println("core1111");
	        				   number++;
	        				   panel.cproblem++;
	        				   panel.repaint();
	        				   break;
	                     }  //end of if 
	        		   }
	               }
	           }  //end of counter for loop 
	           else if(what_category.equals("Consonant")){//�� �κе� ��ư���� �����ؾߵ�
	              for (number = 0; number < 21; number++)  //start of counter for loop (���� ���� ����)
	                {  
	                  System.out.printf("%d. %s?%n", number + 1, Consonant[number].question);  //prints question(�̰� �׸����� ����, �ƴϸ� ����� ����) 
	                    System.out.println("Please Write Your Answers:");

	                    if (entered.compareTo(Consonant[number].answer)==0)  //checks the users input 
	                    { 
	                        Correct();
	                        System.out.println("*** Correct! ***");  //prints correct response 
	                        correct = correct + 1;  //counts number of correct answers 
	                    }  //end of if 
	                    else{  //start of response for wrong answers 
	                       InCorrect();
	                       System.out.println("--- Incorrect! ---");  //print the incorrect response
	                    }
	                  }
	              }
	              else if(what_category.equals("Consonant_VowelList")){//�� �κе� ��ư���� �����ؾߵ�

	                  for (number = 0; number < 40; number++)  //start of counter for loop (���� ���� ����)
	                    {  

	                        System.out.printf("%d. %s?%n", number + 1, Consonant_Vowel[number].question);  //prints question(�̰� �׸����� ����, �ƴϸ� ����� ����) 
	                        System.out.println("Please Write Your Answers:");  
	                        entered = textField_2.getText();//read input 

	                        if (entered.compareTo(Consonant_Vowel[number].answer)==0)  //checks the users input 
	                        { 
	                           Correct();
	                            System.out.println("*** Correct! ***");  //prints correct response 
	                            correct = correct + 1;  //counts number of correct answers 
	                        }  //end of if 
	                        else{  //start of response for wrong answers 
	                           InCorrect();
	                           System.out.println("--- Incorrect! ---");  //print the incorrect response
	                        }

	                    }
	       }

	           System.out.println("*******************");  //prints footer top border 
	           System.out.printf(" Your score is %d/%d%n", correct, number);  //prints results 
	           System.out.println("*******************");  //prints footer bottom border 
	   }

	       public void make_sel_category(){
	    		 JFrame mf = new JFrame();
				 mf.setSize(240,150);
				 JPanel select_category = new JPanel();
				 select_category.setLayout(new GridLayout(1, 3, 0, 0));
				 
				 JButton sel_Vowel= new JButton("Vowel");
				 sel_Vowel.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){
						what_category="Vowel";
		        		   textField_3.setText("*** Correct! ***");
						 mf.setVisible(false);
						 start_prac_basic();
					 }
				 });
				 
				 JButton sel_Consonant  = new JButton("Consonant");
				 sel_Consonant.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){
						 what_category=sel_Consonant.getName();
						 mf.setVisible(false);
						 start_prac_basic();
					 }
				 });
				 JButton sel_Both = new JButton("Both");
				 sel_Both.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){
						 what_category=sel_Both.getName();
						 mf.setVisible(false);
						 start_prac_basic();
					 }
				 });
				 select_category.add(sel_Vowel);
				 select_category.add(sel_Consonant);
				 select_category.add(sel_Both);
				 mf.getContentPane().add(select_category);
				 mf.setVisible(true);
			}

	       }
}