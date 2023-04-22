package com.swagger.brn.brn.resources;

import com.swagger.brn.brn.entities.Responseerror;
import com.swagger.brn.brn.entities.Usuario;
import com.swagger.brn.brn.resources.customerrors.BussinesException;
import com.swagger.brn.brn.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content) //Aplica a resposta 400 para todos os endpoints
@ApiResponse(description = "Not Found",responseCode = "404", content = @Content(schema = @Schema(implementation = Responseerror.class))) //Aplica a resposta 400 para todos os endpoints + schema de resposta json
@RestController
@RequestMapping(value = "/usuario", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) //Indica que os endpoints irão produzir tanto json quanto xml
public class Usuarioresource {
    @Autowired
    UsuarioService usuarioService;

    @Operation(summary = "Lista todos os usuarios", description = "Retorna todos os usuarios disponiveis no ambiente", responses = { //add um titulo e descrição
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content) //Informa ao swagger que a operação retorna um status 200
    })
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsers() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @Operation(summary = "Lista usuario por id", description = "Retorna o usuario correspondende ao id passado", responses = { //add um titulo e descrição
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content) //Informa ao swagger que a operação retorna um status 200
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }


    @Operation(summary = "Busca usuarios por parametros", description = "Retorna usuarios com base nos paramtros passados", responses = { //add um titulo e descrição
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content) //Informa ao swagger que a operação retorna um status 200
    })
    @GetMapping("/find")
    public ResponseEntity<Usuario> findByName(@RequestParam(defaultValue = "") String username) {
        if (username.isEmpty()) {
            throw new BussinesException("O Nome não pode ser nulo", HttpStatus.BAD_REQUEST);
        }
        username = username.replace("%20", ""); //tratando clientes webApi mais antigos
        return ResponseEntity.ok().body(usuarioService.findByUsername(username));
    }

    @Operation(summary = "Atualiza o usuario", description = "Atualiza usuario com base no campo passado", responses = { //add um titulo e descrição
            @ApiResponse(responseCode = "204", description = "User updated", content = @Content) //Informa ao swagger que a operação retorna um status 200
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> saveUser(@PathVariable(required = true) Integer id, @RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.status(204).build();
    }

    @Operation(summary = "Cria um novo usuario", description = "Retorna o usuario correspondende ao id passado", responses = { //add um titulo e descrição
            @ApiResponse(responseCode = "201", description = "User Created", content = @Content) //Informa ao swagger que a operação retorna um status 200
    })
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        if (usuario.getLogin().equals("")) {
            throw new BussinesException("O login não pode ser nulo", HttpStatus.BAD_REQUEST);
        }
        HttpStatus status = HttpStatus.CREATED;
        usuarioService.save(usuario);
        Usuario usuarioResposta = new Usuario(usuario.getId(), usuario.getPassword());
        return ResponseEntity.status(status).body(usuarioResposta);
    }

    @Operation(summary = "Deleta um usuario", description = "Remove um usuario pelo id passado", responses = { //add um titulo e descrição
            @ApiResponse(responseCode = "204", description = "User Deleted", content = @Content) //Informa ao swagger que a operação retorna um status 200
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@RequestParam Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
