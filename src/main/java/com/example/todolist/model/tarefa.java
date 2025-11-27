package com.example.todolist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    @NotBlank(message = "O título é obrigatório") // Validação 1
    @Size(min = 3, message = "O título deve ter no mínimo 3 caracteres") // Validação 2
    private String titulo;

    private String descricao;

    private boolean concluida = false;
}