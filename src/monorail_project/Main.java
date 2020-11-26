package monorail_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Main {

	public static void main(String[] args) {
		GUI monorail = new GUI();

	}

}

/* <실행 과정 설명>
 
 1. 타일을 두겠습니다를 선택  
 2. 새로 생긴 창에서 새로 놓을 타일 선택함. 타일을 선택하면 nexticon의 값이 rail에서 그 타일을 가르키는 인덱스로 바뀜.
 3. 이후 타일 선택창이 닫힌다.
 4. 그후 그타일을 어디에 둘지  선택한다.
 5. 둘곳의 버튼을 선택하면 그 버튼이 선택한 타일로 변경됨에 동시에 nexticon이 6으로 바뀐다.
 (만약 버튼을 한번 눌러서 원하는  버튼의 이미지를 바꾼다음에, 다른 버튼을 누른다면 nexticon은 6이기 때문에 예외처리가 된다. )
 
 
 
 */

class GUI extends JFrame{
	
	JButton[] bt = new JButton[188];
	JButton go = new JButton("타일을 두겠습니다");
	JButton end = new JButton("불가능을 선언하겠습니다");
	
	ImageIcon[] rail = new ImageIcon[6];
	
	int nexticon = 6; // 이 수가 0~5 사이가 아닐 때 puticon 을 실행하면 err 발생하도록 예외처리 해야함 
	
	void set_icon(){
		// rail 그림을 button 크기에 맞도록 수정  ( rail[0~1] = 직선레일, rail[2~5] = 곡선 레일 )
		// 경로가 지금 내 컴퓨터에 맞춰져 있어서 여기 경로만 수정해서 디버깅하면 될듯!
		// 버튼들은 class내에 선언안 rail이라는 이미지 배열에저장 
		
		ImageIcon originIcon = new ImageIcon("/Users/ansanghyeon/Desktop/img/rail0.png"); //이 경로들 자신에 맞게 수정 
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[0] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/ansanghyeon/Desktop/img/rail1.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[1] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/ansanghyeon/Desktop/img/rail2.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[2] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/ansanghyeon/Desktop/img/rail3.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[3] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/ansanghyeon/Desktop/img/rail4.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[4] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/ansanghyeon/Desktop/img/rail5.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[5] = new ImageIcon(changedImg);
		
		// 이미지 생성 끝. 앞으로 이 이미지로 모두 사용할 예정
	}

	GUI(){
		set_icon(); //이미지 제작  
		setTitle("-- MONORAIL GAME --");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3)); // 새로 add 했을때 중앙정렬, 버튼간 좌우 상하간격 3
		
		//가로 17개, 세로 11개의 버튼 생성 
		
		for(int i=1;i<188;i++) {
			bt[i] = new JButton();
			bt[i].setPreferredSize(new Dimension(50, 50));
			bt[i].addActionListener(new Puticon());
			add(bt[i]);
		}
		
		// 게임 진행 버튼 맨 밑에 2개 생성 
		
		go.setPreferredSize(new Dimension(200, 100));
		go.addActionListener(new Setnexticon());
		add(go);
		end.setPreferredSize(new Dimension(200, 100));
		add(end);  
		
		//시작부분 이미지 변경 
		bt[94].setIcon(rail[0]);
		

		setSize(950,750);
		setVisible(true);
	}
	
	//버튼을 누르면 nexticon의 값에 따라 버튼의 아이콘이 바뀜. 단 버튼을 한개만 누르게 하기위해 한번 사용 후 nexticon을 6으로 변경.
	
	class Puticon implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JButton b = (JButton)e.getSource();
			b.setIcon(rail[nexticon]);
			nexticon = 6;
			// 6으로 바꾸는 이유는 6일때는 위에 말한 예외처리가 되기 때문. setnexticon을 통해 nexticon의 값을 생성하는데
			// 이건 버튼 한개의 그림만 바꿔야하기때문에  한번쓰고 버려야함.
		}
	}
	
	//타일을 두겠습니다 를 선택했을 때 어떤 타일을 선택할지 고르는 창이 뜬다. 타일을 고르면 그에 맞게 nexticon이 변경된다.
	
	class Setnexticon implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			new Selecticon();
		}
	}
	
	// 위에 타일을두겟습니다를 선택했을 때 새로 생기는 
	
	class Selecticon extends JFrame{
		
		Selecticon(){
			setTitle("타일 선택");
			setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));			
			
			JLabel label = new JLabel("어떤 타일을 선택하실 건가요?", JLabel.CENTER);
			label.setFont(new Font("", Font.BOLD, 20));
			label.setPreferredSize(new Dimension(700, 50));
			add(label);
			JButton[] temp = new JButton[6];
			
			for(int i=0;i<6;i++) {
				temp[i] = new JButton(""+ i);
				temp[i].setIcon(rail[i]);
				
				//새로운 창에서 버튼을 눌렀을 때 새로운창 꺼지고 nexticon 값 변화 
				
				temp[i].addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e) {
					JButton b = (JButton)e.getSource();
					int from = Integer.parseInt(b.getText());
					nexticon = from;
					dispose();
					}
				});
				add(temp[i]);
			}
			
			setSize(700,200);
			setVisible(true);
		}
	}
	


	
}
