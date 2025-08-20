//package com.library.serviceimplementation;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.library.Entity.Book_Category;
//import com.library.ServiceLiare.CategoryService;
//import com.library.dao.BookCategoryRepository;
//
//@Service
//public class CategoryServiceImpl implements CategoryService{
//	
//	 @Autowired
//	    private BookCategoryRepository categoryRepository;
//
//	 @Override
//	 public int saveOrGetCategory(String categoryName) {
//     Book_Category category = categoryRepository.findByCategoryName(categoryName);
//	     if (category == null) {
//	         category = new Book_Category(); 
//	         category.setCategoryName(categoryName);
//	         category.setTotalBooks(0); // default, will update later
//	         category = categoryRepository.save(category); // reassign to get ID
//	     }
//	     return category.getCategoryId();  // return the categoryId (int)
//	 }
//
//
//	
//
//
//
//
//
//
////	@Override
////	public void updateAvailableBookCount() {
////		// TODO Auto-generated method stub
////		
////	}
//
//
//	@Override
//	public Book_Category save(Book_Category category) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//}
