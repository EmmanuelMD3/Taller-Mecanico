/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package interfaz;

import dao.PropietarioDAO;
import dao.VehiculoDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import modelo.Propietario;
import modelo.Vehiculo;

/**
 *
 * @author chemo
 */
public class VtnVehiculos extends javax.swing.JInternalFrame
{

    /**
     * Creates new form VtnDueño
     */
    public VtnVehiculos()
    {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtRutaImagen = new javax.swing.JTextField();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        placaJT = new javax.swing.JTextField();
        lblImagenVehiculo = new javax.swing.JLabel();
        imagenPanel = new javax.swing.JPanel();
        marcaJT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        modeloJT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        propietarioCB = new javax.swing.JComboBox<>();
        anioCB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        txtRutaImagen.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(1150, 520));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener()
        {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tablaVehiculos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "ID VEHICULO", "PLACA ", "MARCA", "MODELO", "AÑO", "ID PROPIETARIO"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVehiculos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 750, 390));

        buscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                buscarMouseClicked(evt);
            }
        });
        buscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 560, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda-de-lupa.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setText("VEHICULOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("INFORMACION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Placa:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, -1, -1));

        placaJT.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(placaJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 150, -1));

        lblImagenVehiculo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblImagenVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carpeta.png"))); // NOI18N
        lblImagenVehiculo.setText("Imagen:");
        lblImagenVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImagenVehiculo.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblImagenVehiculoMouseClicked(evt);
            }
        });
        getContentPane().add(lblImagenVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, -1, -1));

        imagenPanel.setEnabled(false);
        getContentPane().add(imagenPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 360, 190));

        marcaJT.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        marcaJT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                marcaJTActionPerformed(evt);
            }
        });
        getContentPane().add(marcaJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 180, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MODIFICAR");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 110, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bote-de-basura.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, 40));

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ALTA");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 110, 30));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CANCELAR");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 110, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Marca:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        modeloJT.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        modeloJT.setToolTipText("");
        modeloJT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                modeloJTActionPerformed(evt);
            }
        });
        getContentPane().add(modeloJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 360, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("Modelo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Año:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        propietarioCB.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(propietarioCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, 250, -1));

        anioCB.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        anioCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        getContentPane().add(anioCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 80, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Propietario:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buscarMouseClicked
    {//GEN-HEADEREND:event_buscarMouseClicked

    }//GEN-LAST:event_buscarMouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscarActionPerformed
    {//GEN-HEADEREND:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void marcaJTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_marcaJTActionPerformed
    {//GEN-HEADEREND:event_marcaJTActionPerformed

    }//GEN-LAST:event_marcaJTActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        String placa = placaJT.getText();
        String modelo = modeloJT.getText();
        String marca = marcaJT.getText();

        if (placa.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "La placa no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "El modelo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!placa.matches("^[A-Z]{3}-?\\d{3,4}|[A-Z]{2}-?\\d{2}-?[A-Z]{2}|[A-Z]{2}-?\\d{4}|\\d{3}-?[A-Z]{3}|[A-Z]\\d{6}$"))
        {
            JOptionPane.showMessageDialog(this, "Placa inválida. Los formatos aceptados son:\n"
                    + "- AAA-999 (antiguo)\n"
                    + "- AA-99-AA (nuevo)\n"
                    + "- AA-9999 (nuevo)\n"
                    + "- 999-AAA (nuevo)\n"
                    + "- A999999 (nuevo)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int anio = Integer.parseInt(anioCB.getSelectedItem().toString());

        String nombreSeleccionado = (String) propietarioCB.getSelectedItem();

        PropietarioDAO propietarioDAO = new PropietarioDAO();
        int idPropietario = propietarioDAO.obtenerIdPorNombre(nombreSeleccionado);

        if (idPropietario == -1)
        {
            JOptionPane.showMessageDialog(this, "No se encontró el propietario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String rutaImagen = txtRutaImagen.getText();
        if (rutaImagen.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vehiculo nuevoVehiculo = new Vehiculo(0, placa, marca, modelo, anio, idPropietario, rutaImagen);

        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        boolean exito = vehiculoDAO.insertarVehiculo(nuevoVehiculo);

        if (exito)
        {
            JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            llenarTablaVehiculos();
        } else
        {
            JOptionPane.showMessageDialog(this, "Error al agregar el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void modeloJTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_modeloJTActionPerformed
    {//GEN-HEADEREND:event_modeloJTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloJTActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameOpened
    {//GEN-HEADEREND:event_formInternalFrameOpened
        llenarComboPropietarios(propietarioCB);
        llenarTablaVehiculos();
    }//GEN-LAST:event_formInternalFrameOpened

    private void lblImagenVehiculoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblImagenVehiculoMouseClicked
    {//GEN-HEADEREND:event_lblImagenVehiculoMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen del vehículo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION)
        {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String rutaImagen = archivoSeleccionado.getAbsolutePath();

            // Cargar la imagen en el panel 'imagen' que has definido en NetBeans
            mostrarImagenEnPanel(archivoSeleccionado);

            // Guardar la ruta de la imagen en el JTextField (si lo necesitas)
            txtRutaImagen.setText(rutaImagen);
        }
    }//GEN-LAST:event_lblImagenVehiculoMouseClicked

    private void mostrarImagenEnPanel(File archivoImagen)
    {
        try
        {
            // Leer la imagen del archivo seleccionado
            Image imagen = ImageIO.read(archivoImagen);

            // Redimensionar la imagen al tamaño del panel
            imagen = imagen.getScaledInstance(imagenPanel.getWidth(), imagenPanel.getHeight(), Image.SCALE_SMOOTH);

            // Crear un ImageIcon con la imagen
            ImageIcon icono = new ImageIcon(imagen);

            // Mostrar la imagen en el panel 'imagen'
            Graphics g = imagenPanel.getGraphics();
            g.drawImage(imagen, 0, 0, imagenPanel.getWidth(), imagenPanel.getHeight(), null);
        } catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarTablaVehiculos()
    {
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculos.getModel();
        modelo.setRowCount(0);

        List<modelo.Vehiculo> vehiculos = VehiculoDAO.listarVehiculos();

        for (modelo.Vehiculo vehiculo : vehiculos)
        {
            modelo.addRow(new Object[]
            {
                vehiculo.getId_vehiculo(),
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAño(),
                vehiculo.getId_propietario(),
                vehiculo.getRutaImagen()
            });
        }
    }

    public void llenarComboPropietarios(JComboBox<String> comboPropietarios)
    {
        VehiculoDAO vehiculosDAO = new VehiculoDAO();
        List<Propietario> listaPropietarios = vehiculosDAO.obtenerTodosLosPropietarios();

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Seleccione un propietario");

        for (Propietario propietario : listaPropietarios)
        {
            modelo.addElement(propietario.getNombre());
        }
        comboPropietarios.setModel(modelo);
    }

//    private String guardarImagen(File archivoImagen)
//    {
//        String rutaDestino = "imagenes_vehiculos/" + archivoImagen.getName();
//        File destino = new File(rutaDestino);
//
//        try
//        {
//            Files.copy(archivoImagen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            return rutaDestino;
//        } catch (IOException e)
//        {
//            JOptionPane.showMessageDialog(this, "Error al guardar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//    }
//
//    private File seleccionarImagen()
//    {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
//
//        int opcion = fileChooser.showOpenDialog(this);
//        if (opcion == JFileChooser.APPROVE_OPTION)
//        {
//            return fileChooser.getSelectedFile();
//        }
//        return null;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anioCB;
    private javax.swing.JTextField buscar;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenVehiculo;
    private javax.swing.JTextField marcaJT;
    private javax.swing.JTextField modeloJT;
    private javax.swing.JTextField placaJT;
    private javax.swing.JComboBox<String> propietarioCB;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextField txtRutaImagen;
    // End of variables declaration//GEN-END:variables
}
