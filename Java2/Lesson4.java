/**
 * Java 2. Lesson 4. Game Tic Tac Toe
 *
 * @author Vvedenskiy Aleksandr
 * @version dated Jul 27, 2017
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
public class Lesson4 {
	 
    JTextArea incoming;
    JTextField outgoing;

    public static void main(String[] args) {
        Lesson4 chat = new Lesson4();
        chat.go();
    }
	
    public void go() {
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(25, 40);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
		incoming.setBackground(Color.lightGray);
		JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        outgoing = new JTextField(35);
		outgoing.setBackground(Color.yellow);
        outgoing.addActionListener(new SendButtonListener());
        JButton sendButton = new JButton("Send");
		sendButton.setBackground(Color.green);
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setBounds(550, 200, 480, 485);
        frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            if (!outgoing.getText().trim().isEmpty()) {
                incoming.append(outgoing.getText() + " \n");
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("chatLOG.txt", true));
                    pw.write(outgoing.getText() + " \n");
                    pw.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
            outgoing.setText("");
        }
    }
 }