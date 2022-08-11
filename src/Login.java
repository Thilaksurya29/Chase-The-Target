import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel userNameL,passwordL,title,newUserL;
    JCheckBox showPassword;
    JTextField userName;
    JPasswordField password;
    JButton login,createAccount,clear;
    Login(){
        setTitle("Login");
        getContentPane().setBackground(Color.YELLOW);
        Font font3 = new Font("Cambria", Font.BOLD, 14);
        title = new JLabel("Login");
        userNameL = new JLabel("Username");
        passwordL = new JLabel("Password");
        newUserL = new JLabel("New Player?");

        showPassword = new JCheckBox("Show Password");

        userName = new JTextField();
        password = new JPasswordField();

        login = new JButton("Login");
        createAccount = new JButton("Create New Account");
        clear = new JButton("Clear");

        title.setBounds(180,20,500,20);
        title.setFont(new Font("Algerian", Font.BOLD, 24));
        userNameL.setBounds(100,70,500,20);
        userName.setBounds(100,100,200,20);
        userNameL.setFont(font3);
        passwordL.setBounds(100,160,500,20);
        passwordL.setFont(font3);
        password.setBounds(100,190,200,20);
        showPassword.setBounds(350,190,160,20);
        showPassword.setFont(font3);
        login.setBounds(100,270,120,30);
        clear.setBounds(250,270,120,30);
        newUserL.setBounds(100,350,150,30);
        newUserL.setFont(font3);
        createAccount.setBounds(230,350,150,30);
        showPassword.addActionListener(this);
        clear.addActionListener(this);
        login.addActionListener(this);
        createAccount.addActionListener(this);

        add(title);
        add(userNameL);
        add(userName);
        add(passwordL);
        add(password);
        add(showPassword);
        add(login);
        add(clear);
        add(newUserL);
        add(createAccount);

        setSize(550, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Clear")){
            userName.setText("");
            password.setText("");
            userNameL.setText("Username");
            userNameL.setForeground(Color.BLACK);
            passwordL.setText("Password");
            passwordL.setForeground(Color.BLACK);
        }
        else if(e.getActionCommand().equals("Show Password")){
            if(showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('\u2022');
            }
        }
        else if(e.getActionCommand().equals("Create New Account")){
            userNameL.setText("Username");
            userNameL.setForeground(Color.BLACK);
            passwordL.setText("Password");
            passwordL.setForeground(Color.BLACK);
            title.setText("Register");
            login.setText("Register");
            createAccount.setText("Login");
            newUserL.setText("Already Register?");
        }
        else if(e.getActionCommand().equals("Login")) {
            title.setText("Login");
            login.setText("Login");
            createAccount.setText("Create New Account");
            userNameL.setText("Username");
            userNameL.setForeground(Color.BLACK);
            passwordL.setText("Password");
            passwordL.setForeground(Color.BLACK);
            newUserL.setText("New Player?");

            String name = userName.getText();
            String pwd = new String(password.getPassword());

            if(name.equals("") || pwd.equals("")) {
                if(name.equals("")) {
                    userNameL.setText("Username is required");
                    userNameL.setForeground(Color.RED);
                }
                if(pwd.equals("")) {
                    passwordL.setText("Password is required");
                    passwordL.setForeground(Color.RED);
                }
            } else {
                Player player = new Player(name, pwd);
                int [] log = Details.readDetails(player);
                if(log[0]==0 || log[1]==0) {
                    if(log[0] == 0) {
                        userNameL.setText("Username not found!");
                        userNameL.setForeground(Color.RED);
                    }
                    if(log[1] == 0) {
                        passwordL.setText("Invalid password");
                        passwordL.setForeground(Color.RED);
                    }
                } else {
                    setVisible(false);
                    new Game(player.username, log[2],log[3]);
                }
            }
        }
        else if(e.getActionCommand().equals("Register")){
            String name = userName.getText();
            String pwd = new String(password.getPassword());
            userNameL.setText("Username");
            passwordL.setText("Password");
            if(name.equals("")){
                userNameL.setText("User Name is required");
                userNameL.setForeground(Color.red);
            }
            if(pwd.equals("")){
                passwordL.setText("Password is required");
                passwordL.setForeground(Color.red);
            }
            if(!name.equals("")&&!pwd.equals("")){
                Player newPlayer = new Player(name,pwd);
                if(!Details.writeDetails(newPlayer)){
                    userNameL.setText("Player already registered! Try another");
                    userNameL.setForeground(Color.red);
                }else{
                    setVisible(false);
                    Game game = new Game(newPlayer.username, newPlayer.win, newPlayer.loss);
                }
            }
        }
    }
    public static void main(String[] args){
        Login obj = new Login();
    }
}