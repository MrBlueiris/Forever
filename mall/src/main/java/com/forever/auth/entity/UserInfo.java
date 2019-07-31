package com.forever.auth.entity;


/**
 * @author bajin
 * @date 2018/9/30
 */

public class UserInfo {
    private Long id;
    private String username;
    private String password;

	public UserInfo(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	private String email;
    private String question;
    private String answer;
    private Integer role;

	public UserInfo(Long id, String username, String password, String email, String question, String answer, Integer role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.role = role;
	}

	public UserInfo() {
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", role=" + role +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
