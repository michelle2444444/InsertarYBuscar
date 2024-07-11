import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class buscador {
    public JButton button1;
    public JTextField entrada;
    public JPanel panel;
    public JLabel nombreJ;
    public JLabel cedulaLabel;
    public JLabel b1Label;
    public JLabel b2Label;
    public JLabel promedioLabel;

    public buscador() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String user = "root";
                String password = "172843";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "SELECT * FROM estudiantes WHERE Cedula = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, entrada.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("NOMBRE");
                        String cedula = resultSet.getString("Cedula");
                        double b1 = resultSet.getDouble("b1");
                        double b2 = resultSet.getDouble("b2");
                        double promedio = (b1 + b2) / 2;

                        nombreJ.setText("Nombre: " + nombre);
                        cedulaLabel.setText("Cédula: " + cedula);
                        b1Label.setText("Nota B1: " + b1);
                        b2Label.setText("Nota B2: " + b2);
                        promedioLabel.setText("Promedio: " + promedio);
                    } else {
                        nombreJ.setText("No encontrado");
                        cedulaLabel.setText("");
                        b1Label.setText("");
                        b2Label.setText("");
                        promedioLabel.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    nombreJ.setText("Error al conectar a la base de datos");
                    cedulaLabel.setText("");
                    b1Label.setText("");
                    b2Label.setText("");
                    promedioLabel.setText("");
                }
            }
        });
    }
}
