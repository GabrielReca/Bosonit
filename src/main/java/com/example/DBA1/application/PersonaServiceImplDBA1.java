package com.example.DBA1.application;

import com.example.DBA1.application.port.PersonaServiceDBA1;
import com.example.DBA1.domain.PersonaDBA1;
import com.example.DBA1.infrastructure.dto.input.PersonaInputDTO;
import com.example.DBA1.infrastructure.dto.output.PersonaOutputDTO;
import com.example.DBA1.infrastructure.repository.PersonaRepositoryDBA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class PersonaServiceImplDBA1 implements PersonaServiceDBA1 {

    @Autowired
    PersonaRepositoryDBA1 pr;

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaDBA1> getData(HashMap<String, Object> conditions)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaDBA1> query= cb.createQuery(PersonaDBA1.class);
        Root<PersonaDBA1> root = query.from(PersonaDBA1.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {
                case "user":
                    predicates.add(cb.equal (root.get(field), (String)value));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "created":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case "GREATER_THAN":
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case "LESS_THAN":
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case "EQUAL":
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public PersonaOutputDTO anhadirPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.usuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.usuario().length() > 10 || personaInputDTO.usuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaDBA1 persona = new PersonaDBA1(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = pasarEntityAPersona(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception {
        if(personaInputDTO.usuario() == null)
            throw new Exception("usuario puede ser nulo");
        else if(personaInputDTO.usuario().length() > 10 || personaInputDTO.usuario().length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            pr.deleteById(id);
            PersonaDBA1 persona = new PersonaDBA1(personaInputDTO);
            pr.save(persona);
            PersonaOutputDTO personaDtoOuput = pasarEntityAPersona(persona);
            return personaDtoOuput;
        }
    }

    @Override
    public PersonaOutputDTO buscarPorID(int id) throws Exception {
        PersonaDBA1 persona = pr.findById(id).orElseThrow(() -> new Exception("id no encontrado"));
        PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(persona);
        return personaOutputDTO;
    }

    @Override
    public List<PersonaOutputDTO> busquedaTodos() {
        List<PersonaDBA1> lista = (List<PersonaDBA1>) pr.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList<>();

        for(PersonaDBA1 i: lista)
        {
            PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(i);
            listaOutput.add(personaOutputDTO);
        }

        return listaOutput;
    }

    @Override
    public PersonaOutputDTO busquedaUsuario(String usuario) throws Exception {
        if(usuario == null)
            throw new Exception("usuario puede ser nulo");
        else if(usuario.length() > 10 || usuario.length() < 6)
            throw new Exception(("longitud del usuario no puede ser superior a 10 caracteres"));
        else {
            PersonaDBA1 persona = pr.buscarPersona(usuario);
            PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(persona);
            return personaOutputDTO;
        }
    }

    @Override
    public PersonaOutputDTO eliminarUsuario(Integer id) throws Exception {
        PersonaDBA1 persona = pr.findById(id).get();
        PersonaOutputDTO personaOutputDTO = pasarEntityAPersona(persona);
        pr.deleteById(id);
        return personaOutputDTO;
    }

    public PersonaOutputDTO pasarEntityAPersona(PersonaDBA1 persona){
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona.getId(), persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(), persona.getCity(), persona.isActive(), persona.getCreated_date(), persona.getImagen_url(), persona.getTermination_date());
        return personaOutputDTO;
    }
}
