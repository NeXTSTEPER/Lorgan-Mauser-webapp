package com.lm.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lm.app.dao.AccountDAO;
import com.lm.app.entity.Account;

// This service class is used to fetch user details from the database 
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    // Inject the AccountDAO to interact with the database
	@Autowired
    private AccountDAO accountDAO;
 
    // This method is used to load user-specific data and roles for security purpose 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the account with the given username
        Account account = accountDAO.findAccount(username);
        System.out.println("Account= " + account);
 
        // If the account does not exist, throw UsernameNotFoundException
        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }
 
        // Get user role (for example, EMPLOYEE,MANAGER,..)
        String role = account.getUserRole();
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // Create a GrantedAuthority object from the user role
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
 
        // Add the authority to grantList
        grantList.add(authority);
 
        // Check if the account is enabled, not expired, and not locked
        boolean enabled = account.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        // Create a UserDetails object with the account details and the grantList
        UserDetails userDetails = (UserDetails) new User(account.getUserName(), //
                account.getEncrytedPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
 
        // Return the UserDetails object
        return userDetails;
    }
}
