
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class YearProgressGUI {

    private JProgressBar progressBar;
    private Timer timer;

    public YearProgressGUI() {
        JFrame frame = new JFrame("Year Progress");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setResizable(false);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setBounds(0,150,420,50);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("",Font.PLAIN,16));
        progressBar.setForeground(Color.red);
        progressBar.setBackground(Color.black);

        frame.add(progressBar);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePercentageLabelAndProgressBar();
            }
        });
        timer.start();

        frame.setVisible(true);

        // Calculate the center position of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y); // Set the JFrame location to be in the center of the screen

        frame.setVisible(true);

    }



    private void updatePercentageLabelAndProgressBar() {
        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int totalDaysInYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

        double percentage = (double) dayOfYear / totalDaysInYear * 100;

        progressBar.setString(String.format("Percentage of the year passed: %.2f%%", percentage)); // Set the float value as the progress bar text
        progressBar.setValue((int) percentage);
    }


}
