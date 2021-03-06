/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

/**
 *
 * @author juan.muro
 */
public class OrdenDao {

    private Connection connection;

    public OrdenDao() {
        this.connection = new liquidacion.ConnectionFactory().getConnection();
    }

    public String refOrden() {
        String sql = "select max(ref_orden) as max from orden";
        String resultado = "ORDEN";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String valor = rs.getString("max");
                if (valor == null) {
                    resultado = "ORDEN00000001";
                } else {
                    Long secuencia = Long.parseLong(valor.replaceAll("\\D+", "")) + 1;
                    resultado = resultado + StringUtils.leftPad(secuencia.toString(), 8, "0");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void añadir(Orden orden) {
        String sql = "insert into orden "
                + "(bic_entidad, ref_orden, contrapartida, bic_contrapartida, sentido, importe, divisa, fecha_valor, "
                + "corresponsal_propio, cuenta_corresponsal_propio, corresponsal_ajeno, "
                + "cuenta_corresponsal_ajeno, tipo_mensaje, estado,fecha_liberacion,fecha_liquidacion)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            //prepared statement para inserir la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, orden.getBICEntidad());
            stmt.setString(2, orden.getRefOrden());
            stmt.setString(3, orden.getContrapartida());
            stmt.setString(4, orden.getBICContrapartida());
            stmt.setString(5, orden.getSentido());
            stmt.setDouble(6, orden.getImporte());
            stmt.setString(7, orden.getDivisa());
            stmt.setDate(8, orden.getFechaValor());
            stmt.setString(9, orden.getCorresponsalPropio());
            stmt.setString(10, orden.getCuentaCorresponsalPropio());
            stmt.setString(11, orden.getCorresponsalAjeno());
            stmt.setString(12, orden.getCuentaCorresponsalAjeno());
            stmt.setString(13, orden.getTipoMensaje());
            stmt.setString(14, "No Liberado");
            stmt.setDate(15, orden.getFechaValor());
            stmt.setDate(16, orden.getFechaValor());

            //executar
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public void edit(Orden orden){        
        String sql = "update orden set contrapartida=?, bic_contrapartida=?, sentido=?, importe=?, "
                + "fecha_valor=?, divisa=?, corresponsal_propio=?, cuenta_corresponsal_propio=?, "
                + "corresponsal_ajeno=?, cuenta_corresponsal_ajeno=?, tipo_mensaje=?, estado=? "
                + "where ref_orden=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, orden.getContrapartida());
            stmt.setString(2, orden.getBICContrapartida());
            stmt.setString(3, orden.getSentido());
            stmt.setDouble(4, orden.getImporte());
            stmt.setDate(5, orden.getFechaValor());
            stmt.setString(6, orden.getDivisa());
            stmt.setString(7, orden.getCorresponsalPropio());
            stmt.setString(8, orden.getCuentaCorresponsalPropio());
            stmt.setString(9, orden.getCorresponsalAjeno());
            stmt.setString(10, orden.getCuentaCorresponsalAjeno());
            stmt.setString(11, orden.getTipoMensaje());
            stmt.setString(12, "No Liberado");
            stmt.setString(13, orden.getRefOrden());
            
            stmt.execute();
            stmt.close();            
            
        }catch(SQLException e){            
            throw new RuntimeException(e);                       
        }
    }
   
   
       public void remover (Long id){        
        try{
            
            PreparedStatement stmt = connection.prepareStatement("delete from alumno where id = ?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            
            throw new RuntimeException (e);
        }                
    }
    
    public void liquidarManualOrden(Orden orden){
        String sql = "update orden set estado = ?, fecha_liberacion = CURRENT_TIMESTAMP, "
                + "fecha_liquidacion = CURRENT_TIMESTAMP where id = ?";
        try {
            //prepared statement para inserir la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, "Liquidada");
            stmt.setLong(2, orden.getId());

            //executar
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
     public void liquidarOrden(Orden orden){
        String sql = "update orden set estado = ?, "
                + "fecha_liquidacion = CURRENT_TIMESTAMP where id = ?";
        try {
            //prepared statement para inserir la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, "Liquidada");
            stmt.setLong(2, orden.getId());

            //executar
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void liberarOrden(Orden orden) {
        String sql = "update orden set estado = ?, fecha_liberacion = CURRENT_TIMESTAMP "
                + "where id = ?";
        try {
            //prepared statement para inserir la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            if (orden.getSentido().equals("Pago"))
                stmt.setString(1, "Liberada");
            else
                stmt.setString(1, "ACK");
           
            stmt.setLong(2, orden.getId());

            //executar
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void actualizarEstado(Orden orden, String estado) {
        String sql = "update orden set estado = ? "
                + "where id = ?";
        try {
            //prepared statement para inserir la conexion
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            //setear los valores
            stmt.setString(1, estado);
            stmt.setLong(2, orden.getId());

            //executar
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

    public ArrayList<Orden> listarOrdenes(Filtro filtro) { //Hecho por Ale
        ArrayList<Orden> ordenes = new ArrayList<>();
        String sql = "select * from orden "
                + "where bic_entidad like '%" + filtro.getBICEntidad() + "%' "
                + "and ref_orden like '%" + filtro.getRefOrden() + "%' "
                + "and corresponsal_propio like '%" + filtro.getCorresponsalPropio() + "%' "
                + "and estado like '%" + filtro.getEstado() + "%' "
                + "and sentido like '%" + filtro.getSentido() + "%' "
                + "and divisa like '%" + filtro.getDivisa() + "%'";
        if (filtro.getImporte() != 0)
            sql += " and importe >= " + filtro.getImporte();
        if (filtro.getImporteMax() != 0)
            sql += " and importe <= " + filtro.getImporteMax();
        if (filtro.getFechaLiberacion() != null)
            sql += " and fecha_liberacion >= '" + filtro.getFechaLiberacion() + "'";
        if (filtro.getFechaLiberacionMax() != null)
            sql += " and fecha_liberacion <= '" + filtro.getFechaLiberacionMax() + "'";
        if (filtro.getFechaValor() != null)
            sql += " and fecha_valor >= '" + filtro.getFechaValor() + "'";
        if (filtro.getFechaValorMax() != null)
            sql += " and fecha_valor <= '" + filtro.getFechaValorMax() + "'";
        if (filtro.getFechaLiquidacion() != null)
            sql += " and fecha_liquidacion >= '" + filtro.getFechaLiquidacion() + "'";
        if (filtro.getFechaLiquidacionMax() != null)
            sql += " and fecha_liquidacion <= '" + filtro.getFechaLiquidacionMax() + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Orden o = new Orden();
                o.setId(rs.getLong("id"));
                o.setBICEntidad(rs.getString("bic_entidad"));
                o.setRefOrden(rs.getString("ref_orden"));
                o.setContrapartida(rs.getString("contrapartida"));
                o.setBICContrapartida(rs.getString("bic_contrapartida"));
                o.setSentido(rs.getString("sentido"));
                o.setImporte(rs.getDouble("importe"));
                o.setDivisa(rs.getString("divisa"));
                o.setFechaValor(rs.getDate("fecha_valor"));
                o.setCorresponsalPropio(rs.getString("corresponsal_propio"));
                o.setCuentaCorresponsalPropio(rs.getString("cuenta_corresponsal_propio"));
                o.setCorresponsalAjeno(rs.getString("corresponsal_ajeno"));
                o.setCuentaCorresponsalAjeno(rs.getString("cuenta_corresponsal_ajeno"));
                o.setTipoMensaje(rs.getString("tipo_mensaje"));
                o.setEstado(rs.getString("estado"));
                o.setFechaLiberacion(rs.getDate("fecha_liberacion"));
                o.setFechaLiquidacion(rs.getDate("fecha_liquidacion"));
                o.setFechaEntrada(rs.getDate("fecha_entrada"));
                o.setUltimoTRN(getUltimoTRN(o.getId()));
                ordenes.add(o);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordenes;
    }

    public String getUltimoTRN(long idOrden) {
        String sql = "select trn from mensaje where id = \n"
                + "(select MAX(id) from mensaje \n"
                + "where idorden = ?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, idOrden);
            ResultSet rs = stmt.executeQuery();
            String trn = "";
            while (rs.next()) {
                trn = rs.getString("trn");
            }
            rs.close();
            stmt.close();
            return trn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getPrimerTRN(long idOrden) {
        String sql = "select trn from mensaje where id = \n"
                + "(select MIN(id) from mensaje \n"
                + "where idorden = ?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, idOrden);
            ResultSet rs = stmt.executeQuery();
            String trn = "";
            while (rs.next()) {
                trn = rs.getString("trn");
            }
            rs.close();
            stmt.close();
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
