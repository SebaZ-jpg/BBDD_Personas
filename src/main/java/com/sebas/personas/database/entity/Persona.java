package com.sebas.personas.database.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "libros",
        uniqueConstraints = @UniqueConstraint(name = "uk_libros_isbn", columnNames = "isbn")
)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 13)
    private String isbn;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    @Column(nullable = false)
    private boolean disponible = true;

    protected Persona() {}

    public Persona(String isbn, String titulo, LocalDate fechaPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Long getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public boolean isDisponible() { return disponible; }

    public void marcarNoDisponible() {
        this.disponible = false;
    }
}