package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JTextField ft = new JTextField();
	JTextField TF = new JTextField();
	JLabel l = new JLabel();
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton mul = new JButton();
	JButton div = new JButton();
	JButton equals = new JButton();
	String a;
	String aa;
	String aaa;
	int x;
	int y;
	int result;

	public static void main(String[] args) {
		new Calculator().createUI();

	}

	public void createUI() {
		f.add(p);
		p.add(l);
		p.add(ft);
		p.add(TF);
		p.add(add);
		p.add(sub);
		p.add(mul);
		p.add(div);
		f.setVisible(true);
		ft.setText("               first number               ");
		TF.setText("               second number               ");
		add.setText("add");
		add.addActionListener(this);
		sub.setText("sub");
		sub.addActionListener(this);
		mul.setText("mul");
		mul.addActionListener(this);
		div.setText("div");
		div.addActionListener(this);
		l.setVisible(true);
		l.setText("Click operation button twice for correct answer");
		f.pack();
		f.setSize(500, 500);
	}

	private void add() {
		result = x + y;
		System.out.println(result);
		l.setText(aaa + "=");
	}

	private void subtract() {
		result = x - y;
		System.out.println(result);
		l.setText(aaa + "=");
	}

	private void multiply() {
		result = x * y;
		System.out.println(result);
		l.setText(aaa + "=");
	}

	private void divide() {
		result = x / y;
		System.out.println(result);
		l.setText(aaa + "=");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();

		a = ft.getText();
		aa = TF.getText();
		x = Integer.parseInt(a);
		y = Integer.parseInt(aa);
		aaa = Integer.toString(result);
		if (b.equals(add)) {
			add();
			a = ft.getText();
			aa = TF.getText();
			x = Integer.parseInt(a);
			y = Integer.parseInt(aa);
			aaa = Integer.toString(result);
		} else if (b.equals(sub)) {
			subtract();
			a = ft.getText();
			aa = TF.getText();
			x = Integer.parseInt(a);
			y = Integer.parseInt(aa);
			aaa = Integer.toString(result);
		} else if (b.equals(mul)) {
			multiply();
			a = ft.getText();
			aa = TF.getText();
			x = Integer.parseInt(a);
			y = Integer.parseInt(aa);
			aaa = Integer.toString(result);
		} else if (b.equals(div)) {
			divide();
			a = ft.getText();
			aa = TF.getText();
			x = Integer.parseInt(a);
			y = Integer.parseInt(aa);
			aaa = Integer.toString(result);
		}

	}

}
