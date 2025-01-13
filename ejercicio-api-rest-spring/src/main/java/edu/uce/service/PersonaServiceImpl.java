package edu.uce.service;

import edu.uce.model.Persona;
import edu.uce.repo.IPersonaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements IPersonaService{

    private final IPersonaRepo repo;

    @Override
    public Persona guardar(Persona persona){
        return repo.guardar(persona);
    }

    @Override
    public Persona actualizar(Integer id, Persona persona) {
        return repo.actualizar(id, persona);
    }

    @Override
    public List<Persona> buscarTodos() {
        return repo.buscarTodos();
    }

    @Override
    public Persona buscarPorId(Integer id) {
        if(id > 0){
            return repo.buscarPorId(id);
        }
        return new Persona();
    }

    @Override
    public void eliminar(Integer id) {
        repo.eliminar(id);
    }

}
