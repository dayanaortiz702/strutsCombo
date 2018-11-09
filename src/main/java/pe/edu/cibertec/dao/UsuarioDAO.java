package pe.edu.cibertec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	MySqlConexion con = new MySqlConexion();
	
		public int registerUsuario(String nombre, String usuario,String clave, String idRol) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO usuario VALUES (null,?,?,?,?)";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setString(2, usuario);
				ps.setString(3, clave);
				ps.setString(4, idRol);


				
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return i;
			} finally {
				if (con.getConnection() != null) {
					con.getConnection().close();
				}
			}
		}
		
		
		// method for fetch saved user data
				public ResultSet reportUsuario() throws SQLException, Exception {
					ResultSet rs = null;
					try {
						String sql = "SELECT * from usuario";
						PreparedStatement ps = con.getConnection().prepareStatement(sql);
						rs = ps.executeQuery();
						return rs;
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					} finally {
						if (con.getConnection() != null) {
							con.getConnection().close();
						}
					}
				}
				
				// method for fetch old data to be update
				public ResultSet detalleUsuario(String idusuario) throws SQLException, Exception {
					ResultSet rs = null;
					try {
						String sql = "SELECT * from usuario WHERE idUsuario=?";
						PreparedStatement ps = con.getConnection().prepareStatement(sql);
						ps.setString(1, idusuario);
						rs = ps.executeQuery();
						return rs;
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					} finally {
						if (con.getConnection() != null) {
							con.getConnection().close();
						}
					}
				}
				
				
				// method for update new data in database
				public int updateUsuario(String nombre, String usuario,String clave, String idRol, String idUsuario)
										  throws SQLException, Exception {
					
					con.getConnection().setAutoCommit(false);
					int i = 0;
					try {
						String sql = "UPDATE usuario SET  nombre=?, usuario=?, clave=?, idRol = ? WHERE idUsuario=?";

						
						PreparedStatement ps = con.getConnection().prepareStatement(sql);
						
						ps.setString(1, nombre);
						ps.setString(2, usuario);
						ps.setString(3, clave);
						ps.setString(4, idRol);	
						ps.setString(5, idUsuario);
						
						i = ps.executeUpdate();
						return i;
					} catch (Exception e) {
						e.printStackTrace();
						con.getConnection().rollback();
						return 0;
					} finally {
						if (con.getConnection() != null) {
							con.getConnection().close();
						}
					}
				}
				
				// method for delete the record
				public int deletePropietario(String idusuario) throws SQLException, Exception {
					con.getConnection().setAutoCommit(false);
					int i = 0;
					try {
						String sql = "DELETE FROM usuario WHERE idUsuario=?";
						PreparedStatement ps = con.getConnection().prepareStatement(sql);
						ps.setString(1, idusuario);
						i = ps.executeUpdate();
						return i;
					} catch (Exception e) {
						e.printStackTrace();
						con.getConnection().rollback();
						return 0;
					} finally {
						if (con.getConnection() != null) {
							con.getConnection().close();
						}
					}
				}
}
