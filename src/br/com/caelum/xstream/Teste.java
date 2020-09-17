package br.com.caelum.xstream;

import com.thoughtworks.xstream.XStream;

public class Teste {

	public static void main(String[] args) {
		Produto geladeira = new Produto("Geladeira", 1000.0, "Geladeira duas portas", 1234);
		
		
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.useAttributeFor(Produto.class, "codigo");
		System.out.println(xstream.toXML(geladeira));		
	}

}
