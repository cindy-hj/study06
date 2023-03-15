package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Item;
import com.example.model.OrderItem;
import com.example.model.User;
import com.example.repository.ItemRepository;
import com.example.repository.OrderItemRepository;
import com.example.repository.UserRepository;

@SpringBootTest
class Study06ApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Test
	void createTest() {
		String username = "스펀지밥";
		User user = User.builder()
						.username(username)
						.build();
		userRepository.save(user);
		
		List<OrderItem> orderItems = new ArrayList<>();
		for(int i=1; i<=2; i++) {
			Item item = itemRepository.save(Item.builder()
									  .name("item"+i)
									  .build());
			OrderItem orderItem = OrderItem.builder()
										   .item(item)
										   .user(user)
										   .build();
			orderItems.add(orderItem);
		}
		orderItemRepository.saveAll(orderItems);
	}

}
