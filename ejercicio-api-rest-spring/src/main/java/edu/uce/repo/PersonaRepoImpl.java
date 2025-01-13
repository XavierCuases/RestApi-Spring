package edu.uce.repo;

import edu.uce.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImpl implements IPersonaRepo{

    private List<Persona> listaPersonas;

    public PersonaRepoImpl(){
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
        for(Persona p : this.listaPersonas){
            if(p.getIdPersona() == id){
                this.listaPersonas.remove(persona);
                this.listaPersonas.add(new Persona(id, persona.getNombre(), persona.getApellido()));
                return persona;
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
        for(Persona p : this.listaPersonas){
            if(p.getIdPersona() == id){
                return p;
            }
        }
        return new Persona();
    }

    @Override
    public void eliminar(Integer id) {
        for(Persona p : this.listaPersonas){
            if(p.getIdPersona() == id){
                this.listaPersonas.remove(p);
                return;
            }
        }
    }

}
