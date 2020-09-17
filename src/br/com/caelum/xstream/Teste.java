package br.com.caelum.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class Teste {

	public static void main(String[] args) {
		Produto geladeira = new Eletrodomestico("Geladeira", 1000.0, "Geladeira duas portas", 1234);
		Produto ferro = new Eletrodomestico("Ferro de passar", 100.0, "Ferro com vaporizador", 1235);
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(geladeira);
		produtos.add(ferro);
		produtos.add(geladeira);
		
		Compra compra = new Compra(0001, produtos);
		
		XStream xstream = new XStream();
		xstream.alias("compra", Compra.class);
		xstream.alias("produto", Produto.class);
		xstream.alias("eletrodomestico", Eletrodomestico.class);
		//xstream.addImplicitCollection(Compra.class, "produtos"); //para o caso se querer omitir a tag produtos.
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.useAttributeFor(Produto.class, "codigo");
		String xml = xstream.toXML(compra);
		System.out.println(xml);	
				
		Compra compraDeserializada = (Compra) xstream.fromXML(xml);
		
		System.out.println(compra.equals(compraDeserializada));
	}

}
