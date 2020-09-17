package br.com.caelum.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class Teste {

	public static void main(String[] args) {
		Produto geladeira = new Produto("Geladeira", 1000.0, "Geladeira duas portas", 1234);
		Produto ferro = new Produto("Ferro de passar", 100.0, "Ferro com vaporizador", 1235);
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(geladeira);
		produtos.add(ferro);
		
		Compra compra = new Compra(0001, produtos);
		
		XStream xstream = new XStream();
		xstream.alias("compra", Compra.class);
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		String xml = xstream.toXML(compra);
		System.out.println(xml);	
				
		Compra compraDeserializada = (Compra) xstream.fromXML(xml);
		
		System.out.println(compra.equals(compraDeserializada));
	}

}
