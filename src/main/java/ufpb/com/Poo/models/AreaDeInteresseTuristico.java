package ufpb.com.Poo.models;

import java.util.ArrayList;
import java.util.List;
import static org.apache.catalina.security.SecurityUtil.remove;

import ufpb.com.Poo.exceptions.AtrativoJaExisteException;
import ufpb.com.Poo.exceptions.MunicipioJaExisteException;
import ufpb.com.Poo.exceptions.MunicipioNaoExisteException;
import ufpb.com.Poo.exceptions.RestauranteJaExisteException;
import ufpb.com.Poo.exceptions.TipoDeHospedagemJaExisteException;
import ufpb.com.Poo.exceptions.UsuarioSisTurJaExisteException;

public class AreaDeInteresseTuristico {

    private String nome;
    private List<Municipio> municipios;
    private List<UsuarioSisTur> CadraSisTur;
    public AreaDeInteresseTuristico cadrastrarMunicipioentrada;

    public AreaDeInteresseTuristico(String nome, List<Municipio> municipios, List<UsuarioSisTur> CadraSisTur) {
        this.nome = nome;
        this.municipios = municipios;
        this.CadraSisTur = CadraSisTur;
    }

    public AreaDeInteresseTuristico() {
        this.nome = " ";
        this.municipios = new ArrayList<>();
        this.CadraSisTur = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Municipio> getMunicipios() {
        return this.municipios;
    }

    public void setMunicipio(List<Municipio> municipio) {
        municipios = municipio;
    }

    public List<UsuarioSisTur> getCadrasSisTur() {
        return this.CadraSisTur;
    }

    public void setCadrasSisTur(List<UsuarioSisTur> cadraSisTur) {
        CadraSisTur = cadraSisTur;
    }

    public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo, String nomeMunicipio, String estado) throws MunicipioNaoExisteException,
            AtrativoJaExisteException {
        Municipio muni = this.pesquisarMunicipio(nomeMunicipio, estado);
        for (AtrativoTuristico A : muni.getAtrativoTuristicos()) {
            if (A.getNome().equalsIgnoreCase(atrativo.getNome())) {
                throw new AtrativoJaExisteException("Atrativo j� cadrastrado: " + atrativo.getNome() + "!");
            }
        }
        muni.cadastrarAtrativoTuristico(atrativo);
    }

