package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 
@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    private String titulo;

    private String descricao;

    private boolean concluida = false;
}