package io.github.odevfred.todo_api.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.odevfred.todo_api.model.Tarefa;
import io.github.odevfred.todo_api.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    // Listar todas as tarefas
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // Listar tarefas por ID
    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa com ID " + id + " não encontrada."));
    }

    // Criar tarefa
    public Tarefa criarTarefa(Tarefa tarefa) {
        // Validação de Regra de Negócios
        if (tarefa.getTitulo() == null || tarefa.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título da tarefa é obrigatório e não pode estar vazio.");
        }

        if (tarefa.getDescricao() == null) {
            throw new IllegalArgumentException("A descrição não pode ser nula.");
        }

        // Definindo valores automáticos
        tarefa.setConcluida(false);
        tarefa.setDataCriacao(new Date());

        return tarefaRepository.save(tarefa);
    }

    // Atualizar tarefa
    public Tarefa atualizarTarefa(Long id, Tarefa dadosAtualizados) {
        // Buscar tarefas pelo id
        Tarefa tarefaExistente = buscarPorId(id);

        // Validar o titulo
        if (dadosAtualizados.getTitulo() != null) {
            if (dadosAtualizados.getTitulo().trim().isEmpty()) {
                throw new IllegalArgumentException("O título não pode ser vazio");
            }
            // Atualizar titulo
            tarefaExistente.setTitulo(dadosAtualizados.getTitulo());
        }

        // Atualizar descrição
        if (dadosAtualizados.getDescricao() != null) {
            tarefaExistente.setDescricao(dadosAtualizados.getDescricao());
        }

        // Atualizar status de concluída
        if (dadosAtualizados.getConcluida() != null) {
            tarefaExistente.setConcluida(dadosAtualizados.getConcluida());
        }

        return tarefaRepository.save(tarefaExistente);

    }

    // Deletar tarefa
    public void deletarTarefa(Long id){
        if (!tarefaRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto com ID " + id + " não encontrado");
        }

        tarefaRepository.deleteById(id);
    }

}
