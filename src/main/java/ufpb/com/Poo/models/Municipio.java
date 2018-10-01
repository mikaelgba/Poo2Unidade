package ufpb.com.Poo.models;

import java.util.List;


public class Municipio {
 
    private String nome;
    private double populacao;
    private List<AtrativoTuristico> AtrativoTuristicos;
    private double latitude;
    private double longetude;
    private List<TipoDeHospedagem> TipoDeHospedagens;
    private List<Restaurante> restaurante;
    private String estado;
    private String site;
    private Object getAtrativoTuristicos;

    public Municipio() {
    }

    public Municipio(String nome, double populacao, List<AtrativoTuristico> AtrativoTuristicos, double latitude,
            double longetude, List<TipoDeHospedagem> TipoDeHospedagens, List<Restaurante> restaurante, String estado,
            String site) {
        this.nome = nome;
        this.populacao = populacao;
        this.AtrativoTuristicos = AtrativoTuristicos;
        this.latitude = latitude;
        this.longetude = longetude;
        this.TipoDeHospedagens = TipoDeHospedagens;
        this.restaurante = restaurante;
        this.estado = estado;
        this.site = site;
    }

    public void setMunicipio(String municipio) {
        this.nome = municipio;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public List<AtrativoTuristico> getAtrativoTuristicos() {
        return this.AtrativoTuristicos;
    }

    public void setAtrativoTuristicos(List<AtrativoTuristico> AtrativoTuristicos) {
        this.AtrativoTuristicos = AtrativoTuristicos;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setlatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongetude() {
        return this.longetude;
    }

    public void setLongetude(double longetude) {
        this.longetude = longetude;
    }

    public List<TipoDeHospedagem> getTipoDeHospedagem() {
        return this.TipoDeHospedagens;
    }

    public void setTipoDeHospedagem(List<TipoDeHospedagem> TipoDeHospedagens) {
        this.TipoDeHospedagens = TipoDeHospedagens;
    }

    public List<Restaurante> getRestaurante() {
        return this.restaurante;
    }

    public void setRestaurante(List<Restaurante> Restaurantes) {
        this.restaurante = Restaurantes;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo) {
        this.AtrativoTuristicos.add(atrativo);
    }
    public void cadastrarRestaurante(Restaurante restaurante) {
        this.restaurante.add(restaurante);
    }

    public void cadastrarTipoDeHospedagem(TipoDeHospedagem TipoDeHospedagem) {
        this.TipoDeHospedagens.add(TipoDeHospedagem);
    }           
}
