import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Encdec extends JFrame implements ActionListener {
    public JPanel panel;
    JButton b,b1,b2;
    JRadioButton r,r1;
    JTextField t,t1,t3;
    JLabel l,l1,l2;
    ButtonGroup G;
    public Encdec(){
        panel=new JPanel();
        l=new JLabel("Enter the Text:");
        l2=new JLabel("Cipher Key");
        t3=new JTextField(10);
        t3.setEnabled(false);
        t3.setDisabledTextColor(Color.BLACK);
        l1=new JLabel("Encrypted/Decrypted Text");
        t=new JTextField(50);
        r=new JRadioButton("Caesar Cipher");
        r1=new JRadioButton("ROT-13");
        b=new JButton("Encrypt");
        b.setBounds(30,30,20,10);
        b1=new JButton("Decrypt");
        b2=new JButton("Clear");
        t1=new JTextField(50);
        t1.setDisabledTextColor(Color.BLACK);
        t1.setEnabled(false);
        G=new ButtonGroup();
        b2.setBackground(Color.RED);
        panel.add(l);
        panel.add(t);
        G.add(r);
        G.add(r1);
        panel.add(r);
        panel.add(r1);
        panel.add(b);
        panel.add(b1);
        panel.add(l2);
        panel.add(t3);
        panel.add(l1);
        panel.add(t1);
        panel.add(b2);
        add(panel);
        r.addActionListener(this);
        r1.addActionListener(this);
        b1.addActionListener(this);
        b.addActionListener(this);
        b2.addActionListener(this);
        setSize(1000,600);
        setTitle("Encryption-Decryption");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent event){
        if(r.isSelected()){
            t3.setEnabled(true);
            if(event.getSource()==b) {
                try {
                    String text=t.getText();
                    int s = Integer.parseInt(t3.getText());
                    StringBuffer result = new StringBuffer();
                    for (int i = 0; i < text.length(); i++) {
                        char sp=text.charAt(i);
                        char st=' ';
                        if (Character.isUpperCase(text.charAt(i))) {
                            char ch = (char) (((int) text.charAt(i) + s - 65) % 26 + 65);
                            result.append(ch);
                        }
                        else if(sp==st){
                            result.append(st);
                        }
                        else{
                            char ch = (char) (((int) text.charAt(i) + s - 97) % 26 + 97);
                            result.append(ch);
                        }
                    }
                    String rslt = result.toString();
                    t1.setText(rslt);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(panel,"Unknown Symbols encountered","Error",JOptionPane.WARNING_MESSAGE);
                    t1.setText("");
                    t.setText("");
                    t3.setText("");
                }
            }
            if (event.getSource()==b1){
                try{
                    String text=t.getText();
                    int s = Integer.parseInt(t3.getText());
                    StringBuffer result = new StringBuffer();
                    s=26-s;
                    for (int i = 0; i < text.length(); i++) {
                        char sp=text.charAt(i);
                        char st=' ';
                        if (Character.isUpperCase(text.charAt(i))) {
                            char ch = (char) (((int) text.charAt(i) + s - 65) % 26 + 65);
                            result.append(ch);
                        }
                        else if(sp==st){
                            result.append(st);
                        }
                        else{
                            char ch = (char) (((int) text.charAt(i) + s - 97) % 26 + 97);
                            result.append(ch);
                        }
                    }
                    String rslt = result.toString();
                    t1.setText(rslt);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(panel,"Unknown Symbols encountered","Error",JOptionPane.WARNING_MESSAGE);
                    t1.setText("");
                    t.setText("");
                    t3.setText("");
                }
            }
        }
        if(r1.isSelected()){
            t3.setEnabled(false);
            t3.setText("");
            if(event.getSource()==b){
                try{
                    char[] values =t.getText().toCharArray();
                    int temp=0;
                    for (int i = 0; i < values.length; i++) {
                        char letter = values[i];
                        if (letter >= 'a' && letter <= 'z') {
                            if (letter > 'm') {
                                letter -= 13;
                            }
                            else {
                                letter += 13;
                            }
                        }
                        else if (letter >= 'A' && letter <= 'Z') {
                            if (letter > 'M') {
                                letter -= 13;
                            }
                            else {
                                letter += 13;
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(panel,"Invalid Input","Error",JOptionPane.WARNING_MESSAGE);
                            temp=-1;
                            break;
                        }
                        values[i] = letter;
                    }
                    if(temp==-1){
                        t1.setText("");
                        t.setText("");
                    }
                    else{
                        t1.setText(new String(values));
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(panel,"Unknown Symbols encountered","Error",JOptionPane.WARNING_MESSAGE);
                    t1.setText("");
                    t.setText("");
                    t3.setText("");
                }
            }
            if(event.getSource()==b1){
                try{
                    char[] values =t.getText().toCharArray();
                    for (int i = 0; i < values.length; i++) {
                        char letter = values[i];
                        if (letter >= 'a' && letter <= 'z') {

                            if (letter > 'm') {
                                letter -= 13;
                            }
                            else {
                                letter += 13;
                            }
                        }
                        else if (letter >= 'A' && letter <= 'Z') {
                            if (letter > 'M') {
                                letter -= 13;
                            }
                            else {
                                letter += 13;
                            }
                        }
                        values[i] = letter;
                    }
                    t1.setText(new String(values));}
                catch(Exception e){
                    JOptionPane.showMessageDialog(panel,"Unknown Symbols encountered","Error",JOptionPane.WARNING_MESSAGE);
                    t1.setText("");
                    t.setText("");
                    t3.setText("");
                }
            }
        }
        if (event.getSource()==b2){
            t1.setText("");
            t.setText("");
            t3.setText("");
        }
    }
    public static void main(String[] args){
        Encdec e=new Encdec();
    }
}