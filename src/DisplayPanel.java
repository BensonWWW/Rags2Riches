import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener {
    private JButton startButton;
    private JButton backButton;
    private boolean showWelcomeScreen = true;

    public DisplayPanel() {
        setLayout(null); // Using null layout for manual positioning

        // Start button for welcome screen
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setBounds(540, 480, 500, 50);
        startButton.setFont(new Font("Arial", Font.BOLD, 55));
        add(startButton);

        // Back button for investment screen (initially hidden)
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(50, 50, 150, 40);
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setVisible(false);
        add(backButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (showWelcomeScreen) {
            drawWelcomeScreen(g);
        } else {
            drawInvestmentScreen(g);
        }
    }

    private void drawWelcomeScreen(Graphics g) {
        Color green = new Color(0, 153, 0);

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Title
        g.setFont(new Font("Papyrus", Font.BOLD, 85));
        g.setColor(green);
        g.drawString("Welcome to Rags 2 Riches!", 350, 75);

        // Subtitle
        g.setFont(new Font("Papyrus", Font.BOLD, 45));
        g.drawString("An application for stock market enthusiasts and learners", 300, 150);

        // Instruction
        g.setColor(Color.white);
        g.drawString("Click Start to begin your journey of investing!", 380, 400);

        // Show start button and hide back button
        startButton.setVisible(true);
        backButton.setVisible(false);
    }

    private void drawInvestmentScreen(Graphics g) {
        // Background
        g.setColor(new Color(20, 20, 40)); // Dark blue background
        g.fillRect(0, 0, getWidth(), getHeight());

        // Title
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.setColor(Color.WHITE);
        g.drawString("Investment Dashboard", 400, 80);

        // Sample investment options
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("1. Stock Market Simulator", 450, 200);
        g.drawString("2. Portfolio Builder", 450, 250);
        g.drawString("3. Investment Tutorials", 450, 300);
        g.drawString("4. Market Analysis Tools", 450, 350);

        // Hide start button and show back button
        startButton.setVisible(false);
        backButton.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            showWelcomeScreen = false;
        } else if (e.getSource() == backButton) {
            showWelcomeScreen = true;
        }
        repaint();
    }
}