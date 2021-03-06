/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import com.placeholder.PlaceHolder;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author juan.muro
 */
public class AltaOrden extends javax.swing.JFrame {
    private Orden orden;
    /**
     * Creates new form AltaOrden
     */
    public AltaOrden() {
        initComponents();
        initPlaceHolders();
        this.orden = null;
    }
    
    public AltaOrden(Orden orden){
        initComponents();
        this.orden = orden;
        txtAlta.setText("Actualizar orden");
        txtContrapartida.setText(orden.getContrapartida());
        txtBICContrapartida.setText(orden.getBICContrapartida());
        cbSentido.setSelectedItem(orden.getSentido());
        txtImporte.setText(String.valueOf(orden.getImporte()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(orden.getFechaValor());
        dateChooserPanel1.setCurrent(cal);
        txtDivisa.setText(orden.getDivisa());
        txtCorrespPropio.setText(orden.getCorresponsalPropio());
        txtCuentaCorrespPropio.setText(orden.getCuentaCorresponsalPropio());
        txtCorrespAjeno.setText(orden.getCorresponsalAjeno());
        txtCuentaCorrespAjeno.setText(orden.getCuentaCorresponsalAjeno());
        cbTipoMensaje.setSelectedItem(orden.getTipoMensaje());        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtContrapartida = new javax.swing.JTextField();
        txtBICContrapartida = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        txtCorrespPropio = new javax.swing.JTextField();
        txtCuentaCorrespPropio = new javax.swing.JTextField();
        txtCorrespAjeno = new javax.swing.JTextField();
        txtCuentaCorrespAjeno = new javax.swing.JTextField();
        cbSentido = new javax.swing.JComboBox<>();
        txtAlta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDivisa = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        cbTipoMensaje = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Contrapartida(*)");

        jLabel2.setText("BIC Contrapartida");

        jLabel3.setText("Sentido(*)");

        jLabel4.setText("Importe(*)");

        jLabel5.setText("Fecha Valor(*)");

        jLabel6.setText("Corresponsal Propio(*)");

        jLabel7.setText("Cuenta Corresp. Propio");

        jLabel8.setText("Corresponsal Ajeno(*)");

        jLabel9.setText("Cuenta Corresp. Ajeno");

        jLabel10.setText("Tipo Mensaje");

        jLabel11.setText("(*)Campo Obligatorio");

        txtContrapartida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrapartidaKeyTyped(evt);
            }
        });

