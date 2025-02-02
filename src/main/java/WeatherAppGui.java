import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WeatherAppGui extends JFrame {
    private JTextField searchTextField = new JTextField();
    private JButton searchButton = new JButton(loadImage("src\\assets\\search.png"));
    private JLabel weatherConditionImage = new JLabel(loadImage("src\\assets\\rainy.png"));
    private JLabel temperatureText = new JLabel("0°C");
    private JLabel weatherConditionDesc = new JLabel("Nublado");
    private JLabel humidityImage = new JLabel(loadImage("src\\assets\\humidity.png"));
    private JLabel humidityText = new JLabel("<html><b>Umidade</b> 100%</html>");
    private JLabel windSpeedImage = new JLabel(loadImage("src\\assets\\wind.png"));
    private JLabel windSpeedText = new JLabel("<html>Intencidade dos ventos<b></b> 15km/h</html>");


    public WeatherAppGui() {
        super("Previsão do Tempo");
        setupFrame();
        addGuiComponents();

    }
    private void setupFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(600, 800);

        setLocationRelativeTo(null);

        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(new Color(42, 44, 71));
    }

    private void addGuiComponents() {

        searchTextField.setBounds(15, 15, 450, 60);
        searchTextField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        searchTextField.setBackground(new Color(146, 87, 127));
        searchTextField.setForeground(Color.white);
        searchTextField.setFont(defaultFont(25));
        

        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(480, 13, 76, 76);
        searchButton.setBackground(Color.getColor(getName()));
        searchButton.setBorder(null);
        

        weatherConditionImage.setBounds(50, 250 , 450,96);


        temperatureText.setBounds(50, 350, 450, 96);
        temperatureText.setFont(defaultFont(54));
        temperatureText.setForeground(Color.white);
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);

        weatherConditionDesc.setBounds(50,400,450,96);
        weatherConditionDesc.setFont(defaultFont(36));
        weatherConditionDesc.setForeground(Color.white);
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);


        humidityImage.setBounds(0,500,96,96);

        humidityText.setBounds(90,500,96,96);
        humidityText.setForeground(Color.white);
        humidityText.setFont(defaultFont(16));


        windSpeedImage.setBounds(220,500,96,96);
        
    
        windSpeedText.setBounds(310,500,110,96);
        windSpeedText.setForeground(Color.WHITE);
        windSpeedText.setFont(defaultFont(16));



        add(searchTextField);
        add(searchButton);
        add(weatherConditionImage);
        add(temperatureText);
        add(weatherConditionDesc);
        add(humidityImage);
        add(humidityText);
        add(windSpeedImage);
        add(windSpeedText);

    }
    private Font defaultFont(int size){
        Font defaultFont = new Font("Roboto", Font.PLAIN, size);
        return defaultFont;
    }

    private ImageIcon loadImage(String resourcePath) {
        try {
            BufferedImage image = ImageIO.read(new File(resourcePath));

            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(":(");
        return null;

    }
}
