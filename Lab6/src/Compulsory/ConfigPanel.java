package Compulsory;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner sidesField; // number of sides
    JSpinner radiusField;
    JSpinner strokeField;
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(3);

        JLabel colorLabel = new JLabel("Color type: ");
        JLabel radiusLabel = new JLabel("Radius: ");

        colorCombo = new JComboBox();
        colorCombo.addItem("Random");
        colorCombo.addItem("Black");

        radiusField = new JSpinner(new SpinnerNumberModel(10, 10, 300, 10));
        strokeField = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

        JLabel strokeLabel = new JLabel("Stroke: ");

        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(radiusLabel);
        add(radiusField);
        add(strokeLabel);
        add(strokeField);
        add(colorLabel);
        add(colorCombo);

    }
}