        txtBICContrapartida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBICContrapartidaKeyTyped(evt);
            }
        });

        txtCorrespPropio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrespPropioKeyTyped(evt);
            }
        });

        txtCuentaCorrespPropio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaCorrespPropioKeyTyped(evt);
            }
        });

        txtCorrespAjeno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrespAjenoKeyTyped(evt);
            }
        });

        txtCuentaCorrespAjeno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaCorrespAjenoKeyTyped(evt);
            }
        });

        cbSentido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Cobro", "Pago" }));
        cbSentido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSentidoItemStateChanged(evt);
            }
        });

        txtAlta.setText("Dar de Alta la Operacion");
        txtAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAltaActionPerformed(evt);
            }
        });

        jLabel12.setText("Divisa(*)");

        txtDivisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDivisaKeyTyped(evt);
            }
        });

        btnBorrar.setText("Borrar Campos");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        cbTipoMensaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "MT103", "MT202" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Alta de Órdenes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(txtAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorrespPropio, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(txtContrapartida)
                            .addComponent(txtBICContrapartida)
                            .addComponent(txtImporte)
                            .addComponent(txtCuentaCorrespPropio)
                            .addComponent(txtCorrespAjeno)
                            .addComponent(txtCuentaCorrespAjeno)
                            .addComponent(cbSentido, 0, 339, Short.MAX_VALUE)
                            .addComponent(txtDivisa)
                            .addComponent(cbTipoMensaje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateChooserPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtContrapartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBICContrapartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbSentido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorrespPropio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuentaCorrespPropio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorrespAjeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCuentaCorrespAjeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbTipoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlta)
                    .addComponent(btnBorrar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void alta(){        
        String BICEntidad = "BSCHESMMXXX";
        String contrapartida = txtContrapartida.getText();
        String BICContrapartida = txtBICContrapartida.getText();
        String sentido = cbSentido.getSelectedItem().toString();
        if(cbSentido.getSelectedIndex()==0){            
            sentido = null;            
        }        
        
        boolean fechaOk = true;
        Date sqlDate = null;
        try{
            sqlDate = new Date(dateChooserPanel1.getSelectedDate().getTimeInMillis());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha");
            fechaOk = false;
        }
        if(fechaOk){
            String divisa = txtDivisa.getText();
            String correspPropio = txtCorrespPropio.getText();
            String cuentaCorrespPropio = txtCuentaCorrespPropio.getText();
            String correspAjeno = txtCorrespAjeno.getText();
            String cuentaCorrespAjeno = txtCuentaCorrespAjeno.getText();
            String tipoMensaje=null;

            if(!(cbSentido.getSelectedItem().equals("Cobro"))){
                tipoMensaje = cbTipoMensaje.getSelectedItem().toString();
            }
            
        
        if (cbTipoMensaje.getSelectedIndex()==0){            
            tipoMensaje = null;
        }
        

            if(validar()){
                OrdenDao dao = new OrdenDao();        
                String refOrden = dao.refOrden();
                double importe = Double.parseDouble(txtImporte.getText());

                Orden orden = new Orden(BICEntidad, refOrden, contrapartida, BICContrapartida, sentido, importe, sqlDate,  divisa, correspPropio, cuentaCorrespPropio, correspAjeno, cuentaCorrespAjeno, tipoMensaje);

                dao.añadir(orden);
                JOptionPane.showMessageDialog(null, "La orden ha sido dada de alta correctamente");  
                dispose();
            }
        }
    }  
    
    public void editar(){        
        String BICEntidad = "BSCHESMMXXX";
        String contrapartida = txtContrapartida.getText();
        String BICContrapartida = txtBICContrapartida.getText();
        String sentido = cbSentido.getSelectedItem().toString();
        if(cbSentido.getSelectedIndex()==0){            
            sentido = null;            
        }        
        
        boolean fechaOk = true;
        Date sqlDate = null;
        try{
            sqlDate = new Date(dateChooserPanel1.getSelectedDate().getTimeInMillis());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha");
            fechaOk = false;
        }
        if(fechaOk){
            String divisa = txtDivisa.getText();
            String correspPropio = txtCorrespPropio.getText();
            String cuentaCorrespPropio = txtCuentaCorrespPropio.getText();
            String correspAjeno = txtCorrespAjeno.getText();
            String cuentaCorrespAjeno = txtCuentaCorrespAjeno.getText();
            String tipoMensaje=null;

            if(!(cbSentido.getSelectedItem().equals("Cobro"))){
                tipoMensaje = cbTipoMensaje.getSelectedItem().toString();
            }
            
        
        if (cbTipoMensaje.getSelectedIndex()==0){            
            tipoMensaje = null;
        }
        

            if(validar()){
                OrdenDao dao = new OrdenDao();        
                String refOrden = orden.getRefOrden();
                double importe = Double.parseDouble(txtImporte.getText());

                Orden orden = new Orden(BICEntidad, refOrden, contrapartida, BICContrapartida, sentido, importe, sqlDate,  divisa, correspPropio, cuentaCorrespPropio, correspAjeno, cuentaCorrespAjeno, tipoMensaje);

                dao.edit(orden);
                JOptionPane.showMessageDialog(null, "La orden ha sido actualizada correctamente");  
                dispose();
            }
        }         
    }
    
    public boolean validar (){       
        if(txtContrapartida.getText().equals("")||cbSentido.getSelectedIndex()==0||txtImporte.getText().equals("")||dateChooserPanel1.getSelectedDate() == null||txtDivisa.getText().equals("")||txtCorrespPropio.getText().equals("")||txtCorrespAjeno.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos obligatorios");
        }else{
            if(txtDivisa.getText().toString().length()!=3){

                JOptionPane.showMessageDialog(null, "El campo Divisa debe tener 3 caracteres");          
            }else if (txtCorrespPropio.getText().toString().length()!=11){
                JOptionPane.showMessageDialog(null, "El campo Corresponsal Propio debe tener 11 caracteres");                   
            }else if (txtCuentaCorrespPropio.getText().toString().length() >1 && txtCuentaCorrespPropio.getText().toString().length() < 35  ){
                JOptionPane.showMessageDialog(null, "El campo Cuenta Corresponsal Propio debe tener 35 caracteres");                   
            }else if (txtCorrespAjeno.getText().toString().length()!=11){
                JOptionPane.showMessageDialog(null, "El campo Corresponsal Ajeno debe tener 11 caracteres");                   
            }else if (txtCuentaCorrespAjeno.getText().toString().length() >1 && txtCuentaCorrespPropio.getText().toString().length()<35){
                JOptionPane.showMessageDialog(null, "El campo Cuenta Corresponsal Ajeno debe tener 35 caracteres"); 
            }else{
                try{
                    Double.parseDouble(txtImporte.getText());
                    return true;
                }catch(NumberFormatException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "El campo Importe debe tener valor numérico");                   
                } 
            }
        }
        return false;
    }        

    
    private void txtAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAltaActionPerformed
        
        if(orden == null){
            alta();
        }else{
            editar();
        }

    }//GEN-LAST:event_txtAltaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtContrapartida.setText("");
        txtBICContrapartida.setText("");
        cbSentido.setSelectedIndex(0);
        txtImporte.setText("");
        dateChooserPanel1.setCurrent(null);
        txtDivisa.setText("");
        txtCorrespPropio.setText("");
        txtCuentaCorrespPropio.setText("");
        txtCorrespAjeno.setText("");
        txtCuentaCorrespAjeno.setText("");
        cbTipoMensaje.setSelectedIndex(0);
        initPlaceHolders();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cbSentidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSentidoItemStateChanged
        if (cbSentido.getSelectedItem().equals("Cobro")){            
            cbTipoMensaje.setEnabled(false);
        }else{
            cbTipoMensaje.setEnabled(true);   
        }
    }//GEN-LAST:event_cbSentidoItemStateChanged

    private void txtCuentaCorrespPropioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaCorrespPropioKeyTyped
        if(txtCuentaCorrespPropio.getText().length()>34){
            evt.consume();
        }
    }//GEN-LAST:event_txtCuentaCorrespPropioKeyTyped

    private void txtCuentaCorrespAjenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaCorrespAjenoKeyTyped
        if(txtCuentaCorrespAjeno.getText().length()>34){
            evt.consume();
        }     
    }//GEN-LAST:event_txtCuentaCorrespAjenoKeyTyped

    private void txtCorrespPropioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrespPropioKeyTyped
        if(txtCorrespPropio.getText().length()>10){            
            evt.consume();            
        }
    }//GEN-LAST:event_txtCorrespPropioKeyTyped

    private void txtCorrespAjenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrespAjenoKeyTyped
        if(txtCorrespAjeno.getText().length()>10){            
            evt.consume();            
        }
    }//GEN-LAST:event_txtCorrespAjenoKeyTyped

    private void txtDivisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDivisaKeyTyped
        if(txtDivisa.getText().length()>2){            
            evt.consume();            
        }
    }//GEN-LAST:event_txtDivisaKeyTyped

    private void txtBICContrapartidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBICContrapartidaKeyTyped
        // TODO add your handling code here:
        if(txtBICContrapartida.getText().length()>10){            
            evt.consume();            
        }
    }//GEN-LAST:event_txtBICContrapartidaKeyTyped

    private void txtContrapartidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrapartidaKeyTyped
        // TODO add your handling code here:
        if(txtContrapartida.getText().length()>54){            
            evt.consume();            
        }
    }//GEN-LAST:event_txtContrapartidaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaOrden().setVisible(true);
            }
        });
    }
    
    public void initPlaceHolders(){
        new PlaceHolder(txtContrapartida, "Ej: BANCO SANTANDER MEXICO SA INST. DE BANCA MULTIPLE");
        new PlaceHolder(txtBICContrapartida, "Ej: BMSXMXMMXXX");
        new PlaceHolder(txtImporte,"Ej: 1000.00");
        new PlaceHolder(txtDivisa, "Ej: EUR");
        new PlaceHolder(txtCorrespAjeno, "Ej: CITIITMXXXX");
        new PlaceHolder(txtCorrespPropio, "Ej: BBVAESMMXXX");
        new PlaceHolder(txtCuentaCorrespAjeno, "Ej: ES345678901234567890123456789012345");
        new PlaceHolder(txtCuentaCorrespPropio, "Ej: ES345678901234567890123456789012345");       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JComboBox<String> cbSentido;
    private javax.swing.JComboBox<String> cbTipoMensaje;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton txtAlta;
    private javax.swing.JTextField txtBICContrapartida;
    private javax.swing.JTextField txtContrapartida;
    private javax.swing.JTextField txtCorrespAjeno;
    private javax.swing.JTextField txtCorrespPropio;
    private javax.swing.JTextField txtCuentaCorrespAjeno;
    private javax.swing.JTextField txtCuentaCorrespPropio;
    private javax.swing.JTextField txtDivisa;
    private javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables
}
