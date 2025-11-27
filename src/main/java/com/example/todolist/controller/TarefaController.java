package com.example.todolist.controller;

import com.example.todolist.model.Tarefa;
import com.example.todolist.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/tarefas") 
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // 1. LISTAR TAREFAS (GET)
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // 2. CRIAR TAREFA (POST)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // 3. ATUALIZAR TAREFA (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa dadosAtualizados) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(dadosAtualizados.getTitulo());
                    tarefa.setDescricao(dadosAtualizados.getDescricao());
                    tarefa.setConcluida(dadosAtualizados.isConcluida());
                    Tarefa atualizada = tarefaRepository.save(tarefa);
                    return ResponseEntity.ok().body(atualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    // 4. DELETAR TAREFA (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarTarefa(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefaRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}