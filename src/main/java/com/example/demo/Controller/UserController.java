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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserModel;
import com.example.demo.Service.UserService;

@CrossOrigin("http://localhost:5173/")
@RestController
public class UserController 
{
	@Autowired
	UserService userservice;
	
	@PostMapping("/addUser")
	public String AddUser(@RequestBody UserModel usermodel)
	{
		boolean b=userservice.isAddNewUser(usermodel);
		
		if(b)
		{
			return "New User Added Successfully.....!";
		}
		else
		{
			return "New User NOT  Added Successfully.....!";
		}
	}
	
	
	@GetMapping("/getAllUsers")
	public List<UserModel> getAllUsers()
	{
		return userservice.getAllUsers();
	}
	
	
	@GetMapping("/searchUser/{uid}")
	public UserModel getUserById(@PathVariable("uid") Integer uid)
	{
		UserModel umodel=userservice.getUserById(uid);
		if(umodel!=null)
		{
			return umodel;
		}
		else
		{
			return null;
		}
	}
	
	@PostMapping("/loginUser")
	public String getUserByEmailPass(@RequestBody UserModel user) {
	    boolean b = userservice.getUserByEmailPass(user.getEmail(), user.getPassword());
	    
	    if (b) {
	        return "You Are logged In Successfully...!";
	    } else {
	        return "You Are NOT logged In Successfully...!";
	    }
	}



	
	
	@DeleteMapping("/deleteUser/{uid}")
	public String deleteUserById(@PathVariable("uid") Integer uid)
	{
		boolean  b=userservice.isDeleteUserById(uid);
		
		if(b)
		{
			return "User Deleted Successfully....!";
		}
		else
		{
			return "User NOT Deleted Successfully....!";
		}
		
	}
	
	
	@PutMapping("/updateEmployee")
	public String updateUser(@RequestBody UserModel umodel)
	{
		boolean b=userservice.isupdateUser(umodel);
		
		if(b)
		{
			return "User Updated Successfully.....!";
		}
		else
		{
			return "User NOT Updated Successfully.....!";
		}
		
	}

}
