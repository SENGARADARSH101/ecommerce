package com.serviceops.ecommerce;


import com.serviceops.ecommerce.dto.cart.AddToCartDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import com.serviceops.ecommerce.service.CartService;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class CartRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ProductRepository pRepo;

	@Autowired
	private CategoryRepository crepo;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartService cartService;

	@Autowired
	private SubCategoryRepository subCaterepo;

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository userRepository;
	@Test

	void addProductToCart() {
		Category c = crepo.save(new Category("Electronics"));
		SubCategory subcat = subCaterepo.save(new SubCategory("Laptop",c));
		Product product = pRepo.save(new Product("Lenovo", "New ",47848,subcat));
		UserDto save = service.getUser("rohan@gmail.com");
		AddToCartDto addToCartDto = new AddToCartDto();
		addToCartDto.setQuantity(43);
		cartService.addToCart(addToCartDto,product,save);


	}

	@Test
	void addProductToCartRepo(){
		User save = userRepository.findByUserEmail("customer@gmail.com");
//		User save = userRepository.save(new User("dipendra", "sharma", "rohan@gmail.com", "12345678", Role.ADMIN));
		Category c = crepo.save(new Category("Electronics"));

		SubCategory subcat = subCaterepo.save(new SubCategory("Laptop",c));
		Product product = pRepo.save(new Product("new", "New ",54633,subcat));
		cartRepository.save(new Cart(product,save,3));

	}

	@Test
	void getCartList(){
		User save = userRepository.findByUserEmail("rohan@gmail.com");
//		cartService.cartItemsList(save);
//		System.out.println(cartService.cartItemsList(save));
		System.out.println(cartService.cartItemsList(save));
	}






}
