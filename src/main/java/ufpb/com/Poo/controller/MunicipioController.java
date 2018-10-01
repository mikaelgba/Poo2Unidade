package ufpb.com.Poo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufpb.com.Poo.exceptions.MunicipioJaExisteException;
import ufpb.com.Poo.exceptions.MunicipioNaoExisteException;
import ufpb.com.Poo.models.AreaDeInteresseTuristico;
import ufpb.com.Poo.models.Municipio;

@RestController
public class MunicipioController {

    AreaDeInteresseTuristico municipios = new AreaDeInteresseTuristico();

    @RequestMapping(value = "/municipio", method = RequestMethod.GET)
    public ResponseEntity<String> listarCidades() throws MunicipioNaoExisteException {

        String ListMuni = municipios.listarCidades();
        return new ResponseEntity<>(ListMuni, HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio/{id}", method = RequestMethod.GET)
    public ResponseEntity<Municipio> pesquisarMunicipio(@PathVariable("") String cidade, String estado)
            throws MunicipioNaoExisteException {

        Municipio ListMuni = this.municipios.pesquisarMunicipio(cidade, estado);
        return new ResponseEntity<>(ListMuni, HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio", method = RequestMethod.POST)
    public ResponseEntity<Object> cadrastrarMunicipio(@RequestBody Municipio entrada)
            throws MunicipioJaExisteException {

        Object saida = this.cadrastrarMunicipio(entrada);
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeletarMunicipio(@RequestBody Municipio municipioDelete)
            throws MunicipioNaoExisteException {

        this.municipios.DeletarMunicipio(municipioDelete);
        return new ResponseEntity<>(municipioDelete + " Apagado", HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Municipio> setMunicipio(@RequestBody Municipio muniAlterar)
            throws MunicipioNaoExisteException {

        this.municipios.SetMunicipio(muniAlterar);
        return new ResponseEntity<>(muniAlterar, HttpStatus.OK);
    }
}

