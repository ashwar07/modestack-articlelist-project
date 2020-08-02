package com.example.articleproject.vo;

public class UserVO {

    String username;
    String password;
    String email;
    String address;
    String access_token;
    String date_string;
    
    public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getTimerString() {
		return timerString;
	}

	public void setTimerString(String timerString) {
		this.timerString = timerString;
	}

	String timerString;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public String getDateString() {
		return date_string;
	}

	public void setDateString(String dateString) {
		this.date_string = dateString;
	}
    
    
}
