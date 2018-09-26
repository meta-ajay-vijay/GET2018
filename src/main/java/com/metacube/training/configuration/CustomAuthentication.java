package com.metacube.training.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRole;
import com.metacube.training.service.interfaces.EmployeeService;
import com.metacube.training.service.interfaces.UserRoleService;

@Component
public class CustomAuthentication implements AuthenticationProvider {

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	EmployeeService employeeService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String empCode = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());

		try {
			Employee employee = employeeService.getEmployeeByIdString(empCode);

			if (!employee.getPassword().equals(password)) {

				throw new BadCredentialsException("External system authentication failed");
			}
		} catch (Exception e) {

			throw new BadCredentialsException("External system authentication failed");
		}

		System.out.println("employee" + employeeService.getEmployeeByIdString(empCode));

		List<GrantedAuthority> roles = new ArrayList<>();

		List<UserRole> roleList = userRoleService.findUser(empCode);

		for (UserRole role : roleList) {
			System.out.println("role:" + role.getRole());
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new UsernamePasswordAuthenticationToken(empCode, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
