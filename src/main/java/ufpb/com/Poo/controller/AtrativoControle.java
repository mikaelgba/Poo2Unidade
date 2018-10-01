package ufpb.com.Poo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufpb.com.Poo.exceptions.AtrativoNaoExisteException;
import ufpb.com.Poo.exceptions.MunicipioNaoExisteException;
import ufpb.com.Poo.models.AreaDeInteresseTuristico;
import ufpb.com.Poo.models.AtrativoTuristico;

@RestController
public class AtrativoControle {
    
    AreaDeInteresseTuristico municipios = new AreaDeInteresseTuristico();
    
    @RequestMapping(value = "/municipio/{id}/atrativos", method = RequestMethod.GET)
    public ResponseEntity<String> getAtrativoTuristicos(@RequestBody String nomeMuni, String estado)
            throws AtrativoNaoExisteException, MunicipioNaoExisteException {
        String saida = this.municipios.getAtrativoTuristicos(nomeMuni, estado);
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio/{id}/atrativos/{id}", method = RequestMethod.GET)
    public ResponseEntity<AtrativoTuristico> getAtrativoTuristicosEspecifico(@RequestBody String nomeMuni, String estado, String nomeAtrat)
            throws AtrativoNaoExisteException, MunicipioNaoExisteException {
        
        AtrativoTuristico saida = this.municipios.getAtrativoTuristicosEspecifico(nomeMuni, estado, nomeAtrat);
        return new ResponseEntity<>((AtrativoTuristico) saida, HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio/{id}/atrativos", method = RequestMethod.POST)
    public ResponseEntity<AtrativoTuristico> cadastrarAtrativoTuristico(@RequestBody AtrativoTuristico Atrativo, String nome, String estado)
            throws AtrativoNaoExisteException, MunicipioNaoExisteException {
        
        this.cadastrarAtrativoTuristico(Atrativo, nome, estado);
        return new ResponseEntity<>(Atrativo, HttpStatus.OK);
    }

    @RequestMapping(value = "/municipio/{id}/atrativos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AtrativoTuristico> deletarAtrativoTuristicosEspecifico(@RequestBody AtrativoTuristico atrati, 
            String muni, String estado) throws AtrativoNaoExisteException, MunicipioNaoExisteException {
        
        this.municipios.deletarAtrativoTuristicosEspecifico(atrati, muni, estado);
        return new ResponseEntity<>(atrati, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/municipio/{id}/atrativos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AtrativoTuristico> setAtrativo(@RequestBody AtrativoTuristico SetAtrati, String muniSet, String estadoSet)
            throws MunicipioNaoExisteException, AtrativoNaoExisteException {

        this.municipios.SetAtrativo(SetAtrati, muniSet, estadoSet);
        return new ResponseEntity<>(SetAtrati, HttpStatus.OK);
    }
    
}
