package com.example.demo.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.AppointmentModel;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper; 



@Repository("appRepo")
public class AppointmentRepository 
{
	List<AppointmentModel> appList;
	
	@Autowired
	JdbcTemplate template;
	
	public boolean newAppointment(AppointmentModel app)
	{
		int value=template.update("insert into appointmentmodel values('0',?,?,?,?)",new PreparedStatementSetter () 
		{
			public void setValues(PreparedStatement ps) throws SQLException 
			{
				ps.setString(1,app.getCname() );
				ps.setDate(2, app.getAdate());
				ps.setString(3, app.getAtime());
				ps.setString(4, app.getVnumber());
				
			}
		});
		return value>0?true:false;
	}
	
	public List<AppointmentModel> getAppointmentList()
	{
		appList=template.query("select *from appointmentmodel", new RowMapper<AppointmentModel>() 
		{
           public AppointmentModel mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
        	   AppointmentModel apmodel=new AppointmentModel();
        	   apmodel.setApid(rs.getInt(1));
        	   apmodel.setCname(rs.getString(2));
        	   apmodel.setAdate(rs.getDate(3));
        	   apmodel.setAtime(rs.getString(4));
        	   apmodel.setVnumber(rs.getString(5));
			   return apmodel;
			}
		});
		return appList;
	}
	
	public AppointmentModel getAppointmentByApid(int apid)
	{
		appList=template.query("select *from appointmentmodel where apid=?",new Object[] {apid}, new RowMapper<AppointmentModel>() 
		{
           public AppointmentModel mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
        	   AppointmentModel apmodel=new AppointmentModel();
        	   apmodel.setApid(rs.getInt(1));
        	   apmodel.setCname(rs.getString(2));
        	   apmodel.setAdate(rs.getDate(3));
        	   apmodel.setAtime(rs.getString(4));
        	   apmodel.setVnumber(rs.getString(5));
			   return apmodel;
			}
		});
		return appList.size()>0?appList.get(0):null;
		
	}
	
	
	public boolean deleteAppointmentById(int apid)
	{
		int value=template.update("delete from appointmentmodel where apid="+apid);
		
		if(value>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateAppointmentById(AppointmentModel app)
	{
		int value=template.update("update appointmentmodel set cname=?,adate=?,atime=?,vnumber=? where apid=?",new PreparedStatementSetter () {

			public void setValues(PreparedStatement ps) throws SQLException 
			{
				ps.setString(1, app.getCname());
				ps.setDate(2, app.getAdate());
				ps.setString(3, app.getAtime());
				ps.setString(4, app.getVnumber());
				ps.setInt(5, app.getApid());	
			}
			
		});
		
		return value>0?true:false;
	}

}
