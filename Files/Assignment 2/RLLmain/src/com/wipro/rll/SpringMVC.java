package com.wipro.rll;

import javax.servlet.annotation.WebServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@WebServlet("/Helloworld")
@Controller
public class SpringMVC {

	@RequestMapping("/User_Profile")
	public ModelAndView User_Profile() {
		String message = "Register";
		return new ModelAndView("EVS_TBL_User_Profile", "message", message);
	}
	@RequestMapping("/Party_Register")
	public ModelAndView Party_Register() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_party", "message", message);
	}
	@RequestMapping("/View_Parties")
	public ModelAndView View_Parties() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_party_Show", "message", message);
	}
	@RequestMapping("/User_Register")
	public ModelAndView User_Register() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Credentials_Registation", "message", message);
	}
	@RequestMapping("/Login_User")
	public ModelAndView Login_User() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Credentials_Login", "message", message);
	}
	@RequestMapping("/Election_ADD")
	public ModelAndView Election_ADD() {
		String message = "Party Register";
		return new ModelAndView("EVS_TABLE_Election", "message", message);
	}
	@RequestMapping("/Election_View")
	public ModelAndView Election_View() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Election_Show", "message", message);
	}
	@RequestMapping("/Admin_Password_Change")
	public ModelAndView Admin_Password_Change() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Admin_Change_Password", "message", message);
	}
	@RequestMapping("/ADD_Candidate_Profile")
	public ModelAndView ADD_Candidate_Profile() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Candidate", "message", message);
	}
	@RequestMapping("/View_Candidate_Profile")
	public ModelAndView View_Candidate_Profile() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Candidate_Show", "message", message);
	}
	@RequestMapping("/ADD_Voter_Details")
	public ModelAndView ADD_Voter_Details() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Voter_Details", "message", message);
	}
	@RequestMapping("/CON_Voter_Details")
	public ModelAndView CON_Voter_Details() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Voter_Details_Conform", "message", message);
	}
	@RequestMapping("/Assign_Voter_Details")
	public ModelAndView Assign_Voter_Details() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Admin_Assign_Voter", "message", message);
	}
	@RequestMapping("/Ckeck_Voter")
	public ModelAndView Ckeck_Voter() {
		String message = "Party Register";
		return new ModelAndView("EVS_TBL_Vote_Voter_ID_Check", "message", message);
	}
	@RequestMapping("/new_one")
	public ModelAndView new_one() {
		String message = "Party Register";
		return new ModelAndView("newindex", "message", message);
	}

}
