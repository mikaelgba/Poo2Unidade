package ufpb.com.Poo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufpb.com.Poo.exceptions.UsuarioSisTurJaExisteException;
import ufpb.com.Poo.models.AreaDeInteresseTuristico;
import ufpb.com.Poo.models.UsuarioSisTur;

@RestController
public class UsuarioController {

    AreaDeInteresseTuristico usuarios = new AreaDeInteresseTuristico();

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public ResponseEntity<UsuarioSisTur> cadastrarUsuario(@RequestBody UsuarioSisTur user)
            throws UsuarioSisTurJaExisteException {

        this.usuarios.cadastrarUsuario(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<UsuarioSisTur> GetUsuario(@RequestBody UsuarioSisTur user)
            throws UsuarioSisTurJaExisteException {

        this.usuarios.GetUsuario(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioSisTur> GetUsuarioEspeficico(@RequestBody UsuarioSisTur user, String nome) {

        UsuarioSisTur userEsp = this.usuarios.GetUsuarioEspeficico(user, nome);
        return new ResponseEntity<>(userEsp, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsuarioSisTur> DeletarUser(@RequestBody UsuarioSisTur userDel, String nome, String cpf) {

        this.usuarios.DeletarUser(userDel, nome, cpf);
        return new ResponseEntity<>(userDel, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UsuarioSisTur> setUser(@RequestBody UsuarioSisTur userSet, String cpf){

        try {
            this.usuarios.setUser(userSet, cpf);
            return new ResponseEntity<>(userSet, HttpStatus.OK);
        } catch (UsuarioSisTurJaExisteException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
}
