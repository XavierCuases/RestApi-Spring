package edu.uce.service;

import edu.uce.model.Persona;

import java.util.List;

public interface IPersonaService {

    Persona guardar(Persona persona);
    Persona actualizar(Integer id, Persona persona);
    List<Persona> buscarTodos();
    Persona buscarPorId(Integer id);
    void eliminar(Integer id);

}
