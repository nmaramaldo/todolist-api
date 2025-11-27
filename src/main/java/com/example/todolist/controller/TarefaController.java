package com.example.todolist.controller;

import com.example.todolist.model.Tarefa;
import com.example.todolist.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas") // VERSIONAMENTO
@Tag(name = "Tarefas", description = "Endpoints para gerenciamento de tarefas (Versão 1.0)")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Operation(summary = "Listar todas as tarefas", description = "Retorna uma lista contendo todas as tarefas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Operação bem sucedida")
    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTodas();
    }

    @Operation(summary = "Criar nova tarefa", description = "Cria uma tarefa. O título é obrigatório.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados")
    })
    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa) {
        return new ResponseEntity<>(tarefaService.criar(tarefa), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar tarefa", description = "Atualiza uma tarefa existente baseada no ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(tarefaService.atualizar(id, tarefa));
    }

    @Operation(summary = "Excluir tarefa", description = "Remove uma tarefa do banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tarefa excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}