    public String getAtrativoTuristicos(String nomeMunicipio, String estadoMunicipio)
            throws MunicipioNaoExisteException {
        String retorno = "";
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(nomeMunicipio) && m.getEstado().equalsIgnoreCase(estadoMunicipio)) {
                for( AtrativoTuristico n: m.getAtrativoTuristicos()){
                    retorno += m.getNome() + "\n";
                }      
            } else {
                throw new MunicipioNaoExisteException("municipio n�o existe " + nomeMunicipio);
            }
        }
        return retorno;
    }

    public AtrativoTuristico getAtrativoTuristicosEspecifico(String nomeMunicipio, String estadoMunicipio, String nomeAtrati)
            throws MunicipioNaoExisteException {
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(nomeMunicipio) && m.getEstado().equalsIgnoreCase(estadoMunicipio)) {
                for( AtrativoTuristico n: m.getAtrativoTuristicos()){
                    if( n.getNome().equalsIgnoreCase(nomeAtrati)){
                        return n;
                    }
                }
            } else {
                throw new MunicipioNaoExisteException("municipio n�o existe " + nomeMunicipio);
            }
        }
        return null;
    }

    public void deletarAtrativoTuristicosEspecifico(AtrativoTuristico atrativo, String nomeMunicipio, String estadoMunicipio)
            throws MunicipioNaoExisteException {
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(nomeMunicipio) && m.getEstado().equalsIgnoreCase(estadoMunicipio)) {
                for (AtrativoTuristico n : m.getAtrativoTuristicos()) {
                    if (n.getNome().equalsIgnoreCase(atrativo.getNome())) {
                        remove(n);
                    }
                }
            } else {
                throw new MunicipioNaoExisteException("municipio ou atrativo não existe " + nomeMunicipio);
            }
        }
    }

    public void SetAtrativo(AtrativoTuristico SetAtrati, String cidade, String Nome) throws MunicipioNaoExisteException {
        boolean existente = false;
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(cidade)) {
                for (AtrativoTuristico n : m.getAtrativoTuristicos()) {
                    if (n.getNome().equalsIgnoreCase(SetAtrati.getNome())) {
                        n.setNome(SetAtrati.getNome());
                        n.setComoChegar(SetAtrati.getComoChegar());
                        n.setInfoContato(SetAtrati.getInfoContato());
                        n.setEnderco(SetAtrati.getEnderco());
                        n.setSite(SetAtrati.getSite());
                        existente = true;
                        break;
                    }
                }
            }
        }
        if (!existente) {
            throw new MunicipioNaoExisteException(
                    "Municipio " + SetAtrati.getNome() + " não cadrastrado no SisTur.");
        }
    }

    public String listarCidades() throws MunicipioNaoExisteException {
        List<Municipio> muni = getMunicipios();
        String listaMunicipios = "Lista de Municipios: " + "\n";
        for (Municipio m : muni) {
            listaMunicipios += m.getNome() + "\n";
        }
        return listaMunicipios;
    }

    public void cadrastrarMunicipio(Municipio muni) throws MunicipioJaExisteException {
        boolean existente = false;
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(muni.getNome())) {
                existente = true;
                break;
            }
        }
        if (!existente) {
            this.municipios.add(muni);
        } else {
            throw new MunicipioJaExisteException(
                    "Municipio " + muni.getNome() + " j� cadrastrado no SisTur.");
        }
    }

    public void DeletarMunicipio(Municipio muni) throws MunicipioNaoExisteException {
        boolean existente = false;
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(muni.getNome())) {
                existente = true;
                break;
            }
        }
        if (!existente) {
            this.municipios.remove(muni);
        } else {
            throw new MunicipioNaoExisteException(
                    "Municipio " + muni.getNome() + " não cadrastrado no SisTur.");
        }
    }

    public void SetMunicipio(Municipio muni) throws MunicipioNaoExisteException {
        boolean existente = false;
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(muni.getNome())) {
                m.setNome(muni.getNome());
                m.setlatitude(muni.getLatitude());
                m.setLongetude(muni.getLongetude());
                m.setPopulacao(muni.getPopulacao());
                m.setAtrativoTuristicos(muni.getAtrativoTuristicos());
                m.setRestaurante(muni.getRestaurante());
                m.setTipoDeHospedagem(muni.getTipoDeHospedagem());
                m.setEstado(muni.getEstado());
                m.setSite(muni.getSite());
                existente = true;
                break;
            }
        }
        if (!existente) {
            throw new MunicipioNaoExisteException(
                    "Municipio " + muni.getNome() + " não cadrastrado no SisTur.");
        }
    }

    public Municipio pesquisarMunicipio(String municipio, String estado) throws MunicipioNaoExisteException {
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(municipio) && m.getEstado().equalsIgnoreCase(estado)) {
                return m;
            }
        }
        throw new MunicipioNaoExisteException("Municipio " + municipio + " n�o existe no SisTur!");
    }

    public void cadastrarRestaurante(Restaurante restaurante, String nomeMunicipio, String estado) throws MunicipioNaoExisteException,
            RestauranteJaExisteException {
        Municipio muni = this.pesquisarMunicipio(nomeMunicipio, estado);
        for (Restaurante A : muni.getRestaurante()) {
            if (A.getNome().equalsIgnoreCase(restaurante.getNome())) {
                throw new RestauranteJaExisteException("Restauranre j� cadrastrado: " + restaurante.getNome() + "!");
            }
        }
        muni.cadastrarRestaurante(restaurante);
    }

    public Restaurante getRestaurante(String nomeMunicipio, String estadoMunicipio, String nomeResta)
            throws MunicipioNaoExisteException {
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(nomeMunicipio) && m.getEstado().equalsIgnoreCase(estadoMunicipio)) {
                for( Restaurante n: m.getRestaurante()){
                    if(n.getNome().equalsIgnoreCase(nomeResta)){
                        return n;
                    }
                    
                }
            } else {
                throw new MunicipioNaoExisteException("Municipio n�o existe " + nomeMunicipio);
            }
        }
        return null;
    }
    public void DeletarRest(Restaurante restCadra, String mini, String estado) throws MunicipioNaoExisteException { 
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(mini) && m.getEstado().equalsIgnoreCase(estado)) {
                for (Restaurante n : m.getRestaurante()) {
                    if (n.getNome().equalsIgnoreCase(restCadra.getNome())) {
                        remove(n);
                    }
                }
            } else {
                throw new MunicipioNaoExisteException("municipio ou atrativo não existe " + restCadra.getNome());
            }
        }      
    }
    public String listarRes() {
        
        List<Municipio> muni = getMunicipios();
        String listaRest = "Lista de Restaurantes: " + "\n";
        for (Municipio m : muni) {
            for( Restaurante n:  m.getRestaurante()){
                listaRest  += m.getNome() + "\n";
            }         
        }
        return listaRest ;
    }
    
    public void setRest(Restaurante restSet, String nomeRest) {
        
        for (Municipio m : this.municipios) {
            for (Restaurante n: m.getRestaurante()) {
                if( n.getNome().equalsIgnoreCase(nomeRest)){
                    n.setNome(restSet.getNome());
                    n.setTipoDeResratrante(restSet.getTipoDeRestaurante());
                    n.setClassificacao(restSet.getClassificacao());
                    n.setSite(restSet.getSite());
                    n.setInfoContato(restSet.getInfoContato());
                    n.setEndereco(restSet.getEndereco());
                    break;                   
                }
                break;
            }
        }
    }

    public void cadastrarTipoDeHospedagem(TipoDeHospedagem hospedagem, String nomeMunicipio, String estado) throws MunicipioNaoExisteException,
            TipoDeHospedagemJaExisteException {
        Municipio muni = this.pesquisarMunicipio(nomeMunicipio, estado);
        for (TipoDeHospedagem A : muni.getTipoDeHospedagem()) {
            if (A.getNome().equalsIgnoreCase(hospedagem.getNome())) {
                throw new TipoDeHospedagemJaExisteException("Hospedagem já cadrastra: " + hospedagem.getNome() + "!");
            }
        }
        muni.cadastrarTipoDeHospedagem(hospedagem);
    }

    public List<TipoDeHospedagem> getTipoDeHospedagens(String nomeMunicipio, String estadoMunicipio)
            throws MunicipioNaoExisteException {
        for (Municipio m : this.municipios) {
            if (m.getNome().equalsIgnoreCase(nomeMunicipio) && m.getEstado().equalsIgnoreCase(estadoMunicipio)) {
                return m.getTipoDeHospedagem();
            } else {
                throw new MunicipioNaoExisteException("Municipio n�o existe " + nomeMunicipio);
            }
        }
        return null;
    }

    public void cadastrarUsuario(UsuarioSisTur usuario) throws UsuarioSisTurJaExisteException {
        for (UsuarioSisTur A : getCadrasSisTur()) {
            if (A.getNome().equalsIgnoreCase(usuario.getNome())) {
                throw new UsuarioSisTurJaExisteException("Usuario J� Cadrastrado");
            }
        }
        this.CadraSisTur.add(usuario);
    }

    public String GetUsuario(UsuarioSisTur user) {
        String ListUsers = "";
        for (UsuarioSisTur A : getCadrasSisTur()) {
            ListUsers += A.getNome() + "\n";
        }
        return ListUsers;
    }

    public UsuarioSisTur GetUsuarioEspeficico(UsuarioSisTur user, String nome) {

        for (UsuarioSisTur m : this.CadraSisTur) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

    public void DeletarUser(UsuarioSisTur userDel, String nome, String cpf) {

        for (UsuarioSisTur m : this.CadraSisTur) {
            if (m.getNome().equalsIgnoreCase(nome) && m.getCpf().equalsIgnoreCase(cpf)) {
                this.CadraSisTur.remove(userDel);
                break;
            }
        }
    }

    public void setUser(UsuarioSisTur userSet, String cpf) throws UsuarioSisTurJaExisteException{

        boolean existente = false;
        for (UsuarioSisTur m : this.CadraSisTur) {
            if (m.getNome().equalsIgnoreCase(userSet.getNome()) && m.getCpf().equalsIgnoreCase(userSet.getCpf())) {
                m.setNome(userSet.getNome());
                m.setCpf(userSet.getCpf());
                m.setNumero(userSet.getNumero());
                m.setRg(userSet.getRg());
                existente = true;
                break;
            }
        }
        if (!existente) {
            throw new UsuarioSisTurJaExisteException(
                    "Usuario " + userSet.getNome() + " não cadrastrado no SisTur.");
        }
    }
}
