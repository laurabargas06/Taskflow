package com.taskflow.taskflow.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioservice;

    @GetMapping
    public Iterable<Usuario> listarUsuarios() {
        return usuarioservice.buscarUsuarios();
    }
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioservice.buscarUsuario(id);
    }
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioservice.criarUsuario(usuario);
    }
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return usuarioservice.atualizarUsuario(usuario);
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioservice.deletarUsuario(id);
    }
}
