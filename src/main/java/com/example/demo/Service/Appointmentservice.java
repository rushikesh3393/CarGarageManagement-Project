package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.AppointmentModel;
import com.example.demo.Repository.AppointmentRepository;

@Service("appservice")
public class Appointmentservice 
{
	@Autowired
	AppointmentRepository appRepo;
	
	public boolean newAppointment(AppointmentModel app)
	{
		return appRepo.newAppointment(app);	
	}
	
	public List<AppointmentModel> getAppointmentList()
	{
		return appRepo.getAppointmentList();
	}
	
	public AppointmentModel searchAppointment(int apid)
	{
		return appRepo.getAppointmentByApid(apid);
	}
	
	public boolean deleteAppointmentById(int apid)
	{
		return appRepo.deleteAppointmentById(apid);
	}
	
	public boolean updateAppointmentById(AppointmentModel app)
	{
		return appRepo.updateAppointmentById(app);
	}

}
