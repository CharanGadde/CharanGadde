import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AlarmClock {
    private JFrame frame;
    private JComboBox<String> hourComboBox;
    private JComboBox<String> minuteComboBox;
    private JComboBox<String> secondComboBox;
    private ScheduledExecutorService scheduler;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AlarmClock window = new AlarmClock();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AlarmClock() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JLabel titleLabel = new JLabel("Alarm Clock");
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(titleLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel setTimeLabel = new JLabel("Set Time");
        setTimeLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        panel.add(setTimeLabel);

        // Initialize hour combo box
        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }
        hourComboBox = new JComboBox<>(hours);
        panel.add(hourComboBox);

        // Initialize minute combo box
        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) {
            minutes[i] = String.format("%02d", i);
        }
        minuteComboBox = new JComboBox<>(minutes);
        panel.add(minuteComboBox);

        // Initialize second combo box
        String[] seconds = new String[60];
        for (int i = 0; i < 60; i++) {
            seconds[i] = String.format("%02d", i);
        }
        secondComboBox = new JComboBox<>(seconds);
        panel.add(secondComboBox);

        // Set alarm button
        JButton setAlarmButton = new JButton("Set Alarm");
        setAlarmButton.setFont(new Font("Helvetica", Font.PLAIN, 15));
        setAlarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setAlarm();
            }
        });
        frame.getContentPane().add(setAlarmButton, BorderLayout.SOUTH);

        // Handle window closing
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (scheduler != null && !scheduler.isShutdown()) {
                    scheduler.shutdown();
                }
                System.exit(0);
            }
        });
    }

    private void setAlarm() {
        String hour = (String) hourComboBox.getSelectedItem();
        String minute = (String) minuteComboBox.getSelectedItem();
        String second = (String) secondComboBox.getSelectedItem();

        String alarmTime = hour + ":" + minute + ":" + second;
        System.out.println("Alarm set for: " + alarmTime);

        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(currentTime + " " + alarmTime);

            if (currentTime.equals(alarmTime)) {
                System.out.println("Time to Wake up");
                playSound("sound.wav");
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
}
