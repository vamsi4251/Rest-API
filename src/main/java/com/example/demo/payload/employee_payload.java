package com.example.demo.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class employee_payload {
	private int id;
	@Column(name = "username",nullable = false,length = 40)
	private String name;
	@Email
	@NotNull
	private String email;
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Size(min = 8)
	@NotNull
	private String password;

}
