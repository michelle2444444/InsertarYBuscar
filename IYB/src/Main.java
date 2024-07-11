import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JButton insertarButton = new JButton("Insertar Datos");
        JButton buscarButton = new JButton("Buscar Estudiante");

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insertarFrame = new JFrame("Insertar Datos de Estudiante");
                insertarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                insertarFrame.setContentPane(new InsertarDatos().panel);
                insertarFrame.pack();
                insertarFrame.setLocationRelativeTo(null);
                insertarFrame.setVisible(true);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame buscarFrame = new JFrame("Buscar Estudiante");
                buscarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                buscarFrame.setContentPane(new buscador().panel);
                buscarFrame.pack();
                buscarFrame.setLocationRelativeTo(null);
                buscarFrame.setVisible(true);
            }
        });

        mainPanel.add(insertarButton);
        mainPanel.add(buscarButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


