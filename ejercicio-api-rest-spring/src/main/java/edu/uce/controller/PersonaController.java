package edu.uce.controller;

import edu.uce.model.Persona;
import edu.uce.service.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final IPersonaService service;

    @GetMapping
    public List<Persona> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Persona buscarPorId(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Persona guardar(@RequestBody Persona persona){
        return service.guardar(persona);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable("id") Integer id, @RequestBody Persona persona){
        return service.actualizar(id, persona);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
    }
}
