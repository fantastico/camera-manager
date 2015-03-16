package com.cameramanager.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.cameramanager.model.User;

public class AuthenticationUtil {

	public static User getUser() {
		return (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

	public static boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication()
				.isAuthenticated();
	}

	public static boolean isLocked() {
		return !((User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).isAccountNonLocked();
	}

	public static boolean isExpired() {
		return !((User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).isAccountNonExpired();
	}

	public static boolean isPasswordExpired() {
		return !((User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).isCredentialsNonExpired();
	}


}
