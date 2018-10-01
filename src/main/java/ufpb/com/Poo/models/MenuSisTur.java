package ufpb.com.Poo.models;

import java.util.List;

import javax.swing.JOptionPane;
import ufpb.com.Poo.exceptions.AtrativoJaExisteException;
import ufpb.com.Poo.exceptions.MunicipioNaoExisteException;
import ufpb.com.Poo.exceptions.RestauranteJaExisteException;
import ufpb.com.Poo.exceptions.TipoDeHospedagemJaExisteException;

public class MenuSisTur {
	
	public static void main(String[] args) {
		
		AreaDeInteresseTuristico aIT = new AreaDeInteresseTuristico();
		
		boolean sair = false;
		while (!sair) {
			
			String opcao = JOptionPane.showInputDialog(
					"Escolha entre as op��o a sua desejada:" + "\n"
					+ "Op��o 1: Cadrastrar municipio" + "\n"
					+ "Op��o 2: Cadastrar Atrativos" + "\n"
					+ "Op��o 3: Cadastrar Restaurantes" + "\n"
					+ "Op��o 4: Cadastrar Hospedagens" + "\n"
					+ "Op��o 5: Lista de municipios cadastrados" + "\n" 
					+ "Op��o 6: Listar atrativos, Restaurantes ou Hospedagens de cidade espeficica"+ "\n" 
					+ "Op��o 7: Sair");
			
			switch (opcao){
			//Cadrastra Municipio
			case  "1":
				/*String nome = JOptionPane.showInputDialog("Digite o nome do municipio para o cadastro: ");
				double populacao = Double.parseDouble( JOptionPane.showInputDialog("Digite a quantidade da popula��o do municipio para o cadastro: "));
				List<AtrativoTuristico> atrativo = new ArrayList<AtrativoTuristico>();
				double latitude = Double.parseDouble(JOptionPane.showInputDialog("Digite a latitude do municipio para o cadastro: "));
				double longetude = Double.parseDouble(JOptionPane.showInputDialog("Digite a longetude do municipio para o cadastro: "));
				List<TipoDeHospedagem> tipoDeHospedagem = new ArrayList<TipoDeHospedagem>();
				List<Restaurante> restaurante = new ArrayList<Restaurante>();
				String estado = JOptionPane.showInputDialog("Digite o nome do estado do municipio para o cadastro: ");
				String site = JOptionPane.showInputDialog("Digite o site do municipio para o cadastro: ");
				Municipio muni = new Municipio(nome, populacao, atrativo, latitude, longetude, tipoDeHospedagem, restaurante, estado, site);
				try {
					aIT.cadrastrarMunicipio(muni);
					JOptionPane.showMessageDialog(null, "cadastro realizado no SisTur!");
				} catch (MunicipioJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}*/
				break;
			
			//Cadrastra Atrativos
			case "2":
				
				boolean periTuba = false;
				boolean propBanho = false;
				String TipoOrla = "";
				boolean sair2 = false;
				while(!sair2) {
					
					String MunicipioDaAtracao = JOptionPane.showInputDialog("digite o nome do Municipio: ");
					String EstadoDaAtracao = JOptionPane.showInputDialog("digite o nome do estado: ");
					String opcao2 = JOptionPane.showInputDialog("Escolha entre as op��es:" 
					+ "\n" + "Op��o 1: Praia"
					+ "\n" + "Op��o 2: Shopping" 
					+ "\n" + "Op��o 3: Teatro" 
					+ "\n" + "Op��o 4: Evento");
					
					String nomeAtrativoTuristico = JOptionPane.showInputDialog("Digite o nome do atrativo turistico: ");
					String comoChegarAtrativoTuristico = JOptionPane.showInputDialog("Digite como chegar ao atrativo: ");
					String siteAtrativoTuristico = JOptionPane.showInputDialog("Digite o site do atrativo: ");
					String infoContatoAtrativoTuristico = JOptionPane.showInputDialog("Digite informa��o de contato do atrativo: ");
					String lougradouro = JOptionPane.showInputDialog("lougradouro: ");
					String numero = JOptionPane.showInputDialog("numero: ");
					String bairro = JOptionPane.showInputDialog("bairro: ");
					Endereco endereco = new Endereco(lougradouro, numero, bairro);				
					switch(opcao2) {					
					case "1":						
						String opcao3 = JOptionPane.showInputDialog("digite o tipo de orla, se �" + "\n"
								+ "Op��o 1: Mar Aberto" + "\n"
								+ "Op��o 2: Pequenas Ondas" + "\n"
								+ "Op��o 3: Mar Abrigado" + "\n"
								+ "Op��o 4: Ondas Medias" + "\n"
								+ "Op��o 5: Piscinas Naturais" + "\n" 
								+ "Op��o 6: Ondas Forte");						
						switch (opcao3) {					
						case "1":
							TipoOrla = Praia.TIPO_MAR_ABERTO;
							break;
						case "2":
							TipoOrla = Praia.TIPO_PEQUENAS_ONDAS;
							break;
						case "3":
							TipoOrla = Praia.TIPO_MAR_ABRIGADO;
							break;
						case "4":
							TipoOrla = Praia.TIPO_ONDAS_MEDIAS;
							break;
						case "5":
							TipoOrla = Praia.TIPO_PISCINAS_NATURAIS;
							break;
						case "6":
							TipoOrla = Praia.TIPO_ONDAS_FORTES;
							break;
						}
						String opcao4 = JOptionPane.showInputDialog("esta praia � propria para banho" + "\n"
								+ "Op��o 1: Propria para banho ? " + "\n" 
								+ "Op��o 2: N�o � propra para banho ? :");					
						switch (opcao4) {
						case "1":
							propBanho = true;
							break;
						case "2":
							propBanho = false;
							break;
						}
						String opcao5 = JOptionPane.showInputDialog("esta praia � propria para banho" + "\n"
								+ "Op��o 1: tem perigo de tubar�o ? " + "\n" 
								+ "Op��o 2: N�o h� perigo de tubar�o ?");
						switch (opcao5) {
						
						case "1":
							periTuba = true;
							break;
						case "2":
							periTuba = false;
							break;
						}
						AtrativoTuristico praia = new Praia(nomeAtrativoTuristico, comoChegarAtrativoTuristico, siteAtrativoTuristico,
								infoContatoAtrativoTuristico, periTuba, propBanho, TipoOrla, endereco);
						try {
							aIT.cadastrarAtrativoTuristico(praia, MunicipioDaAtracao, EstadoDaAtracao);
						} catch ( MunicipioNaoExisteException e ) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						} catch ( AtrativoJaExisteException e ) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						sair2 = true;
						break;
					//Shopping
					case "2":
						String HoraAbertura = JOptionPane.showInputDialog("Horario de Abertura:  ");
						String HoraFechamento = JOptionPane.showInputDialog("Horario de Fechamendo: ");
						Shopping shop = new Shopping( nomeAtrativoTuristico, comoChegarAtrativoTuristico, siteAtrativoTuristico,
								infoContatoAtrativoTuristico, HoraAbertura, HoraFechamento, endereco);
						try{
							aIT.cadastrarAtrativoTuristico( shop, MunicipioDaAtracao, EstadoDaAtracao );
						} catch ( MunicipioNaoExisteException e ){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}  catch ( AtrativoJaExisteException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						sair2 = true;
						break;
					//Teatro
					case "3":
						int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade Maxima: "));
						double ingresso = Double.parseDouble(JOptionPane.showInputDialog("Digite valor do ingresso: "));
						String TipoEspetaculo = JOptionPane.showInputDialog("Tipo do espetaculo: ");
						String infoEspetaculo = JOptionPane.showInputDialog("Informa��es ou descri��es do espetaculo: ");
						String abertura = JOptionPane.showInputDialog("Horario de inicio: ");
						String fechamento = JOptionPane.showInputDialog("Horario do termino: ");
						
						Teatro teatro = new Teatro( nomeAtrativoTuristico, comoChegarAtrativoTuristico, siteAtrativoTuristico,
								infoContatoAtrativoTuristico, TipoEspetaculo, capacidade, ingresso, infoEspetaculo, abertura, fechamento, endereco);
						try{
							aIT.cadastrarAtrativoTuristico( teatro, MunicipioDaAtracao, EstadoDaAtracao );
						} catch ( MunicipioNaoExisteException e ){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}  catch ( AtrativoJaExisteException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						sair2 = true;
						break;	
					//Evento
					case "4":
						String tipoDeEvento = "";
						String inicio = JOptionPane.showInputDialog("Horario de inicio: ");
						String fim = JOptionPane.showInputDialog("Horario de encerramento: ");
						String tipodeEventoEntrada = JOptionPane.showInputDialog("Tipo de evento: " + "\n" 
						+ "1: Evento Aberto" + "\n"
						+ "2: Evento Privado");
						switch ( tipodeEventoEntrada ){
						case "1":
							tipoDeEvento = EventoProgramado.FESTA_ABERTA;
							break;
						case "2":
							tipoDeEvento = EventoProgramado.FESTA_PRIVADA;
							break;
						}
						float entrada = Float.parseFloat(JOptionPane.showInputDialog("Valor da Entrada: "));
						
						EventoProgramado evento = new EventoProgramado( nomeAtrativoTuristico, comoChegarAtrativoTuristico, siteAtrativoTuristico,
								infoContatoAtrativoTuristico,inicio, fim, tipoDeEvento, entrada, endereco);
						try{
							aIT.cadastrarAtrativoTuristico( evento, MunicipioDaAtracao, EstadoDaAtracao );
						} catch ( MunicipioNaoExisteException e ){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}  catch ( AtrativoJaExisteException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						sair2 = true;
						break;
					}
				}
				break;
			//Cadastrar Restaurante
			case "3":
				String classificacao = "";
				String tipo = "";
				boolean sair3 = false;
				while(!sair3) {
					String Municipio = JOptionPane.showInputDialog("digite o nome do Municipio: ");
					String Estado= JOptionPane.showInputDialog("digite o nome do estado: ");
					String nomeRestaurante = JOptionPane.showInputDialog("nome do estabelecimento: ");
					String siteRestaurante = JOptionPane.showInputDialog("Site: ");
					String infoRestaurante = JOptionPane.showInputDialog("Informa��o para contato: ");
					String lougradouro = JOptionPane.showInputDialog("lougradouro: ");
					String numero = JOptionPane.showInputDialog("numero: ");
					String bairro = JOptionPane.showInputDialog("bairro: ");
					Endereco endereco = new Endereco(lougradouro, numero, bairro);
					String opcao6 = JOptionPane.showInputDialog("Tipo de Restaurante" + "\n"
							+ "Op��o 1: Restaurante" + "\n"
							+ "Op��o 2: Bar" + "\n"
							+ "Op��o 3: Lanchonete" + "\n"
							+ "Op��o 4: Cafeteria" + "\n"
							+ "Op��o 5: Fast food" + "\n" 
							+ "Op��o 6: Food truck");
					switch (opcao6) {
					case "1":
						tipo = Restaurante.TIPO_RESTAURANTE;
						break;
					case "2":
						tipo = Restaurante.TIPO_BAR;
						break;
					case "3":
						tipo = Restaurante.TIPO_LANCHONETE;
						break;
					case "4":
						tipo = Restaurante.TIPO_CAFETERIA;
						break;
					case "5":
						tipo = Restaurante.TIPO_FAST_FOOD;
						break;
					case "6":
						tipo = Restaurante.TIPO_FOOD_TRUCK;
						break;	
					}
					String opcao7 = JOptionPane.showInputDialog("Classifica��o" + "\n"
							+ "Op��o 1: 1 Estrela" + "\n"
							+ "Op��o 2: 2 Estrela" + "\n"
							+ "Op��o 3: 3 Estrela" + "\n"
							+ "Op��o 4: 4 Estrela" + "\n"
							+ "Op��o 5: 5 Estrela");
					
	                switch (opcao7) {
					case "1":
						classificacao = Restaurante.TIPO_UMA;
						break;
					case "2":
						classificacao = Restaurante.TIPO_DUAS;
						break;
					case "3":
						classificacao = Restaurante.TIPO_TRES;
						break;
					case "4":
						classificacao = Restaurante.TIPO_QUATRO;
						break;
					case "5":
						classificacao = Restaurante.TIPO_CINCO;
						break;
	                }
	                Restaurante restaurantes = new Restaurante(nomeRestaurante, siteRestaurante, infoRestaurante, 
	                		endereco, classificacao, tipo);
					try {
						aIT.cadastrarRestaurante(restaurantes, Municipio, Estado);
					} catch ( MunicipioNaoExisteException e ) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch ( RestauranteJaExisteException e ) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					sair3 = true;
				}
				break;	
			//Cadastrar Hospedagens	
			case "4":
				Boolean Sair4 = false;
				String TipoHosp = "";
				while(!Sair4){
					String Municipio = JOptionPane.showInputDialog("digite o nome do Municipio: ");
					String Estado= JOptionPane.showInputDialog("digite o nome do estado: ");
					String nomeHospedagem = JOptionPane.showInputDialog("nome do estabelecimento: ");
					String siteHospedagem = JOptionPane.showInputDialog("Site: ");
					String infoHospedagem = JOptionPane.showInputDialog("Informa��o para contato: ");
					String lougradouro = JOptionPane.showInputDialog("lougradouro: ");
					String numero = JOptionPane.showInputDialog("numero: ");
					String bairro = JOptionPane.showInputDialog("bairro: ");
					Endereco endereco = new Endereco(lougradouro, numero, bairro);
					
					String opcao8 = JOptionPane.showInputDialog("digite o tipo de Hospedagem " + "\n" 
					+ "1: Hotel" + "\n" 
					+ "2: Pousada" + "\n"
					+ "3: Albergue" + "\n"
					+ "4: Motel" + "\n"
					+ "5: Resort");
					
					switch(opcao8){	
					case "1":
						TipoHosp = TipoDeHospedagem.TIPO_HOTEL;
						break;
					case "2":
						TipoHosp = TipoDeHospedagem.TIPO_POUSADA;
						break;
					case "3":
						TipoHosp = TipoDeHospedagem.TIPO_ALBERGUE;
						break;
					case "4":
						TipoHosp = TipoDeHospedagem.TIPO_MOTEL;
						break;
					case "5":
						TipoHosp = TipoDeHospedagem.TIPO_RESORT;
						break;
					}
					TipoDeHospedagem Hosp = new TipoDeHospedagem(nomeHospedagem, siteHospedagem, infoHospedagem, TipoHosp, endereco);
					
					try{
						aIT.cadastrarTipoDeHospedagem(Hosp, Municipio, Estado);
					} catch ( MunicipioNaoExisteException e ) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch ( TipoDeHospedagemJaExisteException e ) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					Sair4 = true;
				}
				break;
			case "5":
				
				List<Municipio> listMunicipios = aIT.getMunicipios();
				String listaMunicipios = "Lista de Municipios: " + "\n";
				for (Municipio A : listMunicipios) {
					listaMunicipios += A.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, listaMunicipios);
				break;		
			case "6":	
				String TipoDePesquisa = JOptionPane.showInputDialog("Qual op��o deseja pesquisar ? " + "\n"
						+ "Op��o 1: AtrativoTuristico" + "\n"
						+ "Op��o 2: Restaurantes" + "\n"
						+ "Op��o 3: Hospedagens");
				String nomeMunicipio = JOptionPane.showInputDialog("Digite o nome do municipio: ");
				String nomeEstado = JOptionPane.showInputDialog("Digite o nome do estado: ");
				List<Municipio> ListaDeMuni = aIT.getMunicipios();
				String ListaDeRecursosDeMuni = "";
				
				switch(TipoDePesquisa) {	
				case "1":	
					for (Municipio A : ListaDeMuni) {
						if ((A.getNome().equals(nomeMunicipio)) && (A.getEstado().equals(nomeEstado))) {
							for (AtrativoTuristico B : A.getAtrativoTuristicos()) {
								ListaDeRecursosDeMuni += B.getDescricao() + "\n";
							}
						}
					}
					break;		
				case "2":
	
					for (Municipio A : ListaDeMuni) {
						if ((A.getNome().equals(nomeMunicipio)) && (A.getEstado().equals(nomeEstado))) {
							for (Restaurante B : A.getRestaurante()) {
								ListaDeRecursosDeMuni += B.getDescricao() + "\n";
							}
						}
					}
					break;	
				case "3":

					for (Municipio A : ListaDeMuni) {
						if ((A.getNome().equals(nomeMunicipio)) && (A.getEstado().equals(nomeEstado))) {
							for (TipoDeHospedagem B : A.getTipoDeHospedagem()) {
								ListaDeRecursosDeMuni += B.getDescricao() + "\n";
							}
						}
					}
					break;	
				}
				JOptionPane.showMessageDialog(null, ListaDeRecursosDeMuni);
					
			case "7":
				sair = true;
				break;
			}
		}	
	}
}
