import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class tugas3 extends JFrame {
    BorderLayout borderLayout = new BorderLayout();
    JLabel labelSignUp = new JLabel("SIGN UP");
    JLabel labelLogin = new JLabel("LOGIN");
    JLabel labelFullName = new JLabel("Full name");
    JTextField textFieldFullName = new JTextField(20);
    JLabel labelEmail = new JLabel("Email");
    JTextField textFieldEmail = new JTextField(20);
    JLabel labelPassword = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();
    JLabel labelHaveAccount = new JLabel("I've an account");
    JLabel labelDontHaveAccount = new JLabel("I don't have an account");
    JButton buttonLogin = new JButton("Login");
    JButton buttonSignup = new JButton("Sign Up");
    JButton buttonSwitchToLogin = new JButton("Login");
    JButton buttonSwitchToSignup = new JButton("Sign Up");

    public tugas3()
    {
        super("Authentication");
        setLayout(borderLayout); //Border Frame (Utama)
        displaySignUpPage();
    }

    private void displaySignUpPage() {
        getContentPane().removeAll();
        //Panel atas
        JPanel topPanel = new JPanel(); 
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); //Flow Layout agar center

        labelSignUp.setFont(new Font("Arial", Font.BOLD, 24)); 
        topPanel.add(labelSignUp);

        add(topPanel, BorderLayout.NORTH); //Masukkan Top Panel ke Layout frame (layout utama)

        //Panel tengah
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new BoxLayout(CenterPanel, BoxLayout.Y_AXIS));
        
        ButtonHandler1 signUpHandler = new ButtonHandler1();
        buttonSignup.addActionListener(signUpHandler);

        CenterPanel.add(labelFullName);
        CenterPanel.add(textFieldFullName);
        CenterPanel.add(labelEmail);
        CenterPanel.add(textFieldEmail);
        CenterPanel.add(labelPassword);
        CenterPanel.add(passwordField);
        CenterPanel.add(buttonSignup);

        add(CenterPanel, BorderLayout.CENTER);

        //Panel bawah
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        ButtonHandler2 haveAccountHandler = new ButtonHandler2();
        buttonSwitchToLogin.addActionListener(haveAccountHandler);

        bottomPanel.add(labelHaveAccount);
        bottomPanel.add(buttonSwitchToLogin);

        add(bottomPanel, BorderLayout.SOUTH);

        revalidate(); //refresh frame
    }

    private class ButtonHandler1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, "Selamat Datang!", "App Jago", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); //Langsung close
        }
    }

    public void displayLoginPage() {
        getContentPane().removeAll();
        //Panel atas
        JPanel topPanel = new JPanel(); 
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); //Flow Layout agar center

        labelLogin.setFont(new Font("Arial", Font.BOLD, 24)); 
        topPanel.add(labelLogin);

        add(topPanel, BorderLayout.NORTH); //Masukkan Top Panel ke Layout frame (layout utama)

        //Panel tengah
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new BoxLayout(CenterPanel, BoxLayout.Y_AXIS));
        
        ButtonHandler1 loginHandler = new ButtonHandler1();
        buttonLogin.addActionListener(loginHandler);

        CenterPanel.add(labelEmail);
        CenterPanel.add(textFieldEmail);
        CenterPanel.add(labelPassword);
        CenterPanel.add(passwordField);
        CenterPanel.add(buttonLogin);

        add(CenterPanel, BorderLayout.CENTER);

        //Panel bawah
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        ButtonHandler3 dontHaveAccountHandler = new ButtonHandler3();
        buttonSwitchToSignup.addActionListener(dontHaveAccountHandler);

        bottomPanel.add(labelDontHaveAccount);
        bottomPanel.add(buttonSwitchToSignup);

        add(bottomPanel, BorderLayout.SOUTH);

        revalidate();
    }

    private class ButtonHandler2 implements ActionListener //Mengganti frame dengan tampilan login
    {
        public void actionPerformed(ActionEvent event){
            displayLoginPage();
        }
    }

    private class ButtonHandler3 implements ActionListener //Mengganti frame dengan tampilan signup
    {
        public void actionPerformed(ActionEvent event){
            displaySignUpPage();
        }
    }
}

//Frame utama: BorderLayout
//Panel atas: FlowLayout
//Panel tengah: BoxLayout
//Panel bawah: FlowLayout