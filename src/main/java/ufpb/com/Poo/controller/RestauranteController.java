package ufpb.com.Poo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufpb.com.Poo.exceptions.MunicipioNaoExisteException;
import ufpb.com.Poo.exceptions.RestauranteJaExisteException;
import ufpb.com.Poo.models.AreaDeInteresseTuristico;
import ufpb.com.Poo.models.Restaurante;

@RestController
public class RestauranteController {

    AreaDeInteresseTuristico restaurantes = new AreaDeInteresseTuristico();

    @RequestMapping(value = "/restaurante/{id}", method = RequestMethod.GET)
    public ResponseEntity<Restaurante> getRestaurante(String nomeMunicipio, String estadoMunicipio, String nomeResta)
            throws MunicipioNaoExisteException {

        try {
            Restaurante ListR = restaurantes.getRestaurante(nomeMunicipio, estadoMunicipio, nomeResta);
            return new ResponseEntity<>(ListR, HttpStatus.OK);
        } catch (MunicipioNaoExisteException ex) {
            Logger.getLogger(RestauranteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/restaurante/", method = RequestMethod.GET)
    public ResponseEntity<String> listarRest() throws MunicipioNaoExisteException {

        String ListR = restaurantes.listarRes();
        return new ResponseEntity<>(ListR, HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurante/", method = RequestMethod.POST)
    public ResponseEntity<Restaurante> cadastrarUsuario(@RequestBody Restaurante restCadra, String mini, String estado)
            throws MunicipioNaoExisteException, RestauranteJaExisteException {

        this.restaurantes.cadastrarRestaurante(restCadra, mini, estado);
        return new ResponseEntity<>(restCadra, HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurante/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Restaurante> DeletarUser(@RequestBody Restaurante restCadra, String mini, String estado) {

        try {
            this.restaurantes.DeletarRest(restCadra, mini, estado);
            return new ResponseEntity<>(restCadra, HttpStatus.OK);
        } catch (MunicipioNaoExisteException ex) {
            Logger.getLogger(RestauranteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Restaurante> setRest(@RequestBody Restaurante restSet, String nomeRest) {

        this.restaurantes.setRest(restSet, nomeRest);
        return new ResponseEntity<>(restSet, HttpStatus.OK);

    }
}
