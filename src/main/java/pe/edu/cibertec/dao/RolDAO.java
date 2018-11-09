package pe.edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.RolBean;

public class RolDAO {
	
	public List<RolBean> listarRol() {
		List<RolBean> data=new ArrayList<RolBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=MySqlConexion.getConnection();
			String sql="select*from rol";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			while(rs.next()){
				RolBean m=new RolBean();
				
				m.setIdRol(rs.getInt(1));
				m.setDescripcion(rs.getString(2));
				
				data.add(m);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null) rs.close();if(pstm!=null)pstm.close();if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
}
