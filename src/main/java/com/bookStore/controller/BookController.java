package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.LibroService;
import com.bookStore.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	private LibroService servicio;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String guia(){
		return "guia";
	}
	
	@GetMapping("/registro_libro")
	public String libroRegistrar() {
		return "libroRegistrar";
	}
	
	@GetMapping("/Libros_disponibles")
	public ModelAndView getAllBook() {
		List<Book>list=servicio.getAllBook();
		//ModelAndView m = new ModelAndView();
		//m.setViewName("listaLibro");
		//m.addObject("book",list);
		return new ModelAndView("listaLibro","book",list);
	}
	
	@PostMapping("/save")
	public String agregarLibro(@ModelAttribute Book b) {
		servicio.save(b);
		return "redirect:/Libros_disponibles";
	}
	
	@GetMapping("/mi_libros")
	public String getMyBooks(Model model) {
		
		List<MyBookList> list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "misLibros";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id")int id) {
		
		Book b=servicio.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAutor(),b.getPrecio());
		myBookService.saveMyBooks(mb);
		return "redirect:/mi_libros";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
	  	Book b = servicio.getBookById(id);
	  	model.addAttribute("book",b);
		return "editarLibro";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		servicio.deleteById(id);
		return "redirect:/Libros_disponibles";
	}
}













































