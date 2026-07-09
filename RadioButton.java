import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RadioButton extends JFrame {

    private JLabel imageLabel;
    private final String[] pets = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

    public RadioButton() {

        setTitle("Radio Button Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel for radio buttons
        JPanel panel = new JPanel(new GridLayout(5, 1));

        ButtonGroup group = new ButtonGroup();

        imageLabel = new JLabel("", JLabel.CENTER);

        // Create radio buttons
        for (String pet : pets) {

            JRadioButton button = new JRadioButton(pet);

            button.addActionListener(e -> {
                updateImage(pet);
                JOptionPane.showMessageDialog(this,
                        "You selected: " + pet);
            });

            group.add(button);
            panel.add(button);

            // Default selection
            if (pet.equals("Pig")) {
                button.setSelected(true);
                updateImage("Pig");   // Display Pig image immediately
            }
        }

        add(panel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateImage(String pet) {
        // Try resources on classpath first
        String baseName = pet.toLowerCase();
        ImageIcon icon = null;

        // 1) Try classpath resource: /images/<pet>.png
        java.net.URL res = getClass().getResource("/images/" + baseName + ".png");
        if (res != null) {
            icon = new ImageIcon(res);
        }

        // 2) Try files in working dir: images/<pet>.png then .jpg
        if (icon == null) {
            File f = new File("images/" + baseName + ".png");
            if (f.exists()) {
                icon = new ImageIcon(f.getPath());
            } else {
                f = new File("images/" + baseName + ".jpg");
                if (f.exists()) {
                    icon = new ImageIcon(f.getPath());
                }
            }
        }

        // 3) Try file in working dir root: <pet>.png or <pet>.jpg (backwards compatible)
        if (icon == null) {
            File f = new File(baseName + ".png");
            if (f.exists()) {
                icon = new ImageIcon(f.getPath());
            } else {
                f = new File(baseName + ".jpg");
                if (f.exists()) {
                    icon = new ImageIcon(f.getPath());
                }
            }
        }

        // 4) If still null or invalid, generate a placeholder image
        if (icon == null || icon.getIconWidth() == -1) {
            // Create a simple placeholder with the pet name
            int w = 300, h = 200;
            BufferedImage bimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bimg.createGraphics();
            try {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, w, h);
                g.setColor(Color.BLACK);
                g.setFont(g.getFont().deriveFont(24f));
                FontMetrics fm = g.getFontMetrics();
                String text = "Image not found: " + baseName + ".png";
                int tx = (w - fm.stringWidth(text)) / 2;
                int ty = (h - fm.getHeight()) / 2 + fm.getAscent();
                g.drawString(text, Math.max(5, tx), Math.max(20, ty));
            } finally {
                g.dispose();
            }
            imageLabel.setText("");
            imageLabel.setIcon(new ImageIcon(bimg));
        } else {
            imageLabel.setText("");
            imageLabel.setIcon(icon);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButton());
    }
}
