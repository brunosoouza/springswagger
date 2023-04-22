package com.swagger.brn.brn.repositorys;

import com.swagger.brn.brn.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

//Esta classe é um "Mock" simulando algumas operações do padrões ja disponiveis na interface Respository do JPA do spring
@Repository
public class UsuarioRepository {

    public void save(Usuario usuario){
        if(usuario.getId() == null)
            System.out.println("SAVE - Salvando novo usuario");
        else
            System.out.println("UPDATE - Atualizando usuario");

        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(format("DELETE - Deleteando usuario no id %d", id));
    }

    public Usuario findById(Integer id){
        System.out.println("FIND - Buscando usuario pelo id");
        return  new Usuario(id, "brn", "1234");
    }

    public List<Usuario> findAll(){
        List<Usuario> usuarioList = new ArrayList<>(Arrays.asList(
                new Usuario(1, "brn", "1234"),
                new Usuario(2, "mth", "4321")));
        return usuarioList;
    }

    public Usuario findByUsername(String username) {
        return new Usuario(1, username, "1234");
    }
}
