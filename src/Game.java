import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Game extends JFrame implements ActionListener{
    static int sw=0,sl=0;
    static String uN;
    int u_s=0;
    JLabel meL, aiL, me_scoreL, targetL,tL;
    JTextField me, ai, me_score, target;
    JButton zero,one,two,three,four,five,six,logout,stats,rules;


    private static class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }


    Game(String userName, int win, int loss){
        Font font4 = new Font("Algerian", Font.BOLD, 44);
        String t = "CHASE THE TARGET";
        setTitle(userName + "'s CHASE THE TARGET");
        getContentPane().setBackground(Color.YELLOW);
        sw = win;
        sl = loss;
        uN = userName;

        tL = new JLabel("CHASE THE TARGET");
        tL.setFont(font4);
        tL.setBounds(30,20,500,100);
        tL.setForeground (Color.blue);
        meL = new JLabel("YOU");
        meL.setBounds(80,120,240,20);
        meL.setForeground (Color.blue);
        me_scoreL = new JLabel("YOUR SCORE");
        me_scoreL.setBounds(60,350,240,20);
        me_scoreL.setForeground (Color.blue);
        aiL = new JLabel("COMPUTER");
        aiL.setBounds(390,120,240,20);
        aiL.setForeground (Color.red);
        targetL = new JLabel("TARGET");
        targetL.setBounds(400,350,240,20);
        targetL.setForeground (Color.red);

        Font font1 = new Font("Cambria", Font.BOLD, 40);;
        Font font2 = new Font("Cambria", Font.BOLD, 30);
        Font font3 = new Font("Cambria", Font.BOLD, 20);
        me = new JTextField();
        me.setBounds(20,145,150,30);
        me.setBorder(new LineBorder(Color.blue,1));
        me.setFont(font2);
        me.setEnabled(false);
        me.setDisabledTextColor(Color.BLACK);
        me.setHorizontalAlignment(JTextField.CENTER);
        me_score = new JTextField();
        me_score.setBounds(50,390,100,100);
        me_score.setBorder(new LineBorder(Color.blue,1));
        me_score.setFont(font1);
        me_score.setText(Integer.toString(0));
        me_score.setEnabled(false);
        me_score.setDisabledTextColor(Color.BLACK);
        me_score.setHorizontalAlignment(JTextField.CENTER);
        ai = new JTextField();
        ai.setBounds(350,145,150,30);
        ai.setBorder(new LineBorder(Color.red,1));
        ai.setEnabled(false);
        ai.setDisabledTextColor(Color.BLACK);
        ai.setFont(font2);
        ai.setHorizontalAlignment(JTextField.CENTER);
        target = new JTextField();
        target.setBounds(380,390,100,100);
        target.setBorder(new LineBorder(Color.blue,1));
        target.setEnabled(false);
        target.setDisabledTextColor(Color.BLACK);
        target.setFont(font1);
        target.setHorizontalAlignment(JTextField.CENTER);
        int rdm = (int)(Math.random() * 40) + 20;
        target.setText(Integer.toString(rdm));

        stats = new JButton("Stats");
        stats.setBounds(40,580,100,30);
        stats.addActionListener(this);
        rules = new JButton("Rules");
        rules.setBounds(200,580, 100,30);
        rules.addActionListener(this);
        logout = new JButton("Logout");
        logout.setBounds(360,580,120,30);
        logout.addActionListener(this);
        zero = new JButton("0");
        zero.setFont(font3);
        zero.setBounds(20,250,60,30);
        zero.setBorder(new RoundedBorder(12));
        zero.addActionListener(this);
        one = new JButton("1");
        one.setFont(font3);
        one.setBounds(90,250,60,30);
        one.setBorder(new RoundedBorder(12));
        one.addActionListener(this);
        two = new JButton("2");
        two.setBounds(160,250,60,30);
        two.setBorder(new RoundedBorder(12));
        two.addActionListener(this);
        two.setFont(font3);
        three= new JButton("3");
        three.setBounds(230,250,60,30);
        three.setBorder(new RoundedBorder(12));
        three.addActionListener(this);
        three.setFont(font3);
        four = new JButton("4");
        four.setBounds(300,250,60,30);
        four.setBorder(new RoundedBorder(12));
        four.addActionListener(this);
        four.setFont(font3);
        five = new JButton("5");
        five.setBounds(370,250,60,30);
        five.setBorder(new RoundedBorder(12));
        five.addActionListener(this);
        five.setFont(font3);
        six = new JButton("6");
        six.setBounds(440,250,60,30);
        six.setBorder(new RoundedBorder(12));
        six.addActionListener(this);
        six.setFont(font3);

        add(tL);
        add(me);
        add(meL);
        add(ai);
        add(aiL);
        add(me_score);
        add(me_scoreL);
        add(target);
        add(targetL);
        add(zero);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(stats);
        add(rules);
        add(logout);

        setSize(580, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(250,20);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Stats")) {
            String stat = "STATS:\nPLAYER: " + uN + "\n1.Number of wins:  " + sw + "\n2.Number of loss:  " + sl;
            JOptionPane.showMessageDialog(this,stat);
        }
        if(e.getActionCommand().equals("Rules")) {
            String rule = "RULES:\n1)The aim of the game is to chase the target score generated by computer." +
                    "\n2)Select any one of the numbers below. The computer also selects a number randomly." +
                    "\n3)If the number selected by you and computer are same, then you lose." +
                    "\n4)If the number selected by you and computer differs, then the number selected by you is added to your score." +
                    "\n5)The game finishes either by reaching the target or by getting out." +
                    "\n6)Click on the stats to view your overall win/loss stats.";
            JOptionPane.showMessageDialog(this,rule);
        }
        if(e.getActionCommand().equals("0")) {
            me.setText("0");
            ai_job();
        }
        if(e.getActionCommand().equals("1")) {
            me.setText("1");
            ai_job();
        }
        if(e.getActionCommand().equals("2")) {
            me.setText("2");
            ai_job();
        }
        if(e.getActionCommand().equals("3")) {
            me.setText("3");
            ai_job();
        }
        if(e.getActionCommand().equals("4")) {
            me.setText("4");
            ai_job();
        }
        if(e.getActionCommand().equals("5")) {
            me.setText("5");
            ai_job();
        }
        if(e.getActionCommand().equals("6")) {
            me.setText("6");
            ai_job();
        }
        if(e.getActionCommand().equals("Logout")){
            setVisible(false);
            new Login();
        }
    }


    void ai_job(){
        int rdm = (int)(Math.random() * 7) + 0;
        ai.setText(Integer.toString(rdm));
        int o1 = Integer.parseInt(me.getText());
        int o2 = Integer.parseInt(ai.getText());
        int a_s = Integer.parseInt(target.getText());
        if(o1==0 && o2!=0){
            o1=o2;
            o2=0;
        }
        if(o1==o2){
            int x = Integer.parseInt(me_score.getText());
            String output = "SCORE: " + x + "\n";
            if(x<a_s){
                output += "YOU LOSE";
                sl++;
                Details.updateScore(uN,sw,sl);
            }
            else
            {
                output += "YOU WON";
                sw++;
                Details.updateScore(uN,sw,sl);
            }
            JOptionPane.showMessageDialog(this,output);
            reset();
        }
        else{
            u_s+=o1;
            me_score.setText(Integer.toString(u_s));
        }
        if(u_s>=a_s){
            JOptionPane.showMessageDialog(this,"SCORE: "+u_s+"\nYOU WON");
            sw++;
            Details.updateScore(uN,sw,sl);
            reset();
        }
    }

    void reset(){
        int rdm = (int)(Math.random() * 40) + 20;
        target.setText(Integer.toString(rdm));
        me.setText("0");
        me_score.setText("0");
        ai.setText("0");
        u_s=0;

    }
}
