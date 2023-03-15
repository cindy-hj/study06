package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@OneToMany(mappedBy = "user") // 유저는 한명인데 주문한 상품을 여러개, 기준은 클래스의 인스턴스 명(user)을 지정
	private List<OrderItem> orderItem = new ArrayList<>(); // one to one이 아니므로 리스트로 구성되는것
	
}
