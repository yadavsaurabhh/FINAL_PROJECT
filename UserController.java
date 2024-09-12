package com.crs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.dto.ApiResponse;
import com.crs.dto.user.AuthRequestDto;
import com.crs.dto.user.AuthRespDto;
import com.crs.dto.user.DocumentDto;
import com.crs.dto.user.Profile;
import com.crs.dto.user.RegisterUserDto;
import com.crs.dto.user.UpdateUserDto;
import com.crs.entities.Documents;
import com.crs.entities.User;
import com.crs.service.UserService;



@RestController 
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;


	
    //Get All Users
    @GetMapping
	public List<AuthRespDto> listAllEmps() {
		return userService.getAllUser();
	}

    //login
    @PostMapping("/signIn")
	public ResponseEntity<?> logInUser(@RequestBody AuthRequestDto request) {
		System.out.println("in sign in " + request);
	    
		AuthRespDto authRespDto = null;
		authRespDto = userService.logInUser(request);


		 if(authRespDto != null){
			 System.out.println("**********************************");
            return ResponseEntity.status(HttpStatus.OK).body(authRespDto);
        }
		 System.out.println("++++++++++++++++++++++++++++++++++++++++");
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false,"User Not Found"));
	}

    //Register
    @PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody RegisterUserDto request)
	{
		System.out.println("in hire emp "+request);
		
        RegisterUserDto registerUserDto = null;
        registerUserDto = userService.registerUser(request);

        if(registerUserDto != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,"User Registered sucessfully"));
        }
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false,"User Not Registered"));
	}
    

	@PostMapping("/update")
	public  ResponseEntity<?> updateEmpDetails(@RequestBody UpdateUserDto updateReq) {
		System.out.println("in update emp " + updateReq.getId());
		return  ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(updateReq));
	}


	 //login
    @PostMapping("/document")
	public ResponseEntity<?> addDocuments(@RequestBody DocumentDto docRequest) {
		System.out.println("in sign in " + docRequest);
		Documents document = userService.addUserDocuments(docRequest);
		if(document != null){
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"Documents uploaded sucessfully."));
		}
	     return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false,"Documents Not uploaded."));
	}
    
    

   /*  @GetMapping("/profileDetails")
    public Profile getprofile(@PathVariable Long id) {
	System.out.println("in profile " + id);
	Profile profile = null;
	profile = userService.User(id);

	return .Details(id);
}*/


/* 
	// add a method : REST API end point , to get all emps
	// Req : http://host:port/employees , method ; GET
	@GetMapping
	public List<Employee> listAllEmps() {
		return empService.getAllEmployees();
	}

	// add a method : REST API end point , to add new emp details
	// Req : http://host:port/employees , method ; POST
	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee emp)
	// @RequestBody : mandatory method arg level annotation for de-ser / un
	// marshalling
	// => json ---> java
	{
		System.out.println("in save emp " + emp.getId());// id : null (transient)
		return empService.addEmpDetails(emp);
	}

	// add a method : REST API end point , to delete emp details
	// Req : http://host:port/employees/empId , method : DELETE
	@DeleteMapping("/{empId}")
	// @PathVariable : method arg level anno , for binding URI template var to req
	// handling method arg.
	public ApiResponse deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("in del emp " + empId);
		return empService.deleteEmpDetails(empId);
	}

	// add a method : REST API end point , to get emp details by id
	// Req : http://host:port/employees/empId , method : GET
	@GetMapping("/{id}")
	public Employee getEmpDetailsById(@PathVariable Long id) {
		System.out.println("in get emp dtls " + id);
		return empService.getEmpDetails(id);
	}
	// add a method : REST API end point , to get emp details by id
	// Req : http://host:port/employees/empId , method : GET

	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEmp) {
		System.out.println("in update emp " + detachedEmp.getId());// not null
		// validate
		empService.getEmpDetails(detachedEmp.getId());
		// => emp exists by the id --> continue to update
		return empService.addEmpDetails(detachedEmp);
	}

	// add a method : REST API end point , to emp signin
	// Req : http://host:port/employees/signin method=POST
	// req payload : req dto
	// resp : resp dto
	@PostMapping("/signIn")
	public ResponseEntity<?> authenticateEmp(@RequestBody @Valid AuthRequest request) {
		System.out.println("in sign in " + request);
	
			return new ResponseEntity<>(empService.authenticateEmp(request), 
					HttpStatus.OK);

	}
	//add a method to hire / signup  new employee
	// Req : http://host:port/employees/signup method=POST
		// req payload : all emp details except id
		// resp : resp dto all emp dtls except password
	@PostMapping("/signup")
	public ResponseEntity<?> hireEmployee(@RequestBody @Valid SignupRequest request)
	{
		System.out.println("in hire emp "+request);
		//invoke service layer
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(empService.signupEmp(request));
	}
*/	

}
