package com.academia.academiaalunos.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.academia.academiaalunos.domain.Avaliacao;
import com.academia.academiaalunos.requests.AvaliacaoPostRequestBody;
import com.academia.academiaalunos.requests.AvaliacaoPutRequestBody;
import com.academia.academiaalunos.service.AvaliacaoService;
import com.academia.academiaalunos.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("avaliacoes") // http://localhost:8080/avaliacoes
@Log4j2
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AvaliacaoController {
    private final DateUtil dateUtil;
    private final AvaliacaoService avaliacaoService;
    //private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(avaliacaoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Long id){
        return ResponseEntity.ok(avaliacaoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody AvaliacaoPostRequestBody avaliacaoPostRequestBody){
        return new ResponseEntity<>(avaliacaoService.save(avaliacaoPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AvaliacaoPutRequestBody avaliacaoPutRequestBody) {
        avaliacaoService.replace(avaliacaoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        avaliacaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<List<Avaliacao>> findByIdAluno(@PathVariable Long idAluno) {
        List<Avaliacao> avaliacoes = avaliacaoService.findByAluno(idAluno);
        return ResponseEntity.ok(avaliacoes);
    }

}
