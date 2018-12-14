/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import utiles.RandomString;

/**
 *
 * @author juan.muro
 */
public class MensajeDao {

    private Connection connection;

    public MensajeDao() {
        this.connection = new liquidacion.ConnectionFactory().getConnection();
    }
    
    public void añadir(Mensaje mensaje) {
        String sql = "insert into mensaje "
                + "(trn,swift,cruce,idorden) values (?,?,?,?)";
        try {
            //prepared statement para inserir la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, mensaje.getTRN());
            stmt.setString(2, mensaje.getSwift());
            stmt.setString(3, mensaje.getCruce());
            stmt.setLong(4, mensaje.getOrden().getId());

            //executar
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 

    public ArrayList<OrdenMensaje> listarMensajes(Filtro filtro) { //Hecho por alguien que no es Ale 
        ArrayList<OrdenMensaje> ordenmensajes = new ArrayList<>();
        String sql = "select m.*, o.* "
                + "from mensaje as m "
                + "inner join orden as o "
                + "on o.id = m.idorden "
                + "where m.idorden = " + filtro.getId()
                + " and o.tipo_mensaje like '%" + filtro.getTipoMensaje() + "%' "
                + " and o.corresponsal_propio like '%" + filtro.getCorresponsalPropio() + "%' "
                + " and m.trn like '%" + filtro.getTRNMensaje() + "%' ";

        if (filtro.getImporte() != 0)
            sql += " and importe >= " + filtro.getImporte();
        if (filtro.getImporteMax() != 0)
            sql += " and importe <= " + filtro.getImporteMax();
        if (filtro.getFechaValor() != null)
            sql += " and fecha_valor >= '" + filtro.getFechaValor() + "'";
        if (filtro.getFechaValorMax() != null)
            sql += " and fecha_valor <= '" + filtro.getFechaValorMax() + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Orden orden = new Orden();
                orden.setTipoMensaje(rs.getString("tipo_mensaje"));
                orden.setRefOrden(rs.getString("ref_orden"));
                orden.setContrapartida(rs.getString("contrapartida"));
                orden.setImporte(rs.getDouble("importe"));
                orden.setDivisa(rs.getString("divisa"));
                orden.setFechaValor(rs.getDate("fecha_valor"));
                orden.setCorresponsalPropio(rs.getString("corresponsal_propio"));

                Mensaje mensaje = new Mensaje();
                mensaje.setTRN(rs.getString("trn"));
                mensaje.setCruce(rs.getString("cruce"));
                mensaje.setSwift(rs.getString("swift"));
                mensaje.setId(rs.getInt("id"));

                OrdenMensaje om = new OrdenMensaje(orden, mensaje);
                ordenmensajes.add(om);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordenmensajes;
    }

    public String generarTrn(Orden orden) {
        long idOrden = orden.getId();
        String refOrden = orden.getRefOrden();
        String sql = "select count(trn) as numtrn from mensaje where idorden = " + idOrden;

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            long num = 0;

            while (rs.next()) {
                num = rs.getLong("numtrn");
            }

            rs.close();
            stmt.close();
            String trn = refOrden + "." + num + 1;
            return trn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    

    public void closeConnetion() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
