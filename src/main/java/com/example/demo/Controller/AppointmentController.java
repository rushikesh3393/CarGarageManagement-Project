package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.AppointmentModel;
import com.example.demo.Service.Appointmentservice;


@RestController
@CrossOrigin("http://localhost:5173/")
public class AppointmentController 
{
	@Autowired
	Appointmentservice appservice;
	
	@PostMapping("/getAppointment")
	public String newAppointment(@RequestBody AppointmentModel app)
	{
		boolean b=appservice.newAppointment(app);
		if(b)
		{
			return "Your Appointment Registerd Successfully...!";
		}
		else
		{
			return "Your Appointment NOT Registerd Successfully...!";
		}
	}
	
	
	@GetMapping("/getAppointmentList")
	public List<AppointmentModel> getAllAppointment()
	{
		return appservice.getAppointmentList();
	}
	
	
	@GetMapping("/searchAppointment/{apid}")
	public AppointmentModel searchAppointmentByApid(@PathVariable("apid") Integer apid)
	{
		AppointmentModel ap=appservice.searchAppointment(apid);
		if(ap!=null)
		{
			return ap;
		}
		else
		{
			return null;
		}
	}
	
	
	@DeleteMapping("/cancelAppointment/{apid}")
	public String deleteAppointmentById(@PathVariable("apid") Integer apid)
	{
		boolean b=appservice.deleteAppointmentById(apid);
		if(b)
		{
			return "Appointment Cancel Successfully....!";
		}
		else
		{
			return "Appointment Cancel Successfully....!";
		}
		
	}
	
	
	@PutMapping("/updateAppointment")
	public String UpdateAppointmentById(@RequestBody AppointmentModel app)
	{
		boolean b=appservice.updateAppointmentById(app);
		if(b)
		{
			return "Your Appointment Updated Successfully...!";
		}
		else
		{
			return "Your Appointment NOT Updated Successfully...!";	
		}	
	}
	
	@GetMapping("/searchPattern/{pattern}")
	public List<AppointmentModel> getpattern(@PathVariable("pattern")  String pattern)
	{
		List<AppointmentModel> plist=appservice.getpattern(pattern);
		
		if(plist.size()>0)
		{
			return plist;
		}
		else
		{
			return null;
		}
	}
	
	

}
