package cscicalc;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calc implements ActionListener{
	private JTextField eqnbox = new JTextField(15);
	private JButton one = new JButton("1");
	private JButton two = new JButton("2");
	private JButton three = new JButton("3");
	private JButton four = new JButton("4");
	private JButton five = new JButton("5");
	private JButton six = new JButton("6");
	private JButton seven = new JButton("7");
	private JButton eight = new JButton("8");
	private JButton nine = new JButton("9");
	private JButton zero = new JButton("0");
	private JButton clear = new JButton("C");
	private JButton backspace = new JButton("←");
	private JButton equal = new JButton("=");
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton multiply = new JButton("*");
	private JButton divide = new JButton("/");
	private JButton pow = new JButton("xʸ");
	private JButton decimal = new JButton(".");
	private JButton neg = new JButton("±");
	private JButton sin = new JButton("sin");
	private JButton cos = new JButton("cos");
	private JButton tan = new JButton("tan");
	private JButton log = new JButton("log");
	private JButton sqrt = new JButton("sqrt");
	private JPanel mainpanel = new JPanel(new BorderLayout());
	private JPanel buttons = new JPanel(new GridLayout(5,5));
	private JFrame frame = new JFrame("Calculator");
	private Font TNR = new Font("Times New Roman", Font.PLAIN, 60);
	private String operand1 = "";
	private String operand2 = "";
	private String operator = "";
	private String currentOperand = "operand1";
	private String Backspace = "";
	private String Posify = "";
	private String decimalCheck1 = "";
	private String decimalCheck2 = "";
	private double firstOperand = 0.00;
	private double secondOperand = 0.00;
	private double answer = 0.00;
	private boolean alreadyDecimal = false;
	   
	public Calc()
	{
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    addActionListeners();
	    frame.add(mainpanel);
	    mainpanel.add(eqnbox , BorderLayout.NORTH);
	    mainpanel.add(buttons, BorderLayout.CENTER);
	    addElements();
	    //frame.setResizable(false);
	    frame.setSize(600, 600);
	    frame.setVisible(true);
	    eqnbox.setFont(TNR);
	    eqnbox.setEditable(false);
	    eqnbox.setHorizontalAlignment(JTextField.RIGHT);
	    eqnbox.setText("0");
	}
	public void addElements()
	{
		buttons.add(backspace);
	    buttons.add(clear);
	    buttons.add(pow);
	    buttons.add(plus);
	    buttons.add(sqrt);
	    buttons.add(seven);
	    buttons.add(eight);
	    buttons.add(nine);
	    buttons.add(minus);
	    buttons.add(sin);
	    buttons.add(four);
	    buttons.add(five);
	    buttons.add(six);
	    buttons.add(multiply);
	    buttons.add(cos);
	    buttons.add(one);
	    buttons.add(two);
	    buttons.add(three);
	    buttons.add(divide);
	    buttons.add(tan);
	    buttons.add(decimal);
	    buttons.add(zero);
	    buttons.add(neg);
	    buttons.add(equal);
	    buttons.add(log);
	}
	public void addActionListeners()
	{
		sqrt.addActionListener(this);
		sin.addActionListener(this);
		cos.addActionListener(this);
		tan.addActionListener(this);
		log.addActionListener(this);
		backspace.addActionListener(this);
		clear.addActionListener(this);
		pow.addActionListener(this);
		plus.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		minus.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		multiply.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		divide.addActionListener(this);
		decimal.addActionListener(this);
		zero.addActionListener(this);
		neg.addActionListener(this);
		equal.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == backspace)
		{
			if(currentOperand.equals("operand1"))
			{
				if(operand1.charAt(operand1.length()-1)=='.')
				{	
					Backspace = operand1.substring(0, operand1.length()-1);
					operand1 = new String(Backspace);
					alreadyDecimal = false;
					decimal.setEnabled(true);
				}
				else
				{
					Backspace = operand1.substring(0, operand1.length()-1);
					operand1 = new String(Backspace);
				}
			}
			else
			{
				if(operand2.charAt(operand2.length()-1)=='.')
				{	
					Backspace = operand2.substring(0, operand2.length()-1);
					operand2 = new String(Backspace);
					alreadyDecimal = false;
					decimal.setEnabled(true);
				}
				else
				{
					Backspace = operand2.substring(0, operand2.length()-1);
					operand2 = new String(Backspace);
				}
			}
		}
		else if(source == clear)
		{
			operand1 = "";
			operand2 = "";
			operator = "";
			currentOperand = new String("operand1");
			reenableOperators();
		}
		else if(source == pow)
		{
			operator = "pow";
			switchActiveOperand();
		}
		else if(source == plus)
		{
			operator = "plus";
			switchActiveOperand();
		}
		else if(source == seven)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "7";
			}
			else
			{
				operand2 += "7";
			}
		}
		else if(source == eight)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "8";
			}
			else
			{
				operand2 += "8";
			}
		}
		else if(source == nine)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "9";
			}
			else
			{
				operand2 += "9";
			}
		}
		else if(source == minus)
		{
			operator = "minus";
			switchActiveOperand();
		}
		else if(source == four)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "4";
			}
			else
			{
				operand2 += "4";
			}
		}
		else if(source == five)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "5";
			}
			else
			{
				operand2 += "5";
			}	
		}
		else if(source == six)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "6";
			}
			else
			{
				operand2 += "6";
			}
		}
		else if(source==multiply)
		{
			operator = "multiply";
			switchActiveOperand();
		}
		else if(source == one)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "1";
			}
			else
			{
				operand2 += "1";
			}
		}
		else if(source == two)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "2";
			}
			else
			{
				operand2 += "2";
			}
		}
		else if(source == three)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "3";
			}
			else
			{
				operand2 += "3";
			}
		}
		else if(source == divide)
		{
			operator = "divide";
			switchActiveOperand();
		}
		else if(source == decimal)
		{
			if(!alreadyDecimal)
			{	
			if(currentOperand.equals("operand1"))
			{
				operand1 += ".";
				alreadyDecimal = true;
				decimal.setEnabled(false);
			}
			else
			{
				operand2 += ".";
				alreadyDecimal = true;
				decimal.setEnabled(false);
			}
			}
		}
		else if(source == zero)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 += "0";
			}
			else
			{
				operand2 += "0";
			}
		}
		else if(source == neg)
		{
			if(currentOperand.equals("operand1"))
			{
				if(operand1.charAt(0)=='-')
				{
					Posify = operand1.substring(1);
					operand1 = new String(Posify);
				}
				else
					operand1 = "-" + operand1;
			}
			else
			{
				if(operand2.charAt(0)=='-')
				{
					Posify = operand2.substring(1);
					operand2 = new String(Posify);
				}
				else
					operand2 = "-" + operand2;
			}
		}
		else if(source == equal)
		{
			solve();
			eqnbox.setText(operand1);
		}
		else if(source == sin)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 = Double.toString(Math.sin(Double.parseDouble(operand1)));
			}
			else
			{
				operand2 = Double.toString(Math.sin(Double.parseDouble(operand2)));
			}
			if(operand1.equals("NaN")||operand2.equals("NaN"))
			{
				greyOutOperators();
				divZeroForceClear();
			}
		}
		else if(source == cos)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 = Double.toString(Math.cos(Double.parseDouble(operand1)));
			}
			else
			{
				operand2 = Double.toString(Math.cos(Double.parseDouble(operand2)));
			}
			if(operand1.equals("NaN")||operand2.equals("NaN"))
			{
				greyOutOperators();
				divZeroForceClear();
			}
		}
		else if(source == tan)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 = Double.toString(Math.tan(Double.parseDouble(operand1)));
			}
			else
			{
				operand2 = Double.toString(Math.tan(Double.parseDouble(operand2)));
			}
			if(operand1.equals("NaN")||operand2.equals("NaN"))
			{
				greyOutOperators();
				divZeroForceClear();
			}
		}
		else if(source == sqrt)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 = Double.toString(Math.sqrt(Double.parseDouble(operand1)));
			}
			else
			{
				operand2 = Double.toString(Math.sqrt(Double.parseDouble(operand2)));
			}
			if(operand1.equals("NaN")||operand2.equals("NaN"))
			{
				greyOutOperators();
				divZeroForceClear();
			}
		}
		else if(source == log)
		{
			if(currentOperand.equals("operand1"))
			{
				operand1 = Double.toString(Math.log10(Double.parseDouble(operand1)));
			}
			else
			{
				operand2 = Double.toString(Math.log10(Double.parseDouble(operand2)));
			}
			if(operand1.equals("NaN")||operand2.equals("NaN"))
			{
				greyOutOperators();
				divZeroForceClear();
			}
		}
		if(currentOperand.equals("operand1"))
		{
			eqnbox.setText(operand1);
		}
		else
		{
			eqnbox.setText(operand2);
		}
		if(!operator.equals(""))
		{
			greyOutOperators();
		}
	}
	public void greyOutOperators()
	{
		plus.setEnabled(false);
		minus.setEnabled(false);
		multiply.setEnabled(false);
		divide.setEnabled(false);
		pow.setEnabled(false);
	}
	public void reenableOperators()
	{
		plus.setEnabled(true);
		minus.setEnabled(true);
		multiply.setEnabled(true);
		divide.setEnabled(true);
		pow.setEnabled(true);
		one.setEnabled(true);
		two.setEnabled(true);
		three.setEnabled(true);
		four.setEnabled(true);
		five.setEnabled(true);
		six.setEnabled(true);
		seven.setEnabled(true);
		eight.setEnabled(true);
		nine.setEnabled(true);
		zero.setEnabled(true);
		decimal.setEnabled(true);
		neg.setEnabled(true);
		backspace.setEnabled(true);
		equal.setEnabled(true);
		sqrt.setEnabled(true);
		sin.setEnabled(true);
		cos.setEnabled(true);
		tan.setEnabled(true);
		log.setEnabled(true);
	}
	public void switchActiveOperand()
	{
		if(currentOperand.equals("operand1"))
		{
			currentOperand = new String("operand2");
		}
		else
		{
			currentOperand = new String("operand1");
		}
		alreadyDecimal = false;
		decimal.setEnabled(true);
	}
	public void solve()
	{
		boolean divZero = false;
		if(operand1.equals(""))
			operand1 = new String("0");
		else if(operand2.equals(""))
			operand2 = new String("0");
		switch(operator)
		{
			case "pow":
			{
				firstOperand = Double.parseDouble(operand1);
				secondOperand = Double.parseDouble(operand2);
				answer = Math.pow(firstOperand, secondOperand);
				break;
			}
			case "minus":
			{
				firstOperand = Double.parseDouble(operand1);
				secondOperand = Double.parseDouble(operand2);
				answer = firstOperand - secondOperand;
				break;
			}
			case "plus":
			{
				firstOperand = Double.parseDouble(operand1);
				secondOperand = Double.parseDouble(operand2);
				answer = firstOperand + secondOperand;
				break;
			}
			case "multiply":
			{
				firstOperand = Double.parseDouble(operand1);
				secondOperand = Double.parseDouble(operand2);
				answer = firstOperand * secondOperand;
				break;
			}
			case "divide":
			{
				firstOperand = Double.parseDouble(operand1);
				secondOperand = Double.parseDouble(operand2);
				if(secondOperand==0)
				{
					divZero = true;
					operand1 = new String("Undefined");
					break;
				}
				answer = firstOperand / secondOperand;
				break;
			}
		}
		currentOperand = new String("operand1");
		alreadyDecimal = false;
		operand2 = "";
		if(!divZero)
		{
			operand1 = new String(Double.toString(answer));
			decimalCheck1 = operand1.substring(0, operand1.indexOf("."));
			decimalCheck2 = operand1.substring(operand1.indexOf(".")+1);
			if(Double.parseDouble(decimalCheck2)== 0.0)
				operand1 = new String(decimalCheck1);
			decimalCheck1 = "";
			decimalCheck2 = "";
			operator = "";
			reenableOperators();
		}
		else
		{
			operator = "";
			divZeroForceClear();
			divZero = false;
		}
	}
	public void divZeroForceClear()
	{
		one.setEnabled(false);
		two.setEnabled(false);
		three.setEnabled(false);
		four.setEnabled(false);
		five.setEnabled(false);
		six.setEnabled(false);
		seven.setEnabled(false);
		eight.setEnabled(false);
		nine.setEnabled(false);
		zero.setEnabled(false);
		decimal.setEnabled(false);
		neg.setEnabled(false);
		backspace.setEnabled(false);
		equal.setEnabled(false);
		sqrt.setEnabled(false);
		sin.setEnabled(false);
		cos.setEnabled(false);
		tan.setEnabled(false);
		log.setEnabled(false);
	}
	public static void main(String args[])
	{
		Calc Calculator = new Calc();
	}
}
