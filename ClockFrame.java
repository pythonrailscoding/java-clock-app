import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame implements ActionListener {
    SimpleDateFormat simpleDateFormat;
    JLabel timeLabel;
    String currentTime;
    static boolean running = true;
    String day;
    JLabel dayLabel;
    SimpleDateFormat dayFormat;
    JLabel dateLabel;
    String date;
    SimpleDateFormat dateFormat;
    JButton exitButton;

    ClockFrame() {
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(400, 50));
        exitButton.setFont(new Font("Helvetica", Font.BOLD, 15));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");

        timeLabel = new JLabel("",SwingConstants.CENTER);
        currentTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(currentTime);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        timeLabel.setPreferredSize(new Dimension(400, 100));

        dayLabel = new JLabel("", SwingConstants.CENTER);
        dayLabel.setFont(new Font("Helvetica", Font.BOLD, 35));
        dayLabel.setPreferredSize(new Dimension(450, 50));

        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Ink Free", Font.BOLD, 30));
        dateLabel.setPreferredSize(new Dimension(450, 50));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(450, 320));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(exitButton);

        updateTimeAtRegularIntervals();
    }
    public void updateTimeAtRegularIntervals() {
        while (running) {
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            currentTime = simpleDateFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(currentTime);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton){
            System.exit(0);
        }
    }
}
