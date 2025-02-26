package com.bookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mybooks")
public class MyBookList {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	private int id;
	
	private String name;
	private String autor;
	private String precio;
	
	//constructor con parametros
	public MyBookList(int id, String name, String autor, String precio) {
		super();
		this.id = id;
		this.name = name;
		this.autor = autor;
		this.precio = precio;
	}

	//constructor vacio
	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//metodos GET / SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	

}
