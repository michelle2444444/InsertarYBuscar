import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InsertarDatos {
    public JPanel panel;
    public JTextField nombreField;
    public JTextField cedulaField;
    public JTextField b1Field;
    public JTextField b2Field;
    public JButton insertarButton;

    public InsertarDatos() {
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String user = "root";
                String password = "172843";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "INSERT INTO estudiantes (NOMBRE, Cedula, b1, b2) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, nombreField.getText());
                    preparedStatement.setString(2, cedulaField.getText());
                    preparedStatement.setDouble(3, Double.parseDouble(b1Field.getText()));
                    preparedStatement.setDouble(4, Double.parseDouble(b2Field.getText()));
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar datos");
                }
            }
        });
    }
}
