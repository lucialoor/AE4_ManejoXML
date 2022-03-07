package jdom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LecturaXML_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//Sigue el patron de dise�o builder y cuya funcion es crear objetos
		//complejos de manera simple
		DocumentBuilder analizador;
		//el nodo documento
		Document dom;
		//Este nodo representara el nodo raiz en este ejemplo
		Node document;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			//Lo primero es parsear el fichero cruceros.xml para
			//convertilo en un arbol DOM, basicamente lo que hacen los navegadores
			//El arbol DOM seran objetos con una jerarquia en forma de arbol
			dom = analizador.parse("concierto.xml");
			//Ponemos la referencia raiz en el objeto Document
			document = dom.getDocumentElement();
			//Decimos que nos pinte todos los nodos texto del document
			System.out.println("-------------------------");
			System.out.println(document.getTextContent());
			System.out.println("-------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
