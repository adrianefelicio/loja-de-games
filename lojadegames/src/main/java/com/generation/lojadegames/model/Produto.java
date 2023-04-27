package com.generation.lojadegames.model;


	import java.time.LocalDateTime;

	import org.hibernate.annotations.UpdateTimestamp;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.lojadegames.model.Usuario;

import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.Size;

	@Entity
	@Table(name="tb_produtos")

	public class Produto {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "O título é obrigatório!")
		@Size(min = 5 , max = 100, message = "O título deve conter entra 5 e 100 caracteres!")
		private String titulo;
		
		@NotBlank(message = "O texto do produto é obrigatório!")
		@Size(min = 10, max = 1000, message = "O texto da postagem deve conter entre 10 e 1000 caracteres")
		private String texto;
		
		@UpdateTimestamp
		private LocalDateTime data;

		public Long getId() {
			return id;
		}
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Usuario usuario;


		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public LocalDateTime getData() {
			return data;
		}

		public void setData(LocalDateTime data) {
			this.data = data;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
		
	}


