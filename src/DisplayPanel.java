import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DisplayPanel extends JPanel implements ActionListener {
    private final Font titleFont = new Font("Arial", Font.BOLD, 36);
    private final Font subtitleFont = new Font("Arial", Font.PLAIN, 14);
    private final String title = "Rags 2 Riches";
    private final String subtitle = "an application for stock market enthusiasts and aspiring learners";
    private Image backgroundImage;
    private JButton demoButton;
    private JTextField inputField;
    private float hueShift = 0f;

    public DisplayPanel() {
        setLayout(new java.awt.BorderLayout());
        setBackground(Color.BLACK);

        // Load background image if available
        try {
            backgroundImage = ImageIO.read(new File("background.jpg"));
        } catch (IOException e) {
            backgroundImage = null;
        }

        // Create components
        demoButton = new JButton("Get Started");
        demoButton.addActionListener(this);
        demoButton.setForeground(Color.WHITE);
        demoButton.setBackground(new Color(0, 100, 0));

        inputField = new JTextField(20);
        inputField.setHorizontalAlignment(JTextField.CENTER);

        // Add components to panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.add(inputField);
        bottomPanel.add(demoButton);

        add(bottomPanel, java.awt.BorderLayout.SOUTH);

        // Animation timer
        new javax.swing.Timer(50, this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background image or solid color
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // Calculate center positions
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 3;

        // Draw title with animated color
        g.setFont(titleFont);
        g.setColor(Color.getHSBColor(hueShift, 0.9f, 0.9f));
        int titleWidth = g.getFontMetrics().stringWidth(title);
        g.drawString(title, centerX - titleWidth/2, centerY);

        // Draw subtitle
        g.setFont(subtitleFont);
        g.setColor(new Color(150, 255, 150));
        int subtitleWidth = g.getFontMetrics().stringWidth(subtitle);
        g.drawString(subtitle, centerX - subtitleWidth/2, centerY + 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == demoButton) {
            String input = inputField.getText();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Welcome " + (input.isEmpty() ? "to Rags 2 Riches!" : input + "!"));
        } else {
            // Animation update
            hueShift += 0.01f;
            if (hueShift > 1f) hueShift = 0f;
            repaint();
        }
    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new java.awt.Dimension(600, 400);
//    }
}
