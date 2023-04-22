package com.swagger.brn.brn.services;
import com.swagger.brn.brn.entities.Usuario;
import com.swagger.brn.brn.repositorys.UsuarioRepository;
import com.swagger.brn.brn.resources.customerrors.BussinesException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService extends UsuarioRepository {
    public UsuarioService() {

    }
}
