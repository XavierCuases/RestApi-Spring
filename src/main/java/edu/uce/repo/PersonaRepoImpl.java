package edu.uce.repo;

import edu.uce.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImpl implements IPersonaRepo {

    private List<Persona> listaPersonas;

    public PersonaRepoImpl() {
        this.listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona(1, "Jean", "Marchesini"));
        listaPersonas.add(new Persona(2, "Xavier", "Cuases"));
        listaPersonas.add(new Persona(3, "Erick", "Cabrera"));
    }

    @Override
    public Persona guardar(Persona persona) {
        this.listaPersonas.add(persona);
        return persona;
    }

    @Override
    public Persona actualizar(Integer id, Persona persona) {
        for (int i = 0; i < this.listaPersonas.size(); i++) {
            Persona p = this.listaPersonas.get(i);
            if (p.getIdPersona().equals(id)) {
                this.listaPersonas.set(i, new Persona(id, persona.getNombre(), persona.getApellido()));
                return this.listaPersonas.get(i);
            }
        }
        return new Persona();
    }

    @Override
    public List<Persona> buscarTodos() {
        return this.listaPersonas;
    }

    @Override
    public Persona buscarPorId(Integer id) {
        return this.listaPersonas.stream()
                .filter(p -> p.getIdPersona().equals(id))
                .findFirst()
                .orElse(new Persona());
    }

    @Override
    public void eliminar(Integer id) {
        this.listaPersonas.removeIf(p -> p.getIdPersona().equals(id));
    }
}
