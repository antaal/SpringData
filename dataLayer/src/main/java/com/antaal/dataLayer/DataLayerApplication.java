package com.antaal.dataLayer;

import com.antaal.dataLayer.model.Category;
import com.antaal.dataLayer.model.Comment;
import com.antaal.dataLayer.model.Product;
import com.antaal.dataLayer.service.CategoryService;
import com.antaal.dataLayer.service.CommentService;
import com.antaal.dataLayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {
	@Autowired
	private ProductService productService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CategoryService categoryService;
	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

//		categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//
//		Category newCategory = new Category();
//		newCategory.setName("Promotion");
//
//		newCategory = categoryService.addCategory(newCategory);
//
//		categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//
//		productService.getProducts().forEach(
//				product -> System.out.println(product.getName())
//		);
//		Product newProduct = new Product();
//		newProduct.setName("AssuranceAuTiersFidelite");
//		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
//		newProduct.setCost(1100);
//		newCategory.addProduct(newProduct);
//		newProduct=productService.addProduct(newProduct);
//		productService.getProducts().forEach(
//				product -> System.out.println(product.getName())
//		);
//		newProduct.getCategories().forEach(
//				category -> System.out.println(category.getName())
//		);
//		Comment newComment = new Comment();
//		newComment.setContent("Assurance Extraordinaire!");
//		newProduct.addComment(newComment);
//
//		commentService.addComment(newComment);
//
//		Product existingProduct=productService.getProductById(1).get();
//		System.out.println(existingProduct.getCost());
//		existingProduct.setCost(3000);
//		productService.saveProduct(existingProduct);
//
//		existingProduct = productService.getProductById(1).get();
//		System.out.println(existingProduct.getCost());

		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
		searchResults.forEach(product -> System.out.println(product.getProductId()));

		searchResults = productService.getProductsByCategoryName("Standard");
		searchResults.forEach(product -> System.out.println(product.getName()));

		searchResults = productService.getProductsByCostLessThan(1000);
		searchResults.forEach(product -> System.out.println(product.getName()));

		Iterable<Category> searchCategory = categoryService.getCategoryByName("Standard");
		searchCategory.forEach(category -> System.out.println(category.getCategoryId()));

		searchCategory = categoryService.getCategoriesByProductName("AssuranceTousRisques");
		searchCategory.forEach(category -> System.out.println(category.getName()));

		Iterable<Comment> searchComments = commentService.getCommentContaining("deçu");
		searchComments.forEach(comment -> System.out.println(comment.getContent()));
	}


}
