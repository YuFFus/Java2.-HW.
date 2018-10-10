package Java_2.Lessons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class ChartWindow extends JFrame {

    JTextField jtf;
    JLabel[] jlbl;
    JButton jbtn;
    JPanel jpnl1, jpnl2, jpnl3;
    JRadioButton jrbtn1, jrbtn2;
    ButtonGroup bg;
    boolean remoteGuestMsg;
    ChartMsg[] chartMsgs;
    Border solidBorder;
    String activeTalkerName;

    public ChartWindow() {
        setTitle ("YuFFus messenger");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 300);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        jbtn = new JButton("Sent");
        jtf = new JTextField(20);
        jlbl = new JLabel[10];
        for (int i = 0; i<10; i++){
            jlbl[i] = new JLabel(" ");
            jlbl[i].setPreferredSize(new Dimension(250, 20));
        }
        bg = new ButtonGroup();
        jrbtn1 = new JRadioButton("Remote guest");
        jrbtn2 = new JRadioButton("You");
        bg.add(jrbtn1);
        bg.add(jrbtn2);

        jpnl1 = new JPanel();
        jpnl2 = new JPanel();
        jpnl3 = new JPanel();

        jpnl1.setLayout(new BoxLayout(jpnl1, BoxLayout.Y_AXIS));
        for (int i = 9; i >= 0; i--){
            jpnl1.add (jlbl[i]);

        }

        jpnl2.setLayout(new FlowLayout());
        jpnl2.add (jtf); // добавление кнопки в панель
        jpnl2.add (jbtn); // добавление текстового поля в панель

        jpnl3.setLayout(new FlowLayout());
        jpnl3.add(jrbtn1);
        jpnl3.add(jrbtn2);

        getContentPane().add (jpnl1);
        getContentPane().add(jpnl2);
        getContentPane().add(jpnl3);

        setVisible (true);

        chartMsgs = new ChartMsg[10];
        for (int i = 0; i<10; i++){
            chartMsgs[i] = new ChartMsg(" ", " ", false);
        }

        jbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                moveUp(chartMsgs);
                chartMsgs[0].str = jtf.getText();
                chartMsgs[0].chartSideActive = remoteGuestMsg;
                chartMsgs[0].talkerName = activeTalkerName;
                jtf.setText("");
                msgShow(chartMsgs);
            }
        });

        jrbtn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                remoteGuestMsg = true;
                activeTalkerName = "RemoteGuest: ";

            }
        });

        jrbtn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                remoteGuestMsg = false;
                activeTalkerName = "You: ";
            }
        });
    }

    void moveUp (ChartMsg[] chartMsgs){
        for (int i = (chartMsgs.length - 1); i > 0; i--){
            chartMsgs[i].str = chartMsgs[i-1].str;
            chartMsgs[i].chartSideActive = chartMsgs[i-1].chartSideActive;
            chartMsgs[i].talkerName = chartMsgs[i-1].talkerName;
        }
    }

    void msgShow(ChartMsg[] chartMsgs){
        for (int i = 0; i < chartMsgs.length; i++){
            if (chartMsgs[i].chartSideActive){
                jlbl[i].setAlignmentX(JComponent.RIGHT_ALIGNMENT);
            }
            else {
                jlbl[i].setAlignmentX(JComponent.LEFT_ALIGNMENT);
            }
            jlbl[i].setText(chartMsgs[i].talkerName + chartMsgs[i].str);
        }
    }
}