package cn.com.yw.pxtodp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainActivity {
	static int PPI = 0;//手机ppi分辨路
	static JFrame jframe;

	static JButton bt_change;
	static JTextField text_with,text_height,text_px,text_size;
	static JTextField text;
	static JPanel p1,p2,p4,p3,p5,p6;
	static JLabel l1,l2,l3,l4;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小,在具有多个显示屏的系统上，使用主显示屏
		jframe = new JFrame("px/dp转换器");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLayout(new BorderLayout());
		jframe.setBounds(screenSize.width/4,screenSize.height/4, screenSize.width/4,screenSize.height/4);
		jframe.setResizable(false);
		
		text = new JTextField("dp");
		
		 text_with = new JTextField("屏幕宽");
		 text_height = new JTextField("屏幕高");
		 text_px = new JTextField("px");
		 text_size = new JTextField("屏幕尺寸");
		
		bt_change = new JButton("转换");
		bt_change.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				PPI = (int)( Math.sqrt(Integer.parseInt(text_with.getText())*Integer.parseInt(text_with.getText()) 
						+ Integer.parseInt(text_height.getText())*Integer.parseInt(text_height.getText()))/
						Float.parseFloat(text_size.getText()));
				System.out.println(PPI+"");
				text.setText((Integer.parseInt(text_px.getText()) / (PPI/160)) +"");
				}catch(Exception e1){
					
				}
			}});
		
		l1 = new JLabel("屏幕宽");
		l1 = new JLabel("屏幕高");
		l1 = new JLabel("px");
		l1 = new JLabel("dp");
		
		p1 = new JPanel(new BorderLayout());
		p2 = new JPanel(new BorderLayout());
		p3 = new JPanel(new BorderLayout());
		p4 = new JPanel(new BorderLayout());
		p5 = new JPanel(new BorderLayout());
		p6 = new JPanel(new BorderLayout());

		p1.add(text_with,BorderLayout.NORTH);
		p2.add(text_height,BorderLayout.NORTH);
		p3.add(text_px,BorderLayout.NORTH);
		p4.add(text,BorderLayout.NORTH);
		p5.add(bt_change,BorderLayout.NORTH);
		p6.add(text_size,BorderLayout.NORTH);
		
		p1.add(p2,BorderLayout.CENTER);
		p2.add(p3,BorderLayout.CENTER);
		p3.add(p6,BorderLayout.CENTER);
		p6.add(p4,BorderLayout.CENTER);
		p4.add(p5,BorderLayout.CENTER);
		
		jframe.add(p1,BorderLayout.CENTER);
		
        jframe.setVisible(true);
		
	}

}
