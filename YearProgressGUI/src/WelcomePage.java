import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {

    JFrame frame = new JFrame();
    JButton enterButton = new JButton("Enter");
    JButton cancelButton = new JButton("Cancel");

    WelcomePage() {

        enterButton.setBounds(75, 125, 100, 50);
        enterButton.setFocusable(false);
        enterButton.addActionListener(this);

        cancelButton.setBounds(225, 125, 100, 50);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        frame.add(enterButton);
        frame.add(cancelButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420, 420);
        frame.setLayout(null);

        // Calculate the center position of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y); // Set the JFrame location to be in the center of the screen

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            frame.dispose();
            new YearProgressGUI();
        } else if (e.getSource() == cancelButton) {
            frame.dispose();
        }
    }

}